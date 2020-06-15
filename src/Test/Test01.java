package Test;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        String stringA = "AAaaaAa";
        String stringB = "aa";
        String stringC = "ca";

        int lenA = stringA.length();  //7
        int lenB = stringB.length();  //2
        int lenC = stringC.length();  //2

        char[] charsC = stringC.toCharArray();
        for (int i = 0; i < lenA-1; i++){  //AA Aa aa aa aA Aa
            char[] charsA = stringA.toCharArray();
            String s = charsA[i]+"";
            for (int j = 0; j < lenB-1; j++) {
                int count = i;
                s += charsA[++count];
            }
            //判断是否包含
            if (s.equals(stringB)){
                for (int k = 0; k < lenB; k++){
                    charsA[k+i] = charsC[k];
                }
            }
            //将字符数组转换成字符串
            StringBuffer sb = new StringBuffer();
            for (char c : charsA) {
                sb.append(c);
            }
            stringA = sb.toString();
        }



        System.out.println(stringA);

    }
}
