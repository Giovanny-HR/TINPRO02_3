package Container;

public class Standard extends Container{

    private String typeContainer = "Standard";
    private int anInt;

    public Standard(int id, int anInt) {
        super(id, anInt);
    }
    public String getType(){
        return  typeContainer;
    }

    public int getAnInt(){
        return anInt;
    }
}
