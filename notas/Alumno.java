
package notas;

/**
 * 
 * Almacenará toda la información del alumno tanto datos personales como datos
 * academicos
 *
 */
public class Alumno {

  /**
   * EXAMENES_CLASICOS Indica la cantidad m�xima de examenes de tipo cl�sico que
   * un alumno har� por curso.
   */
  public static final int EXAMENES_CLASICOS = 3;

  /**
   * EXAMENES_TESTS Indica la cantidad m�xima de examenes de tipo cl�sico que un
   * alumno har� por curso.
   */
  public static final int EXAMENES_TESTS = 2;

  /** The Constant TRABAJOS. */
  public static final int TRABAJOS = 3;

  /** The Constant PREGUNTAS_TESTS. */
  private static final int PREGUNTAS_TESTS = 50;

  /** The Constant FALLO_RESTA. */
  private static final double FALLO_RESTA = 1 / 3f;

  /**
   * notaFinal indica la nota final que ser� calculada al instanciar la clase por
   * medio del constructor.
   */
  private double notaFinal = 0;

  /** nombre indica el nombre del alumno. */
  private String nombre;

  /** apellidos indica los apellidos del alumno. */
  private String apellidos;

  /** imagen refiere a la imagen del alumno. */
  private String imagen;

  /** edad refiere a la edad del alumno. */
  private int edad;

  /** idEstudiante refiere al número de identificación del estudiante. */
  private int idEstudiante;

  /**
   * isFemenino refiere al sexo del alumno, true = femenino, false = masculino.
   */
  private boolean isFemenino;

  /** examenesClasicos crea un array de objetos de tipo ExamenClasico. */
  private ExamenClasico[] examenesClasicos = new ExamenClasico[EXAMENES_CLASICOS];

  /** examenesTest crea un array de objetos de tipo ExamenTest. */
  private ExamenTest[] examenesTests = new ExamenTest[EXAMENES_TESTS];

  /** trabajos crea un array de objetos de tipo Trabajo. */
  private Trabajo[] trabajos = new Trabajo[TRABAJOS];

  /**
   * El constructor de alumno llama a todos los métodos de generación de los datos
   * necesarios para el alumno, tanto datos personales
   * como notas de exámenes y entregas de trabajos.
   */
  public Alumno() {

    generarId();
    generarSexo();
    generarNombre();
    generarApellido();
    generarEdad();
    generarImagen();
    generarExamenesClasicos();
    generarExamenesTest();
    generarTrabajos();

  }

  /**
   * Constructor utilizado para generar un alumno manualmente.
   *
   * @param nombre           the nombre
   * @param apellidos        the apellidos
   * @param edad             the edad
   * @param isFemenino       the is femenino
   * @param examenesTest     the examenes test
   * @param examenesClasicos the examenes clasicos
   * @param trabajos         the trabajos
   */
  public Alumno(String nombre, String apellidos, int edad, boolean isFemenino, ExamenTest[] examenesTest,
      ExamenClasico[] examenesClasicos, Trabajo[] trabajos) {

    generarId();
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.edad = edad;
    this.isFemenino = isFemenino;
    this.examenesTests = examenesTest;
    this.examenesClasicos = examenesClasicos;
    this.trabajos = trabajos;
    generarImagen();

  }

  /**
   * Genera un array de examenes clásicos.
   */
  private void generarExamenesClasicos() {

    for (int i = 0; i < EXAMENES_CLASICOS; i++) {

      examenesClasicos[i] = new ExamenClasico();

    }

  }

  /**
   * Genera un array de exámenes tipo test.
   */
  private void generarExamenesTest() {

    for (int i = 0; i < EXAMENES_TESTS; i++) {

      examenesTests[i] = new ExamenTest();

    }

  }

  /**
   * Generar entregas de trabajos.
   */
  private void generarTrabajos() {

    for (int i = 0; i < TRABAJOS; i++) {

      trabajos[i] = new Trabajo();

    }

  }

  /**
   * Genera un nombre masculino para los alumnos masculinos.
   */
  public void generarNombreMasculino() {
    int num = (int) (Math.random() * 13);

    switch (num) {
      case 0:
        nombre = "Hector";
        break;
      case 1:
        nombre = "David";
        break;
      case 2:
        nombre = "Raul";
        break;
      case 3:
        nombre = "Alejandro";
        break;
      case 4:
        nombre = "Pablo";
        break;
      case 5:
        nombre = "Alberto";
        break;
      case 6:
        nombre = "Ivan";
        break;
      case 7:
        nombre = "Jose";
        break;
      case 8:
        nombre = "Alexender";
        break;
      case 9:
        nombre = "Moisés";
        break;
      case 10:
        nombre = "Trajano";
        break;
      case 11:
        nombre = "Lucas";
        break;
      case 12:
        nombre = "Antonio";
        break;
    }

  }

  /**
   * Genera un nombre femenino para las alumnas femeninas.
   */
  public void generarNombreFemenino() {
    int num = (int) (Math.random() * 13);
    switch (num) {
      case 0:
        nombre = "Lucia";
        break;
      case 1:
        nombre = "Alicia";
        break;
      case 2:
        nombre = "Maria";
        break;
      case 3:
        nombre = "Aroa";
        break;
      case 4:
        nombre = "Andrea";
        break;
      case 5:
        nombre = "Cristina";
        break;
      case 6:
        nombre = "Alejandra";
        break;
      case 7:
        nombre = "Sara";
        break;
      case 8:
        nombre = "Natalia";
        break;
      case 9:
        nombre = "Isabel";
        break;
      case 10:
        nombre = "Emma";
        break;
      case 11:
        nombre = "Alicia";
        break;
      case 12:
        nombre = "Aurora";
        break;
    }
  }

  /**
   * Genera imágenes de alumnos de ambos sexos.
   */
  private void generarImagen() {
    if (isFemenino) {
      generarImagenFemenina();
    } else {
      generarImagenMasculina();
    }
  }

  /**
   * Genera imagen masculina.
   */
  public void generarImagenMasculina() {

    int num = (int) (Math.random() * 7);
    switch (num) {
      case 0:
        imagen = "/resources/claro_blanco_hombre.png";
        break;
      case 1:
        imagen = "/resources/claro_moreno_hombre.png";
        break;
      case 2:
        imagen = "/resources/claro_pelirrojo_hombre.png";
        break;
      case 3:
        imagen = "/resources/claro_rubio_hombre.png";
        break;
      case 4:
        imagen = "/resources/color_blanco_hombre.png";
        break;
      case 5:
        imagen = "/resources/color_pelirrojo_hombre.png";
        break;
      case 6:
        imagen = "/resources/color_rubio_hombre.png";
        break;

    }

  }

  /**
   * Genera imagen femenina.
   */
  public void generarImagenFemenina() {
    int num = (int) (Math.random() * 7);
    switch (num) {
      case 0:
        imagen = "/resources/clara_blanco_mujer.png";
        break;
      case 1:
        imagen = "/resources/clara_pelirroja_mujer.png";
        break;
      case 2:
        imagen = "/resources/clara_rubia_mujer.png";
        break;
      case 3:
        imagen = "/resources/clara_morena_mujer.png";
        break;
      case 4:
        imagen = "/resources/color_blanco_mujer.png";
        break;
      case 5:
        imagen = "/resources/color_pelirrojo_mujer.png";
        break;
      case 6:
        imagen = "/resources/color_rubio_mujer.png";
        break;

    }
  }

  /**
   * Generar nombre para los alumnos de ambos sexos.
   */
  public void generarNombre() {

    if (isFemenino) {

      generarNombreFemenino();
    } else {

      generarNombreMasculino();
    }

  }

  /**
   * Generas apellidos para los alumnos.
   */
  public void generarApellido() {
    int num = (int) (Math.random() * 13);
    switch (num) {
      case 0:
        apellidos = "Conesa";
        break;
      case 1:
        apellidos = "Quiles";
        break;
      case 2:
        apellidos = "Lopez";
        break;
      case 3:
        apellidos = "Nunez";
        break;
      case 4:
        apellidos = "Garcia";
        break;
      case 5:
        apellidos = "Garci";
        break;
      case 6:
        apellidos = "Aranz";
        break;
      case 7:
        apellidos = "Ruiz";
        break;
      case 8:
        apellidos = "Martinez";
        break;
      case 9:
        apellidos = "Martin";
        break;
      case 10:
        apellidos = "Rabano";
        break;
      case 11:
        apellidos = "Porta";
        break;
      case 12:
        apellidos = "Dominguez";
        break;
    }

  }

  /**
   * Genera un id para los alumnos.
   */
  private void generarId() {

    Curso.alumnosRegistrados++;

    idEstudiante = Curso.alumnosRegistrados;

  }

  /**
   * Genera la edad del alumno.
   */
  private void generarEdad() {

    edad = (int) (Math.random() * 25 + 10);
  }

  /**
   * Genera el sexo del alumno.
   */
  private void generarSexo() {

    int numeroParaGenerar;

    numeroParaGenerar = (int) (Math.random() * 3);

    if (numeroParaGenerar == 1) {
      isFemenino = true;
    } else {
      isFemenino = false;
    }

  }

  /**
   * Indica si el alumno es femenino o masculino.
   *
   * @return Nos devuelve true si el alumno es femenino y false si es masculino
   */
  private boolean isFemenino() {

    if (isFemenino) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * Sets the nota final.
   *
   * @param notaFinal the new nota final
   */
  public void setNotaFinal(double notaFinal) {
    this.notaFinal = notaFinal;
  }

  /**
   * Gets the nota final.
   *
   * @return the nota final
   */
  public double getNotaFinal() {
    return notaFinal;
  }

  /**
   * Gets the nombre.
   *
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Gets the sexo.
   *
   * @return the sexo
   */
  public String getSexo() {
    return (isFemenino) ? "Mujer" : "Hombre";
  }

  /**
   * Gets the apellidos.
   *
   * @return the apellidos
   */
  public String getApellidos() {
    return apellidos;
  }

  /**
   * Gets the examenes clasicos.
   *
   * @return the examenes clasicos
   */
  public ExamenClasico[] getExamenesClasicos() {
    return examenesClasicos;
  }

  /**
   * Gets the examenes tests.
   *
   * @return the examenes tests
   */
  public ExamenTest[] getExamenesTests() {
    return examenesTests;
  }

  /**
   * Gets the trabajos.
   *
   * @return the trabajos
   */
  public Trabajo[] getTrabajos() {
    return trabajos;
  }

  /**
   * Gets the id estudiante.
   *
   * @return the id estudiante
   */
  public int getIdEstudiante() {
    return idEstudiante;
  }

  /**
   * Gets the preguntas tests.
   *
   * @return the preguntas tests
   */
  public static int getPreguntasTests() {
    return PREGUNTAS_TESTS;
  }

  /**
   * Gets the fallo resta.
   *
   * @return the fallo resta
   */
  public static double getFalloResta() {
    return FALLO_RESTA;
  }

  /**
   * Gets the edad.
   *
   * @return the edad
   */
  public int getEdad() {
    return edad;
  }

  /**
   * Gets the imagen.
   *
   * @return the imagen
   */
  public String getImagen() {
    return imagen;
  }

}
