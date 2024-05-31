
package MyLibs.MyOffices;


import MyLibs.Equipment;

//Interface implemented by the 3 offices
public interface IOffice {
    int OfficeNum();
    String OfficeName(); 
    Equipment[] EquipmentList();
}

