import java.io.File;
import java.util.regex.*;

import javax.swing.JFileChooser;

public class SelectFile {
static String selectedFile;
static String spath;

public static void main (){
	
	JFileChooser fileChooser = new JFileChooser();
	fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	int result = fileChooser.showOpenDialog(fileChooser);
	if (result == JFileChooser.APPROVE_OPTION) {
	    File selectedFile = fileChooser.getSelectedFile();
	    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
	 String spath = selectedFile.getAbsolutePath();
//	 spath = spath.replace("\\", "\\\\");
	 
//	 String spath = selectedFile.getAbsolutePath();
//	 if(spath.charAt(spath.length()-1)!=File.separatorChar){
//	     spath += File.separator;
//	 }
	 bukasframe.textPath.setText(spath);
	 
	 System.out.println(spath);
	}
	
}
}
