
package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import notas.Curso;

// TODO: Auto-generated Javadoc
/*
 * @version 1.0
 * @author David Quiles
 * @author Alejandro L�pez
 */

/**
 *  Class Pestanya.
 */
public class Pestanya extends JPanel {
	
	/**  Id usuario seleccionado, para que al cambiar entre pesta�as se quede el alumno que estamos consultando  */
	public static int idUsuarioSeleccionado = 1;
	
	/**  Tabla. */
	protected JTable tabla;
	
	/**  Datos alumno individual. */
	protected DatosAlumnoIndividual datosAlumnoIndividual;
	
	/**  ScrollPane de la tabla, as� el usuario podr� hacer scroll en caso de muchos registros. */
	public static JScrollPane scrollTabla;
	
	/**  Datos tabla. */
	protected String[][] datosTabla;
	
	/**  Columnas tabla. */
	protected String[] columnasTabla;
	
	/**  Oodel, nos permitir� agregar filas en caso de agregar datos a la tabla */
	protected DefaultTableModel model;
	
	/**  Objeto de gestor pestanyas. */
	protected GestorPestanyas gestorPestanyas;
	
	/**
	 * Instantiates a new pestanya.
	 *
	 * @param datosTabla  datos que le enviaremos a la tabla
	 * @param columnasTabla  columnas que le enviaremos tabla
	 * @param gestorPestanyas gestor pestanyas
	 */
	public Pestanya(String[][] datosTabla, String[] columnasTabla, GestorPestanyas gestorPestanyas) {

		setLayout(new BorderLayout());
		
		this.datosTabla = datosTabla;
		this.columnasTabla = columnasTabla;
		this.gestorPestanyas = gestorPestanyas;
		
		crearTabla();

	
	}
	
	/**
	 * Mostrar informacion usuario seleccionado en el panel de la izquierda, para que el usuario pueda ver la foto, edad.
	 */
	protected void mostrarInformacionUsuarioSeleccionado() {
		datosAlumnoIndividual.asignarTextoLabels(Curso.obtenerAlumnoPorID(idUsuarioSeleccionado));
		tabla.changeSelection(idUsuarioSeleccionado-1, 0, false, false);
	}
	
	/**
	 * Actualizar tabla.
	 */
	public void crearTabla() {
		
		agregarTabla();
		ajustarColumnaTablaAlContenido(tabla);
		agregarMouseListenerTabla();
		agregarDatosAlumnoPanel();
		mostrarInformacionUsuarioSeleccionado();
		
		gestorPestanyas.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				mostrarInformacionUsuarioSeleccionado();
				
			}
			
		});
	}
	
	/**
	 * Nos instanciar� el modelo y la tabla, le agregar� los datos al modelo.
	 */
	protected void agregarTabla() {
		
		model = new DefaultTableModel();
		tabla = new JTable(model);
	
		for (int i = 0; i < columnasTabla.length; i++) {
			model.addColumn(columnasTabla[i]);
		}
		for (int i = 0; i < datosTabla.length; i++) {
			model.addRow(datosTabla[i]);
		}
		scrollTabla = new JScrollPane(tabla);

		add(scrollTabla, BorderLayout.EAST);
	
	}
	
	
	
	/**
	 * Tabla cuya finalidad ser� la de al seleccionar cualquier fila de la tabla nos cree un evento para actualizar el panel de Datos Alumno Individual.
	 */
	protected void agregarMouseListenerTabla() {
		tabla.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			
				int filaSeleccionada = tabla.getSelectedRow();
				datosAlumnoIndividual.asignarTextoLabels(Curso.obtenerAlumnoPorID(filaSeleccionada + 1));
				idUsuarioSeleccionado = filaSeleccionada + 1;

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	/**
	 * Agregar panel de datos alumno individual, donde mostrar� a la izquierda de la ventana datos propios del alumno seleccionado en la tabla.
	 */
	protected void agregarDatosAlumnoPanel() {
		datosAlumnoIndividual = new DatosAlumnoIndividual();
		//Padding del panel
		datosAlumnoIndividual.setBorder(new EmptyBorder(new Insets(40, 40, 40, 40)));
		add(datosAlumnoIndividual, BorderLayout.CENTER);
	}
	
	/**
	 * Ajustar columna tabla al contenido, para evitar columnas muy peque�as, ya que java no permite cambiar el tama�o horizontal de las columnas por defecto
	 *
	 * @param table Tabla a las que ajustaremos las columnas
	 */
	public void ajustarColumnaTablaAlContenido(JTable table) {
		
	    final TableColumnModel modeloColumna = table.getColumnModel();
	    for (int columna = 0; columna < table.getColumnCount(); columna++) {
	        int ancho = 15;
	        for (int fila = 0; fila < table.getRowCount(); fila++) {
	            TableCellRenderer renderizar = table.getCellRenderer(fila, columna);
	            Component comp = table.prepareRenderer(renderizar, fila, columna);
	            ancho = Math.max(comp.getPreferredSize().width +1 , ancho);
	        }
	        if(ancho > 300)
	            ancho=300;
	        modeloColumna.getColumn(columna).setPreferredWidth(ancho);
	    }
	}
}
