package BaiTap.ProblemStatement;

import java.util.*;

public class loan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // INPUT
        // Khoản vay
        System.out.println("Enter loan amount: ");
        double loanAmount = scanner.nextDouble();
        
        // Lãi suất hàng năm
        System.out.println("Enter annual interest rate (in percentage): ");
        double annualInterestRate = scanner.nextDouble();

        // Thời gian vay theo năm
        System.out.println("Enter loan period in years: ");
        int loanPeriodInYears = scanner.nextInt();

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




