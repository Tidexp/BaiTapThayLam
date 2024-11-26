package BaiTap.ProblemStatement.library;

import java.util.Date;

public class libraryBook {
    private String bookTitle;
    private Date dueDate;
    private double overdueChargePerDay;
    private double maxCharge;

    static final double DEFAULT_OVERDUE_CHARGE_PER_DAY = 10000.0;
    static final double DEFAULT_MAX_CHARGE = 200000.0;

    public libraryBook(String bookTitle, Date dueDate, double overdueChargePerDay, double maxCharge) {
        this.bookTitle = bookTitle;
        this.dueDate = dueDate;
        this.overdueChargePerDay = overdueChargePerDay;
        this.maxCharge = maxCharge;
    }

    public double calculateOverdueCharge(Date returnDate) {
        long millisecDiff = returnDate.getTime() - dueDate.getTime(); // getTime() sẽ tính toán theo millisecond
        long daysDiff = millisecDiff / (1000 * 60 * 60 * 24); // 1s = 1000 ms

        if(daysDiff <= 0) {
            return 0;
        }

        double overdueCharge = daysDiff * overdueChargePerDay;

        return Math.min(overdueCharge, maxCharge); // đảm bảo phí quá hạn sẽ không vượt quá maxCharge
    }

    public void displayBookInfo(Date returnDate) {
        System.out.println("Book Title: " + bookTitle);
        System.out.println("Due Date: " + dueDate);
        System.out.println("Overdue Charge Per Day: " + overdueChargePerDay);
        System.out.println("Max Charge: " + maxCharge);
        System.out.println("Return Date: " + returnDate);
        System.out.println("Overdue Charge: " + calculateOverdueCharge(returnDate));
        System.out.println();
    }
}
