class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    protected int distanceDriven = 0;
    protected int victories = 0;

    public void drive() {
        this.distanceDriven += 10;
    }

    public int getDistanceTravelled() {
        return distanceDriven;
    }

    public void setNumberOfVictories(int victories) {
        this.victories = victories;
    }

    public int getNumberOfVictories() {
        return this.victories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar otherCar) {
        if (this.getNumberOfVictories() == otherCar.getNumberOfVictories()) {
            return 0;
        } else {
            return this.getNumberOfVictories() < otherCar.getNumberOfVictories() ? 1 : -1;
        }
    }
}