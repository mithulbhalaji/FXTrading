import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class FXtrade{

    private final List<Transaction> transactions = new ArrayList<>();

    //Using hashmap for adding more currency pair and changing the rate in ease
    private static final HashMap<String,Double> currencyPairs = new HashMap<>();
    private static final DecimalFormat decimalFormat = UserInterface.decimalFormat;
    FXtrade(){
        currencyPairs.put("USDINR",66.0);
    }
    public  void bookTrade(Scanner scanner){
        //Required Variable declaration
        String customerName;
        String currencyPair;
        double amount;

        //Getting input from user
        System.out.println("Enter your name : ");
        customerName = getCustomerNameInput(scanner);
        System.out.println("Enter your currency pair");
        currencyPair = getCurrencyPairInput(scanner).toUpperCase();
        System.out.println("Enter the amount");
        amount = getAmountInput(scanner);

        //Confirmation for get rate
        System.out.println("Do you want to get Rate (yes/no)");
        String rateConfirmation = validStringInput(scanner,"yes","no").toUpperCase();
        if(rateConfirmation.equals("YES")){

            //Displaying the amount after conversion
            System.out.println("You are transferring "+currencyPair.substring(3,6) + decimalFormat.format(
                    currencyConversion(amount,currencyPair))+
                    " to "+ customerName+".");
        }

        //Book or cancel the trade
        System.out.println("Book/Cancel this trade?");
        String bookConfirmation = validStringInput(scanner,"book","cancel");
        if(bookConfirmation.equalsIgnoreCase("book")){

            //Making the transaction
            transactions.add(new Transaction(customerName,currencyPair
                    ,currencyConversion(amount,currencyPair),currencyPairs.get(currencyPair)));
            System.out.println("Trade for "+currencyPair +" " +
                    "has been booked with rate "+decimalFormat.format(currencyPairs.get(currencyPair))+" , The amount of "+currencyPair.substring(3,6) +" "+
                    decimalFormat.format(currencyConversion(amount,currencyPair))+" will be transferred in 2 working days to "
                    +customerName+".");

        }else if(bookConfirmation.equalsIgnoreCase("cancel")){
            System.out.println("Trade is Canceled.");
        }
    }

    //printing the trades done so far
    public  void printTrade(){
        //Printing trades in a format
        System.out.printf("%-8s%-14s%-30s%-20s%s%n",
                "TradeNo", "CurrencyPair", "CustomerName", "Amount", "Rate");
        for(Transaction transaction: transactions){
            System.out.print(transaction);
        }
    }

    //Currency conversion
    private static double currencyConversion(double amount,String currencyPair){
        if (currencyPairs.containsKey(currencyPair)) {
            return amount * currencyPairs.get(currencyPair);
        } else {
            System.out.println("Currency pair not found.");
            return -1; // Return a negative value to indicate an error
        }
    }

    //Getting currency pair input from user and validating
    private static String getCurrencyPairInput(Scanner scanner){
        String currencyPair = scanner.next().toUpperCase();
        while(!currencyPairs.containsKey(currencyPair)){
            System.out.println("Enter a vaid currency pair");
            currencyPair = scanner.next().toUpperCase();
        }
        return currencyPair;
    }

    //Getting name from user and validating it
    private static String getCustomerNameInput(Scanner scanner){
        String name = scanner.next();
        while (!name.matches("^[a-zA-Z][a-zA-Z.]*[a-zA-Z]$" )){
            System.out.println("Please enter a valid name");
            name = scanner.next();
        }
        scanner.nextLine();
        return name;
    }

    //Getting amount from user and validating it
    private static double getAmountInput(Scanner scanner){
        double amount;
        while (true){
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if(amount<=0){
                    System.out.println("Please enter a valid" +
                            " amount (Your input should be greater than zero)");
                    return getAmountInput(scanner);
                }else {
                    break;
                }
            }else{
                System.out.println("Please enter a " +
                        "valid amount (Your input is not a number)");
                scanner.next();
            }
        }
        return amount;
    }


    //Validation input for yes or no and book or cancel
    private static String validStringInput(Scanner scanner,String first, String second){
        String input = scanner.next();
        while(!(input.equalsIgnoreCase(first)||input.equalsIgnoreCase(second))){
            System.out.println("Please enter a valid input");
            input = scanner.next();
        }
        return input;
    }



}