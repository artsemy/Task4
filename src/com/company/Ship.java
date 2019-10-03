package com.company;

public class Ship extends Thread {

    private int purpose;
    private int ids;
    private int capacity;
    private int current;
    private Port port;

    public Ship(int purpose, int ids, int capacity, int current, Port port) {
        this.purpose = purpose;
        this.ids = ids;
        this.capacity = capacity;
        this.current = current;
        this.port = port;
    }

    @Override
    public String toString() {
        return "id=" + ids +
                ", cap=" + current + "/" + capacity + ", val=" + purpose;
    }

    @Override
    public void run() {
        try {
            work(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void work(int size) throws InterruptedException {
        while (!port.hasFreeDock()){
            System.out.println("-- can't open dock id=" + ids);
            sleep(1);
        }
        port.closeDock(this);
        sleep(1);
        if (purpose > 0){
            while (current != capacity){
                current += size;
                port.addStuff(size * (-1), this);
                sleep(1);
            }
        } else {
            while (current != 0){
                current -= size;
                port.addStuff(size, this);
                sleep(1);
            }
        }
        port.openDock(this);
        sleep(1);
    }
}
