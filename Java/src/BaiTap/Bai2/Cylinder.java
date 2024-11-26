package BaiTap.Bai2;

import java.util.Scanner;

public class Cylinder {
    void S_TP(double R, double h) {
        double S_toanphan = 2 * Math.PI * R * (R + h);
        System.out.printf("Dien tich toan phan hinh tru la: %.2f", S_toanphan);
        System.out.println();
    }

    void The_tich(double R, double h) {
        double V = Math.PI * Math.pow(R, 2) * h;
        System.out.printf("The tich hinh tru la: %.2f", V);
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cylinder tru1 = new Cylinder();
        System.out.println("Nhap ban kinh R: ");
        double R = scanner.nextDouble();
        System.out.println("Nhap chieu cao h: ");
        double h = scanner.nextDouble();

        tru1.S_TP(R, h);
        tru1.The_tich(R, h);
        scanner.close();
    }
}
