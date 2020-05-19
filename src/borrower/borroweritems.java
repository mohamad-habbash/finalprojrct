/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrower;

/**
 *
 * @author Educ
 */
public class borroweritems {
    int id ;
    String fname;
    String lname;
    int mobile;
    String email;
    String address;
    String gender;

    public borroweritems() {
    }

    public borroweritems(int id, String fname, String lname, int mobile, String email, String address, String gender) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "borroweritems{" + "id=" + id + ", fname=" + fname + ", lname=" + lname + ", mobile=" + mobile + ", email=" + email + ", address=" + address + ", gender=" + gender + '}';
    }
    
}
