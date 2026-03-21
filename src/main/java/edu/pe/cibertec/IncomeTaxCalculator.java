package edu.pe.cibertec;

public class IncomeTaxCalculator {
    private  final double uit;

    public IncomeTaxCalculator(){
        uit = 4_950.0;
    }

    public IncomeTaxCalculator(double uit){
        if (uit <= 0){
            throw new IllegalArgumentException("UIT must be a positive value");
        }
        this.uit = uit;
    }


    public double calculate(double annualIncome) {
        if (annualIncome < 0 ){
            throw new IllegalArgumentException("Annual income cannot be negative.");
        }
        double bracket1 = 7 * uit;
        double bracket2 = 12 * uit;
        double bracket3 = 27 * uit;
        double bracket4 = 42 * uit;
        double bracket5 = 54 * uit;

        if (annualIncome <= bracket1) return  0;
        double tax = 0;

        tax += (Math.min(annualIncome, bracket2) - bracket1) * 0.08;
        if(annualIncome<=bracket2) return tax;

        return  tax;
    }
}
