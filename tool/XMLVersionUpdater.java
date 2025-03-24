import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;
import org.xml.sax.InputSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class XMLVersionUpdater {
    public static void main(String[] args) {


        String filePath = "../models/main.xml";
       
        try {
            String xmlContent = new String(Files.readAllBytes(Paths.get(filePath)));
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlContent)));

            // Get the root element
            Element rootElement = document.getDocumentElement();

            // Update the version attribute
            String currentVersionStr = rootElement.getAttribute("version");
            int currentVersion = Integer.parseInt(currentVersionStr);
            rootElement.setAttribute("version", String.valueOf(currentVersion + 1));

            // Transform the DOM back to a string
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "no");

            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));

            String updatedXML = writer.toString();
            Files.write(Paths.get(filePath), updatedXML.getBytes(StandardCharsets.UTF_8));

            System.out.println(currentVersion+1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
