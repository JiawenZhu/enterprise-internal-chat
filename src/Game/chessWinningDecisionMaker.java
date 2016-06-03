package Game;

public class chessWinningDecisionMaker
{
   private int[][] array_win;
   
   public chessWinningDecisionMaker(int xy, int xy2, int[][] isBlackWinningArray)
   {
    
   }
   public int chessWinning(int row, int column,
         int[][] isBlackWinningArray) 
   {
      array_win =  isBlackWinningArray;
      if (winRow(row, column) || winColumn(row, column)
            || winRightDown(row, column) || winLeftDown(row, column)) {
         if (array_win[row][column] == 1)
            return 1;
         else if (array_win[row][column] == -1)
            return -1;
      }
      return 0;
   }
   public boolean winRow(int row, int column) {
      int count = 1;
      for (int i = column + 1; i < 15; i++) {
         if (array_win[row][column] == array_win[row][i]) {
            count++;
         } else
            break;
      }
      for (int i = column - 1; i >= 0; i--) {
         if (array_win[row][column] == array_win[row][i]) {
            count++;
         } else
            break;
      }

      if (count >= 5) {
         return true;
      } else
         return false;
   }
   public boolean winColumn(int row, int column) {
      int count = 1;
      for (int i = row + 1; i < 15; i++) {
         if (array_win[row][column] == array_win[i][column]) {
            count++;
         } else
            break;
      }
      for (int i = row - 1; i >= 0; i--) {
         if (array_win[row][column] == array_win[i][column]) {
            count++;
         } else
            break;
      }
      if (count >= 5) {
         return true;
      } else
         return false;
   }
   public boolean winRightDown(int row, int column) {
      int count = 1;
      for (int i = column + 1, j = row + 1; i < 15 && j < 15; i++, j++) {
         if (array_win[row][column] == array_win[j][i]) {
            count++;
         } else
            break;
      }
      for (int i = column - 1, j = row - 1; i >= 0 && j >= 0; i--, j--) {
         if (array_win[row][column] == array_win[j][i]) {
            count++;
         } else
            break;
      }
      if (count >= 5) {
         return true;
      } else
         return false;
   }
   public boolean winLeftDown(int row, int column) {
      int count = 1;
      for (int i = column - 1, j = row + 1; i >=0 && j < 15; i--, j++) {
         if (array_win[row][column] == array_win[j][i]) {
            count++;
         } else
            break;
      }
      for (int i = column + 1, j = row - 1; i <15 && j >= 0; i++, j--) {
         if (array_win[row][column] == array_win[j][i]) {
            count++;
         } else
            break;
      }
      if (count >= 5) {
         return true;
      } else
         return false;
   }


}
