import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FirstTest {
    JFrame frame;
    Panel panel;
    int bounce;
    double x = 220, y = 240;
    double paddleDX = 0;
    double ballX = 230, ballY = 0, ballDX = 0, ballDY = 0;
    double friction = 0;
    int hitTimer;
    int randColor;
    boolean continuousControl = true;

    boolean moveLeft = false, moveRight = false;
    public FirstTest(){
        frame = new JFrame("0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new Panel();
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                int key = event.getKeyCode();

                if (key == KeyEvent.VK_LEFT) {
                    moveLeft = true;
                    if (continuousControl) {
                        moveRight = false;
                    }
                }

                if (key == KeyEvent.VK_RIGHT) {
                    moveRight = true;
                    if (continuousControl) {
                        moveLeft = false;
                    }
                }
                panel.repaint();
            }

            public void keyReleased(KeyEvent event) {
                if (!continuousControl) {
                    int key = event.getKeyCode();

                    if (key == KeyEvent.VK_LEFT) {
                        moveLeft = false;
                    }

                    if (key == KeyEvent.VK_RIGHT) {
                        moveRight = false;
                    }
                }
            }

        });
        frame.setContentPane(panel);

        /* Size and then display the frame. */
        frame.setSize(500,300);
        frame.setVisible(true);
    }

    class Panel extends JPanel implements ActionListener{
        Timer timer = new Timer(5, this);
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (randColor == 4) {
                g.setColor(Color.CYAN);
            }else if (randColor == 3) {
                g.setColor(Color.RED);
            }else if (randColor == 2) {
                g.setColor(Color.BLUE);
            }else if (randColor == 1) {
                g.setColor(Color.MAGENTA);
            }else {
                g.setColor(Color.YELLOW);
            }
            g.fillOval((int)ballX, (int)ballY, 30, 30);
            g.setColor(Color.BLACK);
            g.fillRect((int)x, (int)y, 60, 10);
            g.drawString("Score: " + bounce, 50, 50);
            g.dispose();
            timer.start();
        }

        public void actionPerformed(ActionEvent e) {
            updateBall();
            updatePlate();
            repaint();
        }

        public void updateBall() {

            if (ballY > 1000) {
                ballY = 0;
                ballX = 230;
                ballDY = 0;
                ballDX = 0;
                bounce = 0;
                frame.setTitle(Integer.toString(bounce));
            }
            if (ballDY < 13) {
                //ball acceleration
                ballDY += 0.6;
            }

            if (ballY > 210 && ballY < 225 && ballX < x + 60 && ballX > x -30) {
                randColor = (int) (Math.random() * 5);
                //hit!
                ballDY *= -1;
                ballDX = (ballX - x - 15) / 5;
                hitTimer = 0;
                y = 245;
                bounce++;
                frame.setTitle(Integer.toString(bounce));
            }

            if (ballX <= 0 || ballX >= 460) {
                ballDX *= -1;
            }
            ballY += ballDY;
            ballX += ballDX;
        }

        public void updatePlate() {
//		friction = paddleDX/2;
//		paddleDX -= friction;
//		x += paddleDX;
            if (moveLeft && x >= 0 && paddleDX > -10) {
                x -= 8;
//        	paddleDX += -2;
            }
            if (moveRight && x <= 420 && paddleDX < 10) {
                x += 8;
//        	paddleDX += 2;
            }

            if (hitTimer > 5) {
                y = 240;
            } else {
                hitTimer++;
            }

        }

    }

    public static void main(String[] args) {
        new FirstTest();
    }
}


