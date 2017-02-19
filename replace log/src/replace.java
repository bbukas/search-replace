import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;


public class replace {
	public static void main(String[] args) throws IOException {

//	  Path path = Paths.get("C:\\Users\\bukvalife\\git\\bukas-replace-log\\text.txt");
	//  Path path = Paths.get(SelectFile.spath.toString());
	//  String path = SelectFile.path.toString();
		Path path = Paths.get(SelectFile.spath.replace("\\", "\\\\"));
	  Charset charset = StandardCharsets.UTF_8;

	  String content = null;
	try {
		content = new String(Files.readAllBytes(path), charset);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    String search = bukasframe.searchText.getText();
    String replace = bukasframe.replaceText.getText();
    
//	String search = "wowe";
//	String replace = "wowering";
	ByteBuffer input = ByteBuffer.wrap(content.getBytes());
    byte[] toSearch = search.getBytes();
    int index = getIndex(input, toSearch);
    
    byte[] first = new byte[index];
    input.get(first);
    content = content.replace(search, replace);
    byte[] second = replace.getBytes();
    try {
		Files.write(path, content.getBytes(charset));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
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
    return index ;
   
  }

}
