import java.rmi.Naming;

//! Classe de ServidorPrincipal
/*!
    Estabelece URL, conexão
*/

public class ServidorPrincipal {
	public ServidorPrincipal() {
		try {
			Servidor m = new ServidorImpl();
			Naming.rebind("rmi://localhost:1099/Servidor", m);
		} catch( Exception e ) {
			System.out.println( "Trouble: " + e );
		}
		}
	
	public static void main(String[] args) {
		new ServidorPrincipal();
	}
}

