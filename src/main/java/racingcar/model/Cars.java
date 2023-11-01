package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carsList;

    public Cars(List<Car> carsList) {
        this.carsList = (carsList);
    }

    public int size() {
        return carsList.size();
    }

    public Car getCarInIndex(int index) {
        return carsList.get(index);
    }

    public List<String> getWinnerNameList() {
        List<String> result = new ArrayList<>();
        for (Car car : carsList) {
            if (car.getMove() == getMaxMoveInCars()) {
                result.add(car.getName());
            }
        }
        return result;
    }

    private int getMaxMoveInCars() {
        int maxMove = 0;
        for (Car car : carsList) {
            maxMove = Integer.max(maxMove, car.getMove());
        }
        return maxMove;
    }

    @Override
    public String toString() {
        return carsList.stream().map(Car::toString)
                .collect(Collectors.joining("\n","","\n"));
    }
}