package scorpiomiku;

import java.util.ArrayList;

public class HuffManTest extends HuffMan {
    @Override
    protected Node createTree(ArrayList<Node> nodeList) {
        init(nodeList);
        while (nodeList.size() != 1) {
            int size = nodeList.size();
            /*
            for (int k = 0; k < size; k++) {
                System.out.println("create tree test:" + nodeList.get(k).toString() + "   size = " + size);
            }*/
            Node nodeLeft = nodeList.get(size - 1);
            Node nodeRight = nodeList.get(size - 2);
            /*
            System.out.println("左子："+nodeLeft.toString());
            System.out.println("右子："+nodeRight.toString());
            */
            Node nodeParent = new Node();
            nodeParent.setLeftChild(nodeLeft);
            nodeParent.setRightChild(nodeRight);
            Data data = new Data();
            data.setFrequency(nodeRight.getData().getFrequency() + nodeLeft.getData().getFrequency());
            nodeParent.setData(data);
            nodeList.set(size - 2, nodeParent);
            nodeList.remove(size - 1);
            sort(nodeList);
        }
        Node rootNode = nodeList.get(0);
        Node test = rootNode;
       // System.out.println("以下是前序:");
        //testShowTree(test);
        return rootNode;
    }


    private void testShowTree(Node root) {

        if (root != null) {
            System.out.println(root.getData().getC());
            testShowTree(root.getLeftChild());
            testShowTree(root.getRightChild());
        }
    }

    private void init(ArrayList<Node> nodeList) {
        sort(nodeList);
    }

    private void sort(ArrayList<Node> nodeList) {
        int size = nodeList.size();
        if (size == 1) {
            return;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (nodeList.get(j).getData().getFrequency() < nodeList.get(j + 1).getData().getFrequency()) {
                    Node tempNode = nodeList.get(j);
                    nodeList.set(j, nodeList.get(j + 1));
                    nodeList.set(j + 1, tempNode);
                }
            }
        }
    }
}
