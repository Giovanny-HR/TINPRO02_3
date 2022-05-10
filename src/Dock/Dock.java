/*
If there are no containers, then it will wait for a container to be placed on the dock and notify all when it has been removed.
Code starts by checking if the dock is empty, if it is not then wait() will be called until it is.
If an interrupted exception occurs with method getContainer(), then InterruptedException e will be called and the program will print its value
 */

package Dock;
import Container.Container;

import java.util.ArrayList;

public class Dock {
    private ArrayList<Container> storage = new ArrayList<>();
    private int maxContainer;

    public Dock(int maxContainer){
        this.maxContainer = maxContainer;
    }

    public synchronized void addContainer(Container container) {

        while (this.storage.size() == this.maxContainer){ //  Check for Max Capacity
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("Interrupted Exception occurred with method addContainer");
            }
        }
        storage.add(container);
        notifyAll(); // Notify All tasks

        System.out.println("Dock: received container " + container.getId());

        if(this.storage.size() == this.maxContainer) {
            System.out.println("Dock is full, waiting for the removal of a container");
        }
        else{
//            System.out.println("Dock: " + amountLeft() + " amount left");
            System.out.println("Dock: " + amountLeft() + " containers on dock");
        }
    }

    public synchronized Container removeContainer() {
        Container container;

        //if dock is empty wait
        while (this.storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception occurred with method getContainer");
            }
        }
        notifyAll(); //notify all objects

        //If dock has containers notify the trucks
        container = this.storage.remove(0);

        System.out.println("Dock: given container " + container.getId());
        return container;
    }

        //print all container objects that are left in the ship
        public void printContainerList() {
            for (Container container : storage) {
                System.out.println(container + "DOck  Printlist of Conainers");
            }
        }
        public int amountLeft() {
            return this.storage.size();
//            return this.maxContainer - this.storage.size();
        }
}
