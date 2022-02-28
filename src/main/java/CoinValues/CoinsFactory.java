package CoinValues;

public class CoinsFactory {
   public static Coin getCoinInstance (Coins coin) {

       switch (coin){
           case ILS:
               return new ILS();

           case USD:
               return new USD();

       }
       return null;
   }
}
