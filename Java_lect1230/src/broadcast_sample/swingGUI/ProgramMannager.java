package broadcast_sample.swingGUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import broadcast_sample.Company;
import broadcast_sample.TimeTable;
import broadcast_sample.User;



public class ProgramMannager implements ConsoleProgram{

	
	private static List<User> userList;				//계정 리스트
	private static List<Company> comList;		//전체 편성표
	private static List<String> companys;			//방송사 목록

	public void run() {

		userList = (ArrayList<User>)load(fileName("userList"));				
		comList = (ArrayList<Company>)load(fileName("comList"));				
		companys = (ArrayList<String>)load(fileName("companys"));		

		//불러오기
		//조회, 수정 가능
		userList = (userList == null) ? new ArrayList<>() : userList;
		comList = (comList == null) ? new ArrayList<>() : comList;
		companys = (companys == null) ? new ArrayList<>() : companys;


		//불러오기 실패 처리
		if(userList.isEmpty() || userList.size()==0) {
			userList.add(new User("admin", true));
			userList.add(new User("smpl", false));
			System.out.println("임의의 유저를 추가했습니다.");
		}

		if(comList.isEmpty() || comList.size()==0) {
			Company kbs = new Company("KBS");
			kbs.getList().add(new TimeTable(1,0,"kbs제목1","샘플"));
			kbs.getList().add(new TimeTable(3,0,"kbs제목2","샘플"));
			kbs.getList().add(new TimeTable(3,30,"kbs제목3","샘플"));
			comList.add(kbs);
			companys.add("KBS");

			Company sbs = new Company("SBS");
			sbs.getList().add(new TimeTable(1,30,"sbs제목1","샘플"));
			sbs.getList().add(new TimeTable(5,40,"sbs제목2","샘플"));
			comList.add(sbs);
			companys.add("SBS");

			Company mbc = new Company("MBC");
			mbc.getList().add(new TimeTable(1,0,"mbc제목1","샘플"));
			comList.add(mbc);
			companys.add("MBC"); 

			System.out.println("빈 시간표를 임의로 작성했습니다.");
		}

		
		
		//아이디 입력
		
		MainFrame main = new MainFrame();
		
	}
	

}
