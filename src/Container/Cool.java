package Container;

public class Cool extends Container {

    private String typeContainer = "Cool";
    private int anInt;

    public Cool(int id, int anInt) {
        super(id, anInt);
    }

    public String getType(){
        return  typeContainer;
    }

    public int getAnInt(){
        return anInt;
    }
}