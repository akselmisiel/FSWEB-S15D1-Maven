package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Durdurmak için 0, ürün eklemek için 1, ürün çıkarmak için 2, listeyi bastırmak için 3'e basın: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz:");
                    String items = scanner.nextLine();
                    addItems(items);
                    break;
                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz: ");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
                case 3:
                    printSorted();
                    break;
            }
        }
        scanner.close();
    }

    public static void addItems(String items) {
        String itemList[] = items.split(",");
        for (String item : itemList) {
            item = item.trim();
            if (!checkItemIsInList(item))
                groceryList.add(item);
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String itemsToRemove) {
        String itemList[] = itemsToRemove.split(",");
        for (String item : itemList) {
            item = item.trim();
            if (checkItemIsInList(item))
                groceryList.remove(item);
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String item) {
        return groceryList.contains(item);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}
