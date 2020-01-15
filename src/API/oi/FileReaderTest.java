package API.oi;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//advancedJava������Ʈ ���� �Ʒ� ����� test.txt�� ������ �б�
public class FileReaderTest {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			//1.���Ͽ����ϱ�
		fr = new FileReader("src/api/oi/fileTest01.java");
			//2. ���Ͽ�����
		
		int count=0;
		long start = System.nanoTime();
		
		while(true) {
			int data = fr.read();
			if(data==-1) {
				break;
			}
			count++;
			System.out.print((char)data);
		}
		
		long end = System.nanoTime();
		System.out.println("����Ƚ��: "+count);
		System.out.println("����ð�: "+(end-start));
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//3. ���ϴݱ�
			try {
				fr.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
