package com.handsom.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的高级用法
 */
public class RegexAdvance {

    /**
     * 环视，不匹配字符，而是特定的位置，比如大数字加逗号"1345347834" -> "1,345,347,834"
     * 顺序环视"(?=)"，逆序环视"(?<=)"
     * @see RegexAdvance#lookAround()
     */
    {
        //意思是这个位置的后面是handsome，就能匹配上那个位置，字符不占位置，可以理解成字符之间的间隙
        String regAsc = "(?=handsome)";

        //意思是这个位置的前面是handsome，就能匹配上那个位置，字符不占位置，可以理解成字符之间的间隙
        String regDesc = "(?<=handsome)";
    }

    public static void main(String[] args) {
        lookAround2();
    }

    //顺序环视
    private static void lookAround(){
        String str = "jerry is handsome very much";

        //这个"(?=handsome)"能匹配上空格符号' '和handsome的'h'符号之间的位置，然后这个位置的下面就是匹配"handsome"
        //"(?=handsome)handsome"所以这个匹配的就是handsome，"(?=handsome)"单纯这个是匹配位置，没有匹配的文本的
        String reg = "(?=handsome)handsome";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(str);
        if(matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
        System.out.println();
    }

    //逆序环视
    private static void lookAround2(){
        String str = "jerry is handsome very much";

        //这个"(?<=handsome)"能匹配上handsome的'e'符号和"very前面"空格符号' '和之间的位置，然后这个位置的下面就是匹配" very"
        //"(?<=handsome) very"所以这个匹配的就是" very"，"(?<=handsome)"单纯这个是匹配位置，没有匹配的文本的
        String reg = "(?<=handsome) very";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(str);
        if(matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
        System.out.println();
    }
}
