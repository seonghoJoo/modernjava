package chapter02;

import java.util.function.Predicate;

public class AppleHeavyWeightPredicate implements ApplePredicate, Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 100;
    }
}
