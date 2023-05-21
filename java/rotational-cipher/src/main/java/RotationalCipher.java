class RotationalCipher {
    protected int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        if (this.shiftKey == 0 || this.shiftKey == 26) {
            return data;
        }

        StringBuilder result = new StringBuilder("");
        for (char c : data.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';  // Determine base for uppercase or lowercase
                char cipheredChar = (char) ((c - base + shiftKey) % 26 + base);
                result.append(cipheredChar);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
