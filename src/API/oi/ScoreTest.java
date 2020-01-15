package API.oi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
  BufferedReader�� ����Ͽ�
  Score.txt ������ �о �Ʒ��� ���� �������� ���
  �׻� �� �÷����� ����
  ȭ������ ����ϱ�
  
  [�������]
  �̹�ȣ�� ������ 100��
  ������ ������ 98��
  ������� ������ 99��
  ����:
  ���:

*/
public class ScoreTest {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
		br = new BufferedReader(new FileReader("src\\data\\Score.txt"));
		int count=0;
		int total=0;
		while(true) {
			String line = br.readLine();
			if(line==null) {
				break;
			}
			String[] data =line.split(",");
			total = total+Integer.parseInt(data[1]);
			count++;
			System.out.println(data[0]+"�� ������"+data[1]+"��");
		}	
		System.out.println("����: "+total);
		System.out.println("���: "+(total/count));
		System.out.println();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br!=null)br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
