import processing.core.*;

public class App extends PApplet { // A complete list of all my variables.
    float ball;
    float ballX;
    float ballY;
    float line1Y = 100;
    float line1X = 0;
    float line2Y = 190;
    float line2X = 300;
    float line3Y = 275;
    float line3X = 50;
    float line4Y = 400;
    float line4X = 400;
    float line5Y = 475;
    float line5X = 250;
    float line6Y = 550;
    float line6X = 100;
    float line7X = 0;
    float line7Y = 1;
    float line8X = 0;
    float line8Y = 600;
    float lineWidth = 400;
    float lineWidth7 = 800;
    float lineWidth8 = 800;
    int startTime;
    int elapsedTime;
    boolean leftpressed = false;
    boolean rightpressed = false;
    double speed;
    double speedUp1 = -2;
    double speedUp2 = -3;
    double speedUp3 = -4;
    double ballSpeed = -5;
    int gravity = -1;
    boolean ballTouchingLine = false;
    boolean running = true;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void settings() {
        size(800, 600);

    }

    // This is the main collesion code. I had to adjust the variable to 26 so the
    // ball floated on the line and not in the line.
    public boolean isBallTouchingLine(float lineY, float lineX) {
        if (ballY >= lineY - 26 && ballY <= lineY + 6 && ballX >= lineX && ballX <= lineX + lineWidth) {
            return true;
        } else {
            return false;
        }
    }

    // This is the main setup.
    public void setup() {
        background(255);
        speed = -1;
        ball = 45;
        ballX = width / 2;
        ballY = height / 2;
        startTime = millis();
        lineWidth = random(400) + 200;
    }

    public void draw() {
        // This is the main function that makes the game work. In it's own boolean to
        // restart than game once you lose.
        if (running) {
            line1Y += speed;
            line2Y += speed;
            line3Y += speed;
            line4Y += speed;
            line5Y += speed;
            line6Y += speed;
            elapsedTime = (millis() - startTime) / 1000;
            speedUp();

            if (isBallTouchingLine(line7Y, line7X)) {
                System.out.println("touching top");
                ballTouchingLine = true;
                running = false;
                startTime = 0;
            }
            if (ballTouchingLine) {
                ballY += speed;
            } else {
                ballY -= gravity;
            }
            // This section is how I got the ball to move with the line. If the ball is
            // touching the
            // line than it moves at the same speed as the line. If the ball is not than it
            // falls at a different
            // speed to simulate gravity.
            if (isBallTouchingLine(line1Y, line1X) || isBallTouchingLine(line2Y, line2X) ||
                    isBallTouchingLine(line3Y, line3X) || isBallTouchingLine(line4Y, line4X)
                    || isBallTouchingLine(line5Y, line5X) || isBallTouchingLine(line6Y, line6X)) {
                ballTouchingLine = true;
            } else {
                ballTouchingLine = false;

                if (ballTouchingLine) {

                } else {
                    ballY -= gravity;
                }

            }
            if (line1Y <= 0) {
                line1Y = height;
            }
            if (line2Y <= 0) {
                line2Y = height;
            }
            if (line3Y <= 0) {
                line3Y = height;
            }
            if (line4Y <= 0) {
                line4Y = height;
            }
            if (line5Y <= 0) {
                line5Y = height;
            }
            if (line6Y <= 0) {
                line6Y = height;
            }
            moveBall();
        } else { // This is my gameover function.
            System.out.println("game over");
            youLost();

        }

        background(255);
        drawBall();
        drawLine1();
        drawLine2();
        drawLine3();
        drawLine4();
        drawLine5();
        drawLine6();
        drawEndLine();

        // This is my time function to make the time count and displayed in the top left
        // corner.
        if (running) {
            elapsedTime = (millis() - startTime) / 1000;
            textSize(16);
            textAlign(LEFT, TOP);
            fill(0);
            text("Elapsed Time: " + elapsedTime + " seconds", 10, 10);
        }
    }

    public void moveBall() {
        if (leftpressed == true) {
            ballX += ballSpeed;
        }
        if (rightpressed == true) {
            ballX -= ballSpeed;
        }
    }

    // Below are my eight main components being drawn. I call these methods in the
    // draw method.
    public void drawBall() {
        fill(0, 0, 255);
        ellipse(ballX, ballY, ball, ball);
    }

    public void drawLine1() {
        line(line1X, line1Y, line1X + lineWidth, line1Y);
        strokeWeight(6);
        color(255, 128, 0);
    }

    public void drawLine2() {
        line(line2X, line2Y, line2X + lineWidth, line2Y);
        strokeWeight(6);
        color(255, 128, 0);
    }

    public void drawLine3() {
        line(line3X, line3Y, line3X + lineWidth, line3Y);
        strokeWeight(6);
        color(255, 128, 0);
    }

    public void drawLine4() {
        line(line4X, line4Y, line4X + lineWidth, line4Y);
        strokeWeight(6);
        color(255, 128, 0);
    }

    public void drawLine5() {
        line(line5X, line5Y, line5X + lineWidth, line5Y);
        strokeWeight(6);
        color(255, 128, 0);
    }

    public void drawLine6() {
        line(line6X, line6Y, line6X + lineWidth, line6Y);
        strokeWeight(6);
        color(255, 128, 0);
    }

    public void drawEndLine() {
        line(line7X, line7Y, line7X + lineWidth7, line7Y);
        strokeWeight(6);
        color(255, 128, 0);
    }

    public void keyPressed() {
        if (keyCode == LEFT) {
            leftpressed = true;
        }
        if (keyCode == RIGHT) {
            rightpressed = true;
        }
        if (key == 'r') { // This is where the game restarts if I press "r"
            restartGame();
        }
    }

    // And this is where the restartGame method is programmed.
    public void restartGame() {
        ballX = width / 2;
        ballY = height / 2;
        line1Y = 100;
        line2Y = 190;
        line3Y = 275;
        line4Y = 400;
        line5Y = 475;
        line6Y = 550;
        running = true;
        startTime = millis();
        setup();
    }

    public void keyReleased() {
        if (keyCode == LEFT) {
            leftpressed = false;
        }
        if (keyCode == RIGHT) {
            rightpressed = false;
        }
    }

    public void youLost() { // youLost screen that no longer gets displayed.

        background(255);
        fill(0);
        textSize(80);
        text("You Lost!", 240, 150);
        text("Hit 'R' to Restart!", 170, 300);
        text("Time: " + elapsedTime, 270, 400);
    }

    public void speedUp() {
        if (elapsedTime >= 10)
            speed = speedUp1;
        if (elapsedTime >= 20)
            speed = speedUp2;
        if (elapsedTime >= 30)
            speed = speedUp3;
    }
}
