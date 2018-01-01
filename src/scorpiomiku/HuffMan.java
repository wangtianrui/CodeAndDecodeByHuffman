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
                codeMap.put(character, 1);
            } else {
                Integer oldValue = codeMap.get(character);
                codeMap.put(character, oldValue + 1);
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
        }
        return nodeList;
    }

    private Map<Character, String> getCode(Node rootNode) {
        Map<Character, String> codesMap = new HashMap<Character, String>();
        if (rootNode.getLeftChild() == null && rootNode.getRightChild() == null) {
            codesMap.put(rootNode.getData().getC(), "1");
            return codesMap;
        }
        getCode(rootNode, "", codesMap);
        return codesMap;
    }

    private void getCode(Node rootNode, String suffix, Map<Character, String> codesMap) {
        if (rootNode != null) {
            if (rootNode.getLeftChild() == null && rootNode.getRightChild() == null) {
                Character character = rootNode.getData().getC();
                codesMap.put(character, suffix);
            }
            getCode(rootNode.getLeftChild(), suffix + "0", codesMap);
            getCode(rootNode.getRightChild(), suffix + "1", codesMap);
        }
    }

    @Override
    public MapOfEncode encode(String string) {
        ArrayList<Node> nodeArrayList = string2NodeList(string);
        Node rootNode = createTree(nodeArrayList);
        Map<Character, String> codeMap = getCode(rootNode);
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
