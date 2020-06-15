package demo.IO流.对象序列化;

import java.io.*;

/**
 *对象序列化和反序列化
 */
public class Person implements Serializable {  //Serializable接口，没有任何方法，只是一个标志性接口

    private String name;  // String的序列化版本号：-6849794470754667710L
    private int age;
    private String gender;

    //手动添加版本序列号
    private static final long serialVersionUID = -68412321707567710L;  //在String的值上修改

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "name = " + name+", age = " + age;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException  {

        Person p1 = new Person("aaa",30);

        m1(p1);

        m2(p1);

    }


    //序列化（输出）
    private static void m1(Object obj) throws IOException{
        //建立流通道
        OutputStream os = new FileOutputStream("src/files/kkk.txt");
        ObjectOutputStream oos = new ObjectOutputStream(os);
        //写入对象
        oos.writeObject(obj);
        //关闭流
        oos.close();
    }

    //反序列化（输入）
    private static void m2(Object obj) throws IOException, ClassNotFoundException {
        //建立流通道
        InputStream is = new FileInputStream("src/files/kkk.txt");
        ObjectInputStream ois = new ObjectInputStream(is);
        //读取对象
        Object readObj = ois.readObject();
        System.out.println(readObj);
        //关闭流
        ois.close();
    }
    /**
     * 如果在反序列化之前，在Person类中新增了字段，则会出现"InvalidClassException"无效类异常；
     *
     * 原因：
     *  因为类在实现Serializable接口之后，系统就会自动添加一个serialVersionUID序列化版本号字段，修改类后，重新编译，系统会重新生成一个新的版本号值。
     *
     * 解决方法：
     *  保持serialVersionUID的值不变，手动添加一个序列号，值随便写。
     *
     */

}
