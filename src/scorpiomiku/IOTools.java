package scorpiomiku;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IOTools {
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
        FileWriter fw1 = new FileWriter(fileName);
        fw1.write(code);
        fw1.close();
    }

    public static void writeMap(String fileName, Map<Character, String> codeMap) throws IOException {

        FileWriter fw = new FileWriter(fileName);
        Set<Character> keys = codeMap.keySet();
        for (Character key : keys) {
            fw.write(key + "\n");
            fw.write(codeMap.get(key) + "\n");
        }
        fw.close();

        // BufferedWriter bw = new BufferedWriter();

    }

    public static String getCodeFromTxt(String fileName) throws IOException {
        FileInputStream fis2 = new FileInputStream(fileName);
        byte[] bbuf2 = new byte[1024];
        int hasRead2 = 0;
        String returnString2 = "";
        while ((hasRead2 = fis2.read(bbuf2)) > 0) {
            returnString2 = returnString2 + new String(bbuf2, 0, hasRead2);
        }
        System.out.println("成功读取到:" + returnString2);
        return returnString2;
    }

    public static Map<Character, String> getMapFromTxt(String fileName) throws FileNotFoundException {
        Map<Character, String> returnMap = new HashMap<>();
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br1 = new BufferedReader(new InputStreamReader(fis));
        String mChar = "";
        String mCode = "";

        try {
            while ((mChar = br1.readLine()) != null) {
                if ((mCode = br1.readLine()) != null) {
                    System.out.println(mChar + "编码为:" + mCode);
                } else {
                    mCode = br1.readLine();
                    System.out.println(mChar + "编码为:" + mCode);
                }
            }
            //System.out.println("1");
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println(e.toString());
        }
        return returnMap;
    }

    public static void getJPG(String filename){
        try {
            FileInputStream fisJPG = new FileInputStream(filename);
            byte[] read = new byte[1024];
            int len = 0 ;
            while((len=fisJPG.read(read))!=-1){
                System.out.println( read.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
