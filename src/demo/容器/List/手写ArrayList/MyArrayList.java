package demo.容器.List.手写ArrayList;

public class MyArrayList<E> { //添加泛型，规定数组存放元素的类似

    private Object[] elementData; //ArrayList本质上就是数组
    private int size;
    private static final int DEFAULT_CAPACITY = 10;  //默认长度为10

    public MyArrayList(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity){  //构造自定长度的对象
        if (capacity < 0){
            throw new RuntimeException("容器的容量不能为负数！错误值："+capacity);
        } else if (capacity == 0) {
            capacity = DEFAULT_CAPACITY ;
        }
        elementData = new Object[capacity];
    }

    public void add(E element){

        //扩容
//        if (size == elementData.length){ //等于时，实际上size的值已经大于了最大的下标
//            Object[] oldOne = elementData;
//            Object[] newOne = new Object[elementData.length + elementData.length/2];  //右移1位等于除以2（2进制数右移）
//            for (int i = 0 ; i < elementData.length; i++){
//                newOne[i] = oldOne[i];
//            }
//            elementData = newOne;
//        }

        //扩容
        if (size == elementData.length){ //等于时，实际上size的值已经大于了最大的下标
            Object[] newArray = new Object[elementData.length + (elementData.length>>1)];  //右移1位等于除以2（2进制数右移）
                                                                                //+的优先级最高，所以要把右移运算扩起来
            System.arraycopy(elementData,0,newArray,0,elementData.length); //旧，旧的开始索引，新，新的开始索引，执行长度
            elementData = newArray;
        }

        elementData[size++] = element;  //当前索引赋值，然后size加1
    }

    public void set(int index, E element){

        checkIndex(index);

        elementData[index] = element;
    }

    public E get(int index){
        return (E)elementData[index];
    }

    public void remove(int index){  //按索引移除
        checkIndex(index);
        int removeLength = size-(index+1); //要复制的长度（从被移除的索引之后第一个索引，到最后一个索引的长度）
        if (removeLength > 0){
            System.arraycopy(elementData,index+1,elementData,index,removeLength);
        }
        //如果removeLength等于0，说明要移除的是最后一个元素，直接执行下面一步就可以
        elementData[--size] = null;
    }

    public void remove(E element){  //按元素移除
        for (int i = 0; i < size; i++){
            if (element.equals(get(i))){ //默认是 this.get()；且容器中的比较操作都要用equals
                remove(i);
                break;
            }
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

    public int size(){  //当前实际长度
        return this.size;
    }

    public int maxSize(){  //目前最大长度
        return elementData.length;
    }

    public boolean isEmpty(){
        return this.size==0?true:false;  //实际长度为0则返回true，表示为空
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0 ; i < size ; i++) {
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length() - 1,']'); //将最后一个字符（逗号）换成括号
        return sb.toString();
    }





    //测试自定ArrayList
    public static void main(String[] args) {

        MyArrayList<String> a = new MyArrayList<>();
        System.out.println(a.isEmpty());
//        MyArrayList<String> b = new MyArrayList<>(-1);  //测试错误容量初始化

        //测试添加和扩容
        for (int i=0;i<19;i++){
            a.add("aaa");
        }
        System.out.println(a.isEmpty());

        System.out.println(a);  //输出a实际上是调用了toString()方法，即输出的是a.toString()
        System.out.println("实际长度为："+a.size());
        System.out.println("当前最大长度为："+a.maxSize());

        System.out.println("###############################");

        a.set(10,"dddd");
        System.out.println(a);
        System.out.println(a.get(10));

//        a.set(20,"cc");  //测试不合法索引

        a.remove("dddd");
        System.out.println(a);
        System.out.println("实际长度为："+a.size());

    }

}
