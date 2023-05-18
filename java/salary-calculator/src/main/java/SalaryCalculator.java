public class SalaryCalculator {
    public double multiplierPerDaysSkipped(int daysSkipped) {
        if (daysSkipped > 5) {
            return 0.85;
        } else {
            return 1.0;
        }
    }

    public int multiplierPerProductsSold(int productsSold) {
        if (productsSold > 20) {
            return 13;
        } else {
            return 10;
        }
    }

    public double bonusForProductSold(int productsSold) {
        return this.multiplierPerProductsSold(productsSold) * productsSold;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double finalTotal = (1000 * this.multiplierPerDaysSkipped(daysSkipped)) + this.bonusForProductSold(productsSold);
        if (finalTotal >= 2000) {
            return 2000; 
        }

        return finalTotal;
    } 
}
