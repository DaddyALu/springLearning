package demo.反射.调用类的方法;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test01 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        // 1）创建Class对象
        Class<?> class1 = Person.class;

        // 2）反射show()方法
        Method showM = class1.getMethod("show",null); //（方法名，参数类型列表）

        // 3）通过反射技术创建实例
        Object obj = class1.newInstance();

        // 4）调用方法
        showM.invoke(obj,null);  //（实例名，方法的实参列表），参数列表无参传null或者不传
        System.out.println(obj);

        // 5）反射set(String,int)方法
        Method setM = class1.getMethod("set" , String.class , int.class);
        setM.invoke(obj,"张三",21);

        // 6）赋值后再次调用show方法
        showM.invoke(obj,null);
        System.out.println(obj);

    }
}

