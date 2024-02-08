public class task4 {
    public static void main(String[] args) {
        String[] strings1 = {"flower", "flow", "flight"};
        String[] strings2 = {"dog", "racecar", "car"};
        System.out.println("Самый длинный общий префикс: " + longestCommonPrefix(strings1));
        System.out.println("Самый длинный общий префикс: " + longestCommonPrefix(strings2));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
