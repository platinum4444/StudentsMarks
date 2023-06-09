
package interfaz;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import notas.Curso;

// TODO: Auto-generated Javadoc
/**
 * Tendr� los dos elementos principales de la ventana, la barra de herramientas y el gestor de pesta�as
 */
public class Paneles extends JPanel {
	
	/** Objeto gestor pestanyas. */
	GestorPestanyas gestorPestanyas;
	
	/** Objeto curso. */
	Curso curso;
	
	/**
	 * Agregar� al panel la barra de herramientas y el gestor de pesta�as
	 *
	 * @param curso Objeto de la clase Curso
	 */
	public Paneles(Curso curso) {
		this.curso = curso;
		setLayout(new BorderLayout());
		BarraHerramientas barraHerramientas = new BarraHerramientas(curso);
		add(barraHerramientas, BorderLayout.NORTH);
		gestorPestanyas = new GestorPestanyas(curso);
		add(gestorPestanyas, BorderLayout.CENTER);
	}
	
	

}
