package Ship;

public class TankerShip extends Ship {
    private int id;
    private int anInt;


    public TankerShip(int id, int anInt){
        this.id = id;
        this.anInt = anInt;
    }

    @Override
    public int getMaxContainer() {

        return 0;
    }

    @Override
    public int getMaxVolume() {
//        System.out.println("This is Test Tanker Get Max Volume");
        return anInt;
    }

}
