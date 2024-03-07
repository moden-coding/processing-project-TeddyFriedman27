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
    float line3X = 000;
    float line4Y = 400;
    float line4X = 400;
    float line5Y = 475;
    float line5X = 250;
    float line6Y = 550;
    float line6X = 000;
    float line7X = 0;
    float line7Y = 1;
    float lineWidth = 400;
    float lineWidth7 = 800;
    boolean leftpressed = false;
    boolean rightpressed = false;
    int speed = -1;
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
        if (ballY >= lineY - 26 && ballY <= lineY + 26 && ballX >= lineX && ballX <= lineX + lineWidth) {
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
    }

    public void draw() {
        if(running){
            line1Y += speed;
        line2Y += speed;
        line3Y += speed;
        line4Y += speed;
        line5Y += speed;
        line6Y += speed;
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
        if (isBallTouchingLine(line7X, line7Y)) {
            ballTouchingLine = true;
            youLost();
        }

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
            // ballY = line2Y;
        } else {
            ballTouchingLine = false;

            if (ballTouchingLine) {
                // Do not update the ball's position if it's touching the line
            } else {
                // Fall due to gravity
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
    }

    public void drawBall() {
        if (leftpressed = true) {
            ballX -= 10;
        }
        if (rightpressed = true) {
            ballX += 10;
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

        if(key == 'r'){
            restartGame();
            

        }
    }

    public void restartGame(){
        running = true;
        //Reset location of all objects
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
        fill(0); // Set the fill color to black
        textSize(80); // Set the text size to 32 pixels
        text("You Lost!", 250, 200);
        text("Hit 'R' to Restart!", 160, 400);

    }
}

// I need help with:
// Get it to stop running
// get my ball to move smoothly again