package demo.反射.访问类的字段;

public class Person {

    static {
        System.out.println("这是Person类的静态代码块，在类加载内存后执行");
    }

    public String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
