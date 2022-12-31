package chapter06;

import domain.Dish;
import domain.DishType;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Collect {
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
        IntSummaryStatistics menuStatistics = menus.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics.toString());

        int totalCalories = menus.stream().collect(reducing(
                // 초기값
                0,
                // 합계함수
                Dish::getCalories,
                // 변환함수수
                (i,j) -> i+j)
        );
        System.out.println(totalCalories);

        Optional<Dish> mostCaloriDishes = menus.stream()
                .collect(reducing( (d1,d2) -> d1.getCalories() > d2.getCalories() ? d1:d2));
        System.out.println(mostCaloriDishes.get().getName());


        Map<DishType, List<Dish>> dishesByTypes = menus.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByTypes.toString());
    }
}
