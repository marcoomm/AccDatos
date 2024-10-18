package Ejercicio2;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Principal2 {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory
                = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder
                = factory.newDocumentBuilder();
        Document document = builder.parse(
                new File("C:\\Users\\marke\\Desktop\\AccDatos\\Examen181024_Marco\\src\\Ejercicio2\\feed-rss.xml"));
                //Document document = builder.parse(
                //new File("C:\\Users\\FP\\Desktop\\AccDatos\\Examen181024_Marco\\src\\Ejercicio2\\feed-rss.xml"));
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        //System.out.println(root.getNodeName());
        NodeList nList = document.
                getElementsByTagName("channel");
        Node nodo;
        Node nodo1;
        for (int i = 0; i < nList.getLength(); i++) {
            nodo = nList.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                System.out.println("Su titulo es: " + elemento.
                        getElementsByTagName("title").
                        item(0).getTextContent());
                System.out.println("Idioma: " + elemento.
                        getElementsByTagName("language").
                        item(0).getTextContent());
                System.out.println("-------------------------------------------------");
            }

        }
        NodeList nContent = document.getElementsByTagName("item");
        for (int j = 0; j < nContent.getLength(); j++) {
            nodo1 = nContent.item(j);
            if (nodo1.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo1;
                System.out.println("Descripcion del item: " + elemento.
                        getElementsByTagName("description").
                        item(0).getTextContent());
                System.out.println("Link: " + elemento.
                        getElementsByTagName("link").
                        item(0).getTextContent());
                System.out.println("PubDate: " + elemento.
                        getElementsByTagName("pubDate").
                        item(0).getTextContent());
                System.out.println("-------------------------------------------------");
            }
        }
        System.out.println("-------------------------------------------------");
    }
}
