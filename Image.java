import java.rmi.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.Random;
import javax.imageio.*;
import javax.swing.*;

//! Classe Image
/*!
    Chamada na classe Cliente,
    classe que carrega dados da imagem e
    é enviada para o servidor
*/

public class Image implements Serializable{
    
    int width;
    int height;
    int[] pixels;
        
    //! inicializa altura e largura
    public Image(BufferedImage buf){
        width = buf.getWidth();
        height = buf.getHeight();
        pixels = new int[width*height];
        int[] tmp = buf.getRGB(0, 0, width, height, pixels, 0, width);
            
        System.out.println("Altura da imagem: "+buf.getHeight());
        System.out.println("Largura da imagem: "+buf.getWidth());
    }
        
    //! Retorna dados da imagem lida, a imagem inteira
    public BufferedImage getImage(){
        BufferedImage b = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
        b.setRGB(0, 0, width, height, pixels, 0, width);
            
       return b;
     }
}
