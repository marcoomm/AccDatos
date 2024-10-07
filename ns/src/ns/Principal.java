/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ns;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author FP
 */
/*
public class Principal {

    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, TransformerException, FileNotFoundException, SAXException, IOException {

        ArrayList<Empleado> empleados = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("C:\\Users\\marke\\Documents\\NetBeansProjects\\ns\\empleados.xml");
        //Document doc = builder.parse("C:\\Users\\FP\\Documents\\NetBeansProjects\\Interfazes\\xml\\empleados.xml");
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("empleado");

        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) node;

                String id = eElement.getAttribute("id");
                String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
                String apellido = eElement.getElementsByTagName("apellido").item(0).getTextContent();
                String ciudad = eElement.getElementsByTagName("ciudad").item(0).getTextContent();

                empleados.add(new Empleado(id, nombre, apellido, ciudad));

            }
        }

        for (Empleado e : empleados) {
            System.out.println(empleados.toString());
        }

        Empleado empleadoNuevo = new Empleado("", "", "", "");
        empleados.add(empleadoNuevo);
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
        Document document = dBuilder.newDocument();
        Element root = document.createElement("empleados");
        doc.appendChild(root);

        for (Empleado e1 : empleados) {

            Element moduloEmpleado = document.createElement("empleado");
            moduloEmpleado.setAttribute("id", e1.getId());
            root.appendChild(moduloEmpleado);

            Element moduloNombre = document.createElement("nombre");
            moduloNombre.appendChild(document.createTextNode(e1.getNombre()));
            moduloEmpleado.appendChild(moduloNombre);

            Element moduloApellido = document.createElement("apellido");
            moduloApellido.appendChild(document.createTextNode(e1.getApellido()));
            moduloEmpleado.appendChild(moduloApellido);

            Element moduloCiudad = document.createElement("ciudad");
            moduloCiudad.appendChild(document.createTextNode(e1.getCiudad()));
            moduloEmpleado.appendChild(moduloCiudad);

        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileOutputStream("empleados3" + ".xml"));
        transformer.transform(source, result);
        System.out.println("Datos actualizados");
    }

}*/
public class Principal {

    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, TransformerException, FileNotFoundException, IOException {

        // Crear la lista de empleados
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("1", "Juan", "Pérez", "Madrid"));
        empleados.add(new Empleado("2", "María", "Gómez", "Barcelona"));
        empleados.add(new Empleado("3", "Luis", "Fernández", "Sevilla"));

        // Crear un nuevo documento XML
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
        Document document = dBuilder.newDocument();

        // Crear el elemento raíz <empleados>
        Element root = document.createElement("empleados");
        document.appendChild(root);

        // Agregar cada empleado del ArrayList al documento XML
        for (Empleado e : empleados) {
            Element moduloEmpleado = document.createElement("empleado");
            moduloEmpleado.setAttribute("id", e.getId());
            root.appendChild(moduloEmpleado);

            Element moduloNombre = document.createElement("nombre");
            moduloNombre.appendChild(document.createTextNode(e.getNombre()));
            moduloEmpleado.appendChild(moduloNombre);

            Element moduloApellido = document.createElement("apellido");
            moduloApellido.appendChild(document.createTextNode(e.getApellido()));
            moduloEmpleado.appendChild(moduloApellido);

            Element moduloCiudad = document.createElement("ciudad");
            moduloCiudad.appendChild(document.createTextNode(e.getCiudad()));
            moduloEmpleado.appendChild(moduloCiudad);
        }

        // Guardar el archivo XML con la estructura creada
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new FileOutputStream("empleados.xml"));
        transformer.transform(source, result);

        System.out.println("Archivo XML creado con la lista inicial de empleados.");

        // Aquí podrías agregar más empleados al ArrayList y regenerar el archivo si fuera necesario
        Empleado empleadoNuevo = new Empleado("4", "Ana", "Martínez", "Valencia");
        empleados.add(empleadoNuevo);

        // Crear de nuevo el archivo XML con el nuevo empleado agregado
        Document document2 = dBuilder.newDocument();
        Element root2 = document2.createElement("empleados");
        document2.appendChild(root2);

        for (Empleado e : empleados) {
            Element moduloEmpleado = document2.createElement("empleado");
            moduloEmpleado.setAttribute("id", e.getId());
            root2.appendChild(moduloEmpleado);

            Element moduloNombre = document2.createElement("nombre");
            moduloNombre.appendChild(document2.createTextNode(e.getNombre()));
            moduloEmpleado.appendChild(moduloNombre);

            Element moduloApellido = document.createElement("apellido");
            moduloApellido.appendChild(document2.createTextNode(e.getApellido()));
            moduloEmpleado.appendChild(moduloApellido);

            Element moduloCiudad = document.createElement("ciudad");
            moduloCiudad.appendChild(document2.createTextNode(e.getCiudad()));
            moduloEmpleado.appendChild(moduloCiudad);
        }

        // Guardar el nuevo archivo XML actualizado
        StreamResult result2 = new StreamResult(new FileOutputStream("empleados_actualizado.xml"));
        transformer.transform(new DOMSource(document2), result2);

        System.out.println("Archivo XML actualizado con el nuevo empleado.");
    }
}