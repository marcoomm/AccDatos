/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esxcrituraDO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author FP
 */
public class principal {

    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException {
        String nombreFichero = "empleados";
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
        Document doc = dbuilder.newDocument();

        //raiz del documento y añadimos atributos
        Element root = doc.createElement("empleados");
        doc.appendChild(root);

        Element modulo = doc.createElement("empleado");
        modulo.setAttribute("id", "1");
        root.appendChild(modulo);

        Element nombre = doc.createElement("nombre");
        nombre.appendChild(doc.createTextNode("Mark"));
        modulo.appendChild(nombre);
        Element apellido = doc.createElement("apellido");
        apellido.appendChild(doc.createTextNode("Zuckenberg"));
        modulo.appendChild(apellido);
        Element ciudad = doc.createElement("ciudad");
        ciudad.appendChild(doc.createTextNode("Pajaritos"));
        modulo.appendChild(ciudad);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileOutputStream(nombreFichero + ".xml"));
        transformer.transform(source, result);
        System.out.println("Datos actualizados en el archivo XML");
    }

}
