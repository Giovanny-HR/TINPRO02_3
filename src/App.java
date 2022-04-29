


import Container.*;
import Containership.Containership;
import Crane.Crane;
import Dock.Dock;
import Truck.Truck;

import java.util.Random;

public class App{
    public static void main(String[] args){
        //Random generate container for different container types
        Random rand = new Random();
        int type;

        //Make ship and load it with containers of random type
        Containership ship = new Containership(10);
        for(int i = 0 ; i < ship.getMaxContainer(); i++){
            type = rand.nextInt(3) + 1; // + 1 Because it begins with 0
            ship.addContainer(new Container(i, type));
        }
        Dock dock = new Dock(5);

        Crane crane1 = new Crane("Crane 1" , ship, dock);
        Crane crane2 = new Crane("Crane 2" , ship, dock);

        Truck truck1 = new Truck("Truck 1", ship, dock);
        Truck truck2 = new Truck("Truck 2", ship, dock);
        Truck truck3 = new Truck("Truck 3", ship, dock);

        crane1.start();
//        crane2.start();

        truck1.start();
//        truck2.start();
//        truck3.start();

//        truck1.printTruck();


    }
}