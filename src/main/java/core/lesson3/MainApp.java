package core.lesson3;

import java.util.ArrayList;

public class MainApp {

    public static void main(String[] args) {
        ArrayList<Orange> oranges = new ArrayList<>();
        Box<Orange> orangesBox = new Box<>(oranges);
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();
        oranges.add(orange1);
        oranges.add(orange2);
        oranges.add(orange3);
        oranges.add(orange4);

        ArrayList<Orange> secondOranges = new ArrayList<>();
        Box<Orange> secondOrangesBox = new Box<>(secondOranges);
        Orange orange5 = new Orange();
        Orange orange6 = new Orange();
        secondOranges.add(orange1);
        secondOranges.add(orange2);
        secondOranges.add(orange3);
        secondOranges.add(orange4);
        secondOranges.add(orange5);
        secondOranges.add(orange6);

        ArrayList<Apple> apples = new ArrayList<>();
        Box<Apple> applesBox = new Box<>(apples);
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);

        System.out.println(orangesBox.getBoxWeight() + " — вес первой коробки с апельсинами");
        System.out.println(secondOrangesBox.getBoxWeight() + " — вес второй коробки с апельсинами");
        System.out.println(applesBox.getBoxWeight() + " — вес коробки с яблоками");
        System.out.println("Равен ли вес коробок: " + orangesBox.compare(applesBox));

        orangesBox.shiftBoxes(secondOrangesBox);

        System.out.println(orangesBox.getBoxWeight() + " — вес первой коробки с апельсинами");
        System.out.println(secondOrangesBox.getBoxWeight() + " — вес второй коробки с апельсинами");
        System.out.println(applesBox.getBoxWeight() + " — вес коробки с яблоками");
    }
}
