package day020;

import java.text.DecimalFormat;
import java.util.Objects;

import lombok.Data;

@Data
public class Product {

	
	private String code;
	private String category;
	private String name;
	private String option;
	private int price;
	private int amount;
	
	
	
	
	
	
	public Product(String code, String category, String name, String option, int price) {
		this.code = code;
		this.category = category;
		this.name = name;
		this.option = option;
		this.price = price;
		
		//amount 0으로 초기화 되기때문에 적을필요 x
	}





	public Product(int max, String category, String name, String option, int price) {
		this("", category, name, option, price);  		//this 생성자. code 빈문자열. 코드 추가
		
		//code를 추가
		String prefix = Product.getCodePrefix(category);
		DecimalFormat format = new DecimalFormat("000");
		String suffix = format.format(max + 1);
		this.code = prefix + suffix;
				
				
		
	}

	



	@Override
	public String toString() {
		return "[" + category + "]" + name + " " + option + " - " + code + " : " + price + "원 " + amount;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(code, other.code);
	}





	public static String getCodePrefix(String category) {
		// TODO Auto-generated method stub
		
		
		switch(category) {
		case "문구" :
			return "ABC" ;
		
		case "의류" :
			return "DEF"; 
		case "식품" :
			return "XYZ"; 
		case "가전" :
			return "ELC"; 
		case "기타" :
			return "ETC"; 
		default :
			return null;
		}
	}





	public void update(String name, String option, int price) {
		
		this.name = name;
		this.option = option;
		this.price = price;
		
	}





	public void store(int amount) {
		this.amount += amount;
		
		
		
		
	}
			
		
		

	
	
	
	
	
}
