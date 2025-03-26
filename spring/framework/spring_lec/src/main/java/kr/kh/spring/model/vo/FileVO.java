package kr.kh.spring.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileVO {
//다른애들은 생성자 따로 필요 안했는데 얘는 파일 넣을때마다 생성해서 넣어주기 위해 생성자로
	private int fi_num;
	private String fi_ori_name;
	private String fi_name;
	private int fi_po_num;
	
	
	public FileVO(String fi_ori_name, String fi_name, int fi_po_num) {	//얘때문에 noargsconstructor 필요
		this.fi_ori_name = fi_ori_name;
		this.fi_name = fi_name;
		this.fi_po_num = fi_po_num;
	}
	
	
}
