package Crane;

import Container.Container;
import Ship.Containership;
import Dock.Dock;

import java.util.Random;

public class Crane extends Thread {
    Random rand = new Random();
    private String name;
    Containership ship;
    Dock dock;
    Container container;

        //Constructor
    public Crane(String name, Containership ship, Dock dock){
        this.name = name;
        this.ship = ship;
        this.dock = dock;
    }
    public void run(){
        //As long as there are containers on the boat keep transferring containers.
        while(ship.amountLeft() > 0){
            System.out.println(this.name + ": is waiting on a container");

            //Take container from ship
            container = ship.removeContainer();
            System.out.println(this.name + ": received container " + container.getId() + " and is transferring to dock");

            //simulated transfer delay of 1-6 seconds
            int delay = rand.nextInt(5000) + 1000;
            try{
                Thread.sleep(delay);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //Transfer container to docks
            System.out.println(this.name + ": is ready to place container " + container.getId() + " on dock");
            dock.addContainer(container);
            System.out.println(this.name + ": has complete it's transfer of container " + container.getId());
        }
        ship.printContainerList();//Print out list of containers on board after transfer is complete
    }
}
