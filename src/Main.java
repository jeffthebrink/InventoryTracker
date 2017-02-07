import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.Scanner;

public class Main {

    static ArrayList<InventoryItem> itemArrayList = new ArrayList<>();

    public static void printList() {
        //print out current inventory list

        int i = 1;
        for (InventoryItem item : itemArrayList) {

            System.out.println(i + ". " + "[" + item.itemQty + "]" + item.item);
            i++;
        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String password;

        System.out.println("Hello and welcome to the armory!");
        System.out.println("Please enter your password.");
        password = scanner.nextLine();

        if (password.equals("Jeff")) {
            System.out.println("Password correct.");

            System.out.println("We currently have the following: ");

            //Initialize inventory list

            itemArrayList.add(new InventoryItem(1, "sword"));
            itemArrayList.add(new InventoryItem(1, "shield"));
            itemArrayList.add(new InventoryItem(3, "mace"));

            printList();


            //print out options
            while (true) {
                System.out.println();
                System.out.println("Please select an option. ");
                System.out.println("1. Add a new item: ");
                System.out.println("2. Remove an item: ");
                System.out.println("3. Update the quantity of an item: ");

                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        System.out.println("Enter a new item name: ");
                        String item = scanner.nextLine();
                        itemArrayList.add(new InventoryItem(0, item));
                        continue;
                    case 2:
                        System.out.println("Type number of item you'd like to remove. ");
                        printList();
                        int optionRemove = Integer.parseInt(scanner.nextLine());
                        itemArrayList.remove(optionRemove - 1);
                        System.out.println("Item removed. ");
                        continue;

                    case 3:
                        System.out.println("Enter the number of the item you want to update the quantity of. ");
                        printList();
                        int indexToUpdate = Integer.parseInt(scanner.nextLine()) - 1;
                        System.out.println("Input the new quantity");
                        int newQty = Integer.parseInt(scanner.nextLine());
                        itemArrayList.get(indexToUpdate).itemQty = newQty;
                        printList();
                        continue;
                    default:
                        System.out.println("Invalid choice.");
                        continue;
                }
            }

        }
        else System.out.println("Incorrect password. ");
    }


}

