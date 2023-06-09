
package interfaz;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import notas.Curso;

// TODO: Auto-generated Javadoc
/**
 * Gestionar� las pesta�as de la ventana principal
 */
public class GestorPestanyas extends JTabbedPane {
	
	/** The curso. */
	private Curso curso;
	
	/** Array de Strings con la informaci�n a incluir en la tabla de notas clasicos. */
	private NotasClasicos notasClasicos;
	
	/** Array de Strings con la informaci�n a incluir en la tabla de notas tests.  */
	private NotasTests notasTests;
	
	/** Array de Strings con la informaci�n a incluir en la tabla de trabajos. */
	private Trabajos trabajos;
	
	/** Array de Strings con la informaci�n a incluir en la tabla de notas finales. */
	private NotasFinales notasFinales;
	
	/**
	 * Crea los paneles y los agrega al JTabbedPane.
	 *
	 * @param curso Objeto de la clase Curso
	 */
	public GestorPestanyas(Curso curso) {
	
		this.curso = curso;
		
		notasClasicos =  new NotasClasicos(curso.generarInformacionExamenesClasicos(), curso.getColumnasExamenesClasicos(), this);
		notasTests = new NotasTests(curso.generarInformacionExamenesTests(), curso.getColumnasExamenesTests(), this);
		trabajos = new Trabajos(curso.generarInformacionTrabajos(), curso.getColumnasTrabajos(), this);
		notasFinales = new NotasFinales(curso.generarInformacionFinales(), curso.getColumnasFinales(), this);
		
		addTab("Nota Examenes Clasico", notasClasicos);
		addTab("Nota Examenes Test", notasTests);
		addTab("Trabajos", trabajos);
		addTab("Notas finales", notasFinales);
		
	}
	
	
}
