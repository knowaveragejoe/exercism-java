import java.lang.IllegalArgumentException;

public class Hamming {
    private String leftStrand;
    private String rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        if (rightStrand.length() != leftStrand.length() && leftStrand.length() <= 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length() && rightStrand.length() <= 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    public int getHammingDistance() {
        if (this.leftStrand.length() == 0 && this.rightStrand.length() == 0) {
            return 0;
        }

        int distance = 0;
        StringBuilder leftStrand = new StringBuilder(this.leftStrand);
        StringBuilder rightStrand = new StringBuilder(this.rightStrand);

        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }
}
