package com.handsom.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args) {
        addComma();
    }

    /**
     * 大数字加逗号"1345347834" -> "1,345,347,834"
     */
    public static void addComma(){
        String reg = "(?<=\\d)(?=(\\d\\d\\d)+$)";
        String str = "1345347834";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(str);
        //这个s值就是我们期待的
        String s = matcher.replaceAll(",");
        System.out.println(s);

        //神奇的是这个方法是不生效的，有知道的朋友告知一下
        String replace = str.replace(reg, ",");
        System.out.println(replace);

    }
}
