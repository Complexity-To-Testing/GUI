package tp.pr3.exception;


@SuppressWarnings("serial")
public class DatosIncorrectos extends Throwable{
	public DatosIncorrectos (){super();}
	public DatosIncorrectos(String message){
		super(message);
	}
}
