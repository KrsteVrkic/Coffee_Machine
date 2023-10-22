package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static Scanner scanner = new Scanner(System.in);
    static int[] resources = new int[5];

    public static void main(String[] args) {

        initializeResources();

        boolean exit = false;

        while (!exit) {

            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String menuOption = scanner.nextLine();

            switch (menuOption) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillResources();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    printResources();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Please try again.");
            }
        }
    }

    public static void buyCoffee() {

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");

        String option = scanner.next();

        switch (option) {
            case "1":
                espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappuccino();
                break;
            case "back":
                break;
            default:
                System.out.println("WRONG");
        }
    }

    public static void printResources() {
        System.out.println("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money.\n""".formatted(resources[0], resources[1], resources[2], resources[3], resources[4]));
    }

    public static void initializeResources() {
        resources[0] = 400; // Water
        resources[1] = 540; // Milk
        resources[2] = 120; // Coffee Beans
        resources[3] = 9;   // Cups
        resources[4] = 550; // Money
    }

    /*For one espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
    For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
    And for a cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.*/

    public static void espresso() {

        int espressoWater = 250;
        int espressoBeans = 16;

        if (resources[0] >= espressoWater && resources[2] >= espressoBeans) {
            System.out.println("I have enough resources, making you a coffee!");
            resources[0] -= 250;
            resources[2] -= 16;
            resources[3] -= 1;
            resources[4] += 4;
        } else if (resources[0] < espressoWater) {
            System.out.println("Sorry, not enough water!");
        } else {
            System.out.println("Sorry, no enough beans!");
        }
    }

    public static void latte() {

        int latteWater = 350;
        int latteMilk = 75;
        int latteBeans = 20;

        if (resources[0] >= latteWater && resources[1] >= latteMilk && resources[2] >= latteBeans) {
            System.out.println("I have enough resources, making you a coffee!");
            resources[0] -= 350;
            resources[1] -= 75;
            resources[2] -= 20;
            resources[3] -= 1;
            resources[4] += 7;
        } else if (resources[0] < latteWater) {
            System.out.println("Sorry, not enough water!");
        } else if (resources[1] < latteMilk) {
            System.out.println("Sorry, not enough milk!");
        } else {
            System.out.println("Sorry, not enough beans!");
        }
    }

    public static void cappuccino() {

        int cappuccinoWater = 200;
        int cappuccinoMilk = 100;
        int cappuccinoBeans = 12;

        if (resources[0] >= cappuccinoWater && resources[1] >= cappuccinoMilk && resources[2] >= cappuccinoBeans) {
            System.out.println("I have enough resources, making you a coffee!");
            resources[0] -= 200;
            resources[1] -= 100;
            resources[2] -= 12;
            resources[3] -= 1;
            resources[4] += 6;
        } else if (resources[0] < cappuccinoWater) {
        System.out.println("Sorry, not enough water!");
        } else if (resources[1] < cappuccinoMilk) {
        System.out.println("Sorry, not enough milk!");
        } else {
        System.out.println("Sorry, not enough beans!");
        }
    }


    public static void fillResources() {
        System.out.println("Write how many ml of water you want to add:");
        resources[0] += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        resources[1] += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        resources[2] += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        resources[3] += scanner.nextInt();
    }

    public static void takeMoney() {
        System.out.println("I gave you $%d\n".formatted(resources[4]));
        resources[4] = 0;
    }

}