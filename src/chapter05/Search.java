package chapter05;

import domain.Dish;
import domain.DishType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Search {
    public static void main(String[] args) {
        List<Dish> menus = Arrays.asList(
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

        /**
         *  anyMatch 적어도 한 요소와 일치
         * */
        boolean isVeget = menus.stream().anyMatch(Dish::isVegeterian);
        System.out.println("isVeget : "+ isVeget);

        /**
         *  allMatch 모든 요소와 일치
         * */
        boolean isHealthy = menus.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("isHealthy : "+ isHealthy);
        /**
         *  NoneMatch allMatch와 반대
         * */
        boolean Healthy = menus.stream().noneMatch(dish -> dish.getCalories() < 1000);
        System.out.println("Healthy : "+ Healthy);
        /**
         *  findAny
         * */
        Optional<Dish> dishOptional1 = menus.stream()
                .filter(Dish::isVegeterian)
                .findAny();
        System.out.println("dishOptional1 : " + dishOptional1.get().getName() );

        //오류
//                .ifPresent(dish-> System.out.println(dish.getName()));

        /**
         *  findFirst
         * */
        Optional<Dish> dishOptional2 = menus.stream()
                .filter(Dish::isVegeterian)
                .findFirst();
        System.out.println("dishOptional2 : " + dishOptional2.get().getName() );
    }
}
