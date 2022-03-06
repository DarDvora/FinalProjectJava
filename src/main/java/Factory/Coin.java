package Factory;

import CoinValues.ICalculate;

public abstract class  Coin implements ICalculate {
    double value;
    public abstract double getValue();



}
