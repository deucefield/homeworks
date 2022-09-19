package core.lesson3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> box;

    public Box(ArrayList<T> box) {
        this.box = box;
    }

    public double getBoxWeight() {
        double weight=0.;
        for(T t: box) {
            weight+=t.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<? extends Fruit> enterBox) {
        if(this.getBoxWeight() == enterBox.getBoxWeight()) return true;
        else return false;
    }

    public void shiftBoxes(Box<T> fruitBox) {
        for(T t: fruitBox.getFruits()) {
            this.getFruits().add(t);
        }
        fruitBox.getFruits().clear();

/*      ArrayList<T> intermediateBox = this.getFruits();
        ArrayList<T> intermediateBox2 = fruitBox.getFruits(); // Здесь я пытался реализовать метод замены содержимого двух коробок. Но оно не работает, подскажете почему?
        this.getFruits().clear();
        fruitBox.getFruits().clear();

        for(T t: intermediateBox2) {this.getFruits().add(t);}
        for(T t: intermediateBox) {fruitBox.getFruits().add(t);}*/

        /*
        for(T t: fruitBox.getFruits()) { // Здесь тоже самое
            this.getFruits().add(t);
        }

        fruitBox.getFruits().clear();
        for(T t: intermediateBox) {
            fruitBox.getFruits().add(t);
        }*/
    }


    public ArrayList<T> getFruits() {
        return box;
    }

}
