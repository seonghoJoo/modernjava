package chapter04;

import domain.Dish;
import domain.DishType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Dish> dishes = Arrays.asList(
                new Dish("pork", false, 800, DishType.MEAT),
                new Dish("beef", false, 700, DishType.MEAT),
                new Dish("chicken", false, 400, DishType.MEAT),
                new Dish("french frices", true, 530, DishType.OTHER),
                new Dish("rice", true, 350, DishType.OTHER),
                new Dish("season fruits", true, 120, DishType.OTHER),
                new Dish("pizza", true, 550, DishType.OTHER),
                new Dish("prawns", false, 300, DishType.FISH),
                new Dish("salmon", false, 450, DishType.FISH)
        );
        List<Dish> takeWhileDishes = dishes.stream()
                .takeWhile(dish -> dish.getCalories()>320)
                .collect(Collectors.toList());
        System.out.println("===============");
        for (Dish d: takeWhileDishes) {
            System.out.println(d.getName()+ " : " + d.getCalories());
        }
        System.out.println("===============");
        List<Dish> dropWhileDishes = dishes.stream()
                .dropWhile(dish -> dish.getCalories()>320)
                .collect(Collectors.toList());
        for (Dish d: dropWhileDishes) {
            System.out.println(d.getName()+ " : " + d.getCalories());
        }

        System.out.println("===============");
        List<Dish> skipWhileDishes = dishes.stream()
                .filter(dish -> dish.getCalories()>320)
                .skip(2)
                .collect(Collectors.toList());
        for (Dish d: skipWhileDishes) {
            System.out.println(d.getName()+ " : " + d.getCalories());
        }

    }
}
