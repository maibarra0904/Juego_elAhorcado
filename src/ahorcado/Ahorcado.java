/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ahorcado;

import java.applet.Applet;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowFocusListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


/**
 *
 * @author mario
 */

public class Ahorcado {

    /**
     * @param args the command line arguments
     */
    static  Interfaz ventana = new Interfaz();
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        //ventana.setIconImage(ImageIO.read(new File("juego.gif")));
        ventana.setVisible(true); // Hace visible la ventana
        //ventana.setIconImage("juego.gif");
        //ventana.setLocationRelativeTo(null);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    
    
}



class Interfaz extends JFrame {
    
    GridBagLayout gridbag = new GridBagLayout();
    
    Toolkit pantalla = Toolkit.getDefaultToolkit();
    Dimension tamano_p = pantalla.getScreenSize();
    JLabel mensajes = new JLabel("",JLabel.CENTER);
    Label mensajes2 = new Label();
    JButton boton = new JButton();
    TextField caja = new TextField(12);
    JLabel reloj = new JLabel("",JLabel.CENTER);
    JLabel grafico = new JLabel("",JLabel.CENTER);
    presiona_enter_inicio inicio2;
    ImageIcon icon;
    
    public Interfaz(){
        
         // Llama a todas las caracteristicas de la ventana
         // Llama a las caracteristicas generales de la pantalla
        int altura_p = tamano_p.height; // llama la altura de la pantalla de la pc
        int ancho_p = tamano_p.width; // llama el ancho de la pantalla de la pc
        
        Image miIcono = pantalla.getImage("juego.gif");
        setIconImage(miIcono);
        setSize(ancho_p/2, altura_p/2);
        setTitle("Juego: El Ahorcado");
        
        
        
        GridBagConstraints constraints = new GridBagConstraints();
        
        
        setLayout( gridbag );
        mensajes.setText("Ingrese la palabra secreta:");
        mensajes2.setText("");
        boton.setText("Registrar");
        
        
        boton.addActionListener(new inicio());
        
        
        
        icon = new ImageIcon("Ahorcado0.png");
        grafico.setIcon(icon);
        
        //addComponente( new Imagenes(),0,0,2,2,GridBagConstraints.BOTH ,GridBagConstraints.CENTER);
        //addComponente( imagen,0,5,2,3,GridBagConstraints.BOTH ,GridBagConstraints.CENTER);//
        addComponente( grafico,0,1,1,1,GridBagConstraints.BOTH ,GridBagConstraints.CENTER);
        //addComponente( new Label( "Nombre:" ),0,5,1,1,GridBagConstraints.NONE ,GridBagConstraints.CENTER );
        //addComponente( new TextField( 12 ),0,6,1,1,GridBagConstraints.NONE ,GridBagConstraints.CENTER );
        //addComponente( new Label( "Nombre:" ),0,7,1,1,GridBagConstraints.NONE ,GridBagConstraints.CENTER );
        addComponente( mensajes,0,2,1,1,GridBagConstraints.NONE ,GridBagConstraints.CENTER );
        addComponente( caja,0,3,1,1,GridBagConstraints.NONE ,GridBagConstraints.CENTER );
        addComponente( mensajes2,0,4,1,1,GridBagConstraints.NONE ,GridBagConstraints.CENTER );
        addComponente( boton,0,5,1,1,GridBagConstraints.NONE ,GridBagConstraints.CENTER );
        addComponente( reloj,0,6,1,1,GridBagConstraints.NONE ,GridBagConstraints.NORTH );

        //addComponente( new Checkbox( "Sí?" ),0,4,1,1,GridBagConstraints.NONE ,GridBagConstraints.CENTER );
        //addComponente( new List(),0,8,1,1,GridBagConstraints.NONE ,GridBagConstraints.CENTER );
        
        inicio2 = new presiona_enter_inicio();
        
        caja.addKeyListener(inicio2);
        
        
        
    }
    
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("ss");
    long segundo_fijo;
    long lapso;
    boolean parar;
    
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            segundo_fijo = System.currentTimeMillis();
            parar=false;
            while (true) {
            try {
                while(deletreo.equals(deletreo_mod)==false && contador<6){
                    Thread.sleep(500);
                    long segundo_actual = System.currentTimeMillis();
                    lapso = 10-((segundo_actual - segundo_fijo)/1000);
                    reloj.setForeground(Color.red);
                    reloj.setText("Restan: "+String.valueOf(lapso)+" seg");
                    if (contador==5) {
                        reloj.setText("");
                    }
                    if (lapso==0) {
                        segundo_fijo = System.currentTimeMillis();
                        contador++;
                        cambia_imagen();
                        if (contador==5) {
                            
                            JFrame emergente = new JFrame();
                            JOptionPane.showMessageDialog(emergente, "Perdiste");
                            Ahorcado.ventana.dispose();
                            System.exit(0);
                        }
                        else {mensajes.setText("Llevas: "+contador+" intento(s) de 5");}
                    }   
                }
                
                
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
        
    };
    
    public void cambia_imagen (){
        if (contador==1){
            ImageIcon icon1 = new ImageIcon("Ahorcado1.png");
            grafico.setIcon(icon1);
        }
        else if (contador==2){
            ImageIcon icon2 = new ImageIcon("Ahorcado2.png");
            grafico.setIcon(icon2);
        }
        else if (contador==3){
            ImageIcon icon3 = new ImageIcon("Ahorcado3.png");
            grafico.setIcon(icon3);
        }
        else if (contador==4){
            ImageIcon icon4 = new ImageIcon("Ahorcado4.png");
            grafico.setIcon(icon4);
        }
        else if (contador==5){
            ImageIcon icon5 = new ImageIcon("Ahorcado5.png");
            grafico.setIcon(icon5);
        }
    }
    void addComponente( Component comp,int gridx,int gridy,
        int gridw,int gridh , int fill, int anch) {
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridw;
        gbc.gridheight = gridh;
        gbc.fill = fill;
        gbc.anchor = anch;
        gbc.insets = new Insets(10,10,10,10);
        gridbag.setConstraints( comp,gbc );
        add( comp );
        }
    
    Thread hilo = new Thread(runnable);
    
    void accion_inicio() {
        
        boton.setText("Probar");
        palabra = caja.getText();

        for (int h=0; h<palabra.length();h++){
            deletreo.add(palabra.charAt(h));
        }

        for (int h=0; h<palabra.length();h++){
            deletreo_mod.add("*".charAt(0));


        }
        caja.removeKeyListener(inicio2);
        caja.addKeyListener(new validacion());
        caja.addKeyListener(new presiona_enter());
        caja.setText("");
        
        
        //caja.setSize(1,1);
        mensajes.setText("Pruebe con una letra:");
        
        boton.addActionListener(new intento());
        mensajes2.setText(deletreo_mod.toString());
        
        
        segundo_fijo = System.currentTimeMillis();
        
        hilo.start();
        
        caja.requestFocus();
       
        
    }
    
    String palabra;
    java.util.List<Character> deletreo = new ArrayList();
    java.util.List<Character> deletreo_mod = new ArrayList();

    void setIconImage(String juegogif) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public class inicio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
                accion_inicio();
                
                
            }
            
 
    }
    
    void intentar() {
        
        segundo_fijo = System.currentTimeMillis();
        
        if (deletreo.contains(caja.getText().charAt(0))) {
            for (int i=0;i<deletreo.size();i++) {
                if (caja.getText().charAt(0)==deletreo.get(i)){
                        //deletreo_mod.remove(i);
                        deletreo_mod.set(i, caja.getText().charAt(0));

                    }
            }
        }
        
        else {
            contador++;
            mensajes.setText("Llevas: "+contador+" intento(s) de 5");
            
        }
        System.out.println(deletreo);
        System.out.println(deletreo_mod);
        System.out.println(deletreo.equals(deletreo_mod));
        mensajes2.setText(deletreo_mod.toString());
        caja.setText("");
        caja.requestFocus();
        
        
        //caja.setSize(1,1);
        if (contador==5) {
                
                ImageIcon icon5 = new ImageIcon("Ahorcado5.png");
                grafico.setIcon(icon5);
                
                JFrame emergente = new JFrame();
                JOptionPane.showMessageDialog(emergente, "Perdiste", "Mensaje", 0);
                Ahorcado.ventana.dispose();
                System.exit(0);
                
            }
            else if (contador<5) {
                if (deletreo.equals(deletreo_mod)) {
                    
                    
                    
                    JFrame emergente = new JFrame();
                    JOptionPane.showMessageDialog(emergente, "Ganaste");
                    
                    Ahorcado.ventana.dispose();
                    System.exit(0);
                }
                else {
                    cambia_imagen();
                }
            }
            segundo_fijo=System.currentTimeMillis();
        
}
    
    
    
    public class intento implements ActionListener {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            intentar();  
        }
        
        
    }
    
    
    
    
    int contador;
    
    public class validacion implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            
            if(caja.getText().length()>0){
                e.consume();
            }
            
            int key = e.getKeyChar();

            boolean mayusculas = key >= 65 && key <= 90;
            boolean minusculas = key >= 97 && key <= 122;
            boolean espacio = key == 32;

             if (!(minusculas || mayusculas || espacio))
            {
                e.consume();
            }
            
            
            }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
            
        }

        
        
    }
    
    public class presiona_enter implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                intentar();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
    }
    
    public class presiona_enter_inicio implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                accion_inicio();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
    }
}