package org.famcs.JavaLaba4;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader 
{
    private String filePath;
    private Document document;


    public XMLReader (String filename)
    {
        filePath = filename;
        document = null;
    }
    public XMLReader() 
    {
        filePath = "input.xml";
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

    public void configure ()
    {
        try 
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            document = builder.parse(filePath);
        }
        catch (ParserConfigurationException e) 
        {
            System.out.println("Error configurating XML file: " + e.getMessage());
        }
        catch (SAXException e)
        {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println("Error reading XML file: " + e.getMessage());
        }
    }
    public void read (CoffeeMakerCollection collection)
    {
        NodeList nodeList = document.getElementsByTagName("CoffeeMaker");
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);
            if (node.getNodeType() == node.ELEMENT_NODE)
            {
                Element item = (Element) node;
                collection.add(parse(item));
            }
        }

    }
    private CoffeeFabric parse (Element item)
    {
        String ID = item.getAttribute("ID");
        String brand = item.getElementsByTagName("Brand").item(0).getTextContent();
        String model = item.getElementsByTagName("Model").item(0).getTextContent();
        String power = item.getElementsByTagName("Power").item(0).getTextContent();
        String price = item.getElementsByTagName("Price").item(0).getTextContent();
        String dateStr = item.getElementsByTagName("ReleaseDate").item(0).getTextContent();

        CoffeeMaker obj = new CoffeeMaker ();
        
        int IDvalue = Integer.parseInt(ID);
        obj.setID(IDvalue);

        obj.setBrand(brand);
        obj.setModel(model);

        int powervalue = Integer.parseInt(power);
        obj.setPower(powervalue);

        Double pricevalue = Double.parseDouble(price);
        obj.setPrice(pricevalue);

        SimpleDateFormat dateFrmt = new SimpleDateFormat("dd:MM:yyyy");
        try {
            Date date = dateFrmt.parse (dateStr);
            obj.setDate(date);
        }
        catch (ParseException error)
        {
            System.out.println ("Error parsing the string containing the date");
        }
        return obj;
    }
}
