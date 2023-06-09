
package interfaz;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

// TODO: Auto-generated Javadoc
/**
 * Hereda de la clase Pestanya, es un panel dentro de los tabs que mostrar� informaci�n de las notas finales.
 */
public class NotasFinales extends Pestanya {
	
	/** Modelo de la tabla correspondientes a los examenes de tipo test. */
	public static DefaultTableModel modelFinales;
	
	/**
	 * Recibe los datos correspondientes a las notas finales y llama al constructor de la clase padre donde crear� la tabla con los datos recibidos.
	 *
	 * @param trabajos String array con algunos datos del alumno y con datos de los examenes cl�sicos
	 * @param columnas Columnas de la tablas
	 * @param gestorPestanyas Panel Gestor Pestanyas
	 */
	public NotasFinales(String[][] trabajos, String[] columnas, GestorPestanyas gestorPestanyas) {
		
		super(trabajos, columnas, gestorPestanyas);
	
		modelFinales = model;

		}
	
	/**
	 * Agregar fila al modelo de la tabla que corresponde a los examenes cl�sicos.
	 *
	 * @param fila Array de Strings con los datos a agregar
	 */
	public static void agregarFilaFinales(String[] fila) {
		
		modelFinales.addRow(fila);
		
	}
	
	

}
