package Container;

public class Heat extends Container {
    private String typeContainer = "Heat";
    private int anInt;

    public Heat(int id, int anInt) {
        super(id, anInt);
    }

    public String getType(){
        return  typeContainer;
    }
    public int getAnInt(){
        return anInt;
    }
}