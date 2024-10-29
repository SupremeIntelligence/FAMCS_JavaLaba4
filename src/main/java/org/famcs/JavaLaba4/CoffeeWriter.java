package org.famcs.JavaLaba4;

import java.io.FileWriter;
import java.io.IOException;

public class CoffeeWriter 
{
    private String filePath;

    CoffeeWriter ()
    {
        //filePath = projectDirectory;
    }
    CoffeeWriter(String filename)
    {
        filePath = filename;
    }
    public void write (CoffeeMakerList obj)
    {
        try (FileWriter output = new FileWriter (filePath);)
        {
            

        }
        catch (IOException error)
        {
            System.out.println("\nError writing to file " + filePath +"\n" + error.getMessage());
        }

    }
}
