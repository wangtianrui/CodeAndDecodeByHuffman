package scorpiomiku;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        HuffManTest huffManTest = new HuffManTest();
        String readString = IOTools.getData("E:\\javaprogrames\\CodeAndDecodeByHuffman\\HuffManDocTest.docx");
        //MapOfEncode mapOfEncode = huffManTest.encode("有的时候妈妈做家务真的累了，就会想起我，她就会生气地说：朱蕊，你到底长大了没有啊，会不会帮妈妈做点家务啊，这么大了，都12岁了，不小了啊！每当听到这话，看到她那张疲惫的脸和无奈的神情，心里就会很内疚，很想帮妈妈做点事情。四年级的时候，我突然想要帮妈妈拖地，于是我拿起拖把，一下一下地拖了起来，20分钟后，我的汗就掉了下来，感觉累的不得了，就想打退堂鼓。可是一想起妈妈那期待的神情，便自言自语道：平常妈妈天天也做家务呀，她也坚持下来了呀，不行！我一定也要坚持！就这样，我终于把家里拖得干干净净，妈妈回来了以后欣喜不已，直夸我是个懂事的好孩子。");
        MapOfEncode mapOfEncode = huffManTest.encode(readString);
        System.out.println(mapOfEncode.getEncodeString());

        String decode = huffManTest.decode(mapOfEncode);
        System.out.println(decode);

        //IOTools.getTxt("E:\\javaprogrames\\CodeAndDecodeByHuffman\\ReadTxt.txt");
        IOTools.writeCode("E:\\javaprogrames\\CodeAndDecodeByHuffman\\Code.dat", mapOfEncode.getEncodeString());
        IOTools.writeMap("E:\\javaprogrames\\CodeAndDecodeByHuffman\\Map.dat", mapOfEncode.getEncodeMap());


        String code = IOTools.getCodeFromTxt("E:\\javaprogrames\\CodeAndDecodeByHuffman\\Code.dat");
        Map<Character, String> map = IOTools.getMapFromTxt("E:\\javaprogrames\\CodeAndDecodeByHuffman\\Map.dat");

        //System.out.println("完成");
        //IOTools.getJPG("E:\\javaprogrames\\CodeAndDecodeByHuffman\\testdog.jpg");

    }

}
