package my_swing_SS;

import lombok.Data;

//@Entity
@Data
public class Account {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDNTITY)
	private Long id;
	
	//@Column(unique = true, nullable = false)
	private String username;
	
	//@Column(nullable = false)
	private String password;
	
	private boolean isAdmin = false;
	
}
