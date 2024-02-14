package org.example.Entities;

public class Users {
    private int Id;
    private String name;
    private String surname;
    private boolean gender;

    public Users(int Id,String name,String surname,boolean gender){
        this.Id = Id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;

    }
    public int getId(){
        return Id;
    }
    public void setId(int Id){
        this.Id = Id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;

    }
    public boolean isGender(){
        return gender;
    }
    public void  setGender(boolean gender){
        this.gender = gender;
    }

 @Override
    public String toString(){
        return Id +": " + name + ": "+ surname + " - " + (gender ? "male" : "female");
 }

}
