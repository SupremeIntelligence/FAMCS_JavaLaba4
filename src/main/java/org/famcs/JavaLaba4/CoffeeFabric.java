package org.famcs.JavaLaba4;

public abstract class CoffeeFabric
{
    protected int ID;               //ID Обьекта
    protected static int count;     //Счетчик количества обьектов
    
    protected CoffeeFabric () 
    {
        this.ID = this.count++;
    };

    public abstract void Display();

    public int getID()  {return this.ID;}

    public void setID(int id) {
        this.ID = id;
    }

    public static int getCount() {
        return CoffeeFabric.count;
    }

    public static void setCount(int count) {
        CoffeeFabric.count = count;
    }
}
