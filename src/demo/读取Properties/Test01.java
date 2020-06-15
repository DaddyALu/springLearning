package demo.读取Properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

/**
 * 通过IO、Properties、反射技术，读取配置文件的信息
 */
public class Test01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        // 1）通过Properties和IO流读取配置文件类名

            //1，创建一个属性配置对象
            Properties properties = new Properties();
            //2，把一个资源变成输入流
            InputStream is = Test01.class.getResourceAsStream("/demo/读取Properties/config.properties");
            //另一种加载方式
            //InputStream is = Test01.class.getClassLoader().getResourceAsStream("demo/读取Properties/config.properties");

            //3，导入输入流
            properties.load(is);
            //4，读取属性
            String className1 = properties.getProperty("classname1");  //ArrayList
            String className2 = properties.getProperty("classname2");  //LinkedList
            String className3 = properties.getProperty("classname3");  //HashSet

        // 2）通过反射技术，根据完整类名创建Class对象
        Class<?> class1 = Class.forName(className1);
        Class<?> class2 = Class.forName(className2);
        Class<?> class3 = Class.forName(className3);


        // 3）反射，创建类的实例
        Collection<String> collection1 = (Collection<String>)class1.newInstance();  //根据获取到的类名创建的的三个类，都是Collection的实现类
        Collection<?> collection2 = (Collection<?>)class2.newInstance();
        Collection<?> collection3 = (Collection<?>)class3.newInstance();

        collection1.add("aaa");
        collection1.add("bbb");
        collection1.add("ccc");
        System.out.println(collection1);

        //测试
        Class<ArrayList> class4 = ArrayList.class;
        Collection<String> collection4 = class4.newInstance();  // 相当于 = new ArrayList;
        collection4.add("ff");
        collection4.add("gg");
        System.out.println(collection4);
    }
}
