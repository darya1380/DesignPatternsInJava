package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite
{
    public static void main(String[] args) {
        Fridge fridge = new Fridge();
        Sofa sofa = new Sofa();
        DesigningFurniture dis = new DesigningFurniture();
        dis.add(sofa);
        dis.add(fridge);
        dis.design("French Style");
    }
}
interface Furniture
{
    void design(String wayToDesign);
}
class Sofa implements Furniture
{
    @Override
    public void design(String wayToDesign) {
        System.out.println("designing sofa in " + wayToDesign + " way");
    }
}
class Fridge implements Furniture
{
    @Override
    public void design(String wayToDesign) {
        System.out.println("designing Fridge in " + wayToDesign + " way");
    }
}
class DesigningFurniture implements Furniture
{
    private List<Furniture> list = new ArrayList<>();

    @Override
    public void design(String wayToDesign) {
        for (Furniture f: list)
            f.design(wayToDesign);
    }
    public void add(Furniture furniture)
    {
        list.add(furniture);
    }
    public void remove(Furniture furniture)
    {
        list.remove(furniture);
    }
    public void clear()
    {
        System.out.println("clearing list");
        list.clear();
    }
}