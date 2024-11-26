package BaiTap.Bai1;

import java.util.Scanner;

public class BCNN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap vao 2 so: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        int min = Math.min(a, b);
        int i;
        
        for (i = 2; i < min; ++i) {
            if ((a % i == 0) && (b % i == 0)) {
                break;
            }
        }
        
        if (i == min) {
            System.out.println("Khong co mau chung nho nhat");
        } else {
            System.out.println("Mau chung nho nhat la " + i);
        }
        
        scanner.close();
    }
}
