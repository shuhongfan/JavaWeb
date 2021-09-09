import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
//        获取document对象，根据xml文档获取
//        1.获取path
        String path = JsoupDemo1.class.getClassLoader().getResource("users.xml").getPath();
//        2.文档对象  解析xml文档,加载文档进内存,获取dom树
        Document document = Jsoup.parse(new File(path), "utf-8");
//        3. 获取元素对象
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
//        4. 获取数据
        String name = elements.text();
        System.out.println(name);

        String str="<users>\n" +
                "    <user id=\"1\">\n" +
                "        <name>zhangsan</name>\n" +
                "        <age>23</age>\n" +
                "        <gender>male</gender>\n" +
                "    </user>\n" +
                "\n" +
                "    <user id=\"2\">\n" +
                "        <name>lisi</name>\n" +
                "        <age>24</age>\n" +
                "        <gender>female</gender>\n" +
                "        <code>\n" +
                "            <![CDATA[\n" +
                "                if(a<b && a>c)\n" +
                "            ]]>\n" +
                "\n" +
                "        </code>\n" +
                "    </user>\n" +
                "</users>";
        Document document1 = Jsoup.parse(str);
        Elements age = document1.getElementsByTag("age");
        System.out.println(age.text());
    }
}
