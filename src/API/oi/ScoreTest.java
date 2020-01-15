package API.oi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
  BufferedReader를 사용하여
  Score.txt 파일을 읽어서 아래와 같은 형식으로 출력
  항상 두 컬럼으로 고정
  화면으로 출력하기
  
  [출력형태]
  이민호의 점수는 100점
  현빈의 점수는 98점
  김범룡의 점수는 99점
  총점:
  평균:

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
			System.out.println(data[0]+"의 점수는"+data[1]+"점");
		}	
		System.out.println("총점: "+total);
		System.out.println("평균: "+(total/count));
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
