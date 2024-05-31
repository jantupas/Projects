/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLib;

/**
 *
 * @author janed
 */
public class Product {
    //class for product object to be used in the database
    private int prodid;
    private String name;
    private String status;
    private double sellprc;
    private double acqprc;
    private int quantity;
    private String acqdate;
    private String expdate;

    public Product(int prodid, String name, String status, double sellprc, double acqprc, int quantity, String acqdate, String expdate) {
        this.prodid = prodid;
        this.name = name;
        this.status = status;
        this.sellprc = sellprc;
        this.acqprc = acqprc;
        this.quantity = quantity;
        this.acqdate = acqdate;
        this.expdate = expdate;
    }

    public int getProdid() {
        return prodid;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public double getSellprc() {
        return sellprc;
    }

    public double getAcqprc() {
        return acqprc;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getAcqdate() {
        return acqdate;
    }

    public String getExpdate() {
        return expdate;
    }





    

    
    
}
