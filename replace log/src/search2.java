import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class search2 {
	
	final static Logger logger = LogManager.getLogger(search2.class);
	public static String line;
	static Object replace;
	public static Path path;
	public static String charset;
	
	
    public static void main(String[] args) throws IOException {
    	
        Scanner s = null;
        String replace = "";
        String search = bukasframe.searchText.getText();
        replace = bukasframe.replaceText.getText();
        
        		
        try {
    //   s = new Scanner(new BufferedReader(new FileReader("C:\\Users\\bukvalife\\git\\bukas-replace-log\\text.txt")));
        	
        //	s = new Scanner(new BufferedReader(new FileReader(bukasframe.textPath.getText().replace("\\", "\\\\"))));
      //  	s = new Scanner(new BufferedReader(new FileReader(replace.path)));
        	  Path path = Paths.get(bukasframe.textPath.getText().replace("\\", "\\\\"));
    	  	  Charset charset = StandardCharsets.UTF_8;
      //  	s = new Scanner(Paths.get(bukasframe.textPath.getText().replace("\\", "\\\\")));
        	  
        	  try{
    	  	s = new Scanner(path);
        	  }catch (IOException e1) {
					
					e1.printStackTrace();
				} 
        	  
            int i = 0;
            while (s.hasNext()) {
            	i++;
                String line = s.nextLine().toString();
                
        	        boolean foundIt = false;
        	        String regex = ("\\W"+(search.toString())+"\\W");
        	        Pattern p = Pattern.compile(regex);
        	//        Matcher m = p.matcher(searchMe);
        	        Matcher m = p.matcher(line);
        	        
        	        while(m.find()){
        	        //	i=i++;
        	    //        System.out.println("Matcher found " + m.group() + " at index "+ m.start() + " for regex " + regex + " in string \"" + searchMe +"\"" );
        	            foundIt = true;
        	            
        	            if (logger.isDebugEnabled()) {
                      	  logger.debug("Line #" + i + " contains searched term \""  + search + "\" at index "+ m.start());
                      	}
        	            
        	            
        //	            if(replace.length() != 0){
        //	            
       // 	            }
        	            
        	            
       	            if(replace.length() != 0 | foundIt){
       	            	
     //  	            	System.out.println("ovde ide replace");
     //  	            	System.out.println(replace);
       	            	
       	    
       	            	  String content = null;
       	            				content = new String(Files.readAllBytes(path), charset);
   					//	content= line;	
       	            	
       	            	
      	            	ByteBuffer input = ByteBuffer.wrap(content.getBytes());
      	            //    byte[] toSearch = search.getBytes();
      	    //            int index = getIndex(input, toSearch);
      	                
      	                
      	            //    int index = m.start();
      	             
      	          
      	           //     byte[] first = new byte[index];
      	                input.get(m.start()+1);
      	            //    content = content.replace(search, replace);
      	            
      	             content = content.replaceFirst(regex, replace);
      	      //       content = content.
      	             
      	       //      content = fileBuffer.
      	           //     byte[] second = replace.getBytes();
      	                try {
      	            		Files.write(path, content.getBytes(charset));
      	            //		System.out.println("ok2");
      	            	} catch (IOException e) {
      	            		// TODO Auto-generated catch block
      	            		e.printStackTrace();
      	            	}
    	            //    
      	            //    input.position(input.position()+search.length());
      	            input.position(m.start() + (search.length()+1));
      	                System.out.println(input.position());
      	          //      System.out.println("ok");
    	            	
       	            }
       	        }
       	   //     if(!foundIt){
       	    //        System.out.println("No matches found for " + regex + " in string \"" + searchMe +"\'");
       	    //    }
       	   //     System.out.println();
       	//    }
               
               
               
               
          //     if(line.contains(bukasframe.searchText.getText())){
               	
   //                if (logger.isDebugEnabled()) {
   //                	  logger.debug("Line number " + i + " contains searched term " + bukasframe.searchText.getText());
    // /*             	}
                   
        	             
       //        }
               
        	        
            
        	        
        	        
           }
        } finally {
            if (s != null) {
                s.close();
                
            }
        }
    }
}