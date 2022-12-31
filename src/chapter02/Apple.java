package chapter02;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Apple {

    int weight;

    Color color;
    public Apple() {
    }

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> p){
        return apples.stream()
                .filter(apple->p.test(apple))
                .collect(Collectors.toList());
    }


    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }
}
