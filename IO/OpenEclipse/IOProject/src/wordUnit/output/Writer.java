package wordUnit.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

	public static void writeFile(String fileName) {
	
		BufferedWriter bw = null;
		String contents = "입력내용";
		
		try {
			bw = new BufferedWriter(new FileWriter(new File(fileName)));
		} catch (IOException e) {
			System.out.println("파일을 읽는데 실패하였습니다.");
		}
		try {
			bw.write(contents);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		writeFile("C:/test/test.txt");

	}

}