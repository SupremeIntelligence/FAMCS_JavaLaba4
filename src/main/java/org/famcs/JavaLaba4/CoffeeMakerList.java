package org.famcs.JavaLaba4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CoffeeMakerList extends CoffeeMakerCollection
{
    private List<CoffeeFabric> list;

    public CoffeeMakerList ()
    {
        list = new ArrayList<>();
    }

    public CoffeeMakerList(int size)
    {
        list = new ArrayList<>(size);
    }

    @Override
    public void add(CoffeeFabric obj)
    {
        list.add(obj);
    }

    @Override
    public void delete(int index)
    {
        list.remove(index);
    }

    @Override
    public void display ()
    {
        if (!list.isEmpty())
        {
            Iterator<CoffeeFabric> itr = list.iterator();
            while (itr.hasNext())
            {
                CoffeeFabric obj = itr.next();
                obj.Display();
            }
        }
        else
        {
            System.out.println ("There are no objects in the list");
        }
        
    }

    @Override
    public int getSize()
    {
        return list.size();
    }
    @Override
    public void update(CoffeeFabric obj)
    {
        list.set(obj.getID(), obj);
    }

    //@Override
    public void sort ()
    {
        int choice = 0;
        System.out.println ("""
            Choose sort mode:
            1. Sort by ID
            2. Sort by brand
            3. Sort by model
            4. Sort by power
            5. Sort by price
            6. Sort by release date.
                """);
        Scanner scan = new Scanner (System.in);
        choice = scan.nextInt();

        switch (choice)
        {
            case 1: 
            Collections.sort(list, Comparator.comparingInt(CoffeeFabric::getID));
            break;

            case 2:
            Collections.sort(list, Comparator.comparing(CoffeeFabric::getBrand));
            break;

            case 3:
            Collections.sort(list, Comparator.comparing(CoffeeFabric::getModel));
            break;

            case 4:
            Collections.sort(list, Comparator.comparingInt(CoffeeFabric::getPower));
            break;

            case 5:
            Collections.sort(list, Comparator.comparingDouble(CoffeeFabric::getPrice));
            break;
            
            case 6:
            Collections.sort(list, Comparator.comparing(CoffeeFabric::getDate));
            break;

            default:
            System.out.println("Incorrect input");
        }
        scan.close();
    }
}
