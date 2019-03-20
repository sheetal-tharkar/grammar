package com.example.priyamagar.hello;

/**
 * Created by Tharkar on 10/04/2018.
 */

public class UserInformation {
  private String name ;
   private String age ;
    private String phone;
    private String address;
    private String email;


public UserInformation(){

    }


    public UserInformation(String name, String age, String phone, String address) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}


  /*  public UserInformation(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
*/