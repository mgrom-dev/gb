public class task5 {
    public static void main(String[] args) {
        String phrase = "Добро пожаловать на курс по Java";
        String[] words = phrase.split(" ");
        StringBuilder reversedPhrase = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedPhrase.append(words[i]).append(" ");
        }
        System.out.println("Фраза с переставленными словами: " + reversedPhrase.toString().trim());
    }
}
