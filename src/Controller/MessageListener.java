package Controller;

import Model.MessageData;

public interface MessageListener {
    public void processMessage(MessageData e);
}
