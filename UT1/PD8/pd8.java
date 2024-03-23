/*
    Para calcular la memoria total que utilizaría un objeto de la clase Marcapasos, se debe considerar el tamaño en bytes de cada variable de la clase y sumarlos.

    Aquí está el tamaño en bytes de cada tipo de dato primitivo utilizado en la clase Marcapasos:

    byte: 1 byte
    short: 2 bytes
    int: 4 bytes
    float: 4 bytes
    double: 8 bytes
    char: 2 bytes 

    Ahora, vamos a calcular el tamaño total en bytes del objeto Marcapasos:

    presionSanguinea: 1 byte
    frecuenciaCardiaca: 1 byte
    nivelAzucarSangre: 2 bytes
    maxFuerzaExposicion: 4 bytes
    minTiempoEntreLatidos: 4 bytes
    bateriaRestante: 8 bytes
    codigoFabricante: Dependiente de la longitud de la cadena, que se limita a un máximo de 8 caracteres. Suponiendo que cada carácter ocupa 2 bytes, serían 8 * 2 = 16 bytes.
    Sumando todos estos valores, obtenemos la memoria total que ocuparía un objeto de la clase Marcapasos:

    1 byte (presionSanguinea) + 
    1 byte (frecuenciaCardiaca) + 
    2 bytes (nivelAzucarSangre) + 
    4 bytes (maxFuerzaExposicion) + 
    4 bytes (minTiempoEntreLatidos) + 
    8 bytes (bateriaRestante) + 
    16 bytes (codigoFabricante) = 
    36 bytes
    Por lo tanto, un objeto de la clase Marcapasos ocuparía aproximadamente 36 bytes de memoria en total.

 */


public class Marcapasos {
    // Variables para almacenar la información
    private byte presionSanguinea; // 1 byte (rango: 0-250)
    private byte frecuenciaCardiaca; // 1 byte (rango: 0-226)
    private short nivelAzucarSangre; // 2 bytes (rango: 0-1000)
    private int maxFuerzaExposicion; // 4 bytes (rango: 0-3.000.000.000)
    private float minTiempoEntreLatidos; // 4 bytes (rango: 0-100 con decimales)
    private double bateriaRestante; // 8 bytes (rango: % de batería con decimales)
    private String codigoFabricante; // Máximo 8 caracteres (depende del tamaño del string)
    
    // Constructor
    public Marcapasos(byte presionSanguinea, byte frecuenciaCardiaca, short nivelAzucarSangre,
                      int maxFuerzaExposicion, float minTiempoEntreLatidos,
                      double bateriaRestante, String codigoFabricante) {
        this.presionSanguinea = presionSanguinea;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.nivelAzucarSangre = nivelAzucarSangre;
        this.maxFuerzaExposicion = maxFuerzaExposicion;
        this.minTiempoEntreLatidos = minTiempoEntreLatidos;
        this.bateriaRestante = bateriaRestante;
        this.codigoFabricante = codigoFabricante;
    }
}
