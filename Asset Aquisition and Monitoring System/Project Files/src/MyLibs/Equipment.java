package MyLibs;

import MyLibs.MyOffices.IOffice;
import MyLibs.MyOffices.Office;


public class Equipment {
    //variables
    private int equipNum;
    private String equipName;
    private String condition;
    private IOffice office;

    //constructor for Equipment
    public Equipment(int equipNum, String equipName, String condition, IOffice office) {
        this.equipNum = equipNum;
        this.equipName = equipName;
        this.condition = condition;
        this.office = office;
    }
    
    //the following are getter methods
    public IOffice getOffice() {
        return office;
    }

    public int getEQNum() {
        return equipNum;
    }

    public String getEQName() {
        return equipName;
    }

    public String getEQCondition() {
        return condition;
    }
    
}
