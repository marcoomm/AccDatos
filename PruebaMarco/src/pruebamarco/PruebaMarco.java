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

        String xml = "camaras.xml"; // Ruta del archivo XML
        String txt = "insertat.txt"; // Ruta del archivo de salida TXT

        // Cargar el archivo XML
        File xmlFile = new File(xml);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        // Normalizar el documento
        doc.getDocumentElement().normalize();

        // Obtener la lista de elementos "camara"
        NodeList camaraList = doc.getElementsByTagName("camara");

        // Crear el archivo de salida
        FileWriter writer = new FileWriter(txt);

        // Recorrer cada elemento "camara"
        for (int i = 0; i < camaraList.getLength(); i++) {
            Node camaraNode = camaraList.item(i);

            if (camaraNode.getNodeType() == Node.ELEMENT_NODE) {
                Element camaraElement = (Element) camaraNode;

                // Obtener los datos de la cámara
                String id = camaraElement.getAttribute("id");
                String modelo = camaraElement.getElementsByTagName("modelo").item(0).getTextContent();
                String marca = camaraElement.getElementsByTagName("marca").item(0).getTextContent();
                String altura = camaraElement.getElementsByTagName("altura").item(0).getTextContent();
                String anchura = camaraElement.getElementsByTagName("anchura").item(0).getTextContent();
                String profundidad = camaraElement.getElementsByTagName("profundidad").item(0).getTextContent();
                String peso = camaraElement.getElementsByTagName("peso").item(0).getTextContent();
                String megapixeles = camaraElement.getElementsByTagName("megapixeles").item(0).getTextContent();
                String comentarios = camaraElement.getElementsByTagName("comentarios").item(0).getTextContent();

                // Usar StringBuilder para construir el contenido
                StringBuilder camaraInfo = new StringBuilder();
                camaraInfo.append("Cámara ID: ").append(id).append("\n");
                camaraInfo.append("Modelo: ").append(modelo).append("\n");
                camaraInfo.append("Marca: ").append(marca).append("\n");
                camaraInfo.append("Dimensiones: ").append(altura).append(" x ").append(anchura)
                          .append(" x ").append(profundidad).append("\n");
                camaraInfo.append("Peso: ").append(peso).append("\n");
                camaraInfo.append("Megapíxeles: ").append(megapixeles).append("\n");
                camaraInfo.append("Comentarios: ").append(comentarios).append("\n\n");

                // Escribir en el archivo de salida
                writer.write(camaraInfo.toString());
            }
        }

        // Cerrar el archivo
        writer.close();
        System.out.println("El archivo de texto se ha actualizado correctamente.");
        
    }
}
