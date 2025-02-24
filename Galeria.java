package programacionmovil;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * Daniel Cortes Gonzalez
 */
public class Galeria extends JFrame implements ActionListener{
    PanelImagen pi; JPanel pbotones;
    JPanel pb;
    JButton btnAtras, btnAdelante;
    int contador = 1;
    String ImagenNueva;
    
    public Galeria(){
        setSize(400,400);
        setTitle("Imagenes");
        setDefaultCloseOperation(3);
        pi = new PanelImagen();
        ImagenNueva = "Gato" + contador + ".jpg";
        pi.ruta = ImagenNueva;
        pb = new JPanel();
        btnAtras = new JButton("atras");
        btnAdelante = new JButton("adelante");
        btnAtras.addActionListener(this);
        btnAdelante.addActionListener(this);
        pb.add(btnAtras);
        pb.add(btnAdelante);
        add(pi);
        add(pb, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        Galeria g = new Galeria();
        g.setVisible(true);
    }
    public void ActionPerformed(ActionEvent ade){
        if(ade.getSource().equals(btnAtras)){
            if(contador<=1){
                contador = 3;
            }else{
                contador = contador-1;
            }
        }
        if(ade.getSource().equals(btnAdelante)){
                        if(contador>=3){
                contador = 1;
            }else{
                contador = contador+1;
            }
        }
        System.out.println("contador"+contador);
        ImagenNueva = "Gato" + contador + ".jpg";
        pi.ruta = ImagenNueva;
        pi.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
