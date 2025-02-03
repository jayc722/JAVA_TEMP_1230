package day020;

import java.util.Date;

import lombok.Data;

@Data
public class PurchaseItem {
	//구매 내역 관리 클래스
	
	
	Product p;
	int amount;
	int totalPrice;		
	Date date;
	public PurchaseItem(Product p, int amount) {
		super();
		this.p = p;
		this.amount = amount;
		this.totalPrice = 0;
		this.date = new Date();
	}
	
	
	
	
	
}
