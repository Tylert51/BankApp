public class BankApp {

    private String name;
    private Bank bank;
    private BagelShop bagelShop;
    private CreditCard creditCard;
    private boolean twoCreditCards;

    public BankApp(String name, String personalPIN) {
        this.name = name;
        twoCreditCards = false;

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
                "\n(7) Quit";

    }
}
