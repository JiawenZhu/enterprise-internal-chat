package View;
//one big frame with 2 panel
//one panel with chessboard
//another panel with stopwatch

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class GameView extends JFrame
{ 
   private static final int ROW = 15;
   private static final int COLUMN = 15;
   private static final int PAWN_X_POSITION = 30;
   private static final int PAWN_Y_POSITION  = 60;
   private static final int PAWN_SIZE = 35;
   private static final int SQUARE_SIZE= 40;
   public static final int ONE_SEC = 1000;
   private int hour = 0;
   private int minute = 0;
   private int second = 0;
   private JLabel secondLabel;
   private JLabel minuteLabel;
   private JLabel hourLabel;
   private JLabel hourDividor;
   Graphics board;
   private Timer time;
   public GameView() {
      //main window frame
      setTitle("Gokumu");
      setDefaultCloseOperation(3);
      setSize(860, 670);
      setLocationRelativeTo(null);
      getContentPane().setLayout(null);
      
     JPanel chessPanel = chessPanel();
      getContentPane().add(chessPanel);

      JPanel timer = timer();
      getContentPane().add(timer);

      JButton btnClose = new JButton("Close");
      btnClose.setBounds(682, 542, 107, 37);
      getContentPane().add(btnClose);
      btnClose.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
         }
      });
      btnClose.setFont(new Font("Times New Roman", Font.PLAIN, 24));
      setVisible(true);
      board = chessPanel.getGraphics();
      attachChess listener = new attachChess( board);
      chessPanel.addMouseListener(listener);

      

   }
   private JPanel chessPanel()
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
            
            //repaint chess
            for (int i = 0; i < 650; i++) {
               for (int j = 0; j < 650; j++) {
                  if (attachChess.chessBoardArray[i][j] == "black") {
                     g.setColor(Color.BLACK);
                     g.fillOval(i, j,  PAWN_SIZE ,
                           PAWN_SIZE );
                  } else if (attachChess.chessBoardArray[i][j] == "white") {
                     g.setColor(Color.WHITE);
                     g.fillOval(i, j, PAWN_SIZE ,
                           PAWN_SIZE );
                  }
               }
            }
      }
      };
      
      chessPanel.setBackground(new Color(209, 167, 78));
      chessPanel.setBounds(10, 10, 602, 602);
      return chessPanel;
   }
 
   private JPanel timer()
   {


      JPanel timerPanel = new JPanel();
      timerPanel.setBounds(622, 10, 202, 181);
      timerPanel.setLayout(null);

      JPanel clockViewPanel = new JPanel();
      clockViewPanel.setBounds(0, 0, 202, 38);
      timerPanel.add(clockViewPanel);
      clockViewPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      hourLabel = new JLabel("00");
      hourLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
      clockViewPanel.add(hourLabel);

      hourDividor = new JLabel(":");
      hourDividor.setFont(new Font("Times New Roman", Font.PLAIN, 24));
      clockViewPanel.add(hourDividor);

      minuteLabel = new JLabel("00");
      minuteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
      clockViewPanel.add(minuteLabel);

      JLabel minuteDivder = new JLabel(":");
      minuteDivder.setFont(new Font("Times New Roman", Font.PLAIN, 24));
      clockViewPanel.add(minuteDivder);

      secondLabel = new JLabel("00");
      secondLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
      clockViewPanel.add(secondLabel);

      JPanel clockControlPanel = new JPanel();
      clockControlPanel.setBounds(0, 49, 202, 100);
      timerPanel.add(clockControlPanel);
      clockControlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      JButton startBtn = new JButton("Start");   
      startBtn.setFont(new Font("Times New Roman", Font.PLAIN, 24));
      clockControlPanel.add(startBtn);

      JButton stopBtn = new JButton("Stop");
      stopBtn.setFont(new Font("Times New Roman", Font.PLAIN, 24));
      clockControlPanel.add(stopBtn);

      JButton resetBtn = new JButton("Reset");
      resetBtn.setFont(new Font("Times New Roman", Font.PLAIN, 24));
      clockControlPanel.add(resetBtn);

      time = new Timer(ONE_SEC ,new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            if (second < 59)
            {
               second ++;
               if(second < 10)
               {
                  secondLabel.setText("" + "0" + second);
               }
               else
               {
                  secondLabel.setText("" + second);
               }
            }
            else
            {
               second = 0;
               secondLabel.setText("" + "00");
               if (minute < 59)
               {
                  minute ++;
                  if(minute < 10)
                  {
                     minuteLabel.setText("" + "0" + minute );
                  }
                  else
                  {
                     minuteLabel.setText("" + minute );
                  }
               }
               else
               {
                  minute = 0;
                  minuteLabel.setText("" + "00" );
                  hour++;
                  if(hour < 10)
                  {
                     hourLabel.setText("" + "0" + hour);
                  }
                  else
                  {
                     hourLabel.setText("" + hour);
                  }

               }
            }
         }
      });
      startBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            time.start();
         }
      });
      stopBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            time.stop();
         }

      });
      resetBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            time.stop();
            secondLabel.setText("" + "00");
            minuteLabel.setText("" + "00" );
            hourLabel.setText("" + "00");
         }
      });
      return timerPanel;
   }
   
}

