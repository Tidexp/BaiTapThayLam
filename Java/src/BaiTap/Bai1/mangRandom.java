package BaiTap.Bai1;

import java.util.Random;
import java.util.Scanner;

public class mangRandom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap kich thuoc mang n: ");
        int n = scanner.nextInt();
        System.out.print("Nhap gia tri a: ");
        int a = scanner.nextInt();
        System.out.print("Nhap gia tri b: ");
        int b = scanner.nextInt();

        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(b - a + 1) + a; // đảm bảo giá trị nằm trong khoảng min = a và max = b-a+1;
        }

        System.out.print("Array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println(); 

        Integer minPositive = null;
        Integer maxNegative = null;

        for (int value : array) {
            if (value > 0) {
                if (minPositive == null || value < minPositive) {
                    minPositive = value;
                }
            } else if (value < 0) {
                if (maxNegative == null || value > maxNegative) {
                    maxNegative = value;
                }
            }
        }

        if (minPositive != null) {
            System.out.println("So duong nho nhat: " + minPositive);
        } else {
            System.out.println("Khong co so duong nho nhat");
        }

        if (maxNegative != null) {
            System.out.println("So am lon nhat: " + maxNegative);
        } else {
            System.out.println("Khong co so am lon nhat");
        }

        scanner.close();
    }
}
