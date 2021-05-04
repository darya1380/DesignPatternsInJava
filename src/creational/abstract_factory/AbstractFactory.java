package creational.abstract_factory;

public class AbstractFactory
{
    public static void main(String[] args) {
        AbstractCake cake = CakeFactory.getCake(new CheeseCakeFactory("cheese cake"));
        /**
         * i think it is used for when our constructors are not the same
         */
        AbstractCake cake1 = CakeFactory.getCake(new CupCakeFactory("cup cake"));
        System.out.println(cake);
        System.out.println(cake1);
    }
}
abstract class AbstractCake
{
    @Override
    public String toString() {
        return "this is a cake";
    }
}
class CupCake extends AbstractCake
{
    private String name;

    public CupCake(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  super.toString() + " "+"CupCake{" +
                "name='" + name + '\'' +
                '}';
    }
}
class CheeseCake extends AbstractCake
{
    private String name;

    public CheeseCake(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + " " +  "CheeseCake{" +
                "name='" + name + '\'' +
                '}';
    }
}
interface CakeAbstractFactory
{
    AbstractCake getCake();
}
class CheeseCakeFactory implements CakeAbstractFactory
{
    private String name;
    public CheeseCakeFactory(String name)
    {
        this.name = name;
    }
    @Override
    public AbstractCake getCake() {
        return new CheeseCake(name);
    }
}
class CupCakeFactory implements CakeAbstractFactory
{
    private String name;
    public CupCakeFactory(String name)
    {
        this.name = name;
    }

    @Override
    public AbstractCake getCake() {
        return new CupCake(name);
    }
}
class CakeFactory
{
    public static AbstractCake getCake(CakeAbstractFactory factory)
    {
        return factory.getCake();
    }
}
