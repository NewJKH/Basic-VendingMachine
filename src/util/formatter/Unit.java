package util.formatter;

import java.text.DecimalFormat;

public class Unit {
    DecimalFormat format = new DecimalFormat("#,###");
    public String intUnit(int amount){
        return format.format(amount);
    }
}
