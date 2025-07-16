package com.example.StaffRecord.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String staffname;
    private String email;
    private String phone;

    public users(){

    }
    public users(int id,String staffname,String email,String phone){
        this.id=id;
        this.staffname=staffname;
        this.email=email;
        this.phone=phone;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getStaffname() { return staffname; }
    public void setStaffname(String staffname) { this.staffname = staffname; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
