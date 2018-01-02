package scorpiomiku;


import java.io.*;
import java.util.Map;

public class GetResource {
    public static String getTxt(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        byte[] bbuf = new byte[1024];
        int hasRead = 0;
        String returnString = "";
        while ((hasRead = fis.read(bbuf)) > 0) {
            //加上gbk防止中文乱码
            returnString = returnString + new String(bbuf, 0, hasRead, "gbk");
        }
        System.out.println("成功读取到:" + returnString);
        return returnString;
    }

    public static void writeCode(String fileName, String code) throws IOException {

    }

    public static void writeMap(String fileName, Map<Character, String> codeMap) throws IOException {

    }
}
