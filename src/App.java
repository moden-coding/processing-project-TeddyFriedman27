import processing.core.*;

public class App extends PApplet {
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
    double speed = -1;
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

    public boolean isBallTouchingLine(float lineY, float lineX) {
        if (ballY >= lineY - 26 && ballY <= lineY + 6 && ballX >= lineX && ballX <= lineX + lineWidth) {
            System.out.println("Ball touching line");
            return true;

        } else {
            return false;
        }
    }

    public void setup() {
        background(255);
        ball = 45;
        ballX = width / 2;
        ballY = height / 2;
        startTime = millis(); 
        line1Y = random(lineWidth);
        line2Y = random(lineWidth);
        line3Y = random(lineWidth);
        line4Y = random(lineWidth);
        line5Y = random(lineWidth);
        line6Y = random(lineWidth);

    }

    public void draw() {
        if (running) {
            line1Y += speed;
            line2Y += speed;
            line3Y += speed;
            line4Y += speed;
            line5Y += speed;
            line6Y += speed;
            elapsedTime = (millis() - startTime) / 1000;
            speedUp1();  
            speedUp2();  
            speedUp3();  
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
        drawWinLine();

         if (isBallTouchingLine(line7X, line7Y)) {
            ballTouchingLine = true;
            youLost();
        }

        // if (isBallTouchingLine(line8X, line8Y)) {
        //     ballTouchingLine = true;
        //     youWin();
        // }

        if (ballTouchingLine) {
            // Do not update the ball's position if it's touching the line
            ballY += speed;
        } else {
            // Fall due to gravity
            ballY -= gravity;
        }
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
        if (running) {elapsedTime = (millis() - startTime) / 1000;

        // Display elapsed time
        textSize(16);
        textAlign(LEFT, TOP);
        fill(0);
        text("Elapsed Time: " + elapsedTime + " seconds", 10, 10);
        }

    
    }

    public void drawBall() {
        if (leftpressed == true) {
            ballX += ballSpeed;
        }
        if (rightpressed == true) {
            ballX -= ballSpeed;
        }
        ellipse(ballX, ballY, ball, ball);
        fill(0, 0, 255);
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

    public void drawWinLine() {
        line(line8X, line8Y, line8X + lineWidth8, line8Y);
        strokeWeight(6);
        color(255, 128, 0);
    }

    public void keyPressed() {
        if (keyCode == LEFT) {
            leftpressed = true;
        }
        if (keyCode == RIGHT) {
            rightpressed = true;
            // } else if (keyCode == UP) {
            // ballY -= 10;
            // } else if (keyCode == DOWN) {
            // ballY += 10;
        }
        if (key == 'r') {
            restartGame();

        }
    }

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

    public void youLost() {
        running = false;
        startTime = 0;
        fill(0); // Set the fill color to black
        textSize(80); // Set the text size to 32 pixels
        text("You Lost!", 240, 150);
        text("Hit 'R' to Restart!", 170, 300);
        text("Time: " + elapsedTime, 270,400);
    }

    public void speedUp1(){
        if (elapsedTime >= 10)
            speed = speedUp1;
    }
    public void speedUp2(){
        if (elapsedTime >= 20)
            speed = speedUp2;
    }
    public void speedUp3(){
        if (elapsedTime >= 30)
            speed = speedUp3;
    }

}
