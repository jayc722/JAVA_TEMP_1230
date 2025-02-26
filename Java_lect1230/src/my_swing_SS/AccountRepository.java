package my_swing_SS;


//스프링프레임워크 임포트
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account findByUsername(String username);

}
