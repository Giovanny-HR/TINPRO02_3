/*
Create a container class that has 2 properties.
 */

package Container;

public class Container {
    private int id;
    private String typeContainer = "Standard";
    private int anInt;

    public Container(int id, int anInt){
        this.id = id;
        this.anInt = anInt;
    }

    //returns the value of the id variable.
    public int getId(){
        return id;
    }
    //returns the value of the anInt variable
    public int getAnInt(){
        return anInt;
    }
    //Returns the value of the getType variable
    public String getType(){
        return typeContainer;
    }
}
