package com.handsom.beta;

/**
 * 可以传入正则表达式进行匹配
 * @author junzhao
 * @date 2020/5/27 15:51
 */
public class RegExUtil {

    /**
     * 给字符串插入值，比如金额插入逗号，电话插入破折号
     * @see String#replace(char, char)
     * @param str
     * @param reg
     * @param join
     * @return
     */
    public static String join(String str, String reg, String join){
        if(str == null) {
            return null;
        }
        return str.replaceAll(reg, join);
    }

    /**
     * 字符串替换
     * @param str
     * @param reg
     * @param replacement
     * @return
     */
    public static String replaceAll(String str, String reg, String replacement) {
        if(str == null || str.length() <= 0) {
            return str;
        }
        return str.replaceAll(reg, replacement);
    }
}
