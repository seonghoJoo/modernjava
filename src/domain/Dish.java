package domain;

public class Dish {
    private String name;
    private boolean vegeterian;
    private int calories;
    private DishType type;

    public Dish(String name, boolean vegeterian, int calories, DishType type) {
        this.name = name;
        this.vegeterian = vegeterian;
        this.calories = calories;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public boolean isVegeterian() {
        return vegeterian;
    }

    public int getCalories() {
        return calories;
    }

    public DishType getType() {
        return type;
    }
}
