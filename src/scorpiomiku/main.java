package scorpiomiku;

public class main {
    public static void main(String[] args) {
        HuffManTest huffManTest = new HuffManTest();
        MapOfEncode mapOfEncode = huffManTest.encode("hello");
        System.out.println(mapOfEncode.getEncodeString());


        //String decode = huffManTest.decode(mapOfEncode);
        //System.out.println(decode);
    }
}
