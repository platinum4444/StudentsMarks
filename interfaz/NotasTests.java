
package interfaz;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

// TODO: Auto-generated Javadoc
/**
 *  Hereda de la clase Pestanya, es un panel dentro de los tabs que mostrar� informaci�n de las notas de tipo test.
 */
public class NotasTests extends Pestanya {
	
	/** Modelo de la tabla correspondientes a los examenes de tipo test. */
	public static DefaultTableModel modelTest;

	/**
	 * Recibe los datos correspondientes a las notas de tipo test y llama al constructor de la clase padre donde crear� la tabla con los datos recibidos.
	 *
	 * @param examenesTests String array con algunos datos del alumno y con datos de los examenes cl�sicos
	 * @param columnas Columnas de la tablas
	 * @param gestorPestanyas Panel Gestor Pestanyas
	 */
	public NotasTests(String[][] examenesTests, String[] columnas, GestorPestanyas gestorPestanyas) {
			
		super(examenesTests, columnas, gestorPestanyas);
		
		modelTest = model;

	}
	
	/**
	 * Agregar fila al modelo de la tabla que corresponde a los examenes cl�sicos.
	 *
	 * @param fila Array de Strings con los datos a agregar
	 */
	public static void agregarFilaTest(String[] fila) {
		
		modelTest.addRow(fila);

	}
}
