import java.lang.Character;

class SqueakyClean {
    static String clean(String identifier) {
        // Replace all spaces with underscores
        String clean = identifier.replace(" " , "_");

        // Split based on hyphen
        String[] words = clean.split("-");

        // Capitalize first letter of each word except for the first word
        for (int i = 0; i < words.length; i++) {
            // Capitalize first letter of each word after the first
            if (i != 0) {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            }
        }

        StringBuilder joined = new StringBuilder(String.join("", words));
        StringBuilder cleaned = new StringBuilder("");

        for (int i = 0; i < joined.length(); i++) {
            char c = joined.charAt(i);

            if (Character.isLetter(c)) {
                // ignore lowercase greek letters
                if (c >= 'α' && c <= 'ω') {
                    continue;
                }
                cleaned.append(c);
            } else if (c == '_') {
                cleaned.append(c);
            } else if (Character.isISOControl(c)) {
                cleaned.append("CTRL");
            }
        }

        return cleaned.toString();
    }
}
