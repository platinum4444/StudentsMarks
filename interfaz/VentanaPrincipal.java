

package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import notas.Curso;

/**
 * The Class VentanaPrincipal.
 */
public class VentanaPrincipal extends JFrame implements Runnable {
	
	/** Hilo secundario. */
	private Thread hilo;
	
	/** Objeto de la clase Curso. */
	private Curso curso;
	
	/** Objeto de la clase Paneles. */
	private Paneles paneles;
	
	/**
	 * Crear� el hilo y llamar� al m�todo Run.
	 */
	public VentanaPrincipal() {
		hilo = new Thread(this);
		hilo.start();
		
	}
	
	/**
	 * Propiedades ventana.
	 */
	private void propiedadesVentana() {
		setSize(new Dimension(1100, 1000));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setTitle("Software de gestión de alumnos | Student Mark");
		setVisible(true);
	}
	
	/**
	 * Establecer icono ventana.
	 */
	private void establecerIconoVentana() {
		URL urlIcono = getClass().getResource("/resources/highschool.png");
		ImageIcon icon = new ImageIcon(urlIcono);
		setIconImage(icon.getImage());
	}
	
	/**
	 * Agregar paneles.
	 */
	private void agregarPaneles() {
		
		paneles = new Paneles(curso);
		this.getContentPane().add(paneles);
	}
	
	

	/**
	 * Run.
	 */
	@Override
	public void run() {
		
		establecerIconoVentana();
		generarCurso();
		agregarPaneles();
		propiedadesVentana();
		
	}
	
	/**
	 * Generar curso.
	 */
	private void generarCurso() {
		
		curso = new Curso();
	}
	
}
