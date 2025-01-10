package day009;

public class Ex01_String {

	public static void main(String[] args) {
		// 파일명이 주어졌을 때 파일이 이미지인지 아닌지 확인하는 코드
		
		
		
		String fileName = "test.txt";
		final String imgs [] = new String [] {"jpg", "bmp", "gif", "png"};
		
		
		
		/* 내가한거
		
		int count = 0;
		for(int i=0;i<imgs.length;i++) if(fileName.contains(imgs[i])) {
			System.out.println(fileName + "은 이미지 파일이 맞습니다.");
		count++;
		break;
		}
		
		if(count==0)System.out.println(fileName + "은 이미지 파일이 아닙니다.");
		*/
		
		//txt 추출	-> lastIndexOf (확장자가 아니어도 . 들어갈수 있으니)
		//subString
		//반복문을 통해 추출한 문자열이 배열에 있는지 확인 -> 향상된 for문 equals 비교
		//출력
		
		/*
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		
		int check = 0;
		for(String file : imgs) {
			if(fileType.equals(file)) {
				System.out.println(fileName + "은 이미지 파일이 맞습니다.");
				check++;
			}
		}
		if(check<=0)System.out.println(fileName + "은 이미지 파일이 아닙니다.");
				*/
		
		
		int index = fileName.lastIndexOf(".");
		
		if(index<0) {
			System.out.println(fileName + "은 이미지 파일이 아닙니다.");
			return;
		}
		
		String prefix = fileName.substring(index+1);
		
		//그냥 for 문 써도 되긴 하나 배열 수정 안하기때문에 향상된 for문이 편함
		boolean result = false;
		for(String img : imgs) {
			if(img.equals(prefix)) {
				result = true;
				break;
			}
		}
		if(result)System.out.println(fileName + "은 이미지 파일이 맞습니다.");
		else System.out.println(fileName + "은 이미지 파일이 아닙니다.");
	}

}
