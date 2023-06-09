

package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JToolBar;

import notas.Alumno;
import notas.Curso;

// TODO: Auto-generated Javadoc
/**
 * Barra de herramientas situada arriba de la ventana
 */
public class BarraHerramientas extends JToolBar {

	/** Agregar alumnos boton. */
	private JButton agregarUsuarioBoton;
	
	/** exportar alumnos en fichero boton. */
	private JButton guardarUsuariosEnFicheroBoton;
	
	/** Objeto de curso que recibir� por el constructor. */
	private Curso curso;
	
	/** Ventana de guardar fichero */
	private JFileChooser fc;
	
	/** Fichero seleccionado. */
	private File file;
	
	/**
	 * Constructor cuya funci�n es llamar al m�todo que agrega los botones a la Barra de herramientas.
	 *
	 * @param curso Objeto de la clase Curso.
	 */
	public BarraHerramientas(Curso curso) {
		
		this.curso = curso;
		agregarBotones();
		
		
	}
	
	/**
	 * Agrega botones a la Barra de herramientas.
	 */
	private void agregarBotones() {
		agregarUsuarioBoton = new JButton("Agregar alumno");
		guardarUsuariosEnFicheroBoton = new JButton("Exportar calificacion final");
		add(agregarUsuarioBoton);
		add(guardarUsuariosEnFicheroBoton);
		eventoClickBotonAgregar();
		eventoClickBotonGuardar();
	}
	
	/**
	 * Evento click boton agregar.
	 */
	private void eventoClickBotonAgregar() {
		
		agregarUsuarioBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				NuevoAlumno agregarAlumno = new NuevoAlumno(curso);
				
			}
			
		});
	}
	
	/**
	 * Evento click boton guardar.
	 */
	private void eventoClickBotonGuardar() {
		
		guardarUsuariosEnFicheroBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				//int returnVal = fc.showDialog(this);
				/*JFileChooser fc = new JFileChooser();
				fc.showSaveDialog(this);*/
				iniciarSaveFileChooser();
				
			}
			
		});
	}
	
	/**
	 * Iniciar save file chooser.
	 */
	private void iniciarSaveFileChooser() {
		fc = new JFileChooser();
		fc.showSaveDialog(this);
		file = fc.getSelectedFile();
		System.out.println(file.getAbsolutePath());
		escribirDatosEnFichero(file.getAbsolutePath(), Curso.alumnosCurso);
		
	}
	
	/**
	 * Escribir datos en fichero.
	 *
	 * @param ruta La ruta donde guardaremos el fichero
	 * @param alumnos El array de alumnos a guardar en el fichero
	 */
	private void escribirDatosEnFichero(String ruta, Alumno[] alumnos) {
		
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(ruta + ".txt"));
			for (int i = 0; i < Curso.ALUMNOS_CREADOS_AUTOMATICAMENTE_POR_CURSO; i++) {
				
				printWriter.print("ID " + alumnos[i].getIdEstudiante() + ", ");
				printWriter.print("Nombre " + alumnos[i].getNombre() + ", ");
				printWriter.print("Edad " + alumnos[i].getEdad() + ", ");
				printWriter.print("Nota final " + alumnos[i].getNotaFinal());
				printWriter.println();		
				
			}
			printWriter.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
