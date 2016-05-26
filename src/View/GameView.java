//one big frame with 2 panel
//one panel with chessboard
//another panel with stopwatch
package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;



public class GameView extends JFrame
{ 
private static final int ROW = 15;
private static final int COLUMN = 15;
private static final int PAWN_X_POSITION = 30;
private static final int PAWN_Y_POSITION  = 60;
private static final int PAWN_SIZE = 40;
private static final int SQUARE_SIZE= 40;
Graphics board;
private JButton start;
private JButton stop;
//private JButton reset;
//private JLabel reset;
public GameView() {
  
   setResizable(true);
   setTitle("Gokumu");
   setDefaultCloseOperation(3);
   setSize(850, 650);
   setLocationRelativeTo(null);
   getContentPane().setLayout(null);

   JPanel chessPanel = chessBoard();
   getContentPane().add(chessPanel);
   
  
   JPanel timer = timer();
   getContentPane().add(timer);
   setVisible(true);
   //board = chessPanel.getGraphics();
}
private JPanel chessBoard()
{
   JPanel chessPanel = new JPanel()
   {
      //paint lines
      public void paint(Graphics g) {
         g.setColor(Color.BLACK);
         super.paint(g);
         // rows
         for (int i = 0; i < 15; i++) 
         {
            g.drawLine(20, 20 + i * SQUARE_SIZE, 20
                  + (COLUMN - 1) *SQUARE_SIZE,
                  20 + i * SQUARE_SIZE);
         }
         // columns
         for (int i = 0; i < 15; i++) 
         {
            g.drawLine(20 + i * SQUARE_SIZE, 20, 20 + i
                  * SQUARE_SIZE, 20
                  + (COLUMN - 1) * SQUARE_SIZE);
         }
         g.setColor(Color.BLACK);
         //this is the pointer/decoration on the board
         g.fillOval(133, 133, 15, 15);
         g.fillOval(293, 133, 15, 15);
         g.fillOval(453, 133, 15, 15);
         g.fillOval(133, 293, 15, 15);
         g.fillOval(293, 293, 15, 15);
         g.fillOval(453, 293, 15, 15);
         g.fillOval(133, 453, 15, 15);
         g.fillOval(293, 453, 15, 15);
         g.fillOval(453, 453, 15, 15);
      }
   };
   chessPanel.setBackground(new Color(209, 167, 78));
   chessPanel.setBounds(10, 10, 602, 602);
   return chessPanel;
}
private JPanel timer()
{
   
   JPanel timer = new JPanel();
   timer.setBounds(622, 11, 202, 185);
   timer.setLayout(new FlowLayout());
  // timeLbl = new JLabel();
   start = new JButton("Start");
   timer.add(start);
   stop = new JButton("Stop");
   timer.add(stop);
   //reset = new JButton("Reset");
   //timer.add(reset);
   return timer;
}
}


