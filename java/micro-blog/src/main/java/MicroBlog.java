class MicroBlog {
    public String truncate(String input) {
        // Convert string to unicode codepoints
        int[] codePoints = input.codePoints().toArray();

        if (codePoints.length <= 5) {
            return input;
        } else {
            return new String(codePoints, 0, 5);
        }
    }
}
