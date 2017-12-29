## 课题:《哈夫曼树编码解码》

### 一、实验内容

  ```txt
  运用哈夫曼编码的相关知识对任意文本文件进行编码、解码。
  ```

### 二、需要用的数据结构以及实现思路

  ```txt
  需要用到二叉树、HuffMan树、递归等数据结构
  ```
* ##### 二叉树

  ![Alttext](https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=4c929ad3fe1f4134f43a0d2c4476feaf/b999a9014c086e06f719387b01087bf40ad1cb49.jpg)

  ```txt
  在计算机科学中，二叉树是每个节点最多有两个子树的树结构。通常子树被称作“左子树”（left subtree）和“右子
  树”（right subtree）。
  ```

  ```java
  //二叉树节点
  public class TreeNode {
      public int value;
      public int parent;
      public TreeNode leftchild;
      public TreeNode rightchild;
      public TreeNode(int v,int p, TreeNode l, TreeNode r){
          this.value = v;
          this.parent = p;
          this.leftchild =l;
          this.rightchild = r;
      }
  }
  ```
* ##### HuffMan树

  ![Alttext](https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=5adc683524dda3cc1fe9b07260805264/5366d0160924ab1886c1109d3ffae6cd7a890b40.jpg)

  ```txt
  给定n个权值作为n个叶子结点，构造一棵二叉树，若带权路径长度达到最小，称这样的二叉树为最优二叉树，也称为
  哈夫曼树(Huffman Tree)。哈夫曼树是带权路径长度最短的树，权值较大的结点离根较近
  ```
  * ###### 哈夫曼树的构造

    ![Alttext](http://see.xidian.edu.cn/cpp/uploads/allimg/120223/1-120223213KW27.jpg)

    ①根据给定的n个权值｛w1， w2， w3， w4......wn｝构成n棵二叉树的森林 F=｛T1 ， T2 ， T3.....Tn｝，其中每棵二叉树只有一个权值为wi 的根节点，其左右子树都为空。

    ②在森林F中选择两棵根节点的权值最小的二叉树，作为一棵新的二叉树的左右子树，且令新的二叉树的根节点的权值为其左右子树的权值和。

    ③从F中删除被选中的那两棵子树，并且把构成的新的二叉树加到F森林中。

    ④重复2 ，3 操作，直到森林只含有一棵二叉树为止，此时得到的这棵二叉树就是哈夫曼树。

    ```java
    //HuffMan树节点类
    public class HuffmanNode implements Comparable, Cloneable {
        protected int key;              // 权值
        protected HuffmanNode left;     // 左孩子
        protected HuffmanNode right;    // 右孩子
        protected HuffmanNode parent;   // 父结点

        protected HuffmanNode(int key, HuffmanNode left, HuffmanNode right, HuffmanNode
           parent) {
             this.key = key;
             this.left = left;
             this.right = right;
             this.parent = parent;
        }
   }
   ```

### 三、实验目标

>  ###### 算法：使用huffman算法根据要编码的文件中字符出现的频率生成对应的哈夫曼编码对文本文件进行编码和解码

>  ###### 展示：在android app 上展示出相关huffman表和对应的huffman码，并保存到手机上，然后发送到另一个手机端，在另一个手机端上进行解码

### 四、实验分工

名字|学号|负责的模块 |组内担当的位置
------- | -------- | ---------
王天锐 | 1607094155|待定 |组长
陈志彬 | 1607094152|待定 |组员
何德庆 | 1607094153|待定 |组员
郑豪 | 1607094154|待定 |组员

### 五、时间安排

>1月4日前完成需求分析报告。

>1月4日-1月10日，完成相关程序编码工作。

>1月11日，撰写课程设计说明书。

>1月12日，课程设计验收。
