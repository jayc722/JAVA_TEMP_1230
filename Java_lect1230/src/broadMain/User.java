package broadMain;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private boolean ath;
    private Set<String> searchHistory = new HashSet<>();

    public void addSearch(String search) {
        searchHistory.add(search);
    }

    public void printSearchHistory() {
        if (searchHistory.isEmpty()) {
            System.out.println("검색 기록이 없습니다.");
        } else {
            searchHistory.forEach(System.out::println);
        }
    }
}
