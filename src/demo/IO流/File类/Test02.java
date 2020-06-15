package demo.IO流.File类;

import java.io.File;

public class Test02 {

    public static void main(String[] args) {
        listSub1("src/files");
        listSub2("src/files");
    }

    //获得当前路径下所有文件和文件夹的名字
    private static void listSub1(String dirname){
        File f = new File(dirname);
        String[] sub = f.list();  //获取
        for (String s : sub) {
            System.out.println(s);
        }
    }

    //获取当前路径下所有文件和文件夹的绝对路径，包括子文件夹的内容
    private static void listSub2(String dirname){
        File f = new File(dirname);
        File[] files = f.listFiles();  //获取
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
            //如果是一个文件夹
            if (file.isDirectory()){
                listSub2(file.getPath());  //递归调用，打印该文件夹下的所有文件和文件夹信息
            }
        }
    }

}
