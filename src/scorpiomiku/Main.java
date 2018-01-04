package scorpiomiku;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        HuffManTest huffManTest = new HuffManTest();
        String readString = IOTools.getTxt("E:\\javaprogrames\\CodeAndDecodeByHuffman\\ReadTxt.txt");
        MapOfEncode mapOfEncode = huffManTest.encode(readString);
        System.out.println(mapOfEncode.getEncodeString());

        IOTools.writeCodeToDat(mapOfEncode.getEncodeString(),"E:\\javaprogrames\\CodeAndDecodeByHuffman\\Code.dat");

        String code = IOTools.readCodeFromDat("E:\\javaprogrames\\CodeAndDecodeByHuffman\\Code.dat");
        System.out.println(code);

        String deCode = huffManTest.decode(mapOfEncode);
        /*
        String code = IOTools.getCodeFromTxt("E:\\javaprogrames\\CodeAndDecodeByHuffman\\Code.dat");
        Map<Character, String> map = IOTools.getMapFromTxt("E:\\javaprogrames\\CodeAndDecodeByHuffman\\Map.dat");
        */
        //System.out.println("完成");
        //IOTools.getJPG("E:\\javaprogrames\\CodeAndDecodeByHuffman\\testdog.jpg");

    }

}
