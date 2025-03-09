import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Colors
        final String YELLOW = "\u001B[33m"; // Yellow
        final String PINK = "\u001B[35m";   // Pink
        final String RESET = "\u001B[0m";   // Reset color
        
        // Variables
        final int PIN_CORRECTO = 1234;
        boolean block = false;
        int intentos = 0;
        int saldoChicks = 1000000; // Initial balance

        // Password Validation
        while (intentos < 3) {
            System.out.println(YELLOW + "Introduce your password: " + RESET);
            int contrasenaIntroducida = scanner.nextInt();

            if (contrasenaIntroducida == PIN_CORRECTO) {
                System.out.println(PINK + "Hi! Welcome to Frisby's Bank" + RESET);
                break;
            } else {
                intentos++;
                System.out.println("Oh no, Wrong password!");

                if (intentos == 3) {
                    System.out.println("Account blocked. Contact your bank manager.");
                    block = true;
                }
            }
        }

        if (block) {
            scanner.close();
            return;
        }

        // Main Menu
        int option;
        do {
            System.out.println(YELLOW + "Hey, chickenlover! We have the following options: " + RESET);
            System.out.println(PINK + "1. Debit card");
            System.out.println("2. Credit card");
            System.out.println("4. Exit Frisby!");
            System.out.println("Please select one of the options:" + RESET);

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    int debitOption;
                    do {
                        System.out.println(YELLOW + "Debit card options: " + RESET);
                        System.out.println(PINK + "1. Check balance");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Deposit");
                        System.out.println("4. Exit debit card");
                        System.out.println("Please select one of the options:" + RESET);

                        debitOption = scanner.nextInt();

                        switch (debitOption) {
                            case 1:
                                System.out.println(PINK + "You have " + saldoChicks + " chicks!" + RESET);
                                break;

                            case 2: // Withdraw
                                System.out.println("How many chicks do you want to withdraw? (max " + saldoChicks + ")");
                                int chicksWithdrawn = scanner.nextInt();
                                if (chicksWithdrawn > 0 && chicksWithdrawn <= saldoChicks) {
                                    saldoChicks -= chicksWithdrawn;
                                    System.out.println(PINK + "You withdrew " + chicksWithdrawn + " chicks. Remaining: " + saldoChicks + RESET);
                                } else {
                                    System.out.println("Invalid amount! You can't withdraw more than you have.");
                                }
                                break;

                            case 3: // Deposit
                                System.out.println("How many chicks do you want to deposit? (max 1,000,000 per transaction)");
                                int chicksDeposited = scanner.nextInt();
                                if (chicksDeposited > 0 && chicksDeposited <= 1000000) {
                                    saldoChicks += chicksDeposited;
                                    System.out.println(PINK + "You deposited " + chicksDeposited + " chicks. New balance: " + saldoChicks + RESET);
                                } else {
                                    System.out.println("Invalid amount! You can't deposit more than 1,000,000 chicks.");
                                }
                                break;

                            case 4:
                                System.out.println(YELLOW + "Goodbye! Have a great day." + RESET);
                                break;

                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    } while (debitOption != 4);
                    break;

                case 2:
                    int creditOption;
                    do {
                        System.out.println(YELLOW + "Credit card options: " + RESET);
                        System.out.println(PINK + "1. Check balance");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Exit credit card");
                        System.out.println("Please select one of the options:" + RESET);

                        creditOption = scanner.nextInt();
                        switch (creditOption) {
                            case 1:
                                System.out.println(PINK + "Your balance is " + saldoChicks + " chicks!" + RESET);
                                break;

                            case 2:
                                System.out.println("How many chicks do you want to withdraw?");
                                int chicksWithdrawn = scanner.nextInt();
                                if (chicksWithdrawn > 0 && chicksWithdrawn <= saldoChicks) {
                                    saldoChicks -= chicksWithdrawn;
                                    System.out.println(PINK + "You withdrew " + chicksWithdrawn + " chicks. Remaining: " + saldoChicks + RESET);
                                } else {
                                    System.out.println("Invalid amount! You can't withdraw more than you have.");
                                }
                                break;
                        }
                    } while (creditOption != 3);
                    break;

                case 4:
                    System.out.println(PINK + "Thank you for using Frisby's Bank! See you soon!" + RESET);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (option != 4);

        scanner.close();
    }
}
