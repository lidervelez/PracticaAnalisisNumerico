public class Ejer3 {

    // Función para calcular el flujo Q usando la fórmula de Manning
    public static double flujo(double B, double H, double n, double S) {
        return (Math.pow(B * H, 5.0 / 3.0) * Math.sqrt(S)) / (n * Math.pow(B + 2 * H, 2.0 / 3.0));
    }

    // Derivada parcial de Q respecto a n (rugosidad)
    public static double dQdn(double B, double H, double n, double S) {
        return -flujo(B, H, n, S) / n;
    }

    // Derivada parcial de Q respecto a S (pendiente)
    public static double dQdS(double B, double H, double n, double S) {
        return (0.5 * flujo(B, H, n, S)) / S;
    }

    // Redondear a 5 decimales
    public static double redondear(double v) {
        return Math.round(v * 100000.0) / 100000.0;
    }

    // Propagación del error
    public static double error(double dQ, double delta) {
        return dQ * delta;
    }

    public static void main(String[] args) {
        // Parámetros iniciales
        double B = 20.0; // Ancho en metros
        double H = 0.3;  // Profundidad en metros
        double n = 0.03; // Rugosidad
        double S = 0.0003; // Pendiente

        // Rangos de incertidumbre
        double deltaN = 0.003; // Error en rugosidad (10% de 0.03)
        double deltaS = 0.00003; // Error en pendiente (10% de 0.0003)

        // Calcular el flujo exacto
        double Q = redondear(flujo(B, H, n, S));

        // Calcular las derivadas parciales
        double dQdn = dQdn(B, H, n, S);
        double dQdS = dQdS(B, H, n, S);

        // Calcular la propagación del error para n y S
        double eN = redondear(error(dQdn, deltaN));
        double eS = redondear(error(dQdS, deltaS));

        // Resultado de la propagación del error
        double eTotal = redondear(Math.sqrt(Math.pow(eN, 2) + Math.pow(eS, 2)));

        // Imprimir resultados
        System.out.println("Flujo exacto (Q) = " + Q + " m^3/s");
        System.out.println("Error propagado por rugosidad (n) = " + eN + " m^3/s");
        System.out.println("Error propagado por pendiente (S) = " + eS + " m^3/s");
        System.out.println("Error total propagado = " + eTotal + " m^3/s");
        System.out.println("Flujo estimado con error = " + (Q + eTotal) + " m^3/s");
    }
}
