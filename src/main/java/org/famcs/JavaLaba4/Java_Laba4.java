/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.famcs.JavaLaba4;

public class Java_Laba4 {

    public static void main(String[] args) {
        CoffeeMakerList list = new CoffeeMakerList();
        CoffeeMakerMap map = new CoffeeMakerMap();

        CoffeeMaker obj1 = new CoffeeMaker("Bosch", "PP-123", 120, 300);
        CoffeeMaker obj2 = new CoffeeMaker();


        list.add(obj1);
        list.add(obj2);
        
        //list.delete(obj1.getID());

        obj2.setPower(9999);
        list.update (obj2);

        list.display();
        System.out.println();
        
        map.add(obj1);
        map.add(obj2);

        map.display();

        //obj.Display();
    }
}
