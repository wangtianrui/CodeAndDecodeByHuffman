package scorpiomiku;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        /**
         * 此为测试类
         * 请从MainActivity运行
         */
        /*
        HuffManTest huffManTest = new HuffManTest();
        String readString = IOTools.getTxt("E:\\javaprogrames\\CodeAndDecodeByHuffman\\ReadTxt.txt");
        CodeAndMap mapOfEncode = huffManTest.encode(readString);
        System.out.println(mapOfEncode.getEncodeString());
        String encode = huffManTest.decode(mapOfEncode);
        //System.out.println(encode);

        IOTools.writeCodeToDat(mapOfEncode.getEncodeString(),"E:\\javaprogrames\\CodeAndDecodeByHuffman\\Code.dat");
        String code = IOTools.readCodeFromDat("E:\\javaprogrames\\CodeAndDecodeByHuffman\\Code.dat");
        System.out.println("code:"+code);
        IOTools.writeMap(mapOfEncode.getEncodeMap(),"E:\\javaprogrames\\CodeAndDecodeByHuffman\\Map.txt");

        CodeAndMap codeAndMap = new CodeAndMap(code,IOTools.getMap("E:\\javaprogrames\\CodeAndDecodeByHuffman\\Map.txt"));
        String deCode = huffManTest.decode(codeAndMap);
        System.out.println("decode:"+deCode);

        /*
        String code = IOTools.getCodeFromTxt("E:\\javaprogrames\\CodeAndDecodeByHuffman\\Code.dat");
        Map<Character, String> map = IOTools.getMap("E:\\javaprogrames\\CodeAndDecodeByHuffman\\Map.dat");
        */
        //System.out.println("完成");
        //IOTools.getJPG("E:\\javaprogrames\\CodeAndDecodeByHuffman\\testdog.jpg");

    }

}
