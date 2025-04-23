package kr.kh.boot.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //매퍼가 기본생성자로 vo를 호출하는데 생성자 추가할 경우 기본생성자 추가해줘야 함
public class FileVO {
	int fi_num;
	String fi_name;
	String fi_ori_name;
	int fi_po_num;
	
	public FileVO(int po_num, String fi_ori_name, String fi_name) {
		this.fi_po_num = po_num;
		this.fi_ori_name = fi_ori_name;
		this.fi_name = fi_name;
	}
}