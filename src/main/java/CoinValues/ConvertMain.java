package CoinValues;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Date;
import java.text.SimpleDateFormat;


public class ConvertMain {
    public static void main(String[] args) throws Exception {
        boolean b= true;
        boolean ans = true;
        ArrayList<Double> ConvertHistory = new ArrayList<Double>();


        while (b == true) {
            //Welcome screen
            System.out.println("Welcome to currency converter");
            System.out.println("Please choose an option (1/2):");
            System.out.println("1.Dollars to Shekels");
            System.out.println("2.Shekels to Dollars");

            // try = non int validation
            try {
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                // 1/2 validation
                if (choice != 1 && choice != 2) {
                    throw new Exception("Invalid input");
                }

                //input amount screen
                System.out.println("Please enter an amount to convert");
                Scanner scanner1 = new Scanner(System.in);
                double input = scanner1.nextDouble();

                //Convert Dollar to Shekel
                if (choice == 1) {
                    Coin ilsValue = CoinsFactory.getCoinInstance(Coins.ILS);
                    double value = ilsValue.calculate(input);
                    System.out.println("The result is: " + value + " Shekels");
                    ConvertHistory.add(value);
                }
                //Convert Shekel to Dollar
                else if (choice == 2) {
                    Coin usdValue = CoinsFactory.getCoinInstance(Coins.USD);
                    double value = usdValue.calculate(input);
                    //Result screen
                    System.out.println("The result is: " + value + " Dollars");
                    ConvertHistory.add(value);
                }

                //other input is not valid
            } catch (Exception e) {
                System.out.println("Invalid input");
            }


                while (ans == true){
                //Start over or exit
                System.out.println("Do you want to start over? enter y/n");
                Scanner scanner2 = new Scanner(System.in);
                String answer = scanner2.next();

                // Y/N validation
                if (answer.equalsIgnoreCase("y")) {
                    b = true;
                    break;

                } else if (answer.equalsIgnoreCase("n")) {
                    b = false;
                    ans = false;
                    //End screen
                    System.out.println("Thanks for using our currency converter");
                    System.out.println("Your conversion history: " + ConvertHistory);

                    //Export to doc (from stackoverflow)
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                    FileWriter conversionHistoryFile = new FileWriter(dateFormat.format(date) + " conversionHistoryFile.txt");
                    for (double arrayList : ConvertHistory) {
                        conversionHistoryFile.write(arrayList + System.lineSeparator());
                    }
                    conversionHistoryFile.close();
                    break;
                }
                // Other input is not valid
                else {
                    System.out.println("Invalid character please try again");

            }
                }


                }

        }

    }
