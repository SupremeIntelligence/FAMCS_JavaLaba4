package org.famcs.JavaLaba4;

public abstract class CoffeeMaker
{
    protected int ID;               //ID Обьекта
    protected static int count;     //Счетчик количества обьектов
    protected String Brand;
    protected String model;
    protected int power;
    protected double price;
    public CoffeeMaker () 
    {
        this.ID = ++this.count;
    };

    public abstract void Display();

    public int getID()  {return this.ID;}

    public void setID(int id) {
        this.ID = id;
    }

    public static int getCount() {
        return CoffeeMaker.count;
    }

    public static void setCount(int count) {
        CoffeeMaker.count = count;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
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
}
