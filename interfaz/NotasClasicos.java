
package interfaz;



import javax.swing.table.DefaultTableModel;


// TODO: Auto-generated Javadoc
/**
 * Hereda de la clase Pestanya, es un panel dentro de los tabs que mostrar� informaci�n de las notas cl�sicas.
 */
public class NotasClasicos extends Pestanya {
	
	/** Modelo de la tabla correspondientes a los examenes cl�sicos. */
	public static DefaultTableModel modelClasico;

	/**
	 * Recibe los datos correspondientes a las notas clasicas y llama al constructor de la clase padre donde crear� la tabla con los datos recibidos.
	 *
	 * @param examenesClasicos String array con algunos datos del alumno y con datos de los examenes cl�sicos
	 * @param columnas Columnas de la tablas
	 * @param gestorPestanyas Panel Gestor Pestanyas
	 */
	public NotasClasicos(String[][] examenesClasicos, String[] columnas, GestorPestanyas gestorPestanyas) {
		
		super(examenesClasicos, columnas, gestorPestanyas);	
		modelClasico = model;

	}
	
	/**
	 * Agregar fila al modelo de la tabla que corresponde a los examenes cl�sicos.
	 *
	 * @param fila Array de Strings con los datos a agregar
	 */
	public static void agregarFilaClasica(String[] fila) {
		
		modelClasico.addRow(fila);
		
	}
	
}
