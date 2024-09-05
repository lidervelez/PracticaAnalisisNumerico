public class Ejer1 {
    // f(x) = 25x^3 - 6x^2 + 7x - 88
    public static double f(double x) {
        return 25 * Math.pow(x, 3) - 6 * Math.pow(x, 2) + 7 * x - 88;
    }

    // f'(x) = 75x^2 - 12x + 7
    public static double f1(double x) {
        return 75 * Math.pow(x, 2) - 12 * x + 7;
    }

    // f''(x) = 150x - 12
    public static double f2(double x) {
        return 150 * x - 12;
    }

    // f'''(x) = 150
    public static double f3(double x) {
        return 150;
    }

    public static int fact(int n) {
        return (n == 0) ? 1 : n * fact(n - 1);
    }

    public static double aprox(double x0, double x, int ord) {
        double h = x - x0, res = f(x0);
        if (ord >= 1) res += f1(x0) * h;
        if (ord >= 2) res += (f2(x0) * Math.pow(h, 2)) / fact(2);
        if (ord >= 3) res += (f3(x0) * Math.pow(h, 3)) / fact(3);
        return Math.round(res * 1e5) / 1e5;
    }

    public static double err(double vReal, double vAprox) {
        return Math.round((vReal - vAprox) * 1e5) / 1e5;
    }

    public static void main(String[] args) {
        double x0 = 1, x1 = 3;
        double vReal = Math.round(f(x1) * 1e5) / 1e5;
        double vAprox0 = aprox(x0, x1, 0), vAprox1 = aprox(x0, x1, 1);
        double vAprox2 = aprox(x0, x1, 2), vAprox3 = aprox(x0, x1, 3);

        System.out.println("vReal: " + vReal);
        System.out.println("Aprox 0º: " + vAprox0 + " | Error: " + err(vReal, vAprox0));
        System.out.println("Aprox 1º: " + vAprox1 + " | Error: " + err(vReal, vAprox1));
        System.out.println("Aprox 2º: " + vAprox2 + " | Error: " + err(vReal, vAprox2));
        System.out.println("Aprox 3º: " + vAprox3 + " | Error: " + err(vReal, vAprox3));
    }
}
