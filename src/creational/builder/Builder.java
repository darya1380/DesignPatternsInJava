package creational.builder;

public class Builder
{
    public static void main(String[] args) {
        House house = new House.HouseBuilder().setBuyer("MR jones").setMaterial("wood").setName("beautiful home").build();


    }
}
class House
{
    private String material;
    private String name;
    private String buyer;
    private House(HouseBuilder houseBuilder)
    {
        this.material = houseBuilder.getMaterial();
        this.name = houseBuilder.getName();
        this.buyer = houseBuilder.getBuyer();
    }
    public static class HouseBuilder
    {
        private String name;
        private String material;

        public String getName() {
            return name;
        }

        public String getMaterial() {
            return material;
        }

        public String getBuyer() {
            return buyer;
        }

        private String buyer;

        public HouseBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public HouseBuilder setMaterial(String material) {
            this.material = material;
            return this;
        }

        public HouseBuilder setBuyer(String buyer) {
            this.buyer = buyer;
            return this;
        }
        public House build()
        {
            return new House(this);
        }
    }
}

