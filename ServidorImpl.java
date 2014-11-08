import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
//! Classe de ServidorImpl
/*!
    Possui método Converter()
*/
public class ServidorImpl extends UnicastRemoteObject implements Servidor {
	public ServidorImpl() throws RemoteException {
		super();
	}
	
        //! Converte imagem para tons de cinza
	public Image Converter(Image c) throws RemoteException {
            //! objeto buf
            /*!
                objeto recebe imagem de c.getImage
            */ 
            BufferedImage buf = c.getImage();
            
            //! Conversão para tom de cinza
            /*!
                cria novas cor (vermelho, azul, verde) 
                dos pixels da imagem e converte para 
                tom de cinza cada pixel com novo inteiro
                gray, recebendo (red+green+blue)/3
            */ 
            for(int x=0;x<buf.getWidth();x++){
                for(int y=0;y<buf.getHeight();y++){
                    int red = new Color(buf.getRGB(x, y)).getRed();
                    int green = new Color(buf.getRGB(x, y)).getGreen();
                    int blue = new Color(buf.getRGB(x, y)).getBlue();
                    
                    int gray = (red+green+blue)/3;
                    int newColor = new Color(gray,gray,gray).getRGB();
                    
                    buf.setRGB(x, y, newColor);
                }
            }
            
            //! Nova imagem
            /*!
                retorna nova imagem formada em tom de cinza
            */ 
            Image imagem = new Image(buf);
            
            return imagem;
        }
        
        public String heartbeat() throws RemoteException
        {
            return "oi";
        }
        
}

