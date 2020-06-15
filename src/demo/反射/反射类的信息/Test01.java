package demo.反射.反射类的信息;

import java.lang.reflect.Modifier;

/**
 * 反射一个类的信息
 */
public class Test01 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();

        // 1）创建类的对象
        Class<?> class1 = String.class;

        // 2）反射类的信息
            // 2.1 修饰符
            int mod = class1.getModifiers();  //返回类的修饰符(public/static...)，是一个整数
            String modifier = Modifier.toString(mod);  //将整数转换成字符串类型的相应修饰符
            sb.append(modifier);
            // 2.2 类名
            sb.append(" class ");
    //        sb.append(class1.getName());  //返回完整类名
            sb.append(class1.getSimpleName());  //返回简单类名
            // 2.3 父类
            Class<?> superClass1 = class1.getSuperclass();
            if (superClass1 != Object.class){  //如果继承的不是Object类才输出
                sb.append(" extends ");
                sb.append(superClass1.getSimpleName());
            }
            // 2.4 接口
            Class<?>[] interfaces = class1.getInterfaces();  //该类可能实现了多个接口，所以定义为数组
            if (interfaces.length > 0){  //说明实现了接口，有返回内容
                sb.append(" implements ");
                for (Class<?> i : interfaces) {  //遍历添加该类实现的所有接口
                    sb.append(i.getSimpleName()+",");
                }
            }

        //输出类的信息
        System.out.println(sb);
    }
}
