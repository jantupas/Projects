
package MyLibs.MyOffices;

import MyLibs.Equipment;

//definition of office object
public class Office {
    private int officeNum;
    private String officeName;
    private Equipment equipmentlist[];
    
    public Office(int officeNum, String officeName, Equipment[] equipmentlist) {
        this.officeNum = officeNum;
        this.officeName = officeName;
        this.equipmentlist = equipmentlist;
    }
    //method to get Office number
    public int getOfficeNum() {
        return officeNum;
    }
    //method to get name of Office
    public String getOfficeName() {
        return officeName;
    }
    //method to get equipment list
    public Equipment[] getEquipmentlist() {
        return equipmentlist;
    }
    
    
}
