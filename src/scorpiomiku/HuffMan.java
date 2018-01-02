package scorpiomiku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//HuffMan工厂
public abstract class HuffMan implements HuffManMainWays {
    //因为我们除了字符串的还要做图片压缩和解压，所以构造树这个环节可能不一样，所以写成抽象方法
    protected abstract Node createTree(ArrayList<Node> nodeList);

    //把字符串转换为Node的一个线性结构
    protected abstract ArrayList<Node> string2NodeList(String string);
    //两个重载方法，第一个为当只有一个节点的情况就直接编码为0后return,第二个则是左子加0右子加1
    private Map<Character, String> getCodeMap(Node rootNode) {
        Map<Character, String> codesMap = new HashMap<Character, String>();
        if (rootNode.getLeftChild() == null && rootNode.getRightChild() == null) {
            codesMap.put(rootNode.getData().getC(), "0");
            System.out.println(rootNode.getData().getC() + "的编码为:" + codesMap.get(rootNode.getData().getC()));
            return codesMap;
        }
        getCodeMap(rootNode, "", codesMap);
        return codesMap;
    }

    private void getCodeMap(Node rootNode, String suffix, Map<Character, String> codesMap) {
        if (rootNode != null) {
            //System.out.println("当前node为:"+rootNode.getData().getC());
            if (rootNode.getLeftChild() == null && rootNode.getRightChild() == null) {
                Character character = rootNode.getData().getC();
                codesMap.put(character, suffix);
                System.out.println(character + "被放进了Map,编码为:" + suffix);
            }
            getCodeMap(rootNode.getLeftChild(), suffix + "0", codesMap);
            getCodeMap(rootNode.getRightChild(), suffix + "1", codesMap);
        }
    }
    //编码
    @Override
    public MapOfEncode encode(String string) {
        ArrayList<Node> nodeArrayList = string2NodeList(string);
        Node rootNode = createTree(nodeArrayList);
        Map<Character, String> codeMap = getCodeMap(rootNode);
        MapOfEncode mapOfEncode = encode(codeMap, string);
        return mapOfEncode;
    }

    private MapOfEncode encode(Map<Character, String> codeMap, String string) {
        StringBuilder encode = new StringBuilder();
        for (int i = 0, length = string.length(); i < length; i++) {
            Character character = string.charAt(i);
            encode.append(codeMap.get(character));
        }
        MapOfEncode result = new MapOfEncode(encode.toString(), codeMap);
        return result;
    }
    //解码
    @Override
    public String decode(MapOfEncode mapOfEncode) {
        StringBuffer decodeStr = new StringBuffer();
        Map<String, Character> decodeMap = getDecodeMap(mapOfEncode.getEncodeMap());
        Set<String> keys = decodeMap.keySet();
        String encodeString = mapOfEncode.getEncodeString();
        String temp = "";
        int i = 1;
        while (encodeString.length() > 0) {
            temp = encodeString.substring(0, i);
            if (keys.contains(temp)) {
                Character character = decodeMap.get(temp);
                decodeStr.append(character);
                encodeString = encodeString.substring(i);
                i = 1;
            } else {
                i++;
            }
        }
        return decodeStr.toString();
    }
    //得到解码的Map
    private Map<String, Character> getDecodeMap(Map<Character, String> codeMap) {
        Map<String, Character> decodeMap = new HashMap<>();
        Set<Character> keys = codeMap.keySet();
        for (Character key : keys) {
            String value = codeMap.get(key);
            decodeMap.put(value, key);
        }
        return decodeMap;
    }
}
