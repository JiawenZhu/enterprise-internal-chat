package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class chessIdleTimePopUp extends JFrame
{
   public chessIdleTimePopUp() {
      setTitle("Warning!");
      setSize(new Dimension(400,200));
      setLocationRelativeTo(null);
      setResizable(false);
      setDefaultCloseOperation(HIDE_ON_CLOSE);
      getContentPane().setLayout(null);
      
      JLabel lblWarning = new JLabel("The game has not been "
            + "played for a while. ");
      lblWarning.setFont(new Font("Times New Roman", Font.PLAIN, 18));
      lblWarning.setBounds(10, 11, 374, 43);
      getContentPane().add(lblWarning);
      
      JLabel lblNewLabel = new JLabel("Do you want to leave or continue?");
      lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
      lblNewLabel.setBounds(10, 54, 374, 32);
      getContentPane().add(lblNewLabel);
      
      JButton btnLeave = new JButton("Leave");
      btnLeave.setFont(new Font("Times New Roman", Font.PLAIN, 18));
      btnLeave.setBounds(43, 128, 115, 32);
      getContentPane().add(btnLeave);
      
      JButton btnContinue = new JButton("Continue");
      btnContinue.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
         }
      });
      btnContinue.setFont(new Font("Times New Roman", Font.PLAIN, 18));
      btnContinue.setBounds(204, 128, 115, 32);
      getContentPane().add(btnContinue);
      setVisible(true);
   }
}
