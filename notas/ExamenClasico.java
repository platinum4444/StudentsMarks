

package notas;

/**
 * The Class ExamenClasico.
 */
public class ExamenClasico {
	
    /** NOTA_MAXIMA la nota máxima que un Alumno puede tener en un examen clásico (0-10). */
	private final int NOTA_MAXIMA = 10;
	
	/**  nota la nota de un alumno en el exámen clásico. */
	private double nota;
	
	/**
	 * El constructor de ExamenClasico, genera una nota aleatoria por cada examen clasico.
	 */
	public ExamenClasico () {
		generarNotaAleatoria();
	}
	
	/**
	 * Guarda la nota generada en un examen.
	 *
	 * @param nota the nota
	 */
	public ExamenClasico (double nota) {
		this.nota = nota;
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
	 * Genera una nota aleatoria.
	 */
	public void generarNotaAleatoria() {
	    nota  = (double) Math.round(Math.random() * NOTA_MAXIMA);
	}
	
	
}