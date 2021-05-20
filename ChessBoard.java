import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.io.*;
import java.awt.Font;



public class ChessBoard{
    private JFrame frame;
    public static void main(String[]args){
        new ChessBoard();

    }//main

    public ChessBoard(){
        frame = new JFrame("Chess Program");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(frame.getSize());
        frame.add(new InnerProgram(frame.getSize()));
        frame.pack();
        frame.setVisible(true);

    }//constructor

    public static class InnerProgram extends JPanel implements Runnable, MouseListener  {

        Game game = new Game();
        //BoardLoc[][] board = new BoardLoc[8][8];
        private Thread animator;
        Dimension d;

        String str = "";
        int xPos = 0;
        int yPos = 0;

        public InnerProgram (Dimension dimension) {
            setSize(dimension);
            setPreferredSize(dimension);
            addMouseListener(this);
            addKeyListener(new TAdapter());
            setFocusable(true);
            d = getSize();

            //for animating the screen - you won't need to edit
            if (animator == null) {
                animator = new Thread(this);
                animator.start();
            }
            setDoubleBuffered(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(Color.GRAY);
            g2.fillRect(0, 0,(int)d.getWidth() , (int)d.getHeight());





            Color co = new Color(255,255,255);
            g2.setColor(co);
            int fontSize = 10;
            g2.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
            g2.drawString("String " + str,20,40);


            for(int r = 0;r<game.board.length;r++){
                for(int c = 0;c<game.board[0].length;c++){
                    if((r+c)%2==0){
                        g2.setColor(Color.white);
                        g2.fillRect(r*100, c*100, 100, 100);
                    }//if
                }//end nested
            }//end for


            for(Piece p : game.player1.pieces) {
              p.draw(g2);
            }
            for(Piece p : game.player2.pieces) {
              p.draw(g2);
            }



        }



        public void mousePressed(MouseEvent e) {

       xPos = e.getX();
            yPos = e.getY();
            str = xPos + " " + yPos;
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {

        }

        private class TAdapter extends KeyAdapter {

            public void keyReleased(KeyEvent e) {
                int keyr = e.getKeyCode();

            }

            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                String c = KeyEvent.getKeyText(e.getKeyCode());
                str += " char " + c + " key " + key;
              // c = Character.toString((char) key);




            }
        }//end of adapter

        public void run() {
            long beforeTime, timeDiff, sleep;
            beforeTime = System.currentTimeMillis();
            int animationDelay = 37;
            long time = System.currentTimeMillis();
            while (true) {// infinite loop
                // spriteManager.update();
                repaint();
                try {
                    time += animationDelay;
                    Thread.sleep(Math.max(0, time - System.currentTimeMillis()));
                } catch (InterruptedException e) {
                    System.out.println(e);
                } // end catch
            } // end while loop
        }// end of run




    }//end of class (inner program)

}//end of chessboard class
