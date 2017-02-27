import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
import java.util.regex.*;


public class replace {
	public static String content;
	 static String search = bukasframe.searchText.getText();

		public static void main(String[] args) throws IOException {

//			Path path = Paths.get("C:\\Users\\bukvalife\\git\\bukas-replace-log\\text.txt");
	// 		Path path = Paths.get(SelectFile.spath.toString());
	//  	String path = SelectFile.path.toString();
	// 		Path path = Paths.get(SelectFile.spath.replace("\\", "\\\\"));
			
			
			Path path = Paths.get(bukasframe.textPath.getText().replace("\\", "\\\\"));
			Charset charset = StandardCharsets.UTF_8;
			
			
			String content = null;
			
				try {
					content = new String(Files.readAllBytes(path), charset);
					} catch (IOException e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
					}
    
				
				
				
				 String regex = ("\\W"+(search.toString())+"\\W");
		 	        Pattern p = Pattern.compile(regex);
		 	//        Matcher m = p.matcher(searchMe);
		 	        Matcher m = p.matcher(content);
		//	String search = bukasframe.searchText.getText();
			String replace = bukasframe.replaceText.getText();
    
//			String search = "wowe";
//			String replace = "wowering";
			ByteBuffer input = ByteBuffer.wrap(content.getBytes());
			byte[] toSearch = regex.getBytes();
			int index = getIndex(input, toSearch);
		//	String regReplace = ("\\W"+(replace.toString())+"\\W");
			byte[] first = new byte[index];
			input.get(first);
			content = content.replaceAll(regex, replace);
		//	byte[] second = replace.getBytes();
			
				try {
					Files.write(path, content.getBytes(charset));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    
				input.position(input.position()+replace.length());
				System.out.println(content);
    
		}
  
         	public static int getIndex(ByteBuffer input , byte[] search){
         		int index = -1 ;
         		while(input.hasRemaining() && index==-1){
         			boolean found = true ;
         			for(byte b : search){
         				if(input.get()!=b){
         				found = false ;
         				break ; 
         			}
         		}
         			
             if(found)
             {
               index= input.position()-search.length;
             }
           }
           input.rewind();
           return index ;
  
       }

}
