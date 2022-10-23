package Java.OOPs;

class Main {
    private static final String STR = "java_.OOPs.Abstract_class.A";

    public static String stringConcatenation() {
        String s = STR;
        for (int i = 0; i < Short.MAX_VALUE; i++) {
            s = s + STR;
        }
        return s;
    }

    public static String stringBufferConcatenation() {
        StringBuilder sb = new StringBuilder(STR);
        for (int i = 0; i < Short.MAX_VALUE; i++) {
            sb.append(STR);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        stringConcatenation();
        long end = System.nanoTime();
        System.out.println("The time taken by string concatenation: " + (end - start) + "ns");

        start = System.nanoTime();
        stringBufferConcatenation();
        end = System.nanoTime();

        System.out.println("The time taken by StringBuilder concatenation: " + (end - start) + "ns");
    }
}