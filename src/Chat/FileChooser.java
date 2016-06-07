package Chat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 * opens a coming file
 * 
 * @author Jiawen
 * @author Sean
 *
 */
public class FileChooser {
	public static File[] show() {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setMultiSelectionEnabled(true);
      StringBuilder sb = new StringBuilder();

      if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
         // select a file
         return fileChooser.getSelectedFiles();
      } else {
         sb.append("No File was selected");
      }
      return null;
	}
}
