package day020;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor	//nonull인 애들만 생성자로
public class Member {
	@NonNull			
	private String id;
	@NonNull
	private String pw;
	@NonNull
	private String authority;	//사용자, 관리자
	private List<PurchaseItem> list = new ArrayList<PurchaseItem>();		//구매목록 리스트
	
	
	
	
	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
		this.authority = "사용자";
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(id, other.id);
	}





	public void addPurChaseItem(PurchaseItem pi) {
		// TODO Auto-generated method stub
		
	}





}
