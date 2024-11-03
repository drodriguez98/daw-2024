package programacion.ud3.Exercicios.prog03_exercicio1;

public class Fecha {

    // Definición del tipo enumerado para los meses
    public enum enumMes {
        ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO,
        JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE
    }

    // Atributos de la clase
    private int dia;
    private enumMes mes;
    private int anio;

    // Primer constructor: inicializa el mes y los demás atributos a 0
    public Fecha(enumMes mes) {
        this.dia = 0;
        this.mes = mes;
        this.anio = 0;
    }

    // Segundo constructor: inicializa todos los atributos
    public Fecha(int dia, enumMes mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // Métodos get y set para el atributo 'dia'
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    // Métodos get y set para el atributo 'mes'
    public enumMes getMes() {
        return mes;
    }

    public void setMes(enumMes mes) {
        this.mes = mes;
    }

    // Métodos get y set para el atributo 'anio'
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    // Método que indica si la fecha está en verano
    public boolean isSummer() {
        return (mes == enumMes.JUNIO || mes == enumMes.JULIO || mes == enumMes.AGOSTO);
    }

    // Método toString que devuelve la fecha en formato largo
    public String toString() {
        return dia + " de " + mes.toString().toLowerCase() + " del " + anio;
    }
}
