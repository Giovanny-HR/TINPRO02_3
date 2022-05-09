package Containership;

import Container.Container;

import java.util.ArrayList;

public class Containership{
    private int maxContainer;
    private ArrayList<Container> storage;

    public Containership(int maxContainer){
        this.maxContainer = maxContainer;
        this.storage = new ArrayList<>();
    }

    //No try wait here because it's initialized before the threads run
    public void addContainer(Container container){
        storage.add(container);
        System.out.println("Ship: added " + container.getType() + " container " + container.getId());
    }

    public synchronized Container removeContainer(){
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
        if(container.getAnInt() == 2){
            System.out.println("Container " + container.getId() + ": disconnecting from heating system for transfer");
        }
        else if( container.getAnInt() == 3){
            System.out.println("Container " + container.getId() + ": disconnecting from cooling system for transfer");
        }
        else if(container.getAnInt() == 1){
            System.out.println("Container " + container.getId() + ": standard container for transfer");
        }
        System.out.println("Ship: Container " + container.getId() + " is available for pickup");
        return container;
    }

    //Print aal container object that are left in the ship
    public void printContainerList(){
        for(Container container : storage){
            System.out.println(container);
        }
    }
    public int amountLeft() {
        return this.storage.size();
    }
    public int getMaxContainer(){
        return maxContainer;
    }

}