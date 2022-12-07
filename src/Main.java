import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Hi! Welcome to my bank app where you can buy, sell, and manage your own bagel shop!\nWhat is your name: ");
        String name = s.nextLine();
        System.out.print("What would you like your credit card pin to be: ");
        String PIN = s.nextLine();

        BankApp app = new BankApp(name, PIN);
        CreditCard mainCredit = app.getCreditCard();
        CreditCard secondaryCard = null;

        System.out.println("Here is the menu of available actions: \n");
        System.out.print(app.printMenu() + "\nEnter your action: ");
        String answer = s.nextLine();

        CreditCard paymentCard = mainCredit;

        while(isRunning(answer)) {
            if (answer.equals("3")) {
                System.out.print("What would you like for your pin to be: ");
                PIN = s.nextLine();
                System.out.println(app.secondCreditCard(name, PIN));

                secondaryCard = app.getCreditCard2();

            } else if (answer.equals("1")) {
                System.out.print("How many bagels would you like to purchase: ");
                int quant = Integer.parseInt(s.nextLine());
                if (app.getTwoCredit()) {
                    System.out.print("What credit card would you like to use (1) or (2): ");
                    answer = s.nextLine();
                    if (answer.equals("2")) {
                        paymentCard = secondaryCard;
                    } else {
                        paymentCard = mainCredit;
                    }
                }
                System.out.print("What is your pin: ");
                PIN = s.nextLine();
                System.out.println(app.purchaseBagel(paymentCard, quant, PIN));

            } else if (answer.equals("2")) {
                System.out.print("How many bagels would you like to return: ");
                int quant = Integer.parseInt(s.nextLine());
                if (app.getTwoCredit()) {
                    System.out.print("What credit card would you like to use (1) or (2): ");
                    answer = s.nextLine();
                    if (answer.equals("2")) {
                        paymentCard = secondaryCard;
                    }
                }
                System.out.print("What is your pin: ");
                PIN = s.nextLine();
                System.out.println(app.returnBagel(paymentCard, quant, PIN));

            } else if (answer.equals("4")) {
                System.out.println(app.compareCreditCardBal());

            } else if (answer.equals("5")) {
                System.out.println(app.depositProfits());

            } else if (answer.equals("6")) {
                System.out.println(app.checkOnShop());

            } else if (answer.equals("7")) {
                System.out.println(app.checkOnBank());

            } else if (answer.equals("8")) {
                System.out.println(app.showCreditCardInfo());

            }

            System.out.print("\n\n\n" + app.printMenu() + "\nEnter your action: ");
            answer = s.nextLine();
        }
        System.out.println("Successfully quit application");

    }
    public static boolean isRunning(String ans) {
        String possibleAns = "12345678";
        return possibleAns.contains(ans);
    }
}
