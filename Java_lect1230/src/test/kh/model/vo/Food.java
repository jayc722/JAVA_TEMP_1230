package test.kh.model.vo;

import java.io.Serializable;

public class Food implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//필드
	private String name;	//인스턴스변수
	private int kcal;		//인스턴스변수
	
	
	public Food() {
	//기본생성자
	}


	public Food(String name, int kcal) {//매개변수 있는 생성자
		this.name = name;
		this.kcal = kcal;
	}


	//getter setter
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKcal() {
		return kcal;
	}


	public void setKcal(int kcal) {
		this.kcal = kcal;
	}


	@Override
	public String toString() {
		return name + " : " + kcal + "kcal";
	}
	
	
	
	

}
