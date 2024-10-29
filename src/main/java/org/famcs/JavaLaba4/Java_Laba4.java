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
        CoffeeMaker obj3 = new CoffeeMaker("Samsung", "S21 Ultra", 240, 2150.2, 16, 2, 2017 - 1900);
        CoffeeMaker obj4 = new CoffeeMaker("Xiaomi", "15 Pro", 1000, 100,29,10,2024-1900);
        CoffeeMaker obj5 = new CoffeeMaker("Xiaomi", "15 Pro", 1000, 100,29,10,2024-1900);


        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);
        list.add(obj5);
        
        System.out.println(list);
        CoffeeWriter out = new CoffeeWriter ("output.txt");
        out.write (list);
        //list.delete(obj1.getID());

        //obj2.setPower(9999);
        //list.update (obj2);

        //list.display();
       // System.out.println();
        //list.sort();
        //list.display();



        // map.add(obj1);
        // map.add(obj2);
        // map.add(obj3);
        // map.add(obj4);
        // map.add(obj5);

        // System.out.println (map);

        

        // map.display();
        // map.sort();
        // map.display();

        //obj.Display();

        //Добавить метод isEmpty И применить его во всех методах вывода и сортировок
        //Проверить работоспособность метода удаления элементов
    }
}
