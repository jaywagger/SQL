package API.oi;

import java.io.File;

public class fileTest01 {
	public static void main(String[] args) {
		//�������ϰ� ���� �����̳� ������ ��ġ�� file ��ü ���� �� �Ű������� ����
		//1. C:\IoTJY\iotTest����
		File file1 = new File("C:\\IoTJY\\iotTest");//������
/*		File file1 = new File("C:/IoTJY/iotTest");
*/		
		//2. ������Ʈ ������ ������ test.txt����
		//C:\IoTJY
		File file2 = new File("test.text"); 
					//��θ� �������� �ʾ��� ��, �⺻���� �ν��ϴ� ������ ������Ʈ ����
		
		//3. src/data ������ ����� test.txt����
		File file3 = new File("src/data/test.txt"); //�����
		
		System.out.println(file1);
		System.out.println(file2);
		System.out.println(file3);
		System.out.println();
		
		//file �޼��� Ȯ���ϱ�
		System.out.println("file3.canRead()=>"+file3.canRead());
		System.out.println("file3.canWrite()=>"+file3.canWrite());
		System.out.println("file3.getName()=>"+file3.getName());
		System.out.println("file3.getAbsolutePath()=>"
										+file3.getAbsolutePath());
		System.out.println("file3.getParent()()=>"
				+file3.getParent());
		System.out.println("file3.isDirectory()=>"+file3.isDirectory());
		System.out.println("file1.isDirectory()=>"+file1.isDirectory());
		System.out.println("file3.isHidden()=>"+file3.isHidden());
		System.out.println("file3.lastModified()=>"+file3.lastModified());
		System.out.println("file3.length()=>"+file3.length());
		file3.setReadOnly();
	}
}
