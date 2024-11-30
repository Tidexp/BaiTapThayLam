package BaiTap.ProblemStatement.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class ScreensaverPanel extends JPanel {
    private String shape;
    private Color color;
    private String movement;
    private int x = 100, y = 100, dx = 2, dy = 2;
    private Random random = new Random();
    private Timer timer;

    public ScreensaverPanel(String shape, String colorInput, String movement) {
        this.shape = shape;
        this.color = getColor(colorInput);
        this.movement = movement;

        timer = new Timer(10, e -> Action());
        if (!movement.equalsIgnoreCase("Stationary")) {
            timer.start();
        }
    }

    private Color getColor(String colorInput) {
        return switch(colorInput.toLowerCase()) {
            case "red" -> Color.RED;
            case "green" -> Color.GREEN;
            case "blue" -> Color.BLUE;
            case "random" -> new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            // Mặc định là màu đen
            default -> Color.BLACK;
        };
    }

    private void Action() {
        if (movement.equalsIgnoreCase("Smooth")) {
            x += dx;
            y += dy;
            if (x < 0 || x > getWidth() - 50) dx = -dx;
            if (y < 0 || y > getHeight() - 50) dy = -dy;
        } else if (movement.equalsIgnoreCase("Random")) {
            x = random.nextInt(Math.max(getWidth() - 50, 1));
            y = random.nextInt(Math.max(getHeight() - 50, 1));
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(color);
        if (shape.equalsIgnoreCase("Rectangle")) {
            g.fillRect(x, y, 50, 50);
        } else if (shape.equalsIgnoreCase("Ellipse")) {
            g.fillOval(x, y, 70, 30);
        } else { 
            // Default sẽ là hình chữ nhật nếu input không hợp lệ
            g.fillRect(x, y, 50, 50);
        }
    }
}
