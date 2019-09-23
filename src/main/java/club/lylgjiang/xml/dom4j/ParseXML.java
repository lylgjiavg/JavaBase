package club.lylgjiang.xml.dom4j;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Classname ParseXML
 * @Description 解析XML
 * @Date 2019/9/23 8:52
 * @Created by Jiavg
 */
public class ParseXML {

    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        String path = ParseXML.class.getResource("").getPath();

        InputStream inputStream = new FileInputStream(path + "/" + "person.xml");

        Document document = documentBuilder.parse(inputStream);
        

    }
    
}
