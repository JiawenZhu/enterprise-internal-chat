package Game;

import Chat.ChatView;

public class testGUi
{
   public static void main(String[] args) {
      ChatView chat = new ChatView();
      GameView time = new GameView(chat);
   }
}
