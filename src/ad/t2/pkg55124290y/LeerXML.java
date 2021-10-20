package ad.t2.pkg55124290y;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class LeerXML {

    public static void main(String[] args) {

        //Creación del documento:
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            System.out.println("Ha habido un error al crear el DOM. Más información: " + ex);
        }

        //Fichero que será leído
        File ficheroXML = new File(System.getProperty("user.home") + File.separator + "Desktop", "alumno.xml");

        //Parseo del documento
        Document documento = null;
        try {
            documento = builder.parse(ficheroXML);
        } catch (SAXException ex) {
            System.out.println("Ha habido un error al parsear el documento. Más información: " + ex);
        } catch (IOException ex) {
            System.out.println("Ha habido un error al obtener el fichero XML. Más información: " + ex);
        }

        //Normalización del documento
        documento.getDocumentElement().normalize();

        //Creación de la lista de nodos con todos los nodos de la raíz
        NodeList raiz = documento.getElementsByTagName("Alumno");

        //Etiqueta de apertura de la raiz
        System.out.println("<" + documento.getDocumentElement().getNodeName() + ">");

        //Lista de nodos hijos de la raiz
        NodeList listaNodos = raiz.item(0).getChildNodes();
        
        for (int i = 0; i < listaNodos.getLength(); i++) {
            
            //Se toma cada nodo "Nombre"
            Node nodo = listaNodos.item(i);
            
            //Etiqueta de apartura del nodo
            System.out.print("\t<" + nodo.getNodeName() + ">");
        
            //Comprobamos que es una etiqueta, y en ese caso de serlo obtenemos su texto
            if(nodo.getNodeType()== Node.ELEMENT_NODE){
                //Texto de la etiqueta
                System.out.print(nodo.getFirstChild().getNodeValue());
            }
            //Etiqueta de cierre del nodo
            System.out.println("</" + nodo.getNodeName() + ">");
        }
        //Etiqueta de cierre de la raíz
        System.out.println("</" + documento.getDocumentElement().getNodeName() + ">");
    }
}
