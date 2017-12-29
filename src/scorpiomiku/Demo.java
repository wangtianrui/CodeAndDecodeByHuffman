package scorpiomiku;

import java.util.Scanner;
public class Demo {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要编码的报文");
        String message = input.nextLine();
        // 定义字符权重
        int weight[] = {64, 13, 22, 32, 103, 21, 15, 47, 57, 1, 5, 32, 20, 57, 63, 15, 1, 48, 51, 80, 23, 8, 18, 1, 16, 1};
        System.out.println(weight.length);
        Haffman hf = new Haffman(weight, 26);
        hf.build();
        String out = hf.encode(message);
        System.out.println(out);
        String message2 = input.nextLine();
        hf.decode(message2);
    }
}
