package BaiTap.ProblemStatement.Shape;

import javax.swing.*;
import java.awt.*;

public class ScreensaverFrame extends JFrame {
    private ScreensaverPanel panel;

    public ScreensaverFrame(String shape, String colorInput, String movement) {
        setTitle("Screensaver App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        panel = new ScreensaverPanel(shape, colorInput, movement);
        add(panel, BorderLayout.CENTER);
    }
}




