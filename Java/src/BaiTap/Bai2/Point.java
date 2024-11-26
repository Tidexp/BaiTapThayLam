package BaiTap.Bai2;

import java.util.Scanner;

public class Point {
    private double x;
    private double y;
    private double z;
        
    // Constructor khởi tạo giá trị
    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    void Negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }
    
    double Norm() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    void Print() {
        double d = Norm();
        System.out.println("Khoang cach tu diem (" + x + ", " + y + ", " + z + ") den goc la: " + d);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap x: ");
        double x = scanner.nextDouble();
        System.out.print("Nhap y: ");
        double y = scanner.nextDouble();
        System.out.print("Nhap z: ");
        double z = scanner.nextDouble();

        Point point1 = new Point(x, y, z);

        System.out.print("Khoang cach truoc khi bien doi la: ");
        point1.Print();

        System.out.print("Khoang cach sau khi bien doi la: ");
        point1.Negate();
        point1.Print();

        scanner.close();
    }
}
