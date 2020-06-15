package demo.IO流.File类;

import java.io.File;
import java.io.IOException;

public class Test01 {

    public static void main(String[] args) throws IOException {

        //创建文件夹
        File f1 = new File("src/files/Java");
        f1.mkdir();  //创建文件夹 make dir

        File f2 = new File("src/files/Java/sub1");
        f2.mkdir();

        File f3 = new File("src/files/Java","sub2");
        f3.mkdir();

        //创建文件
        File f4 = new File("src/files/Java","java11");
        f4.createNewFile();

        File f5 = new File(f1,"java22");
        f5.createNewFile();

        //获取文件/文件夹属性（不存在的文件或目录也可以调用下面方法）
        File ff1 = new File("src/files/aaa.txt");
        System.out.println(ff1.getAbsolutePath());  //绝对路径
        System.out.println(ff1.getPath());          //路径
        System.out.println(ff1.getParent());        //上一级目录
        System.out.println(ff1.getName());          //对象名(文件名)
        System.out.println(ff1.length());           //文件大小
        System.out.println(ff1.exists());           //是否存在
        System.out.println(ff1.isFile());           //是不是文件
        System.out.println(ff1.isDirectory());      //是不是文件夹
        System.out.println(ff1.isAbsolute());       //是不是绝对路径
        System.out.println(ff1.lastModified());     //最后一次修改时间

    }

}
