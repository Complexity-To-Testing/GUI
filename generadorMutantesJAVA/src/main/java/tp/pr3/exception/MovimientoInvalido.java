package tp.pr3.exception;

@SuppressWarnings("serial")
public class MovimientoInvalido  extends Throwable{
	public MovimientoInvalido (){super();}
	public MovimientoInvalido(String message){
		super(message);
	}
}
