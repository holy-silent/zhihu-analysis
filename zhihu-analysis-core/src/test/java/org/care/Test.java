package org.care;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by van persie on 2017/2/14.
 */
public class Test {
    private static String FOLLOWING_LIST = "https://www\\.zhihu\\.com/people/.*/following";

    private static String FOLLOWERS_LIST = "https://www\\.zhihu\\.com/people/\\w+/followers";

    private static String USER_HREF = "https://www\\.zhihu\\.com/people/\\w+";

    private static String BLOG = "http://blog\\.sina\\.com\\.cn/s/blog_\\w+\\.html";

    public static void main(String[] args) {
//        String ss = "https://www.zhihu.com/people/van-persie-42/following";
//        if (ss.matches(FOLLOWING_LIST)){
//            System.out.print("true");
//        } else {
//            System.out.print("false");
//        }

//        String ss1 = "http://blog.sina.com.cn/s/blog_dfsfdsf.html";
//        if (ss1.matches(BLOG)){
//            System.out.print("true");
//        } else {System.out.print("false");}

//        String s = "A876X";
// 把要匹配的字符串写成正则表达式，然后要提取的字符使用括号括起来
// 在这里，我们要提取最后一个数字，正则规则就是“一个数字加上大于等于0个非数字再加上结束符”
//        Pattern pattern = Pattern.compile("(\\d)[^\\d]*$");
//        Matcher matcher = pattern.matcher(s);
//        if(matcher.find())
//            System.out.println(matcher.group(1));


//        String s1 = "<a class=\"Profile-sideColumnItemLink\" href=\"https://www.zhihu.com/people/kaifulee/logs\" target=\"_blank\">参与     76666     次公共编辑</a>";
//
//        Pattern pattern1 = Pattern.compile("参与\\s*(\\d*)\\s*次公共编辑");
//        Matcher matcher1 = pattern1.matcher(s1);
//        if(matcher1.find())
//            System.out.println(matcher1.group(1));


        List<String> list = new ArrayList<String>();
        list.add("https://www.zhihu.com/people/rosicky311/answers/topic/19552582");
        list.add("https://www.zhihu.com/people/rosicky311");
        list.add("https://www.zhihu.com/people/rosicky311/answers/topic/19550560");
        list.add("https://www.zhihu.com/people/rosicky");
        list.add("https://www.zhihu.com/people/li-lao-shu/followers");
//        for (String href : list) {
//            String[] hrefArray = href.split("/people/");
//            if (hrefArray.length > 1) {
//                if (hrefArray[1].indexOf("/") > 0) {
//                    list.remove(href);
//                }
//            } else {
//                list.remove(href);
//            }
//        }

        for (Iterator<String> it = list.iterator(); it.hasNext();) {

            String str = it.next();

            String[] hrefArray = str.split("/people/");
            if (hrefArray.length > 1) {
                if (hrefArray[1].indexOf("/") > 0) {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}
