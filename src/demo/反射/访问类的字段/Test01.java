package demo.反射.访问类的字段;

import java.io.File;
import java.lang.reflect.Field;

/**
 * 通过反射技术，访问类的字段
 */
public class Test01 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        // 1）创建Class对象
        Class<?> class1 = Person.class;

        // 2）反射name字段
        Field nameF = class1.getField("name");  //返回指定字段名的公共字段(public修饰的字段)

        // 3）通过反射技术创建对象(实例)，默认调用该类的无参构造方法
        Object p1 = class1.newInstance();  //class1就是相当于是Person类的字节码文件，相当于 new Person();

        // 4）设置指定对象的该字段的值，这里的p1对象的类型必须是这个nameF字段对应的类
        nameF.set(p1,"张三");  //相当于：p1.setName("张三");

        // 5）返回字段的值
        System.out.println(p1);  //输出时默认调用p1.toString()方法，已经重写过该方法
        System.out.println(nameF.get(p1));  //获得指定对象的该字段的值，该对象类型与该字段所属的类必须一致；相当于：p1.getName();

        //访问age
        Field ageF2 = class1.getDeclaredField("age");  //可以返回任意字段
        ageF2.setAccessible(true);  //设置私有字段的可访问性，如果没有设置，下面输出结果为java.lang.IllegalAccessException
        ageF2.set(p1,20);  //注意这里赋值的类型要与字段类型一致，写"20"就会报错
        System.out.println(ageF2.get(p1));  //20

        Field ageF1 = class1.getField("age");  //只能返回公共字段
        ageF1.set(p1,18);
        System.out.println(ageF1.get(p1));  //java.lang.NoSuchFieldException，因为该属性是私有的
    }
}
