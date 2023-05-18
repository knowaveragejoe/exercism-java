import java.util.List;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(ProductionRemoteControlCar prc1,
                                                                 ProductionRemoteControlCar prc2) {
        return prc1.compareTo(prc2) > 0 ? List.of(prc1, prc2) : List.of(prc2, prc1);
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> unsortedCars) {
        unsortedCars.sort(ProductionRemoteControlCar::compareTo);

        return unsortedCars;
    }
}