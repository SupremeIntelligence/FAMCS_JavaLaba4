package org.famcs.JavaLaba4;

public abstract class CoffeeMakerCollection 
{
    public abstract void add (CoffeeFabric obj);
    public abstract void delete (int index);
    public abstract void display ();
    public abstract int getSize();
    public abstract void update (CoffeeFabric obj);
    public abstract void sort (int choice);
    public abstract String toString();
    public abstract CoffeeFabric getItem (int index);
}
