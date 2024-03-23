package com.example;

public enum Cars {
    DODGE(940, "Charger"),
    PORSHE(600, "GT 3 RS"),
    FIAT(23, "UNO"),
    LAMBORGINNI(564, "Diablo"),
    TESLA(280, "Model S"),
    HONDA(350, "Civic"),
    FORD(400, "T"),
    SUZUKI(180, "Baleno");

    private final int horsePower;
    private final String favoriteModelString;

    Cars(int horsePower, String favoriteModelString) {
        this.horsePower = horsePower;
        this.favoriteModelString = favoriteModelString;
    }

    private int horsePower() {
        return horsePower;
    }

    private String favoriteModelString() {
        return favoriteModelString;
    }

    String race(Cars car) {
        if (horsePower() < car.horsePower) {
            return car.favoriteModelString();
        } else {
            return favoriteModelString();
        }
    }


    public static void main(String[] args) {

        for (Cars firstCar : Cars.values()) {
            for (Cars secondCar : Cars.values()) {
                if (!firstCar.equals(secondCar)){
                    System.out.println(firstCar + " is going to race against " + secondCar);
                    System.out.println("And the winner is:  " + firstCar.race(secondCar));
                }
            }
        }
    }
}
