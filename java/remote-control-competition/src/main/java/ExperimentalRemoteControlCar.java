class ExperimentalRemoteControlCar implements RemoteControlCar {
    protected int distanceDriven = 0;

    public void drive() {
        distanceDriven += 20;
    }

    public int getDistanceTravelled() {
        return distanceDriven;
    }
}