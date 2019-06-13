package byteUnit.input;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader {
	
	public static void readFile(String fileName) {
		
		byte read[] = new byte[32];
		FileInputStream fis = null;
		BufferedInputStream bis = null;

		try {
			fis = new FileInputStream(new File(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("파일이 존재하지 않습니다.");
			e.printStackTrace();
		}
		
		bis = new BufferedInputStream(fis,1024);
	
		try {
			try {
				bis.read(read);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			String remake = new String(read,"UTF-8");
			System.out.println(remake);
	        bis.close();
		} catch (IOException e) {
			if(fis!=null) {
				try {
					bis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}

		}
				
	}
	
	public static void main(String[] args) {
		readFile("C:/test/test.txt");
	}

}