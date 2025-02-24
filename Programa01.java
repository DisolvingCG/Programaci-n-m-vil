package programacionmovil;

//Daniel Cortes Gonzalez

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Programa01 extends JFrame implements ActionListener{
    JTextField texto, textodado;
    JButton btnSaludar;
    public Programa01 (){
        setSize(400,400);
        setTitle("Programa 1");
        setDefaultCloseOperation(3);
        
        texto = new JTextField("tu nombre:");
        btnSaludar = new JButton("Saludar");
        btnSaludar.addActionListener(this);
        
        textodado = new JTextField();
        
        add(texto, BorderLayout.NORTH);
        add(btnSaludar, BorderLayout.SOUTH);
        add(textodado, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textodado.setText(texto.getText());
    }
}
