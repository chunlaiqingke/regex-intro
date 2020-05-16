package com.handsom.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 为了避免命名带来的不必要的麻烦，我使用代码块
 */
public class RegexIntro {
    //普通文本
    {
        //匹配cat字符串
        String reg = "cat";
    }

    //字符组
    {
        //包含括号中的任意一个字符，只能匹配一个
        String reg = "[abc]";
        //不包含括号中的任意一个,如“D”是能匹配的，这里的^是特殊符号，表示取反的意思
        String regNeg = "[^abc]";
        //范围符号,这个里面“-”是特殊字符，比如0-9表示0123456789，
        //特别注意，字符组中的特殊符号只有“-”和“^”，而且“-”不能出现在中括号的开头，出现在开头也是普通字符，所以组中的?./都是普通字符，跟组外是不一样的
        //在组外?./都是特殊符号
        String regRange = "[0-9a-zA-Z?./]";
    }

    //多选结构
    {
        //“|”表示或的意思,左右两边都是正则表达式，匹配“grey”或者“gray”，等价于“gr[ae]y”
        //还有一个等价的表示“(gray|grey)”，或者“gr(a|e)y”
        //特别说明这里是小括号，如果使用中括号，就是字符组了，就没有“或”的含义了，就是普通的字符
        //而且“gr(a|e)y”这种表示形式的小括号一定要打，否则“gra|ey”这个就变成了匹配"gra"或者"ey"
        String reg = "gray|grey";
    }

    //单词分界符 java是\b,有的语言不是，可能是\<
    {
        //"cat bit me category" 只能识别单词cat，category中的cat是不识别的
        //也可以只限制一边，如“cat\\b”
        String reg = "\\bcat\\b";
    }


    public static void main(String[] args) {
        String s = "\\bcat\\b";
        Pattern compile = Pattern.compile(s);
        Matcher matcher = compile.matcher("cat bit me category");
        boolean b = matcher.find();
        String group = matcher.group();
        int end = matcher.end();
        System.out.println(end);
    }
}
