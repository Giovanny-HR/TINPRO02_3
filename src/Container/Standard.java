package Container;

public class Standard extends Container{

    private String typeContainer = "Standard";
    private int anInt;

    public Standard(int id, int something) {
        super(id, something);
    }
    public String getType(){
        return  typeContainer;
    }
}
