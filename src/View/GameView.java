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
import javax.swing.Timer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.GridLayout;



public class GameView extends JFrame
{ 
   private static final int ROW = 15;
   private static final int COLUMN = 15;
   private static final int PAWN_X_POSITION = 30;
   private static final int PAWN_Y_POSITION  = 60;
   private static final int PAWN_SIZE = 40;
   private static final int SQUARE_SIZE= 40;
   public static final int TENTH_SEC = 1000;
   private int hour = 0;
   private int minute = 0;
   private int second = 0;
   private Timer time ;
   Graphics board;
   private JButton start;
   private JButton stop;
   private JButton reset;
   private JLabel lblHour;
   private JLabel lblHourDivder;
   private JLabel lblSecond;
   private JLabel lblMinuteDivider;
   private JLabel lblMinute;
   public GameView() {
      getContentPane().setFont(new Font("Serif", Font.PLAIN, 19));

      setResizable(true);
      setTitle("Gokumu");
      setDefaultCloseOperation(3);
      setSize(850, 650);
      setLocationRelativeTo(null);
      getContentPane().setLayout(null);

      JPanel chessPanel = chessBoard();
      getContentPane().add(chessPanel);

      JPanel timerPanel = timer();
      getContentPane().add(timerPanel);


      //   JPanel timer = timer();
      //   getContentPane().add(timer);


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

      JPanel timerPanel = new JPanel();
      timerPanel.setBounds(612, 11, 222, 95);
      timerPanel.setLayout(null);
      JPanel clockFace = new JPanel();
      clockFace.setBounds(54, 5, 114, 42);
      timerPanel.add(clockFace);
      clockFace.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      lblHour = new JLabel("00");
      lblHour.setFont(new Font("Serif", Font.PLAIN, 24));
      clockFace.add(lblHour);

      lblHourDivder = new JLabel(":");
      clockFace.add(lblHourDivder);
      lblHourDivder.setFont(new Font("Serif", Font.PLAIN, 24));
      
      lblMinute = new JLabel("00");
      clockFace.add(lblMinute);
      lblMinute.setFont(new Font("Serif", Font.PLAIN, 24));

      lblMinuteDivider = new JLabel(":");
      lblMinuteDivider.setFont(new Font("Serif", Font.PLAIN, 24));
      clockFace.add(lblMinuteDivider);
      
      lblSecond = new JLabel("00");
      lblSecond.setFont(new Font("Serif", Font.PLAIN, 24));
      clockFace.add(lblSecond);

      JPanel stopWatchControl = new JPanel();
      stopWatchControl.setBounds(-4, 52, 231, 43);
      timerPanel.add(stopWatchControl);
      stopWatchControl.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      start = new JButton("Start");
      start.setFont(new Font("Serif", Font.PLAIN, 19));
      stopWatchControl.add(start);

      stop = new JButton("Stop");
      stop.setFont(new Font("Serif", Font.PLAIN, 19));
      stopWatchControl.add(stop);

      reset = new JButton("Reset");
      reset.setFont(new Font("Serif", Font.PLAIN, 19));
      stopWatchControl.add( reset);
      time = new Timer(TENTH_SEC,new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            if (second < 59)
            {
               second++;
               if (second < 10)
               {
                  lblSecond.setText("" + "0" + second);
               }
               else
               {
                  lblSecond.setText("" + second);
               }
            }
            else
            {
               second = 0;
               if (minute < 59)
               {
                  minute++;
                  if (minute < 10)
                  {
                     lblMinute.setText("" + "0" + minute);
                  }
                  else
                  {
                     lblMinute.setText("" + minute);
                  }
                  
               }
               else
               {
                  minute = 0;
                  hour++;
                  if (hour < 10)
                  {
                     lblMinute.setText("" + "0" + hour);
                  }
                  else
                  {
                     lblMinute.setText("" + hour);
                  }
               }
               
            }

         }
      });
      start.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            time.start();
         }
      });


      return timerPanel;

   }

}


