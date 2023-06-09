package notas;

import interfaz.GestorPestanyas;

public class Curso {

	
	/**
	 * PORCENTAJE_PRIMER_EXAMEN_CLASICO sirve para calcular cuánto puntúa el primer examen clasico sobre la nota final
	 **/
	private final double PORCENTAJE_PRIMER_EXAMEN_CLASICO = 10 / 100f;
	/** 
	 * PORCENTAJE_SEGUNDO_EXAMEN_CLASICO sirve para calcular cuánto puntúa el segundo examen sobre la nota final
	**/
    private final double PORCENTAJE_SEGUNDO_EXAMEN_CLASICO = 20 /100f;
    /** 
     * PORCENTAJE_TERCER_EXAMEN_CLASICO sirve para calcular cuánto puntúa el tercer examen sobre la nota final
     **/
    private final double PORCENTAJE_TERCER_EXAMEN_CLASICO = 20 / 100f;
    
    /** 
     * PORCENTAJE_PRIMER_EXAMEN_TEST sirve para calcular cuánto puntúa el primer examen tipo sobre la nota final
     **/
    private final double PORCENTAJE_PRIMER_EXAMEN_TEST = 25 / 100f;
    
    /** 
     * PORCENTAJE_SEGUNDO_EXAMEN_TEST sirve para calcular cuánto puntúa el segundo examen tipo sobre la nota final
     **/
    private final double PORCENTAJE_SEGUNDO_EXAMEN_TEST = 25 / 100f;
    
    /**
     * ALUMNOS_CREADOS_AUTOMATICAMENTE_POR_CURSO sirve para crear los alumnos por cada curso
     **/
	public static final int ALUMNOS_CREADOS_AUTOMATICAMENTE_POR_CURSO = 120;
	
	/**
	 * ALUMNOS_MAXIMOS_POR_CURSO pone un máximo de alumnos que es posible crear por curso
	 **/
	public static final int ALUMNOS_MAXIMOS_POR_CURSO = 140;
	
	/**
	 * alumnosRegistrados indica cuántos alumnnos hay registrados manualmente en el programa en este momento
	 **/
	public static int alumnosRegistrados = 0;
	
	/**
	 * alumnosCurso crea un array de alumnos con sus variables de instancia en un curso
	 **/
	public static Alumno [] alumnosCurso  = new Alumno [ALUMNOS_MAXIMOS_POR_CURSO];
	
	/**
	 * El constuctor de Curso. Cuando es llamado usa los métodos de generar alumnos y calcular sus notas finales
	 */
	public Curso() {
		
		generarAlumnos();
		calcularNotasFinales();
		
	}
	/**
	 * 
	 * @return Devuelve un array con <b>Alumnos</b>
	 */
	public Alumno[] getAlumnos(){
		
		return alumnosCurso;
	}
	
	/**
	 * Agrega un alumno manualmente al array alumnosCurso
	 * @param alumno recibe un objeto de tipo Alumno
	 * 
	 */
	public void agregarAlumnoACurso (Alumno alumno) {
		
		alumnosCurso[alumnosRegistrados-1] = alumno;
		
	}
	
	/**
	 * Genera los alumnos dentro del curso
	 */
	public void generarAlumnos() {
		
		for(int i = 0; i <= ALUMNOS_CREADOS_AUTOMATICAMENTE_POR_CURSO; i++) {
			
			alumnosCurso[i]= new Alumno();
			System.out.println(i);
		}
		
		
	}
	
	/**
	 * Calcula la nota final para cada alumno del curso
	 */
	public void calcularNotasFinales() {
	
		double notaPrimerExamen, notaSegundoExamen, notaTercerExamen, notaCuartoExamen, notaQuintoExamen, notaFinal;   
		
		for(int i = 0; i < alumnosRegistrados; i++) {
	    	
	    	if(Trabajo.haEntregadoTodosLosTrabajos(alumnosCurso[i].getTrabajos())) {
	    		notaPrimerExamen = alumnosCurso[i].getExamenesClasicos()[0].getNota() * PORCENTAJE_PRIMER_EXAMEN_CLASICO;
		    	notaSegundoExamen = alumnosCurso[i].getExamenesClasicos()[1].getNota() * PORCENTAJE_SEGUNDO_EXAMEN_CLASICO;
		    	notaTercerExamen = alumnosCurso[i].getExamenesClasicos()[2].getNota() * PORCENTAJE_TERCER_EXAMEN_CLASICO;
		    	notaCuartoExamen = alumnosCurso[i].getExamenesTests()[0].getNota() * PORCENTAJE_PRIMER_EXAMEN_TEST;
		    	notaQuintoExamen = alumnosCurso[i].getExamenesTests()[1].getNota() * PORCENTAJE_SEGUNDO_EXAMEN_TEST;
		    	
		    	notaFinal = Math.round(notaPrimerExamen + notaSegundoExamen + notaTercerExamen + notaCuartoExamen + notaQuintoExamen);
		    	alumnosCurso[i].setNotaFinal(notaFinal);
	    		
	    	}else {
	    		
	    		alumnosCurso[i].setNotaFinal(3);
	    		
	    	}
	    	
		}
	
	}
	/**
	 * Obtiene la media de los tres exámenes clásicos de un alumno
	 * @param posicionAlumno la posicion del alumno del que queremos obtener la media de los tres exámenes clásicos
	 * @return la nota media de los exámenes clásicos del alumno
	 */
	public double getMediaAlumnoExamenesClasicos(int posicionAlumno) {
		
		double primerExamen = alumnosCurso[posicionAlumno].getExamenesClasicos()[0].getNota();
		double segundoExamen = alumnosCurso[posicionAlumno].getExamenesClasicos()[1].getNota();
		double tercerExamen = alumnosCurso[posicionAlumno].getExamenesClasicos()[2].getNota();
		double media = Math.round((primerExamen + segundoExamen + tercerExamen) / Alumno.EXAMENES_CLASICOS);
		
		return media;
		
	}
	
	/**
	 * Obtiene la media de los tres exámenes tipo test de un alumno
	 * @param posicionAlumno la posicion del alumno del que queremos obtener la media de los dos exámenes de tipo test
	 * @return la nota media de los exámenes tipo test del alumno
	 */
	public double getMediaAlumnoExamenesTests(int posicionAlumno) {
		
		double primerExamen = alumnosCurso[posicionAlumno].getExamenesTests()[0].getNota();
		double segundoExamen = alumnosCurso[posicionAlumno].getExamenesTests()[1].getNota();
		double media = Math.round((primerExamen + segundoExamen) / Alumno.EXAMENES_TESTS);
		
		return media;
		
	}
	
	/**
	 * Genera la información que se mostrará en la tabla cuando se visualice todos los alumnos del curso
	 * @return devuelve la nota de cada uno de los exámenes clásicos de los alumnos del curso
	 */
	public String[][] generarInformacionExamenesClasicos() {
		
		String[][] clasicos = new String[Curso.alumnosRegistrados][5];
		for (int i = 0; i < clasicos.length; i++) {
			clasicos[i][0] = alumnosCurso[i].getNombre();
			clasicos[i][1] = alumnosCurso[i].getApellidos();
			clasicos[i][2] = String.valueOf(alumnosCurso[i].getExamenesClasicos()[0].getNota());
			clasicos[i][3] = String.valueOf(alumnosCurso[i].getExamenesClasicos()[1].getNota());
			clasicos[i][4] = String.valueOf(alumnosCurso[i].getExamenesClasicos()[2].getNota());
		}
		
		return clasicos;
		
	}

	/**
	 * Genera la información que se mostrará en la tabla cuando se visualice un alumno en especial
	 * @param posicionAlumno genera la nota de cada uno de los exámenes clásicos de un alumno específico
	 * @return devuelve la nota de cada uno de los exámenes clásicos de un alumno específico
	 */
	public String[] generarInformacionExamenesClasicos(int posicionAlumno) {
	
		String[] clasicos = new String[5];
		
		clasicos[0] = alumnosCurso[posicionAlumno].getNombre();
		clasicos[1] = alumnosCurso[posicionAlumno].getApellidos();
		clasicos[2] = String.valueOf(alumnosCurso[posicionAlumno].getExamenesClasicos()[0].getNota());
		clasicos[3] = String.valueOf(alumnosCurso[posicionAlumno].getExamenesClasicos()[1].getNota());
		clasicos[4] = String.valueOf(alumnosCurso[posicionAlumno].getExamenesClasicos()[2].getNota());
		
		return clasicos;
		
}

/**
 * Asigna los nombres de las columnas para la interfaz gráfica para los exámenes clásicos
 * @return devuelve las columnas de la interfaz con los nombres ya atribuidos
 */
	public String[] getColumnasExamenesClasicos() {
		
		String[] columnas = {"Nombre", "Apellidos", "Examen 1", "Examen 2", "Examen 3"};
		
		return columnas;
	}
	
	/**
	 * Genera la información que se mostrará en la tabla cuando se visualice todos los alumnos del curso
	 * @return devuelve los datos que la interfaz debe mostrar
	 */
	public String[][] generarInformacionExamenesTests() {
		
		String[][] clasicos = new String[Curso.alumnosRegistrados][10];
		for (int i = 0; i < clasicos.length; i++) {
			clasicos[i][0] = alumnosCurso[i].getNombre();
			clasicos[i][1] = alumnosCurso[i].getApellidos();
			clasicos[i][2] = String.valueOf(alumnosCurso[i].getExamenesTests()[0].getAciertos());
			clasicos[i][3] = String.valueOf(alumnosCurso[i].getExamenesTests()[0].getFallos());
			clasicos[i][4] = String.valueOf(alumnosCurso[i].getExamenesTests()[0].getSinContestar());
			clasicos[i][5] = String.valueOf(alumnosCurso[i].getExamenesTests()[0].getNota());
			clasicos[i][6] = String.valueOf(alumnosCurso[i].getExamenesTests()[1].getAciertos());
			clasicos[i][7] = String.valueOf(alumnosCurso[i].getExamenesTests()[1].getFallos());
			clasicos[i][8] = String.valueOf(alumnosCurso[i].getExamenesTests()[1].getSinContestar());
			clasicos[i][9] = String.valueOf(alumnosCurso[i].getExamenesTests()[1].getNota());
		}
		
		return clasicos;
		
	}
	/**
	 *Genera la información que se mostrará en la tabla cuando se visualice un alumno específico
	 * @param posicionAlumno la posición del alumno del que se quiere obtener la nota de cada uno de los exámenes de tipo test
	 * @return devuelve los datos que la interfaz debe mostrar
	 */
	public String[] generarInformacionExamenesTests(int posicionAlumno) {
		
		String[] tests = new String[10];
	
		tests[0] = alumnosCurso[posicionAlumno].getNombre();
		tests[1] = alumnosCurso[posicionAlumno].getApellidos();
		tests[2] = String.valueOf(alumnosCurso[posicionAlumno].getExamenesTests()[0].getAciertos());
		tests[3] = String.valueOf(alumnosCurso[posicionAlumno].getExamenesTests()[0].getFallos());
		tests[4] = String.valueOf(alumnosCurso[posicionAlumno].getExamenesTests()[0].getSinContestar());
		tests[5] = String.valueOf(alumnosCurso[posicionAlumno].getExamenesTests()[0].getNota());
		tests[6] = String.valueOf(alumnosCurso[posicionAlumno].getExamenesTests()[1].getAciertos());
		tests[7] = String.valueOf(alumnosCurso[posicionAlumno].getExamenesTests()[1].getFallos());
		tests[8] = String.valueOf(alumnosCurso[posicionAlumno].getExamenesTests()[1].getSinContestar());
		tests[9] = String.valueOf(alumnosCurso[posicionAlumno].getExamenesTests()[1].getNota());
		
		return tests;
		
	}
	
	/**
	 * Asigna los nombres de las columnas sobre los exámenes tipo test para la interfaz gráfica 
	 * @return devuelve los datos que la interfaz debe mostrar
	 */
	public String[] getColumnasExamenesTests() {
		
		String[] columnas = {"Nombre", "Apellidos", "A", "F", "SN" ,"Nota", "A", "F", "SN", "Nota"};
		
		return columnas;
	}
	
	/**
	 * Genera la información que se mostrará en la tabla cuando se visualice todos los alumnos del curso
	 * @return devuelve los datos que la interfaz debe mostrar
	 */
	public String[][] generarInformacionTrabajos() {
		
		String[][] trabajos = new String[Curso.alumnosRegistrados][10];
		for (int i = 0; i < trabajos.length; i++) {
			trabajos[i][0] = alumnosCurso[i].getNombre();
			trabajos[i][1] = alumnosCurso[i].getApellidos();
			trabajos[i][2] = String.valueOf(alumnosCurso[i].getTrabajos()[0].getTrabajo());
			trabajos[i][3] = String.valueOf(alumnosCurso[i].getTrabajos()[1].getTrabajo());
			trabajos[i][4] = String.valueOf(alumnosCurso[i].getTrabajos()[2].getTrabajo());
		}
		
		return trabajos;
		
	}
	
	/**
	 * Genera la información que se mostrará en la tabla cuando se visualice un alumno específico
	 * @param posicionAlumno
	 * @return devuelve los datos que la interfaz debe mostrar
	 */
	public String[] generarInformacionTrabajos(int posicionAlumno) {
		
		String[] trabajos = new String[10];
	
			trabajos[0] = alumnosCurso[posicionAlumno].getNombre();
			trabajos[1] = alumnosCurso[posicionAlumno].getApellidos();
			trabajos[2] = String.valueOf(alumnosCurso[posicionAlumno].getTrabajos()[0].getTrabajo());
			trabajos[3] = String.valueOf(alumnosCurso[posicionAlumno].getTrabajos()[1].getTrabajo());
			trabajos[4] = String.valueOf(alumnosCurso[posicionAlumno].getTrabajos()[2].getTrabajo());
		
		return trabajos;
		
	}

	/**
	 * Asigna los nombres de las columnas sobre los trabajos para la interfaz gráfica 
	 * @return devuelve las columnas de la interfaz con los nombres ya atribuidos
	 */
	public String[] getColumnasTrabajos() {
		
		String[] columnas = {"Nombre", "Apellidos", "Trabajo 1", "Trabajo 2", "Trabajo 3"};
		
		return columnas;
	}
	
	/**
	 * Genera la información que se mostrará en la tabla cuando se visualice todos los alumnos del curso
	 * @return devuelve los datos que la interfaz debe mostrar
	 */
	public String[][] generarInformacionFinales() {
		
		String[][] finales = new String[Curso.alumnosRegistrados][6];
		for (int i = 0; i < finales.length; i++) {
			finales[i][0] = alumnosCurso[i].getNombre();
			finales[i][1] = alumnosCurso[i].getApellidos();
			finales[i][2] = String.valueOf(getMediaAlumnoExamenesClasicos(i) + "          ");
			finales[i][3] = String.valueOf(getMediaAlumnoExamenesTests(i));
			finales[i][4] = String.valueOf(Trabajo.haEntregadoTodosLosTrabajos(alumnosCurso[i].getTrabajos()));
			finales[i][5] = String.valueOf(alumnosCurso[i].getNotaFinal());
		}
		
		return finales;
		
	}

	/**
	 * Genera la información que se mostrará en la tabla cuando se visualice todos los alumnos del curso
	 * @param posicionAlumno recibe la posición de un alumno
	 * @return devuelve los datos que la interfaz debe mostrar
	 */
	public String[] generarInformacionFinales(int posicionAlumno) {
		
		String[] finales = new String[6];
	
		finales[0] = alumnosCurso[posicionAlumno].getNombre();
		finales[1] = alumnosCurso[posicionAlumno].getApellidos();
		finales[2] = String.valueOf(getMediaAlumnoExamenesClasicos(posicionAlumno) + "          ");
		finales[3] = String.valueOf(getMediaAlumnoExamenesTests(posicionAlumno));
		finales[4] = String.valueOf(Trabajo.haEntregadoTodosLosTrabajos(alumnosCurso[posicionAlumno].getTrabajos()));
		finales[5] = String.valueOf(alumnosCurso[posicionAlumno].getNotaFinal());
		
		return finales;
		
	}
	
	/**
	 * Asigna los nombres de las columnas sobre los trabajos para la interfaz gráfica
	 * @return devuelve las columnas de la interfaz con los nombres ya atribuidos
	 */
	public String[] getColumnasFinales() {
		
		String[] columnas = {"Nombre", "Apellidos", "AVG Clasicos", "AVG Tests","Trabajos", "Final"};
		
		return columnas;
	}
	
	/**
	 * sirve para buscar un alumno en especial mediante su id
	 * @param id el id del alumno que se quiere buscar
	 * @return el alumno al cual pertenece el id recibido
	 */
	public static Alumno obtenerAlumnoPorID(int id) {
    	for (Alumno alumno : alumnosCurso) {
			if(alumno.getIdEstudiante()==id) {
				return alumno;
			}
		}
    	return null;
    }
}
