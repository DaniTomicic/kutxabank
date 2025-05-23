package V;

import C.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Login extends JFrame {

    private JPanel pPrincipal;
    private JPanel pDatos;
    private JPanel pNumeros;
    private JButton b10;
    private JButton b9;
    private JButton b8;
    private JButton b7;
    private JButton b6;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b5;
    private JButton b4;
    private JButton bAcceder;
    private JTextField tfUsuario;
    private JTextField tfClave;
    private VistaController vistaController;
    String clave = "";

    public Login(VistaController vistaController) {
        generarNumeros();
        setContentPane(pPrincipal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(this.getParent());
        setVisible(true);
        this.vistaController = vistaController;

        //inicializacion y ActionListeer de botones
        b1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               ponerNumero(b1);
           }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ponerNumero(b2);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ponerNumero(b3);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ponerNumero(b4);
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ponerNumero(b5);
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ponerNumero(b6);
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ponerNumero(b7);
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ponerNumero(b8);
            }
        });
        b9.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
               ponerNumero(b9);
           }
        });
        b10.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               ponerNumero(b10);
           }
        });

        bAcceder.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
               onOk();
           }
        });

    }
    private void onOk(){
        if (vistaController.buscarUsuario(tfUsuario.getText())){
            //en caso de true, miramos password
            if (vistaController.comprobarContrasenna(clave)){
                //en caso de true, generamos el panel usuario
                vistaController.setPanelCuentas();
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this,"Contraseña incorrecta");
                tfClave.setText("");
            }
        }else {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado");
        }
    }

    private void generarNumeros() {
        List<String> numeros = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            numeros.add(String.valueOf(i));
        }
        Collections.shuffle(numeros);

        JButton[] botones = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10};
        for (int i = 0; i < botones.length; i++) {
            String numero = numeros.get(i); // Variable final para usar en el listener
            botones[i].setText(numero);
        }
    }
    public void ponerNumero(JButton boton) {
        tfClave.setText(tfClave.getText()+"*");
        clave+=boton.getText();
    }
}
