package wordUnit.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	
	public static void readFile(String fileName) {
		
		String data;
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;

		
		try {
			br = new BufferedReader(new FileReader(new File(fileName)));
		} catch (FileNotFoundException e) {
			System.err.println("파일이 존재하지 않습니다.");
		}
		
		try {
			while((data = br.readLine()) != null) {
				sb.append(data);
			}
		} catch (IOException e1) {
			System.err.println("파일을 읽는 도중 오류가 발생했습니다."); 
		} finally {
		
			try {
				if(br!=null) {
					br.close();	
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println(sb.toString());
				
	}
	
	public static void main(String[] args) {
		readFile("file/WordTest.txt");
		
//		자바는 기본적으로 모든 문자집합에 대하여 16비트로 구성된 유니코드는 사용한다		

//		 finally 안에 return을 할 경우, return이 정상 종료를 의미 하므로 try 구문에서 발생한 
//		 Exception이 출력이 되지 않습니다.
//
//		 finally 안에 또 다른 try catch문
//
//		 이 부분도 생각 많이 해야합니다. finally 구문에서 생기는 Exception이 그 전에 생긴
//		 Exception을 잡아 먹어버림... ㅎㅎ 그래서 try 안에서 발생한 부분을 파악 할 수 없음



	}

}