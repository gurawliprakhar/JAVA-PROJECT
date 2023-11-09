package brickBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class BrickBreakerGame extends JPanel implements ActionListener, KeyListener {
    private int ballX = 200;
    private int ballY = 200;
    private int ballXDir = 1;
    private int ballYDir = 1;

    private int paddleX = 175;
    private int paddleY = 350;

    private int score = 0;
    private int bricksRemaining = 20;

    private ArrayList<Rectangle> bricks = new ArrayList<Rectangle>();

    private Timer timer;

    public BrickBreakerGame() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(5, this);
        timer.start();

        // Initialize bricks
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                bricks.add(new Rectangle(i * 80 + 30, j * 50 + 30, 60, 30));
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 400, 400);

        // Draw bricks
        for (Rectangle brick : bricks) {
            g.setColor(Color.BLUE);
            g.fill3DRect(brick.x, brick.y, brick.width, brick.height, true);
        }

        // Draw paddle
        g.setColor(Color.GREEN);
        g.fillRect(paddleX, paddleY, 60, 8);

        // Draw ball
        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, 20, 20);

        // Draw score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 20);

        // Draw bricks remaining
        g.drawString("Bricks Remaining: " + bricksRemaining, 10, 40);

        if (bricksRemaining == 0) {
            g.setColor(Color.GREEN);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("You Win!", 150, 200);
        }

        if (ballY > 390) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", 140, 200);
        }
    }

    public void actionPerformed(ActionEvent e) {
        ballX += ballXDir;
        ballY += ballYDir;

        // Ball collision with the walls
        if (ballX <= 0 || ballX >= 380) {
            ballXDir = -ballXDir;
        }

        if (ballY <= 0) {
            ballYDir = -ballYDir;
        }

        // Ball collision with the paddle
        if (ballY >= 340 && (ballX >= paddleX && ballX <= paddleX + 60)) {
            ballYDir = -ballYDir;
        }

        // Ball collision with bricks
        for (int i = 0; i < bricks.size(); i++) {
            Rectangle brick = bricks.get(i);
            if (brick.intersects(new Rectangle(ballX, ballY, 20, 20)) && !brick.isEmpty()) {
                bricks.set(i, new Rectangle());
                ballYDir = -ballYDir;
                score += 10;
                bricksRemaining--;
            }
        }

        // Game over condition
        if (ballY > 390) {
            timer.stop();
        }

        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT && paddleX > 0) {
            paddleX -= 10;
        }

        if (keyCode == KeyEvent.VK_RIGHT && paddleX < 340) {
            paddleX += 10;
        }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker Game");
        BrickBreakerGame game = new BrickBreakerGame();
        frame.add(game);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
