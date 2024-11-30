package BaiTap.ProblemStatement.Shape;

import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input shape 
        System.out.print("Choose a shape (Rectangle or Ellipse): ");
        String shape = scanner.nextLine().trim().toLowerCase();

        // Input color
        System.out.print("Choose a color (Red, Green, Blue, or Random): ");
        String color = scanner.nextLine().trim().toLowerCase();

        // Input movement
        System.out.print("Choose a movement (Stationary, Smooth, or Random): ");
        String movement = scanner.nextLine().trim().toLowerCase();

        scanner.close();
        
        // Chạy trên EDT (Luồng xử lý đồ họa của Swing), giúp tránh các lỗi tiềm tàng liên quan đến GUI
        SwingUtilities.invokeLater(() -> {
            ScreensaverFrame frame = new ScreensaverFrame(shape, color, movement);
            frame.setVisible(true);
        });
        
    }
}
