package BaiTap.Bai2;

import java.util.Scanner;

public class Matrix {
    private int hang;
    private int cot;
    private int[][] matrix;

    public Matrix(int hang, int cot) {
        this.hang = hang;
        this.cot = cot;
        this.matrix = new int[hang][cot];
    }

    void input() {
        Scanner scannerInput = new Scanner(System.in);

        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                System.out.print("Nhap phan tu hang " + i + " cot " + j + ": ");
                matrix[i][j] = scannerInput.nextInt();
            }
        }
    }

    void output() {
        for (int i = 0; i < hang; i++) {
            System.out.print("[");
            for (int j = 0; j < cot; j++) {
                if (j == cot - 1) {
                    System.out.print(matrix[i][j]);
                } else {
                    System.out.print(matrix[i][j] + ", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    // Hàm cộng ma trận
    public Matrix add(Matrix paraMatrix) {
        Matrix result = new Matrix(hang, cot);
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                result.matrix[i][j] = this.matrix[i][j] + paraMatrix.matrix[i][j];
            }
        }
        return result;
    }

    // Hàm trừ ma trận
    public Matrix subtract(Matrix paraMatrix) {
        Matrix result = new Matrix(hang, cot);
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                result.matrix[i][j] = this.matrix[i][j] - paraMatrix.matrix[i][j];
            }
        }
        return result;
    }

    // Hàm nhân ma trận
    public Matrix multiply(Matrix paraMatrix) {
        Matrix result = new Matrix(this.hang, paraMatrix.cot);
        for (int i = 0; i < this.hang; i++) {
            for (int j = 0; j < paraMatrix.cot; j++) {
                result.matrix[i][j] = 0;
                for (int k = 0; k < this.cot; k++) {
                    result.matrix[i][j] += this.matrix[i][k] * paraMatrix.matrix[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong hang cua ma tran: ");
        int hang = scanner.nextInt();
        System.out.print("Nhap so luong cot cua ma tran: ");
        int cot = scanner.nextInt();

        // Khởi tạo các ma trận
        Matrix matrix1 = new Matrix(hang, cot);
        System.out.println("Nhap ma tran 1:");
        matrix1.input();

        Matrix matrix2 = new Matrix(hang, cot);
        System.out.println("Nhap ma tran 2:");
        matrix2.input();

        // Xuất các ma trận
        System.out.println("Ma tran 1:");
        matrix1.output();

        System.out.println("Ma tran 2:");
        matrix2.output();

        // Kiểm tra và thực hiện phép cộng
        if (matrix1.hang == matrix2.hang && matrix1.cot == matrix2.cot) {
            System.out.println("Ma tran cong:");
            Matrix addMatrix = matrix1.add(matrix2);
            addMatrix.output();
        } else {
            System.out.println("LOI: Hai ma tran phai co cung kich thuoc de cong.");
        }

        // Kiểm tra và thực hiện phép trừ
        if (matrix1.hang == matrix2.hang && matrix1.cot == matrix2.cot) {
            System.out.println("Ma tran tru:");
            Matrix subMatrix = matrix1.subtract(matrix2);
            subMatrix.output();
        } else {
            System.out.println("LOI: Hai ma tran phai co cung kich thuoc de tru.");
        }

        // Kiểm tra và thực hiện phép nhân
        if (matrix1.cot == matrix2.hang) {
            System.out.println("Ma tran nhan:");
            Matrix mulMatrix = matrix1.multiply(matrix2);
            mulMatrix.output();
        } else {
            System.out.println("LOI: So cot cua ma tran 1 phai bang so hang cua ma tran 2 de thuc hien phep nhan.");
        }

        scanner.close();
    }
}
