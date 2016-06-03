package Chat;

import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 * opens a coming file
 * 
 * @author Jiawen
 *
 */
public class OpenFile {
	JFileChooser fileChooser = new JFileChooser();
	public StringBuilder sb = new StringBuilder();

	public void pickAFile() throws Exception {
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			// select a file
			java.io.File file = fileChooser.getSelectedFile();

			Scanner input = new Scanner(file);

			while (input.hasNext()) {
				sb.append(input.nextLine());
				sb.append("\n");
			}
			input.close();
		} else {
			sb.append("No File was selected");
		}
	}

}
