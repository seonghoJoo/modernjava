package chapter01;

import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<Apple> apples = List.of(new Apple(10, Color.RED), new Apple(150, Color.RED), new Apple(200, Color.GREEN));
        // TODO 걸러낼 사과를 수행한다.
        List<Apple> result = Apple.filterApples(apples, (Apple a) -> a.getWeight() > 100 && a.getColor() == Color.RED);

        Predicate<Apple> appleFilter = (Apple a) -> a.getWeight() > 110 && a.getColor() == Color.RED;
        List<Apple> result2 = Apple.filterApples(apples, appleFilter);

        for(Apple a : result2){
            System.out.println("weight: " + a.weight + " color : " + a.getColor());
        }
    }


}
