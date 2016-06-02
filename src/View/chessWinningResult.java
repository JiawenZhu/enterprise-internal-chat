package View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

  
public class chessWinningResult extends JFrame
{
   int result;
   public chessWinningResult(int i) 
   {
      result = i;
      setTitle("Game Result");
      setSize(new Dimension(400,200));
      setLocationRelativeTo(null);
      setResizable(false);
      setDefaultCloseOperation(HIDE_ON_CLOSE);
      getContentPane().setLayout(new BorderLayout());
      
      JPanel mainPanel = new JPanel();
      getContentPane().add(mainPanel, BorderLayout.CENTER);
      mainPanel.setLayout(null);
      
      JPanel resultPanel = result(result);
      mainPanel.add(resultPanel);
      
      JPanel ButtonPanel = endGame();
      mainPanel.add(ButtonPanel,BorderLayout.CENTER);
      
      this.setVisible(true);
   }
   private JPanel result(int i)
   {
      JPanel ResultPanel = new JPanel();
      ResultPanel.setBounds(10, 45, 374, 44);
      ResultPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
      if (i == 1)
      {
         JLabel resultLabel = new JLabel("Black Stones Wins!");
         ResultPanel.add(resultLabel);
         resultLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
      }
      else
      {
         JLabel resultLabel = new JLabel("White Stones Wins!");
         ResultPanel.add(resultLabel);
         resultLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
      }
      
      return ResultPanel;
   }
   private JPanel endGame()
   {
      JPanel ButtonPanel = new JPanel();
      ButtonPanel.setBounds(10, 123, 374, 37);
      ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
      
      JButton btnNewGame = new JButton("New Game");
      btnNewGame.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
         }
      });
      btnNewGame.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnNewGame.setFont(new Font("Times New Roman", Font.PLAIN, 14));
      ButtonPanel.add(btnNewGame);
      
      JButton btnEndGame = new JButton("End Game");
      btnEndGame.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
         }
      });
      btnEndGame.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnEndGame.setFont(new Font("Times New Roman", Font.PLAIN, 14));
      ButtonPanel.add(btnEndGame);
      
      btnNewGame.setActionCommand("restart");
      btnEndGame.setActionCommand("exit");
    
      
      return ButtonPanel;
   }

 
}
