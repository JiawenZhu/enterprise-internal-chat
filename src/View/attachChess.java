package View;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JPanel;

public class attachChess extends MouseAdapter
{
   private static final int ROW = 15;
   private static final int COLUMN = 15;
   private static final int PAWN_X_POSITION = 30;
   private static final int PAWN_Y_POSITION  = 60;
   private static final int PAWN_SIZE = 40;
   private static final int SQUARE_SIZE= 40;
   public static boolean isBlack = true;
   public Graphics g;
   public int x, y;
   public static String[][] chessBoardArray = new String[700][700];
   public static int[][] isBlackWinningArray = new int[15][15];
   public static chessWinningDecisionMaker winning;
   //public static int count_where = 0;
   public JPanel chessPanel;
   public static Result result;
   
   public attachChess(Graphics g)
   {
      this.g = g;

      // this.panel = panel;
   }
   public void putChessOnBoard(MouseEvent e)
   {
      x = correctXY(e.getX());
      y = correctXY(e.getY());
      System.out.println("x:"+x+"   y:"+y);
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
            result = new Result(1);
            result.initUI();
         } else if (winning.chessWinning(getXY(y), getXY(x), 
               isBlackWinningArray) == -1) {
            result = new Result(-1);
            result.initUI();
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

}


