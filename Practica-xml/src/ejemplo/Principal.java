/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo;

/**
 *
 * @author FP
 */
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.SAXException;

public class Principal {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("C:\\Users\\FP\\Desktop\\AccDatos\\Practica-xml\\productos.xml"));
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList nList = document.getElementsByTagName("producto");
        System.out.println("-.-");
        System.out.println("========================");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println("");
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                System.out.println("Producto id : " + eElement.getAttribute("id"));
                System.out.println("Nombre : " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("Característica 1 : " + eElement.getElementsByTagName("caracteristica1").item(0).getTextContent());
                System.out.println("Caracteristica 2 : " + eElement.getElementsByTagName("caracteristica2").item(0).getTextContent());
                System.out.println("Caracteristica 3 : " + eElement.getElementsByTagName("caracteristica3").item(0).getTextContent());
                System.out.println("Caracteristica 4 : " + eElement.getElementsByTagName("caracteristica4").item(0).getTextContent());
                System.out.println("Altura : "+eElement.getElementsByTagName("altura").item(0).getTextContent());
                System.out.println("Peso : "+eElement.getElementsByTagName("peso").item(0).getTextContent());
                System.out.println("Material : "+eElement.getElementsByTagName("material").item(0).getTextContent());
                System.out.print(";;");
                
                
            }
        }System.out.println(";;");
        System.out.println("");
    }

}
