package Java.OOPs.Composition;

public class Bed {
    private String style;
    private int height;
    private int pillows;

    public Bed(String style, int height, int pillows) {
        this.style = style;
        this.height = height;
        this.pillows = pillows;
    }

    public void make() {
        System.out.println("Bed -> Making");
    }

    public String getStyle() {
        return style;
    }

    public int getHeight() {
        return height;
    }

    public int getPillows() {
        return pillows;
    }
}
