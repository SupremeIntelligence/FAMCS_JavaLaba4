package org.famcs.JavaLaba4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
}