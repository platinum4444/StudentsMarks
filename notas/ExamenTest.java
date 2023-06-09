
package notas;

// TODO: Auto-generated Javadoc
/**
 * The Class ExamenTest.
 */
public class ExamenTest {

  /**
   * PREGUNTAS_TOTALES establece el número de preguntas que tnedrá un examen tipo
   * test.
   */
  public final int PREGUNTAS_TOTALES = 50;

  /** FALLO_RESTA establece la cantidad que resta cada fallo. */
  private static final double FALLO_RESTA = 1 / 3f;

  /** NOTA_MAXIMA establece la nota máxima obtenible. */
  private final int NOTA_MAXIMA = 10;

  /** aciertos el número de aciertos. */
  private int aciertos = 0;

  /** fallos el número de fallos. */
  private int fallos = 0;

  /** noContestadas el número de preguntas sin contestar. */
  private int noContestadas = 0;

  /** nota la nota del alumno. */
  private double nota = 0;

  /**
   * Constructor que genera la puntuación del examen y genera la nota
   */
  public ExamenTest() {

    generarPuntuacion();
    calcularNota();
  }

  /**
   * Constructor que calcula la nota de los parámetros recibidos cuando se agrega
   * un alumno manualmente
   *
   * @param aciertos
   * @param fallos
   * @param preguntas no contestadas
   */
  public ExamenTest(int aciertos, int fallos, int noContestadas) {
    this.aciertos = aciertos;
    this.fallos = fallos;
    this.noContestadas = noContestadas;
    calcularNota();
  }

  /**
   * Genera aciertos aleatorios.
   */
  public void generarAciertosAleatorios() {

    aciertos = (int) (Math.random() * PREGUNTAS_TOTALES);
  }

  /**
   * Genera fallos aleatorios.
   */
  public void generarFallosAleatorios() {

    fallos = (int) (Math.random() * (PREGUNTAS_TOTALES - aciertos));
  }

  /**
   * Genera preguntas no contestadas.
   */
  public void generarPreguntasNoContestadas() {

    noContestadas = PREGUNTAS_TOTALES - (aciertos + fallos);
  }

  /**
   * Genera puntuacion.
   */
  public void generarPuntuacion() {

    generarAciertosAleatorios();
    generarFallosAleatorios();
    generarPreguntasNoContestadas();
  }

  /**
   * Calcula nota.
   */
  public void calcularNota() {
    double calcularFallos = 0, calcularAciertos = 0;

    if (aciertos + fallos + noContestadas == PREGUNTAS_TOTALES) {

      calcularFallos = fallos * FALLO_RESTA;
      calcularAciertos = aciertos - calcularFallos;
      nota = (double) aciertos * NOTA_MAXIMA / PREGUNTAS_TOTALES;

    } else {

      nota = 0;
      System.out.println("Error, problema con las preguntas totales del examen");
    }

  }

  /**
   * Gets the nota.
   *
   * @return the nota
   */
  public double getNota() {

    return nota;
  }

  /**
   * Gets the aciertos.
   *
   * @return the aciertos
   */
  public int getAciertos() {
    return aciertos;
  }

  /**
   * Gets the fallos.
   *
   * @return the fallos
   */
  public int getFallos() {
    return fallos;
  }

  /**
   * Gets the sin contestar.
   *
   * @return the sin contestar
   */
  public int getSinContestar() {
    return noContestadas;
  }

  /**
   * To string.
   *
   * @return the string
   */
  public String toString() {
    return String.valueOf(nota);
  }
}
