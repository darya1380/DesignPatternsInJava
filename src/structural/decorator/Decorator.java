package structural.decorator;

public class Decorator
{
    public static void main(String[] args) {
        Garden g = new MagicGarden(new SpecialGarden(new UsualGarden()));
        g.design();
    }
}
interface Garden
{
    void design();
}
class UsualGarden implements Garden
{

    @Override
    public void design() {
        System.out.println("Usual Garden");
    }
}
class GardenDecorator implements Garden
{
    private Garden garden;
    public GardenDecorator(Garden garden)
    {
        this.garden = garden;
    }
    @Override
    public void design() {
        garden.design();
    }
}

class SpecialGarden extends GardenDecorator
{

    public SpecialGarden(Garden garden) {
        super(garden);
    }

    @Override
    public void design() {
        super.design();
        System.out.println("adding special garden options ");
    }
}
class MagicGarden extends GardenDecorator
{

    public MagicGarden(Garden garden) {
        super(garden);
        System.out.println("Adding some magic tools");
    }
}