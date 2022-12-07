public class BankApp {

    private String name;
    private Bank bank;
    private BagelShop bagelShop;
    private CreditCard creditCard;
    private CreditCard creditCard2;
    private boolean hasTwoCreditCards;

    public BankApp(String name, String personalPIN) {
        this.name = name;
        hasTwoCreditCards = false;

        int randInv = (int) (Math.random() * 1001 + 1000);

        bank = new Bank();
        bagelShop = new BagelShop(name, randInv, 2, bank);
        creditCard = new CreditCard(name, personalPIN);
    }

    public String printMenu() {
        return "Would you like to: " +
                "\n(1) Make a purchase at a bagel shop" +
                "\n(2) Return bagels" +
                "\n(3) Open a second credit card" +
                "\n(4) Compare credit card balances" +
                "\n(5) Deposit profits into the bank" +
                "\n(6) Check inventory" +
                "\n(7) Check banking account" +
                "\n(8) Check credit card balance" +
                "\n(9) Quit";
    }

    public String purchaseBagel(CreditCard credit, int quantity, String PIN) {
        if(bagelShop.payForBagels(credit, quantity, PIN)) {
            return "Payment successful!" +
                    "\nBalanced Owed: " + credit.getBalanceOwed() +
                    "\n" + bagelShop;
        } else {
            return "Purchase not successful";
        }
    }

    public String returnBagel(CreditCard credit, int quantity, String PIN) {
        if(bagelShop.returnBagels(credit, quantity, PIN)) {
            return "Return Successful!" +
                    "\nBalanced Owed: " + credit.getBalanceOwed() +
                    "\n" + bagelShop;
        } else {
            return "Return not successful";
        }
    }

    public String secondCreditCard(String name, String PIN) {
        if (!hasTwoCreditCards) {
            hasTwoCreditCards = true;
            creditCard2 = new CreditCard(name, PIN);
            return "You have successfully created a new credit card account";
        } else {
            return "You already have two credit card accounts";
        }
    }

    public String compareCreditCardBal() {
        if (hasTwoCreditCards) {
            return "This is the credit card account with the lower balance owed: " +
                    "\n" + bank.lowerBalance(creditCard, creditCard2);
        } else {
            return "You only have one card";
        }
    }

    public String depositProfits() {
        bagelShop.depositProfits();
        return "Successful deposit of profits into bank";
    }

    public String checkOnShop() {
        return bagelShop.toString();
    }

    public String checkOnBank() {
        return bank.toString();
    }

    public boolean getTwoCredit() {
        return hasTwoCreditCards;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public CreditCard getCreditCard2() {
        return creditCard2;
    }

    public String showCreditCardInfo() {
        if(hasTwoCreditCards) {
            return "Credit Card 1: " +
                    "\n" + creditCard +
                    "\n\nCredit Card 2: " +
                    "\n" + creditCard2;
        } else {
            return "Credit Card Info: " + creditCard;
        }
    }
}
