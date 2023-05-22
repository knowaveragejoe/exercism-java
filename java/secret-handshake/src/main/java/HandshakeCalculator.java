import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> signals = new ArrayList<Signal>();

        if (number <= 0) {
            return signals;
        }

        // Convert number to binary
        String binary = Integer.toBinaryString(number);

        // Grab up to the last 5 digits, depending on length
        if (binary.length() > 5) {
            binary = binary.substring(binary.length() - 5);
        }
        
        // Reverse binary
        String reverseBinary = new StringBuilder(binary).reverse().toString();

        // Iterate through binary and add signals
        for (int i = 0; i < reverseBinary.length(); i++) {
            if (reverseBinary.charAt(i) == '1') {
                switch (i) {
                    case 0:
                        signals.add(Signal.WINK);
                        break;
                    case 1:
                        signals.add(Signal.DOUBLE_BLINK);
                        break;
                    case 2:
                        signals.add(Signal.CLOSE_YOUR_EYES);
                        break;
                    case 3:
                        signals.add(Signal.JUMP);
                        break;
                    case 4:
                        Collections.reverse(signals);
                        break;
                }
            }
        }

        return signals;
    }
}