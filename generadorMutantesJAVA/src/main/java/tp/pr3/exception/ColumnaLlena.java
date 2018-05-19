package tp.pr3.exception;

@SuppressWarnings("serial")
public class ColumnaLlena extends MovimientoInvalido{
	public ColumnaLlena (){super();}
	public ColumnaLlena(String message){
		super(message);
	}
}
