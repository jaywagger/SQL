package API.Util;

import java.util.ArrayList;

public class ArrayListExam01 {
	public static void main(String[] args) {
		//79,55,100,98,99�� ArrayList�� ��� ������ ����� ����ϼ���
		//[�������]
		//����:
		//���:
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(79);
		list.add(55);
		list.add(100);
		list.add(98);
		list.add(99);
		
		double sum = 0;
		for (int i =0; i<list.size(); i++) {
			sum += list.get(i);   //list.get(i) �ϳ��� ��������
		} System.out.println("����: "+sum);
		
		double avg = sum/list.size();
		System.out.println("���: "+avg);
		
		
	}

}
