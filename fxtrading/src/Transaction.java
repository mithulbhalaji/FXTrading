import java.text.DecimalFormat;

public class Transaction {

    private String customerName;
    private String currencyPair;
    private double amount;
    private double rate;
    private static int tempTradeno=0;
    private int tradeno;
    private static final DecimalFormat decimalFormat = UserInterface.decimalFormat;

    public Transaction(String customerName, String currencyPair, double amount,double rate) {
        this.customerName = customerName;
        this.currencyPair = currencyPair;
        this.amount = amount;
        this.rate = rate;
        tempTradeno++;
        tradeno=tempTradeno;
    }

    @Override
    public String toString() {
        return String.format("%-8d%-14s%-30s%-20s%s%n",tradeno,
                currencyPair, customerName, currencyPair.substring(3,6)+decimalFormat.format(amount), decimalFormat.format(rate));
    }
}
