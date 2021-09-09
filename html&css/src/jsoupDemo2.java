import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class jsoupDemo2 {
    public static void main(String[] args) throws IOException {
//        1. 获取path
        String path = jsoupDemo2.class.getClassLoader().getResource("users.xml").getPath();
//        2. 获取document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
//        3. 获取元素对象
        Elements elements = document.getElementsByTag("user");
//        System.out.println(elements);

//        4. 获取属性名为id的元素对象
        Elements id = document.getElementsByAttribute("id");
        System.out.println(id);
        System.out.println("*****************");

//        5. 获取
        Elements number = document.getElementsByAttributeValue("number", "1");
        System.out.println(number);

        Elements name = document.getElementsByTag("name");
        System.out.println(name.size());
        String number1 = name.attr("number");
        System.out.println(number1);

        Elements elements1 = document.select("name");
        System.out.println(elements1);
        System.out.println("*****************");

        Elements elements2 = document.select("user[number='2']");
        System.out.println(elements2);
    }
}
