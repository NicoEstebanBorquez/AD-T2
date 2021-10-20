package ad.t2.pkg55124290y;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class EscribirXML {

    public static void main(String[] args) {

        //Creación del documento:
        DOMImplementation implementacion = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            implementacion = builder.getDOMImplementation();
        } catch (ParserConfigurationException ex) {
            System.out.println("Ha habido un error al crear el DOM. Más información: " + ex);
        }

        Document documento = implementacion.createDocument(null, "Alumno", null);
        documento.setXmlVersion("1.0");

        //-------------------------------------
        //Creación de la etiqueta "Nombre"
        Element etiqueta = documento.createElement("Nombre");

        //Creación del texto
        Node texto = documento.createTextNode("Nicolas Esteban Borquez");

        //Obtención del emento raíz y posterior añadido del ejemento hijo "Nombre"
        documento.getDocumentElement().appendChild(etiqueta);

        //Añadido del texto a la etiqueta
        etiqueta.appendChild(texto);

        //----------------------------------------
        
        //Transformación del Document XML a un archivo XML final
        //Creación del documento fuente
        Source documentoFuente = new DOMSource(documento);

        //Ceación del fichero de destino
        File ficheroXML = new File(System.getProperty("user.home") + File.separator + "Desktop", "alumno.xml");

        //Creación del flujo hasta el documento de destino
        Result result = new StreamResult(ficheroXML);

        try {
            Transformer transformador = TransformerFactory.newInstance().newTransformer();
            transformador.transform(documentoFuente, result);
        } catch (TransformerConfigurationException ex) {
            System.out.println("Ha habido un error al crear el Transformer. Más información: " + ex);
        } catch (TransformerException ex) {
            System.out.println("Ha habido un error al realizar la transformación del documento. Más información: " + ex);
        }
    }
}
