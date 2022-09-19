package core.lesson3;

public class Fruit {
    private double weight;
    private String fruitName;

    public Fruit(String fruitName, double weight) {
        this.fruitName=fruitName;
        this.weight=weight;
    }

    public double getWeight() {
        return weight;
    }
}
