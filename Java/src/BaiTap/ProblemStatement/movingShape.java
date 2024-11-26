package BaiTap.ProblemStatement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class movingShape extends JFrame {
    private MyPanel myPanel;

    public movingShape() {
        setTitle("Rectangle Screensaver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);

        myPanel = new MyPanel();
        add(myPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        // chạy trên EDT (Luồng xử lý đồ họa của Swing), giúp tránh các lỗi tiềm tàng liên quan đến GUI
        // SwingUtilities.invokeLater(movingShape::new); 

        new movingShape();
    }
}

class MyPanel extends JPanel implements ActionListener {
    private int rectWidth = 100;
    private int rectHeight = 50;
    private int rectX = 200;
    private int rectY = 150;
    private int xSpeed = 3;
    private int ySpeed = 2;
    private Color rectColor = getRandomColor();
    private Timer timer;

    public MyPanel() {
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.black);
        g.setColor(rectColor);
        g.fillRect(rectX, rectY, rectWidth, rectHeight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rectX += xSpeed;
        rectY += ySpeed;

        // Check collision
        // Nếu rect chạm thành bên trái (Tọa độ <= 0) hoặc chạm thành bên phải (Tọa độ vượt quá Width của cửa sổ)
        if(rectX <= 0 || rectX + rectWidth >= getWidth()) { 
            xSpeed = -xSpeed;
            rectColor = getRandomColor();
        }
        // Nếu rect chạm thành bên dưỡi (Tọa độ rectY <= 0) hoặc chạm thành bên trên (Tọa độ vượt quá Height của cửa sổ)
        if(rectY <= 0 || rectY + rectHeight >= getHeight()) {  
            ySpeed = -ySpeed;
            rectColor = getRandomColor();
        }

        // cập nhật trạng thái mỗi khi thay đổi
        repaint();
    }

    private Color getRandomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }
}


