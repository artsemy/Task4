package com.company;

public class Port {

    private int numberOfDock;
    private int capacity;
    private int current;

    public Port() {
        numberOfDock = 3;
        capacity = 2000;
        current = 1000;
    }

    public synchronized boolean hasFreeDock(){
        return numberOfDock > 0;
    }

    public synchronized void closeDock(Ship ship){
        numberOfDock--;
        System.out.println("closed dock by " + ship.toString());
    }

    public synchronized void openDock(Ship ship){
        numberOfDock++;
        System.out.println("opened dock by " + ship.toString());
    }

    public synchronized void addStuff(int s, Ship ship){
        System.out.println("-------------");
        current += s;
        System.out.println(this.toString());
        System.out.println(ship.toString());
        System.out.println("-------------");
    }

    @Override
    public String toString() {
        return "Port " +
                "free docks=" + numberOfDock +
                ", cap=" + current + "/" + capacity;
    }

}
