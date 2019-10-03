package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Port port = new Port();
        Ship[] ships = new Ship[10];
        Random r = new Random();
        for (int i = 0; i < ships.length; i++) {
            int k = (r.nextInt(4) + 4) * 50;
            int t = k - (r.nextInt(3) + 1) * 50;
            int p = i%2 == 0 ? 1 : -1;
            ships[i] = new Ship(p, i, k, t, port);
        }
        for (Ship ship : ships) {
            ship.start();
        }
        while (Thread.activeCount() != 2){}
        System.out.println("end: " + port.toString());
    }
}
