import java.text.DecimalFormat;

class Complex2 {
    private double real; // Parte real do número complexo
    private double imag; // Parte imaxinaria do número complexo

    // Constructor para inicializar un número complexo
    public Complex2(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // Métodos para obter partes do número complexo
    public double getReal() { return real; }

    public double getImag() { return imag; }

    // Método para converter o número complexo a cadena
    @Override
    public String toString() { 
        return formatComplex(real, imag); 
    }

    // Métodos para sumar e restar números complexos
    public Complex2 add(Complex2 other) {
        return new Complex2(this.real + other.real, this.imag + other.imag);
    }

    public Complex2 subtract(Complex2 other) {
        return new Complex2(this.real - other.real, this.imag - other.imag);
    }

    // Método para formatar a saída dos números complexos
    private String formatComplex(double real, double imag) {
        DecimalFormat df = new DecimalFormat("#.##"); // Formato para 2 decimais
        String realPart = df.format(real); // Formateo da parte real
        String imagPart = df.format(Math.abs(imag)); // Tomar o valor absoluto da parte imaxinaria
        return (imag >= 0) ? (realPart + " + " + imagPart + "i") : (realPart + " - " + imagPart + "i"); // Devolve a representación en formato adecuado
    }
}