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
public class SellProd {
    //class for sold products object to be used in database
    private int prodid;
    private String name;
    private double sellprc;
    private int quantity;

    public SellProd(int prodid, String name, double sellprc, int quantity) {
        this.prodid = prodid;
        this.name = name;
        this.sellprc = sellprc;
        this.quantity = quantity;
    }

    public int getProdid() {
        return prodid;
    }

    public String getName() {
        return name;
    }

    public double getSellprc() {
        return sellprc;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
}
