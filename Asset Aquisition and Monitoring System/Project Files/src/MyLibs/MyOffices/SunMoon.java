
package MyLibs.MyOffices;

import MyLibs.Equipment;


public class SunMoon implements IOffice{
    private Equipment[] equipments; //the equipment list for this specific office

    @Override
    //hardcodes the following to the IOffice object named "SunMoon"
    public int OfficeNum() {
         return 2;
    }

    @Override
    public String OfficeName() {
        return "Sun&Moon";
    }
    
    @Override
    public Equipment[] EquipmentList() {
        return equipments;
    }
}
