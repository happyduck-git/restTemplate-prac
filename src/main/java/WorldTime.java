import lombok.Getter;

import java.util.Date;

@Getter
public class WorldTime {

    private String timezone;
    private Date datetime;
    private int  day_of_week;
}
