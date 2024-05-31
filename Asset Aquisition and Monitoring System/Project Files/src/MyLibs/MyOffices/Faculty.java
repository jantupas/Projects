
package MyLibs.MyOffices;

import MyLibs.Equipment;
import MyLibs.MyOffices.IOffice;

public class Faculty implements IOffice{
    private Equipment[] equipments;     //the equipment list for this specific office

    @Override
    //hardcodes the following to the IOffice object named "Faculty"
    public int OfficeNum() {
         return 0;
    }

    @Override
    public String OfficeName() {
        return "Faculty";
    }
    
    @Override
    public Equipment[] EquipmentList() {
        return equipments;
    }
}
