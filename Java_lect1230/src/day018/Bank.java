package day018;

public enum Bank {
	//열거형... 추가될수 있어 적절하진 않음-등록된 은행만 입력할수있게
	
	신한, 국민, 우리, 하나, 기업, 농협, 수협;
	


	public static void printBanks() {
	// TODO Auto-generated method stub
	Bank [] list = Bank.values();
	
	for(int i = 0; i < list.length; i++) {
		System.out.println((i == 0 ? "" : ",") + list[i]);
	}
	System.out.println();
}
	
	
	public static boolean check(String str) {		//문자열을 열거형 값으로 바꿀수 있는지 신한 ->(Bank)신한으로 
		try {
			
			return Bank.valueOf(str) != null;	//이값이 null이 아니면 true
			
		}catch (Exception e) {
			return false;
		}
		
	}

	
	
}
