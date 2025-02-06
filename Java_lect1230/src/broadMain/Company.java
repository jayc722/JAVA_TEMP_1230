package broadMain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    private String companyName;
    private List<TimeTable> list = new ArrayList<>();

    public Company(String companyName) {
        this.companyName = companyName;
    }
}
