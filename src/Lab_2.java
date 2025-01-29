public class Lab_2 {
    private double a, b;

    public Lab_2(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public boolean IfOnLine(double x, double y) {
        return y == a * x + b;
    }

    public double[] intersection(Lab_2 other) {
        if (this.a == other.a) return null;
        double x = (other.b - this.b) / (this.a - other.a);
        return new double[]{x, a * x + b};
    }

    public static void   lab_2() {
        Lab_2 line1 = new Lab_2(2, 3);
        Lab_2 line2 = new Lab_2(-1, 5);
        double x = 1, y = 5;
        System.out.println("Точка (" + x + ", " + y + ") " + (line1.IfOnLine(x, y) ? "належить" : "не належить") + " прямій 1");
        System.out.println("Точка (" + x + ", " + y + ") " + (line2.IfOnLine(x, y) ? "належить" : "не належить") + " прямій 2");

        double[] intersection = line1.intersection(line2);
        if (intersection != null) {
            System.out.println("Перетин: (" + intersection[0] + ", " + intersection[1] + ")");
        } else {
            System.out.println("Прямі паралельні");
        }

    }
}
