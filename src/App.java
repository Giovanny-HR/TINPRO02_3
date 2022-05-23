


import Container.*;
import Ship.*;
import Crane.Crane;
import Dock.Dock;
import Ship.TankerShip;
import Truck.Truck;


import java.util.Random;

public class App{
    public static void main(String[] args){
        //Random generate container for different container types
        Random rand = new Random();
        int type;

        //Make cShip and load it with containers of random type
        Containership cShip = new Containership(10);

        for(int i = 0 ; i < cShip.getMaxContainer(); i++){
            type = rand.nextInt(3) + 1; // Generate a random integer number between 0 & 3
            //Each time it generates a new container type, it creates another instance of Container using this values as its constructor parameter (i) and assigns it to the Ship object addContainer method call..
//            cShip.addContainer(new Container(i, type));
//            cShip.addContainer(new Standard(i, type));
            //-------------------------------------------
            if(type == 1){// Standard
                cShip.addContainer(new Standard(i,type));
            }
            else if(type == 2){ // Heat
                cShip.addContainer(new Heat(i, type));
            }
            else {// Cool
                cShip.addContainer(new Cool(i, type));
            }
            //-------------------------------------------
        }

        //Objects
        Dock dock = new Dock(5);

        Crane crane1 = new Crane("Crane 1" , cShip, dock);
        Crane crane2 = new Crane("Crane 2" , cShip, dock);

        Truck truck1 = new Truck("Truck 1", cShip, dock);
        Truck truck2 = new Truck("Truck 2", cShip, dock);
        Truck truck3 = new Truck("Truck 3", cShip, dock);

        crane1.start();
        crane2.start();

        truck1.start();
        truck2.start();
        truck3.start();


    }
}