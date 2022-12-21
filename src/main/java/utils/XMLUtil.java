package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class XMLUtil {

    public static String readOutput(String XMLString, String tagName){
        StringBuilder response = new StringBuilder();
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(XMLString.getBytes("UTF-8"));
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = documentBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();
            Element element = doc.getDocumentElement();

            response.append(element.getElementsByTagName(tagName).item(0).getTextContent());
        } catch (IOException | ParserConfigurationException | SAXException e){
            e.printStackTrace();
        }

        return response.toString();
    }
}
