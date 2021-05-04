package structural.adapter;

public class Adapter
{
    public static void main(String[] args) {
        TVAdapter tvAdapter = new TVAdapterImpl();

    }
}
class Volt
{
    int val;

    public Volt(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
class TV
{
    public Volt getVolt()
    {
        return new Volt(120);
    }
}
interface TVAdapter
{
    Volt get120V();
    Volt get220V();
}
class TVAdapterImpl extends TV implements TVAdapter
{

    @Override
    public Volt get120V() {
        return convert(getVolt(), 10);
    }

    @Override
    public Volt get220V() {
        return convert(getVolt(), 5);
    }

    private Volt convert(Volt volt, int i)
    {
        return new Volt(volt.getVal() / i);
    }
}