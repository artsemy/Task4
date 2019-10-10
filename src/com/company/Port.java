package com.company;

public class Port {

    private int numberOfDock;
    private int capacity;
    private int current;

    //constructor
    public Port() {
        numberOfDock = 3;
        capacity = 2000;
        current = 1000;
    }

    //check for free dock
    public synchronized boolean hasFreeDock(){
        return numberOfDock > 0;
    }

    //ship occupy dock 'close'
    public synchronized void closeDock(Ship ship){
        numberOfDock--;
        System.out.println("closed dock by " + ship.toString());
    }

    //ship set free dock 'open'
    public synchronized void openDock(Ship ship){
        numberOfDock++;
        System.out.println("opened dock by " + ship.toString());
    }

    //ship according to type get or give containers
    public synchronized void addStuff(int s, Ship ship){
        System.out.println("-------------");
        current += s;
        System.out.println(this.toString());
        System.out.println(ship.toString());
        System.out.println("-------------");
    }

    //to string
    @Override
    public String toString() {
        return "Port " +
                "free docks=" + numberOfDock +
                ", cap=" + current + "/" + capacity;
    }

}
