package API.oi;

import java.io.File;
import java.text.SimpleDateFormat;

//������ ���θ� Ž��
public class fileTest02 {
	public static void main(String[] args) {
		/*
		 * C:\IoTJY\iotTest ������  ���� ���� �� ������ ���
		 * �������
		 * a------����
		 * b------����
		 * ArrayTest01.java--------����: ������ ������ ���
		 * ������ ������ ��¥�� �� �� ���� �������� ���
		*/
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		File file = new File("C:\\IoTJY\\iotTest"); 
		File[] filelist = file.listFiles();
		for(int i=0; i<filelist.length;i++) {
			if(filelist[i].isDirectory()) {
				System.out.println(filelist[i].getName()
						+"-------[����]");
			}else {
				System.out.println(filelist[i].getName()
						+"-------[����: ("+
						filelist[i].length()+")]:"
								+ sdf.format(filelist[i].lastModified()));
			}
		}
	}

}
