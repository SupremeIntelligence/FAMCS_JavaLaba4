package org.famcs.JavaLaba4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
            System.out.println();
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
            Map<Integer, CoffeeFabric> trMap = new TreeMap<>(map);
            map = trMap;
            break;

            case 2:
            map = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.comparing(CoffeeFabric::getBrand)))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key1, key2)->key1, LinkedHashMap::new));
            break;

            case 3:
            map = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.comparing(CoffeeFabric::getModel)))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key1, key2)->key1, LinkedHashMap::new));
            break;

            case 4:
            map = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(CoffeeFabric::getPower)))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key1, key2)->key1, LinkedHashMap::new));
            break;

            case 5:
            map = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(CoffeeFabric::getPrice)))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key1, key2)->key1, LinkedHashMap::new));
            break;
            
            case 6:
            map = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.comparing(CoffeeFabric::getDate)))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key1, key2)->key1, LinkedHashMap::new));
            break;

            default:
            System.out.println("Incorrect input");
        }
        scan.close();
    }
    @Override
    public String toString()
    {
        String str = "";
        if (!map.isEmpty())
        {
            Iterator<Integer> itr = map.keySet().iterator();
            while (itr.hasNext())
            {
                CoffeeFabric obj = map.get(itr.next());
                str += obj.toString() + "\n";
            }
        }
        return str;
    }
}