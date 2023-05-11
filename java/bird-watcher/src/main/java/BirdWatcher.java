import java.util.Arrays;

class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return Arrays.copyOfRange(this.birdsPerDay, this.birdsPerDay.length - 7, this.birdsPerDay.length);
    }

    public int getToday() {
        return this.birdsPerDay[this.birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        this.birdsPerDay[this.birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int birds : this.birdsPerDay) {
            if (birds == 0) {
                return true;
            }
        }

        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int total = 0;

        if (numberOfDays > this.birdsPerDay.length) {
            numberOfDays = this.birdsPerDay.length;
        }

        for (int i = 0; i < numberOfDays; i++) {
            total += this.birdsPerDay[i];
        }

        return total;
    }

    public int getBusyDays() {
        int totalBusyDays = 0;
        for (int birds: this.birdsPerDay) {
            if (birds >= 5) {
                totalBusyDays++;
            }
        }

        return totalBusyDays;
    }
}
