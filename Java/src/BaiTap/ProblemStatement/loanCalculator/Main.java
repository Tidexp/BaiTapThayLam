package BaiTap.ProblemStatement.loanCalculator;

import java.util.Scanner;
    
public class Main {
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

        Loan loanCalculator = new Loan();
        loanCalculator.calculateLoan(loanAmount, annualInterestRate, loanPeriodInYears);

        scanner.close();
    }
}

