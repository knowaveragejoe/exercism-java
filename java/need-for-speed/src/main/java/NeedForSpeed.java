class NeedForSpeed {
    private int speed = 0;
    private int batteryDrain = 0;
    private int distanceDriven = 0;
    private int battery = 100;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }   

    public boolean batteryDrained() {
        return this.battery <= 0;
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public void drive() {
        if (this.batteryDrained()) {
            return;
        }

        distanceDriven += speed;
        battery -= batteryDrain;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private int distance = 0;

    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {
        while (!car.batteryDrained()) {
            car.drive();
        }

        if (car.distanceDriven() >= distance) {
            return true;
        }

        return false;
    }
}
