package scorpiomiku;

import java.util.Map;

public class MapOfEncode {
    private String encode;
    private Map<Character, String> encodeMap;

    public MapOfEncode(String encode, Map<Character, String> encodeMap) {
        this.encode = encode;
        this.encodeMap = encodeMap;
    }

    public String getEncode() {
        return encode;
    }

    public Map<Character, String> getEncodeMap() {
        return encodeMap;
    }
}
