package API.oi;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

//Scannerũ������Next�޼ҵ��� ����� ����
public class InputStreamReaderTest {
	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		PrintStream out = System.out;
	
		while(true) {
		//1. ��Ʈ���� �����͸� 1byte�б�
			try {
				int data = in.read();
				if(data==13) {
					break;
				}
				out.print((char)data);
			}catch(IOException e) {
				e.printStackTrace();
				
			}
			
		}
		
	}

}
