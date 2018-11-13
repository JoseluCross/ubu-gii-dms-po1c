package persistence;

public class PersistenceException extends Exception {

	public PersistenceException(String string) {
		super(string);
	}
	
	public PersistenceException(String s, Throwable t) {
		super(s, t);
	}
	
	public PersistenceException() {
		super();
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5245700347051184568L;

}
