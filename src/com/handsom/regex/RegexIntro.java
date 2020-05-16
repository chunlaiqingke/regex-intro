package com.handsom.regex;

import java.util.ArrayList;
import java.util.List;
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

    //可选元素 ?
    {
        //匹配某个元素有或者没有，这里匹配"color"或者"colour",即u字符有一次或者没有
        String reg = "colou?r";
        //如果想作用于多个元素，打上小括号即可 ,即匹配"seven"或者"seventh"
        String regMulti = "seven(th)?";
    }

    //重复出现   和可选元素符号"?"的作用类似
    {
        //"+" 表示"之前紧邻的元素出现一次或多次”，而"*" 表示“之前紧邻的元素出现任意多次，或者不出现
        //这个可以匹配"hadoop",也可以匹配“hadop”,但是不可以匹配"hadp"
        String reg = "hado+p";
        //这个可以匹配"hadoop",也可以匹配“hadop”,还可以匹配"hadp"
        String reg2 = "hado*p";
        //也可以使用小括号匹配多个元素
        String reg3 = "had(op)+";

        //这里讲一个特殊符号"."点号，在字符组的时候提过,点可匹配任意单个字符
        //加上"*"之后就可以匹配任意字符串，这个经常用到，目的是忽略你不关心的那部分字符串
        String regDot = ".*";
    }

    //=================================================================

    //重头戏
    //小括号的作用：之前已经提到2个基本的作用。1: 限制多选结构的范围，即"|"可以打括号；2: 重复出现操作的单元
    //第三个功能（important）：捕获文本，反向引用
    {
        /**
         * 反向引用是正则表达式的特性之一，它容许我们匹配与表达式先前部分匹配的同样的文本
         * @see RegexIntro#brackets()
         */
        String reg = "([a-zA-Z]+) +\\1";

        /**
         * 分组捕获
         */
        String regGroup = "";
    }



    public static void main(String[] args) {
        capture();
    }

    //java中的正则表达式的简单使用
    public static void apiIntro(){
        String reg = "\\bcat\\b";
        Pattern compile = Pattern.compile(reg);
        String target = "cat bit me category";
        Matcher matcher = compile.matcher(target);
        //是否有匹配的子串
        boolean b = matcher.find();
        //整个字符串是否完全匹配
        boolean matches = matcher.matches();
        //匹配上的子串值
        String group = matcher.group();
        int end = matcher.end();
        System.out.println(end);
    }

    public static void brackets(){
        //"([a-zA-Z]+)" 这个表示一个单元，"\\1"表示这个前面的第一个单元（即第一个括号），"\\2"表示前面第二个括号的内容，以此类推
        String reg = "([a-zA-Z]+) +\\1";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher("the the the   the");
        if(matcher.find()){
            //这里的group是"the the"
            String group = matcher.group();
            //group1是"the"
            String group1 = matcher.group(1);
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(start + ";" + end + ";" + group);
        }
    }

    public static void capture(){
        String s = "dsadsadas<peter>dsadasdas<lionel>\"www.163.com\"<kenny><>";
        Pattern p = Pattern.compile("(<[^>]*>)");
        Matcher m = p.matcher(s);
        List<String> result=new ArrayList<String>();
        while(m.find()){
            result.add(m.group());
        }
        for(String s1:result){
            System.out.println(s1);
        }
    }
}
