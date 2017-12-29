package scorpiomiku;

public class Haffman {
    public final int Max = 10000;
    private int x1, x2;
    private int m1, m2;
    // 哈夫曼树节点
    private HaffNode[] hafftree;
    //　记录权重
    private int[] weight;
    private int n;
    private String[] code;

    // 由权重生成哈夫曼树
    public Haffman(int[] weight, int n) {
        this.n = n;
        System.out.println("n "+n);
        this.weight = new int[2 * n - 1];
        for(int i = 0; i < 2 * n - 1; i++){
            if(i < n)
            this.weight[i] = weight[i];
            else
                this.weight[i] = 0;
        }
        this.hafftree = new HaffNode[2 * n - 1];
        this.code = new String[2 * n - 1];
    }
    // 构建哈夫曼树
    public void build(){
        int j;
        for (int i = 0; i < n * 2 - 1; i++) {
            hafftree[i] = new HaffNode(this.weight[i],0,0,-1,-1);
            // 完成哈夫曼树节点的初始化
        }

        for (int i = 0; i < n - 1; i++) {
            m1 = m2 = Max;
            x1 = x2 = 0;

            for (j = 0; j < n + i; j++) {
                if (hafftree[j].weight < m1 && hafftree[j].flag == 0) {
                    m2 = m1;
                    x2 = x1;
                    m1 = hafftree[j].weight;
                    x1 = j;
                } else if (hafftree[j].weight < m2 && hafftree[j].flag == 0) {
                    m2 = hafftree[j].weight;
                    x2 = j;
                }
            }
            hafftree[x1].parent = n + i;
            hafftree[x2].parent = n + i;
            hafftree[x1].flag = 1;
            hafftree[x2].flag = 1;
            hafftree[n + i].weight = hafftree[x1].weight + hafftree[x2].weight;
            hafftree[n + i].leftchild = x1;
            hafftree[n + i].rightchild = x2;
        }
    }
    // （递归函数）利用哈夫曼树生成对应编码，左边＋０，右边＋１
    private void code(String start, int i){
        this.code[i] = new String(start);
        if(hafftree[i].leftchild != -1){
            code(start+'0', hafftree[i].leftchild);
        }
        if(hafftree[i].rightchild != -1){
            code(start+'1', hafftree[i].rightchild);
        }
    }
    // 将报文编码
    public String encode(String message){
        code("0", 2 * n - 2);
        String res = "";
        for(int i = 0; i < message.length(); i++){
            if(message.charAt(i) == ' '){
                res += ' ';
            }
            else{
                res += this.code[message.charAt(i) - 65];
            }
        }
        return res;
    }
    // 将报文译码
    public void decode(String message){
        String res = "";
        String tmp = "";

        for(int i = 0; i < message.length(); i++){
            tmp += message.charAt(i);
            if(message.charAt(i) == ' '){
                res += ' ';
                tmp = "";
            }
            // 匹配之前生成的哈夫曼树，用字典匹配结果，生成可以阅读的报文
            for(int j = 0; j < n; j++){
                if(tmp.equals(this.code[j])){
                    res += (char)('A' + j);
                    tmp = "";
                }

            }
        }
        System.out.println("编码为:");
        System.out.println(message);
        System.out.println("译码为:");
        System.out.println(res);
    }
}
