package kr.kh.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor //생성자가 있으면 생성자 자동생성 안되니 추가
public class PersonDTO {
	
	private String name;
	private int age;
	
	public String getTotal() {
		return name + " : " + age;
	}
}
