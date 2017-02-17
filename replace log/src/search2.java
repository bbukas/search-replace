import java.io.*;
import java.util.Scanner;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;

public class search2 {
	
//	final static Logger logger = Logger(search2.class);
	final static Logger logger = LogManager.getLogger(search2.class);
	
	
    public static void main(String[] args) throws IOException {
    	
        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("C:\\Users\\bukvalife\\git\\bukas-replace-log\\text.txt")));
            int i = 0;
            while (s.hasNextLine()) {
            	i++;
            //    System.out.println(s.nextLine());
                String line = s.nextLine().toString();
                if(line.contains("wowe")){
                //    System.out.println(i);
        //            logger.debug("Line");
                    if (logger.isDebugEnabled()) {
                    	  logger.debug("Line number " + i + " contains searched term *wowe ");
                    	}
                }
                
            }
        } finally {
            if (s != null) {
                s.close();
                
            }
        }
    }
}