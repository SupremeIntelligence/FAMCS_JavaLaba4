package org.famcs.JavaLaba4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
}
