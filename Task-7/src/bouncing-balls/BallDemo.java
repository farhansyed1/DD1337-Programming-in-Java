import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the
 * Canvas class.
 *
 * @author Michael Kölling and David J. Barnes
 * @author Farhan Syed
 * @version 2021.04.11
 */

public class BallDemo  {

    private Canvas myCanvas;

    public static void main(String[] args){
        BallDemo demo = new BallDemo();
        demo.boxBounce(10);
    }

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()  {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    //Exercise 5.62 and 5.64
    /**
     * bounce simulates bouncing balls
     * @param numberOfBalls the number of balls that will be created
     */
    public void bounce(int numberOfBalls) {
        int ground = 400;           // position of the ground line
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create the balls somewhere in the top half of the screen
        ArrayList<BouncingBall> balls = new ArrayList<BouncingBall>();
        Random random = new Random();
        int yRandomPosition;
        int xRandomPosition;
        int diameterIncrement = 16;

        for (int i = 0; i < numberOfBalls ; i++) {
            yRandomPosition = random.nextInt(251); //random y position from 0 to 250
            xRandomPosition = random.nextInt(301); //random x position from 0 to 300
            balls.add(new BouncingBall(xRandomPosition,yRandomPosition,diameterIncrement,Color.BLUE,ground,myCanvas));
            diameterIncrement += 1;
        }

        //draw and show the balls
        for(BouncingBall ball: balls){
            ball.draw();
        }

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            for(BouncingBall ball: balls){
                ball.move();
                // stop once ball has travelled a certain distance on x axis
                if(ball.getXPosition() >= 550){
                    finished = true;
                }
            }
        }
    }

    //Exercise 5.65 and 5.66
    /**
     * boxBounce simulates bouncing balls in a box
     * @param numberOfBalls the number of balls that will be created in the box
     */
    public void boxBounce(int numberOfBalls){
        myCanvas.setVisible(true);

        // set the boundaries of the box and draw it
        int leftBoundary = 150;
        int rightBoundary = 450;
        int topBoundary = 50;
        int bottomBoundary = 350;

        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(150, 50, 450, 50); //top side
        myCanvas.drawLine(450, 50, 450, 350); //right side
        myCanvas.drawLine(450, 350, 150, 350); //bottom side
        myCanvas.drawLine(150, 350, 150, 50); //left side

        // Giving random positions and creating the balls within the box
        ArrayList<BoxBall> balls = new ArrayList<BoxBall>();
        Random random = new Random();
        int yRandomPosition;
        int xRandomPosition;

        Color randomColor;

        for (int i = 0; i < numberOfBalls ; i++) {
            yRandomPosition = random.nextInt(201) + 100;    //random y position from 100 to 300
            xRandomPosition = random.nextInt( 201) + 200;   //random x position from 200 to 400
            randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

            balls.add(new BoxBall(xRandomPosition,yRandomPosition,30,randomColor,
                    leftBoundary, rightBoundary, topBoundary, bottomBoundary,myCanvas));
        }

        //draw and show the balls
        for(BoxBall ball: balls){
            ball.draw();
        }

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            for(BoxBall ball: balls){
                ball.move();
            }
        }
    }
}
