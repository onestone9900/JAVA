package byteUnit.input;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
	
	public static void readFile(String fileName) {
		
		byte read[] = new byte[32];
		
		try(InputStream is = new  BufferedInputStream (new FileInputStream(new File(fileName)),1024)) {
			is.read(read);
			String remake = new String(read,"UTF-8");
			System.out.println(remake);
		} catch (FileNotFoundException e) {
			System.err.println("파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		readFile("file/ByteTest.txt");
	}

}