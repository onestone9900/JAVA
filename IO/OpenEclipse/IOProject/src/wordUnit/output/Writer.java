package wordUnit.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

	public static void writeFile(String fileName, String word) {
		
		BufferedWriter bw=null;
		
		 try {
			bw = new BufferedWriter(new FileWriter(new File(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		try {
			bw.write(word);
			bw.close();
		} catch (IOException e) {
			if(bw!=null) {
				try {
					bw.close();
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