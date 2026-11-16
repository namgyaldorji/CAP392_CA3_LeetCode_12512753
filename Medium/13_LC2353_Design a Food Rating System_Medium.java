import java.util.*;

class FoodRatings {

    HashMap<String, Integer> rating = new HashMap<>();
    HashMap<String, String> cuisine = new HashMap<>();
    HashMap<String, TreeSet<String>> map = new HashMap<>();

    FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        for (int i = 0; i < foods.length; i++) {

            rating.put(foods[i], ratings[i]);
            cuisine.put(foods[i], cuisines[i]);

            map.putIfAbsent(cuisines[i], new TreeSet<>((a, b) -> {
                if (rating.get(a).equals(rating.get(b))) {
                    return a.compareTo(b);
                }
                return rating.get(b) - rating.get(a);
            }));

            map.get(cuisines[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {

        String c = cuisine.get(food);

        map.get(c).remove(food);

        rating.put(food, newRating);

        map.get(c).add(food);
    }

    public String highestRated(String cuisine) {

        return map.get(cuisine).first();
    }
}
