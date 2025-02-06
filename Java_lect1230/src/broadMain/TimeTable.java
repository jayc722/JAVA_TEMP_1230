package broadMain;

import java.io.Serializable;
import java.text.DecimalFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimeTable implements Serializable {
    private static final long serialVersionUID = 1L;
    private int time;
    private int min;
    private String name;
    private String types;

    @Override
    public String toString() {
        return new DecimalFormat("00").format(time) + "시 " + 
               new DecimalFormat("00").format(min) + "분 | " +  
               name + " | " + types + " | ";
    }

    public String toStringNoTime() {
        return "(" + new DecimalFormat("00").format(min) + ") " + 
               name + " | " + types + " | ";
    }
}
