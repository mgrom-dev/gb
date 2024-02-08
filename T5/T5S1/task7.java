public class task7 {
    public static void main(String[] args) {
        int a1 = 1, b1 = 7, c1 = 1, d1 = 3;
        int a2 = 11, b2 = 7, c2 = 2, d2 = 1;
        generate(a1, b1, c1, d1, "");
        generate(a2, b2, c2, d2, "");
        System.out.println("Набор команд для a1 -> b1: " + transformNumber(a1, b1, c1, d1));
        System.out.println("Набор команд для a2 -> b2: " + transformNumber(a2, b2, c2, d2));
    }

    public static void generate(int source, int target, int c, int d, String path) {
        if (source > target)
            return;
        if (source == target) {
            System.out.println(path);
            return;
        }
        generate(source + c, target, c, d, path + "k1");
        generate(source * d, target, c, d, path + "k2");
    }

    public static String transformNumber(int a, int b, int c, int d) {
        if (a > b) {
            return "";
        }

        StringBuilder commands = new StringBuilder();
        while (a != b) {
            if (a < b && c != 0 && (b - a) % c == 0) {
                int times = (b - a) / c;
                for (int i = 0; i < times; i++) {
                    commands.append("к1, ");
                }
                a = b;
            } else if (a < b && c == 0) {
                return "";
            } else {
                a += d;
                commands.append("к2, ");
            }
        }
        return commands.toString().replaceAll(", $", "");
    }
}
