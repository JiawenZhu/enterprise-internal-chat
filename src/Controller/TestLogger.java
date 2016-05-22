package Controller;

import java.util.ArrayList;
import Model.MessageData;

public class TestLogger {
	public static void main(String[] args) {
		ArrayList<MessageData> list = Logger.requestLog();
		System.out.println(list.size());
	}
}
