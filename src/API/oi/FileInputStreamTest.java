package API.oi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//advancedJava������Ʈ ���� �Ʒ� ����� test.txt�� ������ �б�
public class FileInputStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			//1.���Ͽ����ϱ�
		fis = new FileInputStream("test.txt");
			//2. ���Ͽ�����
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
			//3. ���ϴݱ�
			try {
				fis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
