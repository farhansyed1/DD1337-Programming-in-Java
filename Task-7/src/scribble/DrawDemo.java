import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @author Farhan Syed
 * @version 2021.04.11
 */
public class DrawDemo {
    private Canvas myCanvas;
    private Random random;

    public static void main(String[] args){
        DrawDemo demo = new DrawDemo();
        demo.drawTriangle();
        demo.drawPentagon();
        demo.drawPolygon(6);
        demo.spiral();
    }

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo() {
        myCanvas = new Canvas("Drawing Demo", 500, 400);
        random = new Random();
    }

    //Exercise 5.57
    /**
     * drawTriangle draws a triangle on the screen.
     */
    public void drawTriangle(){
        Pen pen = new Pen(10, 100, myCanvas);
        pen.setColor(Color.green);

        for (int i = 0; i < 3; i++) {
            pen.move(100);
            pen.turn(-120);
        }
    }

    //Exercise 5.58
    /**
     * drawPentagon draws a pentagon on the screen.
     */
    public void drawPentagon() {
        Pen pen = new Pen(200, 200, myCanvas);
        pen.setColor(Color.red);

        for (int i = 0; i < 5; i++) {
            pen.move(80);
            pen.turn(-72);
        }
    }

    //Exercise 5.59
    /**
     * drawPolygon draws a polygon on the screen.
     * @param n the number of sides the polygon has
     */
    public void drawPolygon(int n){
        Pen pen = new Pen(200, 100, myCanvas);
        pen.setColor(Color.orange);

        for (int i = 0; i < n; i++) {
            pen.move(80);
            pen.turn(360/n);
        }
    }

    //Exercise 5.60
    /**
     * spiral draws a spiral on the screen.
     */
    public void spiral(){
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.black);

        pen.turnTo(90);         //starts drawing downwards

        for (int i = 1; i < 80; i++) {
            int lineLength = 4*i;
            pen.move(lineLength);
            pen.turn(90);
        }
    }

    /**
     * drawSquare draws a square on the screen.
     */
    public void drawSquare() {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);

        square(pen);
    }

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel() {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen) {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble() {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i = 0; i < 10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));

            pen.randomSquiggle();
        }
    }

    /**
     * Clear the screen.
     */
    public void clear() {
        myCanvas.erase();
    }
}
