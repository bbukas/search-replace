import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class stream {

	public static void main(String args[]) {

//		String fileName = "c://lines.txt";

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get((bukasframe.textPath.getText().replace("\\", "\\\\"))))) {

		//	String linija = new String();
	//		linija = stream.toString();
		//	stream.forEach(System.out::println);

	//		stream.forEach(regexsearch.displayFind());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}