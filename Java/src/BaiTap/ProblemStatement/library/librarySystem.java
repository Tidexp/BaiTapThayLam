package BaiTap.ProblemStatement.library;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class librarySystem {
    private ArrayList<libraryBook> books;
    private Scanner scanner;
    private SimpleDateFormat dateFormat;

    public librarySystem() {
        this.books = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void run() {
        // Nhập các cuốn sách
        while (true) {
            System.out.print("Enter book title (or type 'done' to finish): ");
            String title = scanner.nextLine();
        
            if (title.equalsIgnoreCase("done")) break;
        
            // Nhập ngày hết hạn và kiểm tra tính hợp lệ
            Date dueDate = null;
            // Biến cờ để kiểm tra tính hợp lệ của ngày
            boolean validDate = false;
        
            while (!validDate) { 
                System.out.print("Enter due date (dd/MM/yyyy): "); 
                String dueDateStr = scanner.nextLine(); 
        
                try { 
                    dueDate = dateFormat.parse(dueDateStr); 
        
                    Calendar cal = Calendar.getInstance(); 
                    cal.setTime(dueDate); 
        
                    int year = cal.get(Calendar.YEAR); 
                    int month = cal.get(Calendar.MONTH) + 1; 
                    int day = cal.get(Calendar.DAY_OF_MONTH); 
        
                    int inputDay = Integer.parseInt(dueDateStr.substring(0, 2)); 
                    int inputMonth = Integer.parseInt(dueDateStr.substring(3, 5)); 
                    int inputYear = Integer.parseInt(dueDateStr.substring(6, 10)); 
        
                    if (year == inputYear && month == inputMonth && day == inputDay) validDate = true; 
                    else throw new Exception("Invalid date value."); 
                } catch (ParseException e) { 
                    System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                } catch (Exception e) { 
                    System.out.println("Invalid date value.");
                }
            }
        
            // Các giá trị mặc định cho phí phạt
            System.out.print("Enter overdue charge per day (default: " + libraryBook.DEFAULT_OVERDUE_CHARGE_PER_DAY + "): "); 
            String chargeStr = scanner.nextLine();
            double overdueChargePerDay = chargeStr.isEmpty() ? libraryBook.DEFAULT_OVERDUE_CHARGE_PER_DAY : Double.parseDouble(chargeStr); 
        
            System.out.print("Enter maximum charge (default: " + libraryBook.DEFAULT_MAX_CHARGE + "): "); 
            String maxChargeStr = scanner.nextLine();
            double maxCharge = maxChargeStr.isEmpty() ? libraryBook.DEFAULT_MAX_CHARGE : Double.parseDouble(maxChargeStr); 
        
            // Thêm sách vào danh sách
            libraryBook book = new libraryBook(title, dueDate, overdueChargePerDay, maxCharge); 
            books.add(book);
        }       

        // Nhập ngày trả sách
        while (true) {
            System.out.print("Enter return date (dd/MM/yyyy) or 'done' to finish: "); 
            String returnDateStr = scanner.nextLine(); 
        
            if (returnDateStr.equalsIgnoreCase("done")) break; 
        
            // Nhập ngày trả sách và kiểm tra tính hợp lệ
            Date returnDate = null;
            // Biến cờ để kiểm tra tính hợp lệ của ngày
            boolean validDate = false;
        
            while (!validDate) { 
                try { 
                    returnDate = dateFormat.parse(returnDateStr); 
        
                    Calendar cal = Calendar.getInstance(); 
                    cal.setTime(returnDate); 
        
                    int year = cal.get(Calendar.YEAR); 
                    int month = cal.get(Calendar.MONTH) + 1; 
                    int day = cal.get(Calendar.DAY_OF_MONTH); 
        
                    int inputDay = Integer.parseInt(returnDateStr.substring(0, 2)); 
                    int inputMonth = Integer.parseInt(returnDateStr.substring(3, 5)); 
                    int inputYear = Integer.parseInt(returnDateStr.substring(6, 10)); 
        
                    if (year == inputYear && month == inputMonth && day == inputDay) validDate = true; 
                    else throw new Exception("Invalid date value."); 
                } catch (ParseException e) { 
                    System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                    System.out.print("Enter return date (dd/MM/yyyy) or 'done' to finish: "); 
                    returnDateStr = scanner.nextLine(); 
                } catch (Exception e) { 
                    System.out.println("Invalid date value.");
                    System.out.print("Enter return date (dd/MM/yyyy) or 'done' to finish: "); 
                    returnDateStr = scanner.nextLine(); 
                }
            }
        
            // Hiển thị thông tin và tính phí phạt
            System.out.println("\nOverdue Charges Calculation for Return Date: " + returnDate); 
            System.out.println();
            // Duyệt qua danh sách sách để tính phí phạt
            for (libraryBook book : books) book.displayBookInfo(returnDate); 
        }
        scanner.close(); 
    }
}
