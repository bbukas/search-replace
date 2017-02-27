import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.regex.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class regexsearch {
	final static Logger logger = LogManager.getLogger(regexsearch.class);
	 public static void main(String args[]) {
		
	//	 displayFind((bukasframe.searchText.getText().toString()),(replace.content));
	//	 displayFind (regex, searchMe);
	 }
//	 static void displayFind(String regex, String searchMe) {
	 static void displayFind() {
	        boolean foundIt = false;
	        String regex = ("\\w"+(bukasframe.searchText.getText().toString())+"\\W");
	        
	        System.out.println(regex);
	        
	        Path path = Paths.get(bukasframe.textPath.getText().replace("\\", "\\\\"));
	  	  Charset charset = StandardCharsets.UTF_8;
	        String searchMe = null;
	        int i = 0;
	    	searchMe = search2.line.toString();
	        
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(searchMe);
	        while(m.find()){
	        	i=i++;
	            System.out.println("Matcher found " + m.group() + " at index "+ m.start() + " for regex " + regex + " in string \"" + searchMe +"\"" );
	            foundIt = true;
	            
	            if (logger.isDebugEnabled()) {
              	  logger.debug("Line number " + i + " contains searched term " + bukasframe.searchText.getText());
              	}
	        }
	        if(!foundIt){
	            System.out.println("No matches found for " + regex + " in string \"" + searchMe +"\'");
	        }
	        System.out.println();
	    }
}
