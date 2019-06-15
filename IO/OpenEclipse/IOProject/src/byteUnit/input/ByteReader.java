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
		InputStream is = null;
		
		try {
			is= new  BufferedInputStream (new FileInputStream(new File(fileName)),1024);
		} catch (FileNotFoundException e) {
			System.err.println("파일이 존재하지 않습니다.");
			e.printStackTrace();
		}

		try {
			is.read(read);
			String remake = new String(read,"UTF-8");
			System.out.println(remake);
			is.close();
		} catch (IOException e) {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}
		}
	}

	public static void main(String[] args) {
		readFile("file/ByteTest.txt");
	}

}