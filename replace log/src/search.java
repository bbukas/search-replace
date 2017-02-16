import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;


public class search {
  
  public static void main(String[] args)
  {
	  Path path = Paths.get("C:\\Users\\bukvalife\\git\\bukas-replace-log\\text.txt");
	  Charset charset = StandardCharsets.UTF_8;

	  String content = null;
	try {
		content = new String(Files.readAllBytes(path), charset);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  //  String fullText = new String(Files.readAllBytes(path), charset);
    String search = "wowe";
    String replace = "wow, WOW!";
    ByteBuffer input = ByteBuffer.wrap(content.getBytes());
    byte[] toSearch = search.getBytes();
    int index = getIndex(input, toSearch);
    
    byte[] first = new byte[index];
    input.get(first);
    content = content.replaceAll(search, replace);
  //  byte[] second = replace.getBytes();
    
    input.position(input.position()+search.length());
    
    System.out.println(content);
    
    
  }
  
  public static int getIndex(ByteBuffer input , byte[] toSearch)
  {
    int index = -1 ;
    while(input.hasRemaining() && index==-1)
    {
      boolean found = true ;
      for(byte b : toSearch)
      {
        if(input.get()!=b)
        {
          found = false ;
          break ; 
        }
      }
      if(found)
      {
        index= input.position()-toSearch.length;
      }
    }
    input.rewind();
  //  System.out.println(index);
    return index ;
   
  }

}
