import javax.swing.*;


import java.awt.event.*;
import java.awt.*;

public class Window {
    JFrame frame;
    JPanel panel;
    int hitTimer;
    double x = 220, y = 240;
    final int MAX_VELOCY = 1;
    public Window() {
        frame = new JFrame("game test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new Panel();
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
            }
            public void keyReleased(KeyEvent event) {

            }
        });
        panel.repaint();
        frame.setContentPane(panel);

        /* Size and then display the frame. */
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    class Panel extends JPanel implements ActionListener{
        Timer timer = new Timer(5, this);
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            Triangle tri = new Triangle((int)x, (int)y, 20, Math.PI / 3, g);
            timer.start();
            g.dispose();
        }
        public void actionPerformed(ActionEvent e) {

            repaint();
        }
    }

    public static void main(String args){
        new Window();
    }
}
