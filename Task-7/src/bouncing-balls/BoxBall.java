import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class BoxBall {

    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;

    private Canvas canvas;
    private int ySpeed;
    private int xSpeed;
    private int leftWallPosition;
    private int rightWallPosition;
    private int ceilingPosition;
    private int groundPosition;

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param leftWallPosition  the position of the left wall
     * @param rightWallPosition  the position of the right wall
     * @param groundPosition  the position of the ground
     * @param ceilingPosition the position of the ceiling
     * @param drawingCanvas  the canvas to draw this ball on
     **/
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                   int leftWallPosition, int rightWallPosition,
                   int ceilingPosition, int groundPosition, Canvas drawingCanvas) {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        this.leftWallPosition = leftWallPosition;
        this.rightWallPosition = rightWallPosition;
        this.ceilingPosition = ceilingPosition;
        this.groundPosition = groundPosition;
        canvas = drawingCanvas;

        //Giving random speed
        Random random = new Random();
        ySpeed = random.nextInt(10) + 1;
        xSpeed = random.nextInt(10) + 1;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw() {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()  {
        // remove from canvas at the current position
        erase();

        // compute new position
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the ground
        if (yPosition >= (groundPosition - diameter)) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed;
        }
        //check if it has hit ceiling
        else if(yPosition <= (ceilingPosition)){
            yPosition = (int)(ceilingPosition);
            ySpeed = -ySpeed;
        }
        //check if it has hit right wall
        else if(xPosition >= (rightWallPosition - diameter)){
            xPosition = (int)(rightWallPosition - diameter);
            xSpeed = -xSpeed;
        }
        //check if it has hit left wall
        else if(xPosition <= (leftWallPosition + 1)){
            xPosition = (int)(leftWallPosition + 1);
            xSpeed = -xSpeed;
        }

        // draw again at new position
        draw();
    }

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition() {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition() {
        return yPosition;
    }
}
