import java.rmi.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.Random;
import javax.imageio.*;
import javax.swing.*;

//! Classe de Cliente
/*!
    Realiza leitura de imagem colorida
*/

public class Cliente extends Component{
    BufferedImage img;
    
    //! Método teste
    public BufferedImage imagem(){
        try{
        return img = ImageIO.read(new File("Secret.jpg"));
        }catch(IOException e){
            System.out.println("Erro na leitura de imagem");
            return null;
        }
    }
    
    public Cliente(){//inicializar janela com imagem com tom de cinza salva
        try{
            img = ImageIO.read(new File("Secret.jpg"));
        }catch(Exception e){
            
        }
    }
    
    //! Main le a imagem e conecta com o servidor
    public static void main(String args[]) {
        try {
            File file = new File("Secret.jpg");
            FileInputStream fis = new FileInputStream(file);  
            BufferedImage image = ImageIO.read(fis);
                        
            int w = image.getWidth(); int h = image.getHeight();
                        
            int[] pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
            Color color = new Color(pixels[100]);
            //! objeto Servidor m
            /*!
                objeto para instanciar método Converter()
            */  
            boolean vivo = true;
	    Servidor m = (Servidor) Naming.lookup("rmi://localhost/Servidor");
            
            //! Chamada de método
            /*!
                objeto imcinza recebe nova imagem (tipo Image)
            */ 
            System.out.println("Chamar servidor: ");
            Image imcinza = m.Converter(new Image(image));//chamar servidor para converter para cinza
                        
            //! imcinza, novo objeto Image
            /*!
                salva nova imagem, convertida do pelo método do servidor
            */
            ImageIO.write(imcinza.getImage(), "JPG", new File("finalimage.jpg"));
            
            JFrame f = new JFrame("Nova imagem");//abrindo nova imagem salva em janela            
            JLabel picLabel;
            JPanel panel;
            
            panel = new JPanel();
            panel.setPreferredSize(new Dimension(imcinza.getImage().getWidth(), imcinza.getImage().getHeight()));
            
            picLabel = new JLabel(new ImageIcon(imcinza.getImage()));
            panel.add(picLabel);
            
            f.add(new JScrollPane(panel));
	    //f.pack();
            f.setVisible(true);
            f.setSize(imcinza.getImage().getWidth(), imcinza.getImage().getHeight());
            
            //f.add(new Cliente());
            //f.pack();
            //f.setVisible(true);
            while(true){
               System.out.println(m.heartbeat());
            }
	} catch (Exception e) {
            System.out.println("GenericException: " + e.toString());
	}
	}
}

