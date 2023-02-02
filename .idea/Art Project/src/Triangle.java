import java.awt.*;
public class Triangle {
    private int[] x = new int[3];
    private int[] y = new int[3];

    public Triangle(int x , int y, int size, double dir, Graphics g) {
        this.x[0] = x + (int) (size * Math.cos(dir));
        this.y[0] = y - (int) (size * Math.sin(dir));
        this.x[1] = x + (int) (size * Math.cos(dir + 2 * Math.PI / 3));
        System.out.println(size * Math.sin(dir + 2 * Math.PI / 3));
        this.y[1] = y - (int) (size * Math.sin(dir + 2 * Math.PI / 3));
        this.x[2] = x + (int) (size * Math.cos(dir + 4 * Math.PI / 3));
        this.y[2] = y - (int) (size * Math.sin(dir + 4 * Math.PI / 3));
        g.fillPolygon(this.x, this.y, 3);
    }

}
