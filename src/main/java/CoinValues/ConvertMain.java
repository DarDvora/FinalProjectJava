package CoinValues;
import java.util.Scanner;
import java.util.ArrayList;


public class ConvertMain {
    public static void main(String[] args) {
        boolean b = true;
        int i = 0;
        ArrayList<Double> ConvertHistory = new ArrayList<Double>();
        while (b=true){
            //Welcome screen
            System.out.println("Welcome to currency converter");
            System.out.println("Please choose an option (1/2):");
            System.out.println("1.Dollars to Shekels");
            System.out.println("2.Shekels to Dollars");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            //input amount screen
            System.out.println("Please enter an amount to convert");
            Scanner scanner1 = new Scanner(System.in);
            double input = scanner1.nextDouble();

            //Convert Dollar to Shekel
            if (choice == 1) {
                Coin ilsValue = CoinsFactory.getCoinInstance(Coins.ILS);
                ILS ils = new ILS();
                double value = ils.calculate(input);
                System.out.println("The result is: " + value + " Shekels");
                ConvertHistory.add(value);
            }
            //Convert Shekel to Dollar
            else if (choice == 2) {
                Coin usdValue = CoinsFactory.getCoinInstance(Coins.USD);
                USD usd = new USD();
                double value = usd.calculate(input);
                //Result screen
                System.out.println("The result is: " + value + " Dollars");
                ConvertHistory.add(value);
            }
            //Start over or exit
            System.out.println("Do you want to start over? enter y/n");
            Scanner scanner2 = new Scanner(System.in);
            String answer = scanner2.next();
            if (answer.equalsIgnoreCase("y")){
                b = true;
                i++;

            } else if (answer.equalsIgnoreCase("n")){
                b = false;
                //End screen
                System.out.println("Thanks for using our currency converter");
                System.out.println("Your conversion history: "+ConvertHistory);
                break;
            }

        }
        }

    }

