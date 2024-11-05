package org.famcs.JavaLaba4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "brand", "model", "price", "releaseDate"})
public class CoffeeMaker extends CoffeeFabric
{
    protected String brand;
    protected String model;
    protected int power;
    protected double price;
    protected Date releaseDate;     
    
    public CoffeeMaker()
    {
        brand = "BRANDNAME";
        model = "MODELNAME";
        power = 0;
        price = 0.0;
        releaseDate = new Date(99, 0, 1);
    }
    
    public CoffeeMaker(String brandname, String modelname, int powervalue, double pricevalue)
    {
        brand = brandname;
        model = modelname;
        power = powervalue;
        price = pricevalue;
        releaseDate = new Date(99, 0, 1);
    }
    
    public CoffeeMaker(String brandname, String modelname, int powervalue, double pricevalue, int day, int month, int year)
    {
        brand = brandname;
        model = modelname;
        power = powervalue;
        price = pricevalue;
        releaseDate = new Date(year, month, day);
    }

    

    @Override
    public String getBrand() {
        return brand;
    }
    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Override
    public String getModel() {
        return model;
    }
    @Override
    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public int getPower() {
        return power;
    }
    @Override
    public void setPower(int power) {
        this.power = power;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    public Date getDate()
    {
        return releaseDate;
    }
    @Override
    public void setDate(Date date)
    {
        this.releaseDate = date;
    }
    @Override
    public void Display()
    {
         SimpleDateFormat dateFrmt = new SimpleDateFormat("dd:MM:yyyy");
         String dateStr = dateFrmt.format(releaseDate);
        Formatter frmt = new Formatter();
        frmt.format("ID: %4d | Brand: %10s | Model: %10s | Power: %5dW | Price: %6.1f BYN | Release Date: %10s", getID(), brand, model, power, price, dateStr);
        System.out.println(frmt);
    }
    
    @Override
    public String toString()
    {
        SimpleDateFormat dateFrmt = new SimpleDateFormat("dd:MM:yyyy");
         String dateStr = dateFrmt.format(releaseDate);
        Formatter frmt = new Formatter();
        return frmt.format("ID: %4d | Brand: %10s | Model: %15s | Power: %5dW | Price: %6.1f BYN | Release Date: %10s", getID(), brand, model, power, price, dateStr).toString();
        
    }

    public void Input(Scanner scan)
    {
        //Scanner scan = new Scanner (System.in);
        System.out.println("Enter the brand name: ");
        scan.nextLine();
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

        System.out.println("Enter the release day: ");
        int day = scan.nextInt();

        System.out.println("Enter the release month:");
        int month = scan.nextInt();

        System.out.println ("Enter the release year: ");
        int year = scan.nextInt();
        year = year - 1900;
        Date newDate = new Date(year, month, day);
        this.releaseDate = newDate;
    };
}
