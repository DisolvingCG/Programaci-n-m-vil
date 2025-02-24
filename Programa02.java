package programacionmovil;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * Cortes Gonzalez Daniel
 */
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * Cortes Gonzalez Daniel
 */
public class Programa02 extends JFrame implements ActionListener {
    JTextField pantalla;
    JButton botones[];
    String op1, op2;
    double resultado;
    boolean vsuma, vresta, vmultiplicacion, vdivision, vpunto;

    public Programa02() {
        setTitle("Casio");
        setSize(400, 600);
        setDefaultCloseOperation(3);
        setLayout(null);
        
        // Inicialización de la pantalla
        pantalla = new JTextField();
        pantalla.setBounds(1, 1, 380, 80);
        Font tipoLetra = new Font("Arial", Font.BOLD, 70);
        pantalla.setFont(tipoLetra);
        pantalla.disable();
        pantalla.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(pantalla);

        botones = new JButton[16]; // Se cambió de 13 a 16 para incluir todos los botones

        // Definir botones numéricos
        botones[0] = new JButton("0");
        botones[0].setBounds(1, 420, 80, 80);
        botones[0].setFont(tipoLetra);
        botones[0].addActionListener(this);
        add(botones[0]);

        int x = 1;
        int y = 320;
        int contColumnas = 1;

        for (int i = 1; i < 10; i++) {
            botones[i] = new JButton(i + "");
            botones[i].setBounds(x, y, 80, 80);
            botones[i].setFont(tipoLetra);
            botones[i].addActionListener(this);
            add(botones[i]);
            x = x + 100;
            contColumnas = contColumnas + 1;
            if (contColumnas == 4) {
                x = 1;
                y = y - 100;
                contColumnas = 1;
            }
        }

        // Botones de operaciones
        botones[10] = new JButton("+");
        botones[10].setBounds(301, 120, 80, 80);
        botones[10].setFont(tipoLetra);
        botones[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op1 = pantalla.getText();
                pantalla.setText("");
                vsuma = true;
                vpunto = true; // Permite usar el punto al iniciar una nueva operación
            }
        });
        add(botones[10]);

        botones[11] = new JButton("=");
        botones[11].setBounds(201, 420, 80, 80);
        botones[11].setFont(tipoLetra);
        botones[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op2 = pantalla.getText();
                if (vsuma) {
                    resultado = Double.parseDouble(op1) + Double.parseDouble(op2);
                    vsuma = false;
                }
                if (vresta) {
                    resultado = Double.parseDouble(op1) - Double.parseDouble(op2);
                    vresta = false;
                }
                if (vmultiplicacion) {
                    resultado = Double.parseDouble(op1) * Double.parseDouble(op2);
                    vmultiplicacion = false;
                }
                if (vdivision) {
                    resultado = Double.parseDouble(op1) / Double.parseDouble(op2);
                    vdivision = false;
                }
                pantalla.setText(resultado + "");
            }
        });
        add(botones[11]);

        botones[12] = new JButton("-");
        botones[12].setBounds(301, 220, 80, 80);
        botones[12].setFont(tipoLetra);
        botones[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op1 = pantalla.getText();
                pantalla.setText("");
                vresta = true;
                vpunto = true;
            }
        });
        add(botones[12]);

        botones[13] = new JButton(".");
        botones[13].setBounds(101, 420, 80, 80);
        botones[13].setFont(tipoLetra);
        botones[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vpunto) {
                    pantalla.setText(pantalla.getText() + ".");
                    vpunto = false; // Desactiva el punto después de usarlo
                }
            }
        });
        add(botones[13]);

        // Botón de multiplicación
        botones[14] = new JButton("*");
        botones[14].setBounds(301, 320, 80, 80);
        botones[14].setFont(tipoLetra);
        botones[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op1 = pantalla.getText();
                pantalla.setText("");
                vmultiplicacion = true;
                vpunto = true;
            }
        });
        add(botones[14]);

        // Botón de división
        botones[15] = new JButton("/");
        botones[15].setBounds(301, 420, 80, 80);
        botones[15].setFont(tipoLetra);
        botones[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op1 = pantalla.getText();
                pantalla.setText("");
                vdivision = true;
                vpunto = true;
            }
        });
        add(botones[15]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if ((comando.charAt(0) >= '0' && comando.charAt(0) <= '9')) {
            pantalla.setText(pantalla.getText() + comando);
        }
    }

    public static void main(String[] args) {
        Programa02 calc = new Programa02();
        calc.setVisible(true);
    }
}
