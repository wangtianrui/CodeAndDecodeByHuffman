package scorpiomiku;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HuffManTest huffManTest = new HuffManTest();
        MapOfEncode mapOfEncode = huffManTest.encode("hsadkjasd;");
        System.out.println(mapOfEncode.getEncodeString());


        String decode = huffManTest.decode(mapOfEncode);
        System.out.println(decode);

        GetResource.getTxt("E:\\javaprogrames\\CodeAndDecodeByHuffman\\ReadTxt.txt");
    }
}
