/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.persistence;

/*
 * Clase para la Factory del CSVPersistence
 */
public class CSVPersistenceFactory implements PersistenceFactory {

	/*
	 * Instancia para el Singleton.
	 */
	private static CSVPersistenceFactory instance;
	
	/*
	 * Método para obtener la instancia de CSVPersistenceFactory.
	 * 
	 * @return: instancia de CSVPersistenceFactory.
	 */
	public static CSVPersistenceFactory getInstance() {
		if (instance == null)
			instance = new CSVPersistenceFactory();
		return instance;
	}
	
	/*
	 * Constructor privado para el Singleton.
	 */
	private CSVPersistenceFactory() {
		
	}
	
	@Override
	public Persistence getPersistence() {
		return new CSVPersistence();
	}

}
