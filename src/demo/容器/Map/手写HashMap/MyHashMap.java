package demo.容器.Map.手写HashMap;

public class MyHashMap<K,V> {

    Node<K,V>[] table;  //位桶数组。 bucket array
    private int size = 0;
    private final static int DEFAULT_CAPACITY = 16;  //长度一般为2的整数幂

    public MyHashMap(){
        table = new Node[DEFAULT_CAPACITY];
    }

    public void put(K key, V value){

        //扩容
        int count = 0;
        for (int i = 0; i < table.length; i++){  //判断当前位桶已有元素数量
            if (table[i] != null){
                count++;
            }
        }
        if (count == 0.75*table.length){  //如果达到4分之3的占用，则扩容到原来的2倍
            Node<K,V>[] newTable = new Node[table.length*2];
            //拷贝
            System.arraycopy(table,0,newTable,0,table.length);  //旧，旧的开始索引，新，新的开始索引，执行长度
            //换用新table
            table = newTable;
        }

        //定义新节点
        Node<K,V> newNode = new Node<>();
        newNode.hash = myHash(key.hashCode(),table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        //将节点放入位桶
        Node<K,V> temp = table[newNode.hash];
        if (temp == null){  //如果数组该位置为空，直接将新建的节点放入
            table[newNode.hash] = newNode;
            size++;
        } else {  //如果不为空，则遍历对应的链表
            while (temp != null){
                if (temp.key.equals(key)){  //是否key重复，重复的话直接覆盖value，其他的值保持不变
                    temp.value = value;
                    break;
                } else if (temp.next == null){  //如果不重复，则判断当前位置是否为最后一个节点；如果是则直接插入到当前节点之后
                    temp.next = newNode;
                    size++;  //如果只是覆盖，不执行size++
                    //break;  //这里不用加break，因为如果next为null，那么下一个循环就不会再进行了
                }
                temp = temp.next;
            }
        }

    }

    public V get(K key){
        V value = null;
        int hash = myHash(key.hashCode(),table.length);  //获得该key对应的应该存储的位桶索引
        if (table[hash] != null){  //如果该位置存有元素
            Node<K,V> node = table[hash];
            while (node != null){  //遍历链表
                if (node.key.equals(key)){  //如果找到了该key
                    value = node.value;
                    break;
                } else {
                    node = node.next;
                }
            }
        }
        return value;
    }

    public int size(){
        return this.size;
    }

    public int lenght(){
        return table.length;
    }

    @Override
    public String toString(){  // {[K:V],[K:V],[K:V]}
        StringBuilder sb = new StringBuilder("{");

        for (int i = 0; i < table.length; i++){  //遍历数组
            Node<K,V> node = table[i];
            while (node != null){  //遍历链表
                sb.append("["+node.key+"="+node.value+"],");
                node = node.next;
            }
        }

        sb.setCharAt(sb.length()-1,'}');

        return sb.toString();
    }

    private int myHash(int keyHash, int lenght){  //这里返回的不是"哈希码"，是我们根据自己的算法自定的hash值

        //以下两种方法都是为了散列存放，但是结果不一定相同

        //散列算法1
        int hash = keyHash&(lenght-1);  //位运算，效率高
//        System.out.println("myHash:"+(keyHash&(lenght-1)));

        //散列算法2
//        int hash1 = keyHash%(lenght-1);  //取摸运算，效率低
//        System.out.println("myHash:"+(keyHash%(lenght-1)));

        return hash;
    }




    public static void main(String[] args) {

        MyHashMap<Integer,String> m = new MyHashMap<>();  //要用Integer包装类，int无法生成对象

        m.put(1,"aa");  //测试添加
        m.put(10,"bb");
        m.put(20,"cc");
        System.out.println(m);

        m.put(20,"dd");  //测试覆盖
        System.out.println(m);

        m.put(53,"xx");  //测试链表的生成（放入位桶里的同一位置）；53、69得出hash值都为5
        m.put(69,"yy");
        System.out.println(m);

        System.out.println(m.get(20));  //测试get获取
        System.out.println(m.get(53));
        System.out.println(m.get(2));  //"null"

        System.out.println("Node数量："+m.size());  //测试size()方法

        for (int i = 0; i < 13; i++){  //测试扩容功能；按默认长度，位桶存放12个元素后就会扩容(这里要循环13次，说明0～12会出现相同的hash值)
            m.put(i,"mm");
        }
        System.out.println("位桶长度："+m.lenght());

        // 还有remove()等方法还没写，remove()会出现的情况比较多，较为复杂

    }

}
