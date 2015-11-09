package com.Arbin;

/**
 * Created by lt3733yt on 11/9/2015.
 */
public class Dog {
    private String name;
    private int age;
    private boolean isPuppy;

    public Dog(String name,int age,boolean isPuppy){
        this.name=name;
        this.age=age;
        this.isPuppy=isPuppy;
    }
    //the jlist will use this to create a string to display in the GUI
    public String toString(){
        if (isPuppy){
            return ("Puppy's name is"+name+", puppy's age is"+age);
        }else{
            return ("Dog's name is "+name+", dog's age is "+age);
        }
    }
}
