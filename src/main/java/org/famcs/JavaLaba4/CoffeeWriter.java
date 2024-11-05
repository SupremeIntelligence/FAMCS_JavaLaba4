package org.famcs.JavaLaba4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CoffeeWriter 
{
    private String filePath;

    CoffeeWriter ()
    {
        filePath = "output.txt";
    }
    CoffeeWriter(String filename)
    {
        filePath = filename;
    }

    public String getfilePath()
    {
        return filePath;
    }

    public void write (CoffeeMakerCollection obj)
    {
        try (FileWriter output = new FileWriter (filePath);)
        {
            output.write(obj.toString());
        }
        catch (IOException error)
        {
            System.out.println("\nError writing to file " + filePath +"\n" + error.getMessage());
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
            System.out.println("Error archivating file " + e.getMessage());
        }
    }
}
