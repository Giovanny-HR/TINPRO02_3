package Container;

public class Container {
    private int id;
    private String typeContainer = "Standard";
    private int anInt;

    public Container(int id, int anInt){
        this.id = id;
        this.anInt = anInt;
    }

    public int getId(){
        return id;
    }
    public int getAnInt(){
        return anInt;
    }
    public String getType(){
        return typeContainer;
    }
}
