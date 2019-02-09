package tree;

public class Node {    //存放节点数据

    int data;    //指向左子节点

    Node left;    //指向右子节点

    Node right;    /**

     * @function 默认构造函数

     * @param data 节点数据

     */

    public Node(int data) {
        this.data = data;

        left = null;

        right = null;

    }

}
