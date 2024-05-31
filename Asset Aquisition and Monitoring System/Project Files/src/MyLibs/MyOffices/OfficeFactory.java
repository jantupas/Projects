
package MyLibs.MyOffices;

//Abstract factory that has method to create office
public abstract class OfficeFactory{
    
    protected abstract IOffice createOffice(int objectRequest);
    
    public IOffice returnOffice(int object){
        IOffice office=createOffice(object);
        return office;
    }
}
