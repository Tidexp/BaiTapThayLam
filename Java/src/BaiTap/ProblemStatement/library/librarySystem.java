package BaiTap.ProblemStatement.library;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class librarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<libraryBook> books = new ArrayList<>(); // Danh sách những cuốn sách
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Nhập các cuốn sách
        while (true) {
            System.out.print("Enter book title (or type 'done' to finish): ");
            String title = scanner.nextLine();
        
            if (title.equalsIgnoreCase("done")) {
                break;
            }
        
            // Nhập ngày hết hạn và kiểm tra tính hợp lệ
            Date dueDate = null;
            // Biến cờ để kiểm tra tính hợp lệ của ngày
            boolean validDate = false;
        
            while (!validDate) {
                System.out.print("Enter due date (dd/MM/yyyy): ");
                String dueDateStr = scanner.nextLine();
        
                try {
                    // ép kiểu dueDateStr từ String thành SimpleDateFormat (ở đây là dd/MM/yyyy), sau đó gán vào dueDate
                    // dueDate sẽ lưu trữ ngày tháng theo dạng millisecond tính từ 01/01/1970
                    dueDate = dateFormat.parse(dueDateStr);
        
                    // Khởi tạo đối tượng Calendar, mặc định là ngày tháng hệ thống
                    Calendar cal = Calendar.getInstance();
                    // Quy đổi dueDate từ millisecond sang ngày tháng năm
                    cal.setTime(dueDate);
        
                    // lấy ngày tháng năm được quy đổi từ millisecond
                    int year = cal.get(Calendar.YEAR); // Lấy năm
                    int month = cal.get(Calendar.MONTH) + 1; // Calendar.MONTH bắt đầu từ 0, nên cần cộng thêm 1
                    int day = cal.get(Calendar.DAY_OF_MONTH); // Lấy ngày trong tháng
        
                    // Tách chuỗi dueDateStr để lấy ngày, tháng, năm từ chuỗi nhập vào (trước khi đổi sang millisecond)
                    int inputDay = Integer.parseInt(dueDateStr.substring(0, 2)); // lấy dd
                    int inputMonth = Integer.parseInt(dueDateStr.substring(3, 5)); // lấy MM
                    int inputYear = Integer.parseInt(dueDateStr.substring(6, 10)); // lấy yyyy
        
                    // Kiểm tra tính hợp lệ của ngày tháng năm giữa chuỗi nhập vào và ngày tháng năm sau khi quy đổi từ millisecond
                    if (year == inputYear && month == inputMonth && day == inputDay) {
                        validDate = true; // Ngày tháng năm hợp lệ, thoát vòng lặp nhập ngày
                    } else {
                        // Nếu thời gian không hợp lệ, VD: 99/99/2024, catch exception (báo lỗi)
                        throw new Exception("Invalid date value.");
                    }
                } catch (ParseException e) { // nếu ép kiểu dueDate = dateFormat.parse(dueDateStr) bị lỗi định dạng
                    System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                } catch (Exception e) { // các trường hợp còn lại
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
        while(true) {
            System.out.print("Enter return date (dd/MM/yyyy) or 'done' to finish: ");
            String returnDateStr = scanner.nextLine();
        
            if (returnDateStr.equalsIgnoreCase("done")) {
                break;
            }
        
            // Nhập ngày trả sách và kiểm tra tính hợp lệ
            Date returnDate = null;
            // Biến cờ để kiểm tra tính hợp lệ của ngày
            boolean validDate = false; 
        
            while (!validDate) { // Chỉ tiếp tục yêu cầu nhập ngày khi ngày nhập sai
                try {
                    // Ép kiểu returnDateStr từ String thành Date theo định dạng dd/MM/yyyy, , sau đó gán vào returnDate
                    // returnDate sẽ lưu trữ ngày tháng theo dạng millisecond tính từ 01/01/1970
                    returnDate = dateFormat.parse(returnDateStr);
        
                    // Khởi tạo đối tượng Calendar, mặc định là ngày tháng hệ thống
                    Calendar cal = Calendar.getInstance();
                    // Quy đổi returnDate từ millisecond sang ngày tháng năm
                    cal.setTime(returnDate); 
        
                    // lấy ngày tháng năm được quy đổi từ millisecond
                    int year = cal.get(Calendar.YEAR); // Lấy năm
                    int month = cal.get(Calendar.MONTH) + 1; // Calendar.MONTH bắt đầu từ 0, cần cộng thêm 1
                    int day = cal.get(Calendar.DAY_OF_MONTH); // Lấy ngày trong tháng
        
                    // Tách chuỗi returnDateStr để lấy ngày, tháng, năm từ chuỗi nhập vào (trước khi đổi sang millisecond)
                    int inputDay = Integer.parseInt(returnDateStr.substring(0, 2)); // Lấy ngày (dd)
                    int inputMonth = Integer.parseInt(returnDateStr.substring(3, 5)); // Lấy tháng (MM)
                    int inputYear = Integer.parseInt(returnDateStr.substring(6, 10)); // Lấy năm (yyyy)
        
                    // Kiểm tra tính hợp lệ của ngày tháng năm giữa chuỗi nhập vào và ngày tháng năm sau khi quy đổi từ millisecond
                    if (year == inputYear && month == inputMonth && day == inputDay) {
                        validDate = true; // Ngày tháng năm hợp lệ, thoát vòng lặp nhập ngày
                    } else {
                        // Có ngoại lệ là ngày tháng năm không hợp lệ, cần phải catch exception
                        throw new Exception("Invalid date value.");
                    }
                } catch (ParseException e) { // nếu ép kiểu returnDate = dateFormat.parse(returnDateStr) bị lỗi định dạng
                    System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                    System.out.print("Enter return date (dd/MM/yyyy) or 'done' to finish: ");
                    returnDateStr = scanner.nextLine();
                } catch (Exception e) { // các trường hợp còn lại
                    System.out.println("Invalid date value.");
                    System.out.print("Enter return date (dd/MM/yyyy) or 'done' to finish: ");
                    returnDateStr = scanner.nextLine();
                }
            }
        
            // Hiển thị thông tin và tính phí phạt
            System.out.println("\nOverdue Charges Calculation for Return Date: " + returnDate);
            System.out.println();
            // Duyệt qua danh sách sách để tính phí phạt
            for (libraryBook book : books) {
                book.displayBookInfo(returnDate); // Hiển thị thông tin sách và tính phí phạt
            }
        }
        

        scanner.close();
    }
}
