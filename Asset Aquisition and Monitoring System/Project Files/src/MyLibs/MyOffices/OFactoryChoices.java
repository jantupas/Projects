
package MyLibs.MyOffices;

//Extends OfficeFactory and creates office object to be returned
public class OFactoryChoices extends OfficeFactory{
    private IOffice office; 

    @Override
    protected IOffice createOffice(int objectRequest) {
        switch (objectRequest) {
            case 0:
                office = new Deans();   //create Dean's office object 
                break;
            case 1:
                office = new Faculty(); //create Faculty office object
                break;
            case 2:
                office = new SunMoon(); //Create SunMoon office object
                break;
            default:
                break;
        }
        
       return office;
    }

}
