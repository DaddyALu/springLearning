package demo.容器.List.手写LinkedList;

public class Node {

    Node pre;  //上一个节点
    Node next;  //下一个节点
    Object element;  //元素数据

    public Node(Object element) {
        this.element = element;
    }

    public Node(Node pre, Node next, Object element) {
        this.pre = pre;
        this.next = next;
        this.element = element;
    }
}
