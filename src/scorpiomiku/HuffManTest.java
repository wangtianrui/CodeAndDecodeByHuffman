package scorpiomiku;

import java.util.ArrayList;

public class HuffManTest extends HuffMan {
    @Override
    protected Node createTree(ArrayList<Node> nodeList) {
        init(nodeList);
        while (nodeList.size() != 1) {
            int size = nodeList.size();
            Node nodeLeft = nodeList.get(size - 1);
            Node nodeRight = nodeList.get(size - 2);
            Node nodeParent = new Node();
            nodeParent.setLeftChild(nodeLeft);
            nodeRight.setRightChild(nodeRight);
            Data data = new Data();
            data.setFrequency(nodeRight.getData().getFrequency() + nodeLeft.getData().getFrequency());
            nodeParent.setData(data);
            nodeList.set(size - 2, nodeParent);
            nodeList.remove(size - 1);
            sort(nodeList);
        }
        Node rootNode = nodeList.get(0);
        return rootNode;
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
