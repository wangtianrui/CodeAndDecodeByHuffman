package scorpiomiku;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/*
* 用来存放解码用的MAP，和码
*/
public class CodeAndMap implements Serializable {
    private String encodeString;
    private Map<Character, String> encodeMap;

    public CodeAndMap(String encode, Map<Character, String> encodeMap) {
        this.encodeString = encode;
        this.encodeMap = encodeMap;
    }

    public String getEncodeString() {
        return encodeString;
    }

    public Map<Character, String> getEncodeMap() {
        return encodeMap;
    }

    public String mapToString() {
        Set<Character> keys = this.encodeMap.keySet();
        String returnString = "";
        for (Character key : keys) {
            returnString = returnString + key + ":" + this.encodeMap.get(key) + "\n";
        }
        return returnString;
    }
}
