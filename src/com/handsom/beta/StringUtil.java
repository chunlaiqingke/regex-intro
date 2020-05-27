package com.handsom.beta;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author junzhao
 * @date 2020/5/27 15:23
 */
public class StringUtil {
    /**
     * 抽取字符串，抽取pre和post之间的值
     * @param str
     * @param pre
     * @param post
     * @return
     */
    public static List<String> extract(String str, String pre, String post){
        List<String> result = new ArrayList<>();
        if(str == null || str.length() <= 0){
            return result;
        }
        String reg = "(\\w+)";
        reg = pre != null ? pre + reg : reg;
        reg = post != null ? reg + post : reg;
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(str);
        while (matcher.find()){
            result.add(matcher.group());
        }
        return result;
    }

    /**
     *  todo 给字符串插入值，比如金额插入逗号，电话插入破折号
     *  @see RegExUtil#join(String, String, String)
     * @param str
     * @param join
     * @return
     */
    @Deprecated
    public static String join(String str, String join){
        return str;
    }

    public static int match(String str, String seq) {
        Pattern compile = Pattern.compile(seq);
        Matcher matcher = compile.matcher(str);
        return matcher.groupCount();
    }

    public static Map<String, String> extractKeys(String str, List<String> keys){
        return null;
    }
}
