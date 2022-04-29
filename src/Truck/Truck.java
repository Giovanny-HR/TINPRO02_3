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
    Heat heat;
    Cool cool;

    public Truck(String name, Containership ship, Dock dock){
        this.name = name;
        this.ship = ship;
        this.dock = dock;
    }

    public void run(){
        //As long as there are containers left keep on shipping
        while((ship.amountLeft() > 0) || (dock.amoutLeft() > 0)){ // While ship > 0 OR dock amount containers left > 0 do this...
            System.out.println(this.name +  ": is waiting on a container");

            //take container from dock
            container = dock.removeContainer();
            if(container.getType() == "Heat"){
                System.out.println(this.name + "received container " + container.getId() + " and is attaching heated system"); //this.name + "received container " + container.getId() + " and is attaching heated system"
            }
            else if(container.getType() == "Cool"){
                System.out.println(this.name + "received container " + container.getId() + " and is attaching heated system");
            }
            else if (container.getType() == "Standard") {
                System.out.println(this.name + "received container " + container.getId() + " and is attaching heated system");//"Container: " + container.getId() + " is attached on " + this.name
            }
            //Simmulated shipping delay with 3-7 seconds
//            int delay = rand.nextInt(4000) + 3500;
            int delay = rand.nextInt(6000) + 1000;
            try{
                Thread.sleep(delay);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            //transfer container to docks
            System.out.println(this.name + ": transferring container " + container.getId() + "completed");
        }
        dock.printContainerList();
    }

    public void printTruck(){

        if(Objects.equals(container.getType(), "Standard")) {
            System.out.println(this.name + ": Test print");
        }
        else{
            System.out.println("Not Found");
        }
    }
}
