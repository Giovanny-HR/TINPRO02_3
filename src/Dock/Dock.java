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
//        System.out.println("Test-1 Adding Container");// Test

        while (this.storage.size() == this.maxContainer){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("Interrupted Exception occurred with method addContainer");
            }
        }
        storage.add(container);
//        System.out.println("Test-2 Adding Container");// Test
//        System.out.println(this.storage.size());// Test
        notifyAll();

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
//        System.out.println("Test-1 remove Container"); // Test
//        System.out.println("Dock: amount container left " + amountLeft());// Test

        //if dock is empty wait
        while (this.storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception occurred with method getContainer");
            }
        }
//        System.out.println("Test-2 remove Container"); // Test
        notifyAll();

        //If dock has containers notify the trucks
        container = this.storage.remove(0);
//        notifyAll();

//        System.out.println("Test-3 Notified Truck"); // Test

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
