package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void printAmount(int waterStatus, int milkStatus, int coffeeBeansStatus, int disposableCupStatus, int moneyStatus) {
        System.out.println("The coffee machine has:");
        System.out.println(waterStatus + " of water");
        System.out.println(milkStatus + " of milk");
        System.out.println(coffeeBeansStatus + " of coffee beans");
        System.out.println(disposableCupStatus + " of disposable cups");
        System.out.println("$" + moneyStatus + " of money");
        System.out.println();
    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int waterStatus = 400;
        int milkStatus = 540;
        int coffeeBeansStatus = 120;
        int disposableCupStatus = 9;
        int moneyStatus = 550;


        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            System.out.println();
            if (action.equals("exit")) {
                break;
            } else {
                switch (action) {
                    case "buy":
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                        String coffee = scanner.next();
                        System.out.println();
                        switch (coffee) {
                            case "1":
                                if (waterStatus < 250) {
                                    System.out.println("Sorry, not enough water!\n");

                                } else if (coffeeBeansStatus < 16) {
                                    System.out.println("Sorry, not enough coffee!");
                                } else if (disposableCupStatus < 1) {
                                    System.out.println("Sorry, not enough cups!");
                                } else {
                                    waterStatus -= 250;
                                    coffeeBeansStatus -= 16;
                                    disposableCupStatus--;
                                    moneyStatus += 4;
                                    System.out.println("I have enough resources, making you a coffee!\n");
                                }
                                break;
                            case "2":
                                if (waterStatus < 350) {
                                    System.out.println("Sorry, not enough water!");
                                } else if (milkStatus < 75) {
                                    System.out.println("Sorry, not enough milk!");
                                } else if (coffeeBeansStatus < 20) {
                                    System.out.println("Sorry, not enough coffee!");
                                } else if (disposableCupStatus < 1) {
                                    System.out.println("Sorry, not enough cups!");
                                } else {
                                    waterStatus -= 350;
                                    milkStatus -= 75;
                                    coffeeBeansStatus -= 20;
                                    disposableCupStatus--;
                                    moneyStatus += 7;
                                    System.out.println("I have enough resources, making you a coffee!\n");
                                }
                                break;
                            case "3":
                                if (waterStatus < 350) {
                                    System.out.println("Sorry, not enough water!");
                                } else if (milkStatus < 75) {
                                    System.out.println("Sorry, not enough milk!");
                                } else if (coffeeBeansStatus < 20) {
                                    System.out.println("Sorry, not enough coffee!");
                                } else if (disposableCupStatus < 1) {
                                    System.out.println("Sorry, not enough cups!");
                                } else {
                                    waterStatus -= 200;
                                    milkStatus -= 100;
                                    coffeeBeansStatus -= 12;
                                    disposableCupStatus--;
                                    moneyStatus += 6;
                                    System.out.println("I have enough resources, making you a coffee!\n");
                                }
                                break;
                            case "back":
                                break;
                            default:
                                break;
                        }
                        break;
                    case "fill":
                        System.out.println("Write how many ml of water do you want to add: ");
                        waterStatus += scanner.nextInt();
                        System.out.println("Write how many ml of milk do you want to add: ");
                        milkStatus += scanner.nextInt();
                        System.out.println("Write how many grams of coffee beans do you want to add: ");
                        coffeeBeansStatus += scanner.nextInt();
                        System.out.println("Write how many disposable cups of coffee do you want to add: ");
                        disposableCupStatus += scanner.nextInt();
                        break;
                    case "take":
                        System.out.println("I gave you $" + moneyStatus);
                        moneyStatus = 0;

                        break;
                    case "remaining":
                        System.out.println();
                        printAmount(waterStatus, milkStatus, coffeeBeansStatus, disposableCupStatus, moneyStatus);
                        break;
                    default:
                        continue;
                }


            }
        }
        scanner.close();

    }
}