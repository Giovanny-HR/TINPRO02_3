/*
 Instance of Container stores information about what type of container truck is carrying
 dock - A Dock variable that will be used to store the dock where this truck is currently docked.
 ship - A Containership variable that will be used to store the ship that is currently being shipped.

 */
package Truck;

import Container.*;
import Containership.Containership;
import Dock.Dock;

import java.util.Objects;
import java.util.Random;

public class Truck extends Thread{
    Random rand = new Random();
    private String name;
    Containership ship;
    Container container;
    Dock dock;

    public Truck(String name, Containership ship, Dock dock){
        //To store information
        this.name = name;
        this.ship = ship;
        this.dock = dock;
    }

    public void run(){
        //As long as there are containers left keep on shipping
        while(ship.amountLeft() > 0 ||  dock.amountLeft() > 0 ){ // While ship > 0 OR dock amount containers left > 0 do this...
            System.out.println(this.name +  ": is waiting on a container");

            //Take container from dock
            //Removes one of the 3 possible containers from dock and assigns it to variable container
            container = dock.removeContainer();
            //Take container from dock if the container has an integer value of ....
            if(container.getAnInt() == 2){
                System.out.println(this.name + " received container " + container.getId() + " and is attaching heated system"); //this.name + "received container " + container.getId() + " and is attaching heated system"
            }
            else if(container.getAnInt() == 3){
                System.out.println(this.name + " received container " + container.getId() + " and is attaching heated system");
            }
            else if (container.getAnInt() == 1) {
                System.out.println(this.name + " received container " + container.getId() + " and is transferring");//"Container: " + container.getId() + " is attached on " + this.name
            }
            else{
                System.out.println("No Container Found"); //Test
            }
            //Simulated shipping delay with 3-7 seconds
//            int delay = rand.nextInt(4000) + 3500;
            int delay = rand.nextInt(6000) + 1000;
            try{
                Thread.sleep(delay);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            //transfer container to docks
            System.out.println(this.name + ": transfer of  container " + container.getId() + " completed!");
            System.out.println(this.name + ": is waiting on a container");

            if(ship.amountLeft() == 0 && dock.amountLeft() == 0){
                break;
            }
            else{
                continue;
            }
        }
        dock.printContainerList();
    }

    public void printTruck(){// Test

        if(Objects.equals(container.getType(), "Standard")) {
            System.out.println(this.name + ": Test print");
        }
        else{
            System.out.println("Not Found");
        }
    }
}
