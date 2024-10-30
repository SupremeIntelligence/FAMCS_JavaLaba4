/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.famcs.JavaLaba4;

import java.util.Scanner;

public class Java_Laba4 {

    public static void main(String[] args) {

        CoffeeMakerList list = new CoffeeMakerList();
        CoffeeMakerMap map = new CoffeeMakerMap();

        // CoffeeMaker obj1 = new CoffeeMaker("Bosch", "PP-123", 120, 300);
        // CoffeeMaker obj2 = new CoffeeMaker();
        // CoffeeMaker obj3 = new CoffeeMaker("Samsung", "S21 Ultra", 240, 2150.2, 16, 2, 2017 - 1900);
        // CoffeeMaker obj4 = new CoffeeMaker("Xiaomi", "15 Pro", 1000, 100,29,10,2024-1900);
        // CoffeeMaker obj5 = new CoffeeMaker("Xiaomi", "17 Pro Max", 1100, 150,29,10,2024-1900);

        //Добавить метод isEmpty И применить его во всех методах вывода и сортировок
        //Проверить работоспособность метода удаления элементов

        //menu

        String menu = """
                      Choose your preffered data type:
                      1.List
                      2.Map
                      3.Exit
                      """;
        String submenu = """
                         Choose option:
                         1.Read from file
                         2.Write to file
                         3.Display data
                         4.Add item
                         5.Update item
                         6.Delete item
                         7.Sort data by field
                         8.Return to main menu
                         """;
        String sortmenu = """
                          Choose sort mode: 
                          1. Sort by ID
                          2. Sort by brand
                          3. Sort by model
                          4. Sort by power
                          5. Sort by price
                          6. Sort by release date.""";

        CoffeeReader in = new CoffeeReader("input.txt");
        CoffeeWriter out = new CoffeeWriter ("output.txt");

        System.out.println(menu);
        int choice;
        int subChoice;
        int sortChoice;
        Scanner scan = new Scanner (System.in);
        choice = scan.nextInt();

        while (choice != 3)
        {
            switch (choice)
            {
                case 1:
                    System.out.println (submenu);
                    subChoice = scan.nextInt();
                    while (subChoice != 8)
                    {
                        switch(subChoice)
                        {
                            case 1:
                                System.out.println ("//Reading data from file//");
                                in.read (list);
                                subChoice = scan.nextInt();
                                break;
                            case 2:
                                System.out.println("//Writing data to file//");
                                out.write(list);
                                subChoice = scan.nextInt();
                                break;

                            case 3:
                                System.out.println (list);
                                subChoice = scan.nextInt();
                                break;

                            case 4:
                                System.out.println("//Adding a new item//");
                                CoffeeMaker obj = new CoffeeMaker();
                                obj.Input(scan);
                                list.add(obj);
                                subChoice = scan.nextInt();
                                break;

                            case 5:
                                System.out.println("//Updating item//");

                                subChoice = scan.nextInt();
                                break;

                            case 6:
                                System.out.println("//Deleting item//");

                                subChoice = scan.nextInt();
                                break;
                            case 7:
                                System.out.println ("//Sorting data//");
                                System.out.println(sortmenu);
                                sortChoice = scan.nextInt();
                                list.sort(sortChoice);
                                subChoice = scan.nextInt();
                                break;
                            default:
                                System.out.println("Incorrect input. Try again:");
                                subChoice = scan.nextInt();
                                break;

                        }
                    }
                    System.out.println(menu);
                    choice = scan.nextInt();
                    break;
                case 2:
                    System.out.println (submenu);
                    subChoice = scan.nextInt();
                    while (subChoice != 8)
                    {
                        switch(subChoice)
                        {
                        case 1:
                            System.out.println ("//Reading data from file//");
                            in.read (map);
                            subChoice = scan.nextInt();
                            break;
                        case 2:
                            System.out.println("//Writing data to file//");
                            out.write(map);
                            subChoice = scan.nextInt();
                            break;

                        case 3:
                            System.out.println (map);
                            subChoice = scan.nextInt();
                            break;

                        case 4:
                            System.out.println("//Adding a new item//");
                            CoffeeMaker obj = new CoffeeMaker();
                            //obj.Input(scan);
                            map.add(obj);
                            subChoice = scan.nextInt();
                            break;

                        case 5:
                            System.out.println("//Updating item//");

                            subChoice = scan.nextInt();
                            break;

                        case 6:
                            System.out.println("//Deleting item//");

                            subChoice = scan.nextInt();
                            break;
                        case 7:
                            System.out.println(sortmenu);
                            sortChoice = scan.nextInt();
                            System.out.println ("//Sorting data//");
                            map.sort(sortChoice);
                            subChoice = scan.nextInt();
                            break;
                        default:
                            System.out.println("Incorrect input. Try again:");
                            subChoice = scan.nextInt();
                            break;
                        }
                    }
                    System.out.println(menu);
                    choice = scan.nextInt();
                    break;

                default:
                    System.out.println("Incorrect input. Try again:");
                    choice = scan.nextInt();
                    break;
            }
        }
    }
}
