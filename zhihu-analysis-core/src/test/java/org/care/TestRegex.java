package org.care;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by van persie on 2017/2/21.
 */
public class TestRegex{
    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
    private static final String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符

    static public void main(String[] args) {
//        String str = "<div style='text-align:center;'> 整治“四风”   清弊除垢<br/><span style='font-size:14px;'> </span><span style='font-size:18px;'>公司召开党的群众路线教育实践活动动员大会。</span><br/></div>";
//        System.out.println(deleteHtml(str));

//        testGreedyQuantifiers();

//        String regex = "<SCRIPT type=\"text/javascript\">alert('hello world')</SCRIPT>xixihaha";
//        Pattern p = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
//        Matcher m = p.matcher(regex);
//        System.out.println(m.replaceAll(""));

//        String ss = "<script[^>]*?>";
//        String ss = "<script.*?>\\s*";
//        String ss = "<script[^>]+>";

//        String sss = "<script ksjdfksdkfkdsj>   >3333>";
//        String sss = "<script4>ddd<scripthhh>";
//        Pattern p = Pattern.compile(ss, Pattern.CASE_INSENSITIVE);
//        Matcher m = p.matcher(sss);
//        System.out.println(m.replaceAll(""));
//        System.out.println(System.lineSeparator());
//        System.out.println(UUID.randomUUID().toString());

        String md = DigestUtils.md5Hex("app_keyabctimestamp201702282143516eabde4bb1d74326b71613e49ba8d376".getBytes());
        System.out.print(md);

    }

    static public String deleteHtml(String htmlStr) {
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签
        return htmlStr.trim();
    }



    static public void testGreedyQuantifiers() {
//        String regext = "(AA){2}";
        String regext = "(AA)+?";
        Pattern p = Pattern.compile(regext, Pattern.CASE_INSENSITIVE);
//        Pattern p = Pattern.compile(regext);
        Matcher m = p.matcher("aaaaddddaab");
        if (m.find()) {
//            System.out.println(true);
            System.out.println(m.group(0));
//            System.out.println(m.replaceAll(""));
        } else {
            System.out.print(false);
        }
    }


}
