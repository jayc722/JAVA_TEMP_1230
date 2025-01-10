package day009;

public class Ex11_TryCatch {

	public static void main(String[] args) {
		// 예외 발생할수있는 경우
		
		try {
			System.out.println(1/0);						//예외가 발생하는 코드
			
			String str = null;
			System.out.println(str.charAt(0));
		
		/*catch (NullPointerException e) {	    	//먼저 걸리는애(부모클래스) 오면 밑에 안 가기 때문에 에러발생
			}*/										//순서대로 작동하기 때문
		}catch (ArithmeticException e) {
			
			System.out.println("arimetic예외 발생");
			
		}catch (NullPointerException | ArrayIndexOutOfBoundsException e) {		
			
			System.out.println("nullpointer 혹은 arrayoutofbounds 예외 발생");
		}catch(RuntimeException e) {
			
			System.out.println("runtime 예외 발생");
		}catch(Exception e) {							//가장 마지막에 excepion(최상위) 넣는게 안전
			
			System.out.println("예외 발생");
		}
		System.out.println("프로그램 종료");
		System.out.println("-----------------");
		print();
		
	}
	
	public static void print() {
		try {
			System.out.println(1/0);
		}catch(Exception e) {
			System.out.println("예외 발생");
			return;
		}finally {
		System.out.println("메소드 종료");				//리턴 이후에도 반드시 실행
		}
		System.out.println("예외 없음");
	}

}
