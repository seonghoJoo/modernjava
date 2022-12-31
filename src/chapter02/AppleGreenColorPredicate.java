package chapter02;

import java.util.function.Predicate;

public class AppleGreenColorPredicate implements ApplePredicate, Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals(Color.GREEN);
    }
}
