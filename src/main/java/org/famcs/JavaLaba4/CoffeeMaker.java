package org.famcs.JavaLaba4;

import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;
public class CoffeeMaker extends CoffeeFabric
{
    protected String brand;
    protected String model;
    protected int power;
    protected double price;
    protected Date releaseDate;             //добавить даты
    
    public CoffeeMaker()
    {
        brand = "BRANDNAME";
        model = "MODELNAME";
        power = 0;
        price = 0.0;
    }
    
    public CoffeeMaker(String brandname, String modelname, int powervalue, double pricevalue)
    {
        brand = brandname;
        model = modelname;
        power = powervalue;
        price = pricevalue;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setDate(Date date)
    {
        this.releaseDate = date;
    }
    
    public Date getDate()
    {
        return releaseDate;
    }
    @Override
    public void Display()
    {
        Formatter frmt = new Formatter();
        frmt.format("ID: %d   Brand: %s   Model: %s   Power: %dW   Price: %.2f BYN", getID(), brand, model, power, price );
        System.out.println(frmt);
    }
    
    public void Input(Scanner scan)
    {
        System.out.println("Enter the brand name: ");
        String str = scan.nextLine();
        this.brand = str;
        System.out.println ("Enter the model: ");
        str = scan.nextLine();
        this.model = str;
        System.out.println ("Enter the power value: ");
        double value = scan.nextDouble();
        this.power = (int) Math.round(value);
        System.out.println ("Enter the price:");
        value = scan.nextDouble();
        this.price = value;
    };
}
