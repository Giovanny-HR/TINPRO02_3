/*
Code will not run until all the containers have been added to the list
 */

package Containership;

import Container.Container;

import java.util.ArrayList;

public class Containership{
    private int maxContainer;
    private ArrayList<Container> storage;

    public Containership(int maxContainer){
        this.maxContainer = maxContainer;
        this.storage = new ArrayList<>(); // creates an empty ArrayList
    }

    //No try wait here because it's initialized before the threads run
    public void addContainer(Container container){
        storage.add(container);//Add a container to the ArrayList storage
        System.out.println("Ship: added " + container.getType() + " container " + container.getId());
    }

    // Remove container from Ship(Containership)
    public synchronized Container removeContainer(){
        // If there are no containers on the ship, then it will wait until one is added and then remove that one.
        Container container;
        //If ship is empty wait
        while(this.storage.size() == 0){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("Interrupted Exception with getContainer method");
            }
        }
        //If ship has containers notify the trucks
        notifyAll();

        container = this.storage.remove(0);
        //Check container's number and then calling its function
        if(container.getAnInt() == 2){// Checks to see if there are any containers connected to the ship's heating system
            System.out.println("Container " + container.getId() + ": disconnecting from heating system for transfer");
        }
        else if( container.getAnInt() == 3){// Checks to see if there are any containers connected to the ship's cooling system
            System.out.println("Container " + container.getId() + ": disconnecting from cooling system for transfer");
        }
        else if(container.getAnInt() == 1){// if none of these conditions are true, then nothing happens and continues its way
            System.out.println("Container " + container.getId() + ": standard container for transfer");
        }
        System.out.println("Ship: Container " + container.getId() + " is available for pickup");
        return container;
    }

    //Print all container object that are left in the ship
    public void printContainerList(){
        for(Container container : storage){
            System.out.println(container);
        }
    }
    //Return the storage size
    public int amountLeft() {
        return this.storage.size();
    }
    //return the maxContainer value
    public int getMaxContainer(){
        return maxContainer;
    }

}