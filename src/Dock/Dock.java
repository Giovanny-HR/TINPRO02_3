package Dock;
import Container.Container;

import java.util.ArrayList;

public class Dock {
    private ArrayList<Container> storage = new ArrayList<>();
    private int maxContainer;

    public Dock(int maxContainerSpace){
        this.maxContainer = maxContainerSpace;
    }

    public synchronized void addContainer(Container container) {
        while (this.storage.size() == this.maxContainer){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("Intterpted Exception occured with method addContainer");
            }
        }
        notifyAll();
        System.out.println("Dock: received container " + container.getId());
//        System.out.println("Dock: amount container left " + amoutLeft());
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
        //If dock has containers notify the trucks
        container = this.storage.remove(0);
        notifyAll();
        System.out.println("Dock: given container " + container.getId());
        return container;
    }

        //print all container objects that are left in the ship
        public void printContainerList() {
            for (Container container : storage) {
                System.out.println(container);
            }
        }
        public int amoutLeft() {
            return this.storage.size();
        }
}
