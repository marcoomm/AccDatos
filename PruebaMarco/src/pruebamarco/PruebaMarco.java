/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebamarco;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.SAXException;

/**
 *
 * @author FP
 */
public class PruebaMarco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("C:\\Users\\FP\\Desktop\\AccDatos\\Practica-xml\\productos.xml"));

        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList nList = document.getElementsByTagName("camaras_web");

        //System.out.println("Lo ULTIMO de los camaras web");
        //System.out.println("==============================");
        
        File fichero = new File("insertar.txt");
        for (int temp = 0; temp < nList.getLength(); temp++) {

            FileWriter escribir = new FileWriter(fichero);
            Node node = nList.item(temp);

            //String frase1 = "Lo ultimo de las cámaras web";
            //String frase2 = "==============================";
            //escribir.WRITE(frase1).WRITE(frase2);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) node;
                String id = eElement.getAttribute("id");

                /*String id = eElement.getAttribute("id");
                String modelo = eElement.getElementsByTagName("modelo").item(0).getTextContent();
                String marca = eElement.getElementsByTagName("marca").item(0).getTextContent();
                String altura = eElement.getElementsByTagName("altura").item(0).getTextContent();
                String anchura = eElement.getElementsByTagName("altura").item(0).getTextContent();
                String profundidad = eElement.getElementsByTagName("profundidad").item(0).getTextContent();
                String peso = eElement.getElementsByTagName("peso").item(0).getTextContent();
                String megapixeles = eElement.getElementsByTagName("megapixeles").item(0).getTextContent();
                String comentarios = eElement.getElementsByTagName("comentarios").item(0).getTextContent();
                String señal = "**************************";
                String texto = "";
                escribir.write("id: "+id + " ¡¡" + "\n")/*.WRITE("modelo: "+modelo + " ¡¡" + "\n")
                        .WRITE("marca: "+marca + " ¡¡" + "\n")
                        .WRITE("altura: "+altura + " #" + "\n").WRITE("anchura: "+anchura + " @" + "\n")
                        .WRITE("profundidad: "+profundidad+" #"+"\n").WRITE("peso: "+peso+" @"+"\n")
                        .WRITE("megapixeles: "+megapixeles+" #"+"\n").WRITE("Comentarios :"+comentarios)
                        .WRITE("******");*/
                escribir.write("id: " + id + " ¡¡" + "\n");
                escribir.close();
            }

            //escribir.WRITE("FIN DEL DOCUMENTO XML");
        }

    }

}
