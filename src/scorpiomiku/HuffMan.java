package scorpiomiku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class HuffMan implements HuffManMainWays {

    protected abstract Node createTree(ArrayList<Node> nodeList);

    private ArrayList<Node> string2NodeList(String string) {
        ArrayList<Node> nodeList = new ArrayList<>();
        Map<Character, Integer> codeMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            if (!codeMap.keySet().contains(character)) {
                //System.out.println("map 里没有   "+character+"   放入了");
                codeMap.put(character, 1);
            } else {
                Integer oldValue = codeMap.get(character);
                codeMap.put(character, oldValue + 1);
                //System.out.println("map 里有   "+character+"   加一了");
            }
        }
        Set<Character> charactersInMap = codeMap.keySet();
        for (Character key : charactersInMap) {
            Node node = new Node();
            Data data = new Data();
            data.setC(key);
            data.setFrequency(codeMap.get(key));
            node.setData(data);
            nodeList.add(node);
            //System.out.println(data.getC() + "被加到了List里，次数为:"+data.getFrequency());
        }
        return nodeList;
    }

    private Map<Character, String> getCodeMap(Node rootNode) {
        Map<Character, String> codesMap = new HashMap<Character, String>();
        if (rootNode.getLeftChild() == null && rootNode.getRightChild() == null) {
            codesMap.put(rootNode.getData().getC(), "0");
            System.out.println(rootNode.getData().getC() + "的编码为:"+codesMap.get(rootNode.getData().getC()));
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
                System.out.println(character+"被放进了Map,编码为:"+suffix);
            }
            getCodeMap(rootNode.getLeftChild(), suffix + "0", codesMap);
            getCodeMap(rootNode.getRightChild(), suffix + "1", codesMap);
        }
    }

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
