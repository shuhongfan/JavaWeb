import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
//        1. 获取student.xml的path
        String path = JsoupDemo3.class.getClassLoader().getResource("users.xml").getPath();
//        2. 获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
//        3 .根据document对象,创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);
//        4结合xpath语法查询
        List<JXNode> jxNodes = jxDocument.selN("//user/name");
        for (JXNode jxNode:jxNodes) System.out.println(jxNode);
    }
}
