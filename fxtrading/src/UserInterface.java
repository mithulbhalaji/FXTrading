import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class UserInterface  {

    public static final DecimalFormat decimalFormat = new DecimalFormat("#,###,###.00");
    public static void main(String[] args) throws IOException {
        //Initializing required objects
        FXtrade fXtrade = new FXtrade();
        Scanner scanner =new Scanner(System.in);

        //User Interface
        int userInput = 0;
        System.out.println("Welcome to Foreign Exchange Trading");
        while(true){
            System.out.println("__________________________________________________________________________________________________");
            System.out.println("| Book trade - 1\n| Print trade - 2\n| Exit - 3");

            //Checking valid input from user
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
            }
            if(userInput==1){
                fXtrade.bookTrade(scanner);
            }else if (userInput==2) {
                fXtrade.printTrade();
            }else if (userInput==3) {
                System.out.println("Do you really want to exit (y/n)");
                String confirmation = scanner.next();
                if(confirmation.equalsIgnoreCase("y")){
                    System.out.println("Bye - have a good day");
                    scanner.close();
                    break;
                }else if(!confirmation.equalsIgnoreCase("n")){
                    System.out.println("Enter a valid option");
                }
            }else{
                System.out.println("Please enter a valid option");
                scanner.nextLine();
            }
        }
    }
}
