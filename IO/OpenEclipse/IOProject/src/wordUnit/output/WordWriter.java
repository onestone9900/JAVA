package wordUnit.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WordWriter {

	public static void writeFile(String fileName, String word) {
		
		try(Writer writer = new BufferedWriter(new FileWriter(new File(fileName)))) {
			writer.write(word);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		writeFile("file/WordTest.txt", "테스트파일2");
	}

}