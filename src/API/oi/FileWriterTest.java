package API.oi;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
	public static void main(String[] args) throws IOException {
		//File����� �Ű������� ���޵� ������ ������ �ش� ������ ���� �۾�������
		//���� ��� ���� ������ �����Ͽ� �۾��Ѵ�.
		//1.���Ͽ���
		FileWriter fw = new FileWriter("src/data/write.txt",true);
											//true���� ����� �ȵȴ�
		//2.���Ͽ�����	
		fw.write(97); //int������=> ascii�� �ش��ϴ� ���ڰ� ���
		fw.write("���ڿ�����\n");
		fw.write("Test");
		//3.���ϴݱ�	
		fw.close();
	}

}
