package org.famcs.JavaLaba4;

import java.io.FileWriter;
import java.io.IOException;

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
}
