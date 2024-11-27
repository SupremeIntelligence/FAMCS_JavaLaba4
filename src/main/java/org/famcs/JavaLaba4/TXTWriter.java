package org.famcs.JavaLaba4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TXTWriter implements DataWriter
{
    private String filePath;

    TXTWriter ()
    {
        filePath = "output.txt";
    }
    TXTWriter(String filename)
    {
        filePath = filename;
    }

    @Override
    public String getFilePath()
    {
        return filePath;
    }

    @Override
    public void write (CoffeeMakerCollection collection)
    {
        try (FileWriter output = new FileWriter (filePath+ ".txt");)
        {
            output.write(collection.toString());
        }
        catch (IOException error)
        {
            System.out.println("\nError writing to file " + filePath + ".txt" +"\n" + error.getMessage());
        }
    }
    public void zipArchive (String zipfilename)
    {
        try
        {
            FileInputStream fileInput = new FileInputStream(filePath);
            FileOutputStream fileOutput = new FileOutputStream(zipfilename);
            ZipOutputStream zipOutput = new ZipOutputStream(fileOutput);

            ZipEntry zipEntry = new ZipEntry(filePath);
            zipOutput.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInput.read(buffer)) >= 0)
            {
                zipOutput.write(buffer, 0, length);
            }
            zipOutput.close();
        }
        catch (IOException e)
        {
            System.out.println("Error archiving file " + e.getMessage());
        }
    }

    public void jarArchive(String jarfilename)
    {
        try 
        {
            FileInputStream fileInput = new FileInputStream(filePath + ".txt");
            FileOutputStream fileOutput = new FileOutputStream(jarfilename);
            JarOutputStream jarOutput = new JarOutputStream(fileOutput);

            JarEntry jarEntry = new JarEntry(filePath + ".txt");
            jarOutput.putNextEntry(jarEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInput.read(buffer)) >= 0)
            {
                jarOutput.write(buffer, 0, length);
            }
            jarOutput.close();

        } 
        catch (IOException e) 
        {
            System.out.println("Error archiving file " + e.getMessage());
        }
        
    }
}
