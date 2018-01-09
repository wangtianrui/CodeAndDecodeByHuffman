package scorpiomiku;


import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IOTools {
    public static void writeTxt(String decode, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(decode.getBytes());
        fos.close();
    }

    public static String getTxt(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        byte[] bbuf = new byte[1024];
        int hasRead = 0;
        String returnString = "";
        while ((hasRead = fis.read(bbuf)) > 0) {
            //加上gbk防止中文乱码
            returnString = returnString + new String(bbuf, 0, hasRead, "gbk");
        }
        //System.out.println("成功读取到:" + returnString);
        return returnString;
    }

    public static void writeMap(Map<Character, String> codeMap, String fileName) throws IOException {

        /*
        FileWriter fw = new FileWriter(fileName);
        Set<Character> keys = codeMap.keySet();
        for (Character key : keys) {
            fw.write(key +"\n");
            fw.write(codeMap.get(key)+"\n");
        }
        fw.close();
        */
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(codeMap);
        oos.flush();
        oos.close();
        fos.close();
    }

    ;

    public static Map<Character, String> getMap(String fileName) throws IOException, ClassNotFoundException {
        Map<Character, String> returnMap = new HashMap<>();
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        returnMap = (Map<Character, String>) ois.readObject();
        ois.close();
        fis.close();
        return returnMap;
    }


    public static String readCodeFromDat(String filename) {
        String returnString = "";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
            byte[] temp = new byte[1];
            int len = 0;
            while ((len = fis.read(temp)) != -1) {
                returnString = returnString + new String(temp);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnString;
    }

    public static void writeCodeToDat(String string, String filename) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            fos.write(string.getBytes());
            System.out.println(new String(string.getBytes()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getFileName(String string) {
        String returnString = "";
        String temp[] = string.split("\\\\");
        returnString = temp[temp.length - 1].split("[.]")[0];
        return returnString;
    }
}
