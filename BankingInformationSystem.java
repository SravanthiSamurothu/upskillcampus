import java.util.Scanner;

public class BankingInformationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String accountHolder = "";
        String accountNumber = "";
        String password = "";
        double balance = 0.0;

        int choice;

        do {
            System.out.println("\n===== BANKING INFORMATION SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Holder Name: ");
                    accountHolder = sc.nextLine();

                    System.out.print("Enter Account Number: ");
                    accountNumber = sc.nextLine();

                    System.out.print("Set Password: ");
                    password = sc.nextLine();

                    System.out.print("Enter Initial Deposit Amount: ");
                    balance = sc.nextDouble();

                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    if (accountNumber.equals("")) {
                        System.out.println("No account found. Please create an account first.");
                        break;
                    }

                    System.out.print("Enter Account Number: ");
                    String enteredAccNo = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String enteredPassword = sc.nextLine();

                    if (enteredAccNo.equals(accountNumber) && enteredPassword.equals(password)) {
                        int option;
                        do {
                            System.out.println("\n===== WELCOME " + accountHolder + " =====");
                            System.out.println("1. Check Balance");
                            System.out.println("2. Deposit Money");
                            System.out.println("3. Withdraw Money");
                            System.out.println("4. Account Details");
                            System.out.println("5. Logout");
                            System.out.print("Enter your option: ");
                            option = sc.nextInt();

                            switch (option) {
                                case 1:
                                    System.out.println("Current Balance: ₹" + balance);
                                    break;

                                case 2:
                                    System.out.print("Enter deposit amount: ₹");
                                    double deposit = sc.nextDouble();
                                    if (deposit > 0) {
                                        balance += deposit;
                                        System.out.println("Deposit successful!");
                                        System.out.println("Updated Balance: ₹" + balance);
                                    } else {
                                        System.out.println("Invalid deposit amount!");
                                    }
                                    break;

                                case 3:
                                    System.out.print("Enter withdrawal amount: ₹");
                                    double withdraw = sc.nextDouble();
                                    if (withdraw > 0 && withdraw <= balance) {
                                        balance -= withdraw;
                                        System.out.println("Withdrawal successful!");
                                        System.out.println("Updated Balance: ₹" + balance);
                                    } else {
                                        System.out.println("Insufficient balance or invalid amount!");
                                    }
                                    break;

                                case 4:
                                    System.out.println("\n===== ACCOUNT DETAILS =====");
                                    System.out.println("Account Holder Name: " + accountHolder);
                                    System.out.println("Account Number: " + accountNumber);
                                    System.out.println("Balance: ₹" + balance);
                                    break;

                                case 5:
                                    System.out.println("Logged out successfully!");
                                    break;

                                default:
                                    System.out.println("Invalid option!");
                            }
                        } while (option != 5);
                    } else {
                        System.out.println("Invalid Account Number or Password!");
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using Banking Information System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}