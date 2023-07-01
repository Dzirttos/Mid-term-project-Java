package model;

public class Toy {
    int id;
    String name;
    int quantity;
    int chance;

    public String info() {
        return "" + this.getName() +
                "!!! под серийным номером " + this.getId() +
                ". Вероятность выпадания такой игрушки составляет всего " + this.getChance() + 
                "%!!! Всего в наличии " + this.getQuantity() +
                " шт.\u001B[0m";
    }

    public Toy() {
    }

    public Toy(int id, String name, int quantity, int chance) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.chance = chance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
}