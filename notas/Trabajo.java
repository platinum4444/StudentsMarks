

package notas;

/**
 * The Class Trabajo.
 */
public class Trabajo {
    
	/**PLAZO_MAXIMO establece el plazo máximo de días que el programa puede generar de retraso en la entrega
	 * de un trabajo */
	private final int PLAZO_MAXIMO = 6;
	
	/**isPresentado indica si el trabajo está presentado o no */
	private boolean isPresentado;
	
	/** indica los días de retraso */
	private int diasRetraso;
	
	
    /**
     * Constructor que genera si un trabajo ha sido persentado o no y los días de retraso en caso de que sí
     */
    public Trabajo() {
        generarPresentado();
        generarDiasRetraso();
    }
    
    /**
     * Constructor al que se le pasa si un trabajo ha sido presentado y los días de retraso que recibe
     *
     * @param isPresentado si el trabajo ha sido presentado
     * @param diasRetraso indica los días de retraso
     */
    public Trabajo(boolean isPresentado, int diasRetraso) {
    	this.isPresentado = isPresentado;
    	this.diasRetraso = diasRetraso;
    }
    
    /**
     * Genera si ha sido presentado
     */
    public void generarPresentado () {
    	
    	isPresentado = ((int) (Math.random() * 7) < 5)?true:false;
    	
    }
    
    
    /**
     * Genera los dias de retraso.
     */
    public void generarDiasRetraso() {
    	
    	if(isPresentado) {
    		diasRetraso = (int) (Math.random() * PLAZO_MAXIMO);
    	}
    	
    }
    
    /**
     * Genera si el trabajo está aprobado.
     *
     * @return si está suspendido o aprobado
     */
    public boolean trabajoAprobado () {
        
        if(isPresentado) {
            if(diasRetraso > 5) {
                return false;
            }else {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Ha entregado todos los trabajos.
     *
     * @param recibe un array de trabajos
     * @return devuelve true si ha entregado todos los trabajos
     */
    static public boolean haEntregadoTodosLosTrabajos(Trabajo[] trabajos) {
    	
    	for (Trabajo b : trabajos) {
            if (b.isPresentado() == false) {
                    return false;
            }
        }
    	return true;
    }

	/**
	 * Comprueba si un trabajo ha sido presentado.
	 *
	 * @return true si ha sido presentado
	 */
	public boolean isPresentado() {
		return isPresentado;
	}

	/**
	 * Gets the dias retraso.
	 *
	 * @return the dias retraso
	 */
	public int getDiasRetraso() {
		return diasRetraso;
	}
	
	/**
	 * Gets the trabajo.
	 *
	 * @return the trabajo
	 */
	public String getTrabajo() {
		
		return (trabajoAprobado())?"Aprobado":"Suspendido";
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Is presentado " + isPresentado + "\nDias retraso " + diasRetraso;
	}

}
