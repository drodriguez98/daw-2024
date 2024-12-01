import java.text.DecimalFormat;

class Complex {
    private double real; // Parte real do número complexo
    private double imag; // Parte imaxinaria do número complexo

    // Construtor para inicializar un número complexo
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // Método para obter a parte real
    public double getReal() { return real; }

    // Método para obter a parte imaxinaria
    public double getImag() { return imag; }

    // Método para converter o número complexo a cadena
    @Override
    public String toString() { 
        return formatComplex(real, imag); 
    }

    // Método para sumar dous números complexos
    public Complex add(Complex other) {
        double real = this.real + other.real; // Suma das partes reais
        double imag = this.imag + other.imag; // Suma das partes imaxinarias
        return new Complex(real, imag); // Retorna o resultado como un novo número complexo
    }

    // Método para restar dous números complexos
    public Complex subtract(Complex other) {
        double real = this.real - other.real; // Resta das partes reais
        double imag = this.imag - other.imag; // Resta das partes imaxinarias
        return new Complex(real, imag); // Retorna o resultado como un novo número complexo
    }

    // Método para multiplicar dous números complexos
    public Complex multiply(Complex other) {
        double real = this.real * other.real - this.imag * other.imag; // Parte real do produto
        double imag = this.real * other.imag + this.imag * other.real; // Parte imaxinaria do produto
        return new Complex(real, imag); // Retorna o resultado como un novo número complexo
    }

    // Método para dividir dous números complexos
    public Complex divide(Complex other) {
        double divisor = other.real * other.real + other.imag * other.imag; // Calculo do divisor
        if (divisor == 0) {
            throw new ArithmeticException("Division por cero non permitida."); // Excepción se o divisor é cero
        }
        double real = (this.real * other.real + this.imag * other.imag) / divisor; // Parte real da división
        double imag = (this.imag * other.real - this.real * other.imag) / divisor; // Parte imaxinaria da división
        return new Complex(real, imag); // Retorna o resultado como un novo número complexo
    }
    

    // Método para formatar a saída dos números complexos
    private String formatComplex(double real, double imag) {
        DecimalFormat df = new DecimalFormat("#.##"); // Formato para 2 decimais
        String realPart = df.format(real); // Formateo da parte real
        String imagPart = df.format(Math.abs(imag)); // Tomar o valor absoluto da parte imaxinaria
        return (imag >= 0) ? (realPart + " + " + imagPart + "i") : (realPart + " - " + imagPart + "i"); // Devolve a representación en formato adecuado
    }
}