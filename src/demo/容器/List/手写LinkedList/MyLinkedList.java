package demo.容器.List.手写LinkedList;

public class MyLinkedList<E> {  // LinkedList应该是循环的双向链表，这里手工写的并不是循环的

    private Node first;
    private Node last;
    private int size;

    public void add(E element){  //顺序添加
        Node node = new Node(element);
        if (first == null){
            first = node;
            last = node;
        } else {
            node.pre = last;
            node.next = null;  //不是循环链表
            last.next = node;
            last = node;
        }
        size++;
    }

    public void add(int index, E element){  //指定位置的添加
        Node node = new Node(element);

        Node up = null;
        if (index != 0){
            up = getNode(index-1);
            up.next = node;
            node.pre = up;
        } else {
            first = node;
        }

        Node down = null;
        if (index != size-1){
            down = getNode(index);
            down.pre = node;
            node.next = down;
        } else {
            last = node;
        }

        size++;
    }

    public E get(int index){
        Node temp = getNode(index);

        return temp!=null?(E)temp.element:null;
    }

    private Node getNode(int index){
        checkIndex(index);

        Node temp = null;
        //优化查找
        if (index < (size>>2)){
            temp = first;
            for (int i = 0; i < index; i++){
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = size-1; i > index; i--){
                temp = temp.pre;
            }
        }
        return temp;
    }

    public void remove(int index){
        Node temp = getNode(index);

        if (temp != null){
            Node up = temp.pre;
            Node down = temp.next;

            if (up != null){    //temp不等于first时才执行
                up.next = down;
            } else {    //up等于null时，表示temp指向的是链表的第一个元素，即first
                first = down;
            }

            if (down != null){    //temp不为last时才执行
                down.pre = up;
            } else {    //temp指向last时
                last = up;
            }

            size--;
        }
    }

    //索引合法判断
    private void checkIndex(int index){
        //如果越界
        if (index < 0 || index >= size){
            //不合法时手动抛出异常
            throw new RuntimeException("索引越界！非法索引："+index);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while (temp != null){
            sb.append(temp.element+",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }



    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("a");  //添加
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("f");
        System.out.println(list);
        System.out.println(list.get(3));

        list.remove(3);  //删除d
        System.out.println(list);
        System.out.println(list.get(3));

        list.remove(0);  //删除a (first)
        list.remove(list.size - 1);  //删除f (last)
        list.add("g");
        System.out.println(list);
        System.out.println(list.get(1));

        list.add(0,"h");  //添加到指定位置
        System.out.println(list);
        System.out.println(list.get(0)+","+list.get(1));

    }

}
