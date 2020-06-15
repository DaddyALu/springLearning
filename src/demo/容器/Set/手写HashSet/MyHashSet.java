package demo.容器.Set.手写HashSet;

import java.util.HashMap;

public class MyHashSet<E> {

    HashMap<E,Object> map;
    private static final Object PRESENT = new Object();

    public MyHashSet(){
        map = new HashMap();
    }

    public void add(E element){
        map.put(element,PRESENT);
    }

    public int size(){
        return map.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (E key : map.keySet()) {
            sb.append(key+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {

        MyHashSet<String> set = new MyHashSet<>();

        set.add("aaa");  //测试添加
        set.add("bbb");
        set.add("ccc");
        set.add("ddd");
        set.add("eee");
        set.add("aaa");  //测试重复
        System.out.println(set);

        System.out.println(set.size());  //size()



    }

}
