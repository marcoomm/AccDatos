package modificarEmpleado;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import modificarEmpleado.Empleado;
import org.xml.sax.SAXException;

public class Principal {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, FileNotFoundException, SAXException, IOException {

        ArrayList<Empleado> empleados = new ArrayList<>();

        // Parsear el archivo XML existente
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("C:\\Users\\marke\\Desktop\\AccDatos\\modEmpleado\\empleados.xml");
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

        // Crear un nuevo documento XML
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
        Document document = dBuilder.newDocument();

        // Crear el elemento raíz y agregarlo al nuevo documento
        Element root = document.createElement("empleados");
        document.appendChild(root);
        
        Empleado empleadoNuevo = new Empleado("555", "Marco", "Vjola", "null");
        empleados.add(empleadoNuevo);
        
        // Agregar empleados existentes al nuevo documento
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

        // Agregar un nuevo empleado


        // Transformar y escribir el nuevo documento a un archivo XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document); // Usar el nuevo documento
        StreamResult result = new StreamResult(new FileOutputStream("empleados3.xml"));
        transformer.transform(source, result);
        System.out.println("Datos actualizados");
    }
}
