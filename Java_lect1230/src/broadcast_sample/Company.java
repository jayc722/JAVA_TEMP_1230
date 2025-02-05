package broadcast_sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class Company implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String companyName;
	 List<TimeTable> list;
	
	
	
	

	
	public void sort() {
		//시간c순 정렬
		list.sort((o1,o2)->{
			if(o1.getTime() != o2.getTime()) {
				return o1.getTime() - o2.getTime();
			}
			return o1.getMin() - o2.getMin();
		});
	}
	
	
		
	public void printOnly() {
			
		}
		
	public void printAll() {
		
		int numA = 0;
		int numB = 0;
		int numC = 0;
		int numD = 0;
		for (int i = 0; i < list.size();i++) {
			numA = list.get(i).getTime();
			numC = list.get(i).getMin();
			
			if(numC>numD) {
				System.out.println();
			}else if(numA>numB) {
				System.out.println();
				numC = 0;
			}
			
			System.out.println(list.get(i).toString());
			
			numB = numA;
			numD = numC;
		}
		
		
		
	}



	public Company(String companyName) {
		this.companyName = companyName;
		list = new ArrayList<TimeTable>();
	}
	
	


	
	
	
	
}




