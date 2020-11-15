/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author mubayed
 */
public class Persona {
// DAO DATA OBJECT

    private int CustomerID;
    private String StoreID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Addressid;

    public Persona() {
    }

    public Persona(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Persona(String StoreID, String FirstName, String LastName, String Email, String Addressid) {
        this.StoreID = StoreID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Addressid = Addressid;
    }


    public Persona(int CustomerID, String StoreID, String FirstName, String LastName, String Email, String Addressid) {
        this.CustomerID = CustomerID;
        this.StoreID = StoreID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Addressid = Addressid;
    }

    public String getAddressid() {
        return Addressid;
    }

    public void setAddressid(String Addressid) {
        this.Addressid = Addressid;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getStoreID() {
        return StoreID;
    }

    public void setStoreID(String StoreID) {
        this.StoreID = StoreID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Persona{" + "CustomerID= " + CustomerID + ", StoreID= " + StoreID + ", FirstName= " + FirstName + ", LastName= " + LastName + ", Email= " + Email + ", Addressid= " + Addressid + '}';
    }

}
