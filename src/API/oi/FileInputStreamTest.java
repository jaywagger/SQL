package API.oi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//advancedJava프로젝트 폴더 아래 저장된 test.txt의 내용을 읽기
public class FileInputStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			//1.파일오픈하기
		fis = new FileInputStream("test.txt");
			//2. 파일엑세스
		while(true) {
			int data = fis.read();
			if(data==-1) {
				break;
			}
			System.out.print((char)data);
		}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//3. 파일닫기
			try {
				fis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
