package Game;

public class gameData
{
 private boolean isBlack;
 private int xCoordinate;
 private int yCoordinate;
 private boolean gameCoordinateSent;
 private boolean gameCoordinateReceived;
 
 public gameData()
 {
  
 }
 public void setPlayerStatus(boolean playerStatus)
 {
    this.isBlack = playerStatus;
 }
 public void setCoordinate(int x, int y)
 {
    this.xCoordinate = x;
    this.yCoordinate = y;
 }
 public void setSentStatus(boolean status)
 {
    this.gameCoordinateSent = status;
 }
 public void setReceiveStatus(boolean status)
 {
    this.gameCoordinateReceived = status;
 }
 public boolean getBlack()
 {
    return isBlack;
 }
 public int getXCoordinate()
 {
    return xCoordinate;
 }
 public int getYCoordinate()
 {
    return yCoordinate;
 }
 public boolean getSentStatus()
 {
    return gameCoordinateSent;
 }
 public boolean getReceiveStatus()
 {
    return gameCoordinateReceived;
 }
}
