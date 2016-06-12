package Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class attachChess extends MouseAdapter
{
   private static final int ROW = 15;
   private static final int COLUMN = 15;
   private static final int PAWN_SIZE = 35;
   private static final int SQUARE_SIZE= 40;
   public static boolean isBlack = true;
   public Graphics g;
   public Graphics oldBoard;
   public int x, y;
   public static String[][] chessBoardArray = new String[700][700];
   public static int[][] isBlackWinningArray = new int[15][15];
   public static chessWinningDecisionMaker winning;
   public JPanel chessPanel;
   gameData gamedata = new gameData();
   public attachChess(Graphics g)
   {
      this.g = g;
      oldBoard = g;
     

      // this.panel = panel;
   }
   public void mouseReleased(MouseEvent e)
   {
      x = correctXY(e.getX());
      y = correctXY(e.getY());
      System.out.println("x:"+x+"   y:"+y);
      if (gamedata.getGameStatus() == 0)
      {
      //mouseclick board event
      if (x < 582 && x >= 0 && y < 582 && y >= 0) {
         if (isBlack && chessBoardArray[x][y] == null) {
            g.setColor(Color.BLACK);

            g.fillOval(x, y, PAWN_SIZE ,
                  PAWN_SIZE );

            chessBoardArray[x][y] = "black";

            isBlackWinningArray[getXY(y)][getXY(x)] = 1;
            isBlack = false;

         } else if (chessBoardArray[x][y] == null) {
            g.setColor(Color.WHITE);
            g.fillOval(x, y, PAWN_SIZE ,
                  PAWN_SIZE );

            chessBoardArray[x][y] = "white";

            isBlackWinningArray[getXY(y)][getXY(x)] = -1;

            isBlack = true;
         }
         //decide if the player is winning
         winning = new chessWinningDecisionMaker(getXY(y), 
               getXY(x), isBlackWinningArray);
         if (winning.chessWinning(getXY(y), getXY(x), 
               isBlackWinningArray) == 1) {
            //result = new chessWinningResult(1);
            System.out.println("Black Wins");
            GameView.setResult(1);
            JPanel chessPanel = GameView.chessPanel();
           
            JOptionPane.showMessageDialog(null,
                  "Black Stone Wins!",
                  "Congratulations",
                  JOptionPane.INFORMATION_MESSAGE,
                  null);
            g = this.clear(g);
            
         } else if (winning.chessWinning(getXY(y), getXY(x), 
               isBlackWinningArray) == -1) {
            //result = new chessWinningResult(-1);
            System.out.println("White Wins");
            GameView.setResult(-1);
            JOptionPane.showMessageDialog(null,
                  "White Stone Wins!",
                  "Congratulations",
                  JOptionPane.INFORMATION_MESSAGE,
                  null);
            g = this.clear(g);

         }
         for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
               System.out.print(isBlackWinningArray [i][j] + "  ");
            }
            System.out.println("");
         }
         System.out.println("");
      }
      }
      //start of the conversation chess game
      else if (gamedata.getGameStatus() == 1)
      {
         if(gameData.getBlack()== true)
         {
            //mouse release black
            //get coordinate  and paint white
            putChess(Color.BLACK);
            if(gamedata.getReceiveStatus() == true)
            {
               int x = gamedata.getXCoordinate();
               int y = gamedata.getYCoordinate();     
               paintChess(x,y,Color.WHITE);
            }
         }
         else if(gameData.getBlack()== false)
         {
            putChess(Color.WHITE);
            if(gamedata.getReceiveStatus() == true)
            {
               int x = gamedata.getXCoordinate();
               int y = gamedata.getYCoordinate();
               paintChess(x,y,Color.BLACK);
            }
         }
       //decide if the player is winning
         winning = new chessWinningDecisionMaker(getXY(y), 
               getXY(x), isBlackWinningArray);
         if (winning.chessWinning(getXY(y), getXY(x), 
               isBlackWinningArray) == 1) {
            //result = new chessWinningResult(1);
            System.out.println("Black Wins");
            GameView.setResult(1);
            JPanel chessPanel = GameView.chessPanel();
           
            JOptionPane.showMessageDialog(null,
                  "Black Stone Wins!",
                  "Congratulations",
                  JOptionPane.INFORMATION_MESSAGE,
                  null);
            g = this.clear(g);
            
         } else if (winning.chessWinning(getXY(y), getXY(x), 
               isBlackWinningArray) == -1) {
            //result = new chessWinningResult(-1);
            System.out.println("White Wins");
            GameView.setResult(-1);
            JOptionPane.showMessageDialog(null,
                  "White Stone Wins!",
                  "Congratulations",
                  JOptionPane.INFORMATION_MESSAGE,
                  null);
            g = this.clear(g);
         
      }
      }

   }  
   
   //correct xy coordinate
   private int correctXY(int x) {
      x = x / 40;

      return x * 40;
   }
   //get XY coordinate
   private int getXY(int x) {
      x = x / 40;
      return x;
   }
   private Graphics clear(Graphics g)
   {
      for (int i = 0; i < 15; i++) {
         for (int j = 0; j < 15; j++) {
            if (isBlackWinningArray [i][j] == 1 ||
                  isBlackWinningArray [i][j] == -1)
            {
               isBlackWinningArray [i][j] = 0;
               int y = i * 40;
               int x = j * 40;
               Color myColour = new Color(209, 167, 78);
               g.setColor(myColour);
               g.fillRect(10, 10, 602, 602);
               chessBoardArray[x][y] = null;
               isBlack = true;
               g.setColor(Color.BLACK);
               // rows
               for (int k = 0; k < 15; k++) 
               {
                  g.drawLine(20, 20 + k * SQUARE_SIZE, 20
                        + (COLUMN - 1) *SQUARE_SIZE,
                        20 + k * SQUARE_SIZE);
               }
               // columns
               for (int l = 0; l < 15; l++) 
               {
                  g.drawLine(20 + l * SQUARE_SIZE, 20, 20 + l
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
         }
      }
      return g;
      
   }
   private void putChess(Color c)
   {
      if (x < 582 && x > 10 && y < 582 && y > 10 && chessBoardArray[x][y] == null) {
         g.setColor(c);
         g.fillOval(x, y, PAWN_SIZE ,
               PAWN_SIZE );
         //need to change accordingly to the color
         if(gamedata.getBlack() == true)
         {

         chessBoardArray[x][y] = "black";
        
         isBlackWinningArray[getXY(y)][getXY(x)] = 1;

         }
         else
         {
            chessBoardArray[x][y] = "white";

            isBlackWinningArray[getXY(y)][getXY(x)] = -1;
         }
         gamedata.setReceiveStatus(true);
         gamedata.setCoordinate(x, y);
         for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
               System.out.print(isBlackWinningArray[i][j] + "  ");
            }
            System.out.println("");
         }
         System.out.println("");
         
        
      }
   }
   private void paintChess( int x, int y, Color c)
   
   {
      if (x < 582 && x > 10 && y < 582 && y > 10 && chessBoardArray[x][y] == null) {
         g.setColor(Color.WHITE);
         g.fillOval(x, y, PAWN_SIZE ,
               PAWN_SIZE );

         if(gamedata.getBlack() == false)
         {

         chessBoardArray[x][y] = "white";
        
         isBlackWinningArray[getXY(y)][getXY(x)] = -1;

         }
         else
         {
            chessBoardArray[x][y] = "black";

            isBlackWinningArray[getXY(y)][getXY(x)] = 1;
         }

         for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
               System.out.print(isBlackWinningArray[i][j] + "  ");
            }
            System.out.println("");
         }
         System.out.println("");

      }
   }

}



