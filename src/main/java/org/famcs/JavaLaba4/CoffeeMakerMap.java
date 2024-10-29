package org.famcs.JavaLaba4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CoffeeMakerMap extends CoffeeMakerCollection
{
    private Map<Integer, CoffeeFabric> map;

    public CoffeeMakerMap ()
    {
        map = new HashMap<>();
    }
    public CoffeeMakerMap (int size)
    {
        map = new HashMap<>(size);
    }

    @Override
    public void add(CoffeeFabric obj)
    {
        map.put (obj.getID(), obj);
    }

    @Override
    public void delete(int index)
    {
        map.remove(index);
    }

    @Override
    public void display ()
    {
        if (!map.isEmpty())
        {
            Iterator<Integer> itr = map.keySet().iterator();
            while (itr.hasNext())
            {
                CoffeeFabric obj = map.get(itr.next());
                obj.Display();
            }
        }
        else 
        {
            System.out.println("There are no objects in the map");
        }
    }

    @Override
    public int getSize()
    {
        return map.size();
    }
    
    @Override
    public void update(CoffeeFabric obj)
    {
        map.put(obj.getID(), obj);
    }

    @Override
    public void sort()
    {
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
            //Collections.sort(list, Comparator.comparingInt(CoffeeFabric::getID));
            break;

            case 2:
            //Collections.sort(list, Comparator.comparing(CoffeeFabric::getBrand));
            break;

            case 3:
            //Collections.sort(list, Comparator.comparing(CoffeeFabric::getModel));
            break;

            case 4:
            //Collections.sort(list, Comparator.comparingInt(CoffeeFabric::getPower));
            break;

            case 5:
            //Collections.sort(list, Comparator.comparingDouble(CoffeeFabric::getPrice));
            break;
            
            case 6:
            //Collections.sort(list, Comparator.comparing(CoffeeFabric::getDate));
            break;

            default:
            System.out.println("Incorrect input");
            

        }
    }
    }
}