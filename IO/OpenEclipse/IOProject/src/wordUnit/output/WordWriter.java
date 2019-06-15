package wordUnit.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WordWriter {

	public static void writeFile(String fileName, String word) {
		
		Writer writer = null;
		
		 try {
			 writer = new BufferedWriter(new FileWriter(new File(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			writer.write(word);
			writer.close();
		} catch (IOException e) {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		writeFile("file/WordTest.txt", "테스트파일2");
	}

}