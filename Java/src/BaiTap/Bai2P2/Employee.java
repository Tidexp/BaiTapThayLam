package BaiTap.Bai2P2;

import java.util.Scanner;

public class Employee {
    private String fullName;
    private String idCard;

    public Employee(String fullName, String idCard) {
        this.fullName = fullName;
        this.idCard = idCard;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ho ten nhan vien: ");
        this.fullName = scanner.nextLine();

        System.out.print("Nhap so CMND: ");
        this.idCard = scanner.nextLine();
    }

    public void display() {
        System.out.println("Ho ten nhan vien: " + fullName);
        System.out.println("So CMND: " + idCard);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee employee = new Employee("Nguyen Van A", "123456789"); 

        System.out.println("Ho ten nhan vien: " + employee.getFullName());
        System.out.println("So CMND: " + employee.getIdCard());

        System.out.print("Nhap ho ten moi cua nhan vien: ");
        employee.setFullName(scanner.nextLine());
        System.out.print("Nhap so CMND moi cua nhan vien: ");
        employee.setIdCard(scanner.nextLine());

        employee.display();

        scanner.close();
    }
}

