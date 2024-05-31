
package MyLibs.MyOffices;

import MyLibs.Equipment;

public class Deans implements IOffice{
    private Equipment[] equipments; //the equipment list for this specific office

    @Override
    //hardcodes the following to the IOffice object named "Deans"
    public int OfficeNum() {
         return 1;
    }

    @Override
    public String OfficeName() {
        return "Dean's";
    }
    
    @Override
    public Equipment[] EquipmentList() {
        return equipments;
    }
}
