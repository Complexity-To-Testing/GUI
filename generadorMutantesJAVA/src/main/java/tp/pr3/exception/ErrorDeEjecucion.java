package tp.pr3.exception;

public class ErrorDeEjecucion extends Throwable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4533025273538515170L;
	public ErrorDeEjecucion (){super();}
	public ErrorDeEjecucion(String message){
		super(message);
	}
}
