package byteUnit.output;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteWriter {

	public static byte[] stringToByteArray(String word) {
		
		byte[] byteWord = word.getBytes();
		return byteWord;
	}
	
	public static void writeFile(String fileName, byte[] word) {
		
		try(OutputStream os= new  BufferedOutputStream (new FileOutputStream(new File(fileName)))){
			os.write(word);	
		} catch (FileNotFoundException e) {
			System.err.println("파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		writeFile("file/ByteTest.txt", stringToByteArray("테스트파일2"));
	}

}