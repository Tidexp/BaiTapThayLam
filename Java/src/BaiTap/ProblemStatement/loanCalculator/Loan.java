package BaiTap.ProblemStatement.loanCalculator;

import java.util.*;

public class Loan {
    public void calculateLoan(double loanAmount, double annualInterestRate, int loanPeriodInYears){
        // Chuyển từ lãi suất hàng năm sang hàng tháng
        double monthlyInterestRate = (annualInterestRate / 100) / 12;

        // Số tháng vay
        int numberOfPayments = loanPeriodInYears * 12;

        // Tính toán khoản thanh toán hàng tháng
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow( 1 / (1 + monthlyInterestRate), numberOfPayments ));

        // Tính tổng số tiền phải thanh toán trong thời gian vay
        double totalPayment = monthlyPayment * numberOfPayments;

        // OUTPUT
        System.out.println("\nFor:");
        System.out.println("Loan Amount: $ " + loanAmount);
        System.out.println("Annual Interest Rate: " + annualInterestRate + " %");
        System.out.println("Loan Period (years): " + loanPeriodInYears);
        System.out.println("\nMonthly Payment is $ " + String.format("%.2f", monthlyPayment));
        System.out.println("TOTAL Payment is $ " + String.format("%.2f", totalPayment));
    }
}




