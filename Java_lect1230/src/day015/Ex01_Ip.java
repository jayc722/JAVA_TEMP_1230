package day015;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Ex01_Ip {

	public static void main(String[] args) {
//InetAdress 클래스 예제
		//localhost : 내부 아이피주소에 지정된 이름. 127.0.0.1 고정
		
		try {
			InetAddress address = InetAddress.getByName("localhost");
			
			System.out.println(address);
			address = InetAddress.getByName("www.naver.com");		//도메인 -> ip주소를 입력하기 편하도록 ->ip주소와 도메인 연결작업 필요
			System.out.println(address);
			
			InetAddress [] list = InetAddress.getAllByName("www.naver.com");
			System.out.println(Arrays.toString(list));		//->규모가 있는 아이피 가져올때(네이버같은 사이트는 여러개의 아이피주소로 이뤄져있음)
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		
		
	}

}
