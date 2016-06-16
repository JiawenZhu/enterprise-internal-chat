package Game;

public class gameData
{
 
 private static boolean isBlack;
 private int xCoordinate;
 private int yCoordinate;
 private int gameStatus;
 public gameData()
 {
   gameStatus = 1;
 }
 //player status, true if player is black,false if player is white
 public void setPlayerStatus(boolean playerStatus)
 {
    this.isBlack = playerStatus;
 }
 //set the coordinates of stone player put down
 public void setCoordinate(int x, int y)
 {
    this.xCoordinate = x;
    this.yCoordinate = y;
 }

 //gameStatus would be 1 if one player play via chat, 0 if player 
 //play with someone else on the same window.
 public void setGameStatus(int status)
 {
    this.gameStatus = status;
 }
 //get the status of the game player
 public static boolean getBlack()
 {
    return isBlack;
 }
 //get the x coordinate
 public int getXCoordinate()
 {
    return xCoordinate;
 }
 //get y coordinate
 public int getYCoordinate()
 {
    return yCoordinate;
 }
 public int  getGameStatus()
 {
    return gameStatus;
 }
}

