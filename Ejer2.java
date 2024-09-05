public class Ejer2 {
    // f(x) = ln(x)
    public static double f(double x) {
        return Math.log(x);
    }

    // f'(x) = 1/x
    public static double f1(double x) {
        return 1 / x;
    }

    // f''(x) = -1/x^2
    public static double f2(double x) {
        return -1 / Math.pow(x, 2);
    }

    // f'''(x) = 2/x^3
    public static double f3(double x) {
        return 2 / Math.pow(x, 3);
    }

    // f''''(x) = -6/x^4
    public static double f4(double x) {
        return -6 / Math.pow(x, 4);
    }

    public static int fact(int n) {
        return (n == 0) ? 1 : n * fact(n - 1);
    }

    public static double aprox(double x0, double x, int ord) {
        double h = x - x0, res = f(x0);
        if (ord >= 1) res += f1(x0) * h;
        if (ord >= 2) res += (f2(x0) * Math.pow(h, 2)) / fact(2);
        if (ord >= 3) res += (f3(x0) * Math.pow(h, 3)) / fact(3);
        if (ord >= 4) res += (f4(x0) * Math.pow(h, 4)) / fact(4);
        return Math.round(res * 1e5) / 1e5;
    }

    public static double err(double vReal, double vAprox) {
        return Math.round((vReal - vAprox) * 1e5) / 1e5;
    }

    public static void main(String[] args) {
        double x0 = 1, x1 = 2.5;
        double vReal = Math.round(f(x1) * 1e5) / 1e5;
        double vAprox0 = aprox(x0, x1, 0), vAprox1 = aprox(x0, x1, 1);
        double vAprox2 = aprox(x0, x1, 2), vAprox3 = aprox(x0, x1, 3);
        double vAprox4 = aprox(x0, x1, 4);

        System.out.println("vReal: " + vReal);
        System.out.println("Aprox 0º: " + vAprox0 + " | Err: " + err(vReal, vAprox0));
        System.out.println("Aprox 1º: " + vAprox1 + " | Err: " + err(vReal, vAprox1));
        System.out.println("Aprox 2º: " + vAprox2 + " | Err: " + err(vReal, vAprox2));
        System.out.println("Aprox 3º: " + vAprox3 + " | Err: " + err(vReal, vAprox3));
        System.out.println("Aprox 4º: " + vAprox4 + " | Err: " + err(vReal, vAprox4));
    }
}
