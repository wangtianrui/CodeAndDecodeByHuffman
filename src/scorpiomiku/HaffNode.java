package scorpiomiku;

public class HaffNode {
    public int weight;
    public int flag;
    public int parent;
    public int leftchild;
    public int rightchild;
    public HaffNode(int w, int f, int p, int l, int r){
        this.weight = w;
        this.flag = f;
        this.parent = p;
        this.leftchild =l;
        this.rightchild = r;
    }
}
