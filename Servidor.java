import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;
//! Classe de Servidor
/*!
    Classe de interface Servidor
*/

public interface Servidor extends Remote {
	public Image Converter(Image c)
		throws RemoteException;
        
        public String heartbeat() throws RemoteException;
}


