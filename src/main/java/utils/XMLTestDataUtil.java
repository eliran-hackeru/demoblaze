package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLTestDataUtil {

    public static String getValue(String userKey, String fieldName) {
        try {
            File file = new File("src/main/resources/testData/userCredentials.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName(userKey);
            if (nodeList.getLength() > 0) {
                Element element = (Element) nodeList.item(0);
                return element.getElementsByTagName(fieldName).item(0).getTextContent();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read XML data", e);
        }
        return null;
    }
}