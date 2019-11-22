package com.slab.scientificcalculatorx;

/**
 * Created by Suhid on 3/31/2017.
 */
public class MathLib {
    public double factorial(double x){

        double fact = 1,i;
        for(i = 1;i <=x;i++){
        fact = fact*i;
        }
        return fact;
    }
    public double nCr(double n,double r){
     double ncr = factorial(n)/(factorial(n-r)*factorial(r));
return ncr;
    }
    public double nPr(double n,double r){
     double npr = factorial(n)/(factorial(n-r));
      return npr;
    }
}
