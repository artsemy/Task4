package com.company;

import java.util.Random;

public class Main {

    /*
    multithreading. ships and port. port has 3 docks
    ship can get and give containers. one dock one ship.
    number of containers less than ships (on dock) and port
    can contain.
     */
    public static void main(String[] args) {
        //create port
        Port port = new Port();
        //create ships
        Ship[] ships = new Ship[10];
        Random r = new Random();
        for (int i = 0; i < ships.length; i++) {
            int k = (r.nextInt(4) + 4) * 50;
            int t = k - (r.nextInt(3) + 1) * 50;
            int p = i%2 == 0 ? 1 : -1;
            //start threads
            ships[i] = new Ship(p, i, k, t, port);
            ships[i].start();
        }
        while (Thread.activeCount() != 2){}
        System.out.println("end: " + port.toString());

    }
}
