package org.famcs.JavaLaba4;

import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWriter 
{
    private String filePath;
    private Document document;


    public XMLWriter (String filename)
    {
        filePath = filename;
        document = null;
    }
    public XMLWriter() 
    {
        filePath = "output.xml";
        document = null;
    }
    public String getFilePath()
    {
        return filePath;
    }
    public Document getDocument()
    {
        return document;
    }

    public void write (CoffeeMakerCollection collection)
    {
        Element root = document.getDocumentElement();
        int size = collection.getSize();

        CoffeeFabric obj;
        for (int i = 0; i < size; i++)
        {
            obj = collection.getItem(i);
            write(obj, root);
        }
        try 
        {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(filePath);
            transformer.transform(source, result);

        } 
        catch (TransformerException e ) 
        {
            System.out.println ("Error transforming to XML file: " + e.getMessage());
        }
            
    }

    private void write (CoffeeFabric obj, Element root)
    {
        Element itemRoot = document.createElement("CoffeeMaker");
        itemRoot.setAttribute("ID", Integer.toString(obj.getID()));
        root.appendChild(itemRoot);

        createItemChild(itemRoot, "Brand", obj.getBrand());
        createItemChild(itemRoot, "Model", obj.getModel());
        String power = Integer.toString(obj.getPower());
        createItemChild(itemRoot, "Power", power);
        String price = Double.toString(obj.getPrice());
        createItemChild(itemRoot, "Price", price);
        SimpleDateFormat dateFrmt = new SimpleDateFormat("dd:MM:yyyy");
        String date = dateFrmt.format(obj.getDate());
        createItemChild(itemRoot, "ReleaseDate", date);
        
    }
    private void createItemChild (Element item, String tag, String context)
    {
        Element child = document.createElement(tag);
        child.appendChild(document.createTextNode(context));
        item.appendChild(child);
    }

    public void configure ()
    {
        try 
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder builder = factory.newDocumentBuilder();
    
            document = builder.newDocument();
            Element root = document.createElement("CoffeeMakers");
            document.appendChild(root);
        } 
        catch (ParserConfigurationException e) 
        {
            System.out.println("Error configurating XML file: " + e.getMessage());
        }
    }

}
