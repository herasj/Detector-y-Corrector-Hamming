/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rambal_bustillo;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Integer.toBinaryString;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.paint.Color;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.lang.Object;

/**
 *
 * @author Juan Pablo
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    File archivo;
    String linea = "0";

    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
        fr_deteccion.setLocationRelativeTo(null);
        fr_correccion.setLocationRelativeTo(null);
        bt_deteccion.setOpaque(false);
        bt_deteccion.setContentAreaFilled(false);
        bt_deteccion.setBorderPainted(false);
        bt_atras.setOpaque(false);
        bt_atras.setContentAreaFilled(false);
        bt_atras.setBorderPainted(false);
        bt_correccion.setOpaque(false);
        bt_correccion.setContentAreaFilled(false);
        bt_correccion.setBorderPainted(false);
        Atras_Dec.setOpaque(false);
        Atras_Dec.setContentAreaFilled(false);
        Atras_Dec.setBorderPainted(false);
        jLabelDec1.setVisible(false);
        jLabelDec2.setVisible(false);
        jButtonDec1.setVisible(false);
        jButtonDec2.setVisible(false);
        browseButoon.setOpaque(true);
        browseButoon.setBorderPainted(false);
        //browseButoon.setBackground(Color.AQUAMARINE);
        jButtonDec1.setOpaque(true);
        jButtonDec2.setOpaque(true);
    }

    public static String AsciiToBinary(String asciiString) {

        byte[] bytes = asciiString.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            // binary.append(' ');  
        }
        return binary.toString();
    }

    private static String asciiToHex(String asciiValue) {
        char[] chars = asciiValue.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }
        return hex.toString();
    }

    private static String hexToASCII(String hexValue) {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < hexValue.length() - 1; i += 2) {
            String str = hexValue.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
        return output.toString();
    }

    String[] hexToBin(String[] coso) {
        String[] coso2 = new String[coso.length];
        for (int i = 0; i < coso.length; i++) {
            coso2[i] = "";
            for (int j = 0; j < 2; j++) {
                switch (coso[i].substring(j, j + 1).toLowerCase()) {
                    case "0":
                        coso2[i] = coso2[i] + "0000";
                        break;
                    case "1":
                        coso2[i] = coso2[i] + "0001";
                        break;
                    case "2":
                        coso2[i] = coso2[i] + "0010";
                        break;
                    case "3":
                        coso2[i] = coso2[i] + "0011";
                        break;
                    case "4":
                        coso2[i] = coso2[i] + "0100";
                        break;
                    case "5":
                        coso2[i] = coso2[i] + "0101";
                        break;
                    case "6":
                        coso2[i] = coso2[i] + "0110";
                        break;
                    case "7":
                        coso2[i] = coso2[i] + "0111";
                        break;
                    case "8":
                        coso2[i] = coso2[i] + "1000";
                        break;
                    case "9":
                        coso2[i] = coso2[i] + "1001";
                        break;
                    case "a":
                        coso2[i] = coso2[i] + "1010";
                        break;
                    case "b":
                        coso2[i] = coso2[i] + "1011";
                        break;
                    case "c":
                        coso2[i] = coso2[i] + "1100";
                        break;
                    case "d":
                        coso2[i] = coso2[i] + "1101";
                        break;
                    case "e":
                        coso2[i] = coso2[i] + "1110";
                        break;
                    case "f":
                        coso2[i] = coso2[i] + "1111";
                        break;
                }
            }
        }
        return coso2;
    }

    String[] binToHex(String[] coso) {
        String[] coso2 = new String[coso.length];
        for (int i = 0; i < coso.length; i++) {
            coso2[i] = "";
            for (int j = 0; j < 2; j++) {
                switch (coso[i].substring(4 * j, 4 * j + 4).toLowerCase()) {
                    case "0000":
                        coso2[i] = coso2[i] + "0";
                        break;
                    case "0001":
                        coso2[i] = coso2[i] + "1";
                        break;
                    case "0010":
                        coso2[i] = coso2[i] + "2";
                        break;
                    case "0011":
                        coso2[i] = coso2[i] + "3";
                        break;
                    case "0100":
                        coso2[i] = coso2[i] + "4";
                        break;
                    case "0101":
                        coso2[i] = coso2[i] + "5";
                        break;
                    case "0110":
                        coso2[i] = coso2[i] + "6";
                        break;
                    case "0111":
                        coso2[i] = coso2[i] + "7";
                        break;
                    case "1000":
                        coso2[i] = coso2[i] + "8";
                        break;
                    case "1001":
                        coso2[i] = coso2[i] + "9";
                        break;
                    case "1010":
                        coso2[i] = coso2[i] + "a";
                        break;
                    case "1011":
                        coso2[i] = coso2[i] + "b";
                        break;
                    case "1100":
                        coso2[i] = coso2[i] + "c";
                        break;
                    case "1101":
                        coso2[i] = coso2[i] + "d";
                        break;
                    case "1110":
                        coso2[i] = coso2[i] + "e";
                        break;
                    case "1111":
                        coso2[i] = coso2[i] + "f";
                        break;
                }
            }
        }
        return coso2;
    }

    private void crearArchivo(String FILE, String[] salida, int t) {
        if (FILE.equals("")) {
            FILE = "salida.txt";
        }
        String[] file = FILE.split(".txt");
        try {
            PrintWriter writer = null;
            if (t == 1) {
                writer = new PrintWriter(archivo.getPath().substring(0, archivo.getPath().length() - archivo.getName().length()) + file[0] + ".btp", "UTF-8");
            } else {
                if (t == 0) {
                    writer = new PrintWriter(archivo.getPath().substring(0, archivo.getPath().length() - archivo.getName().length()) + FILE, "UTF-8");
                } else {
                    if (t == 2) {
                        writer = new PrintWriter(archivo.getPath().substring(0, archivo.getPath().length() - archivo.getName().length()) + file[0] + ".ham", "UTF-8");
                    }
                    else
                    {
                    if (t == 3) {
                        file = FILE.split(".ham");
                        writer = new PrintWriter(archivo.getPath().substring(0, archivo.getPath().length() - archivo.getName().length()) + file[0] + ".txt", "ISO-8859-1");
                    }
                    }
                }
            }
            int i = 0;
            while (i < salida.length) {
                String s = salida[i];
                writer.println(s);
                i++;
            }
            writer.close();
        } catch (IOException e) {
        }
    }

    String[] agregarParidad(String[] coso) {
        int par = 0;
        String[] coso2 = new String[coso.length];
        for (int i = 0; i < coso.length; i++) {
            coso2[i] = coso[i];
            for (int j = 0; j < coso[i].length(); j++) {
                if (coso[i].substring(j, j + 1).equals("1")) {
                    par++;
                }
            }
            if (par % 2 == 0) {
                coso2[i] = coso2[i] + "0";
            } else {
                coso2[i] = coso2[i] + "1";
            }
            par = 0;
        }
        return coso2;
    }

    char Operacion(int[] indices, String PalCod) {
        int suma = 0;
        for (int i = 0; i < indices.length; i++) {
            suma = suma + Integer.parseInt(PalCod.substring(21 - indices[i], 22 - indices[i]));
        }
        suma = suma % 2;

        if (suma == 0) {
            return '0';
        } else {
            return '1';
        }

    }

    String XOR(String PalCod, int indice) {
        char Paridad = 'E';
        int[] xor1 = {3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
        int[] xor2 = {6, 3, 7, 10, 11, 14, 15, 18, 19};
        int[] xor4 = {5, 6, 7, 12, 13, 14, 15, 20, 21};
        int[] xor8 = {9, 10, 11, 12, 13, 14, 15};
        int[] xor16 = {17, 18, 19, 20, 21};
        switch (indice) {
            case 1:
                Paridad = Operacion(xor1, PalCod);
                break;
            case 2:
                Paridad = Operacion(xor2, PalCod);
                break;
            case 4:
                Paridad = Operacion(xor4, PalCod);
                break;
            case 8:
                Paridad = Operacion(xor8, PalCod);
                break;
            case 16:
                Paridad = Operacion(xor16, PalCod);
                break;

        }
        StringBuilder Retorno = new StringBuilder(PalCod);
        // System.out.println("El bit a reemplazar es el "+(21-indice)+" con la paridad "+Paridad);
        Retorno.setCharAt(21 - indice, Paridad);
        return Retorno.toString();
    }

    String ExtraerParidades(String PalCod) {
         char correccion='E';
         int decimal=0;
        char Paridad[] = new char[6];
        int Errores[] = new int[6];
        StringBuilder Retorno = new StringBuilder(PalCod);
        int[] xor1 = {3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
        int[] xor2 = {6, 3, 7, 10, 11, 14, 15, 18, 19};
        int[] xor4 = {5, 6, 7, 12, 13, 14, 15, 20, 21};
        int[] xor8 = {9, 10, 11, 12, 13, 14, 15};
        int[] xor16 = {17, 18, 19, 20, 21};

        Paridad[1] = Operacion(xor1, PalCod);

        Paridad[2] = Operacion(xor2, PalCod);

        Paridad[3] = Operacion(xor4, PalCod);

        Paridad[4] = Operacion(xor8, PalCod);

        Paridad[5] = Operacion(xor16, PalCod);

        if (Paridad[1] == PalCod.charAt(20)) {
            Errores[1] = 0;
        }
            else{
                    Errores[1]=1;
                    }
        
        if (Paridad[2] == PalCod.charAt(19)) {
            Errores[2] = 0;
        }
            else{
                    Errores[2]=1;
                    }
        
        if (Paridad[3] == PalCod.charAt(17)) {
            Errores[3] = 0;
        }
            else{
                    Errores[3]=1;
                    }
        
        if (Paridad[4] == PalCod.charAt(13)) {
            Errores[4] = 0;
        }
            else{
                    Errores[4]=1;
                    }
        
        if (Paridad[5] == PalCod.charAt(5)) {
            Errores[5] = 0;
        }
            else{
                    Errores[5]=1;
                    }
        
        if (Errores[1]==0 && Errores[2]==0 && Errores[3]==0 && Errores[4]==0 && Errores[5]==0){
            System.out.println("Sin errores");
        }
        else
        {
           
            //JOptionPane.showMessageDialog(null, "Se encontro un error, se corregirá inmediatamente", "Error detectado", JOptionPane.ERROR_MESSAGE);
        String str=Integer.toString(Errores[5])+Integer.toString(+Errores[4])+Integer.toString(Errores[3])+Integer.toString(Errores[2])+Integer.toString(Errores[1]);
            System.out.println("Err: "+str);
        
        decimal=Integer.parseInt(str,2);  

            System.out.println("Error en la pos "+ decimal);
            if(PalCod.charAt(21-decimal)=='0'){
            correccion='1';
            }
            else{
                    correccion='0';
                    }
            Retorno.setCharAt(21-decimal,correccion);
            }
            

    return Retorno.toString ();
}
Boolean VerificarPotencia(int num) {
        double Res;
        Res = Math.log10(num) / Math.log10(2);
        if (Res % 1 == 0) {
            return true;
        } else {
            return false;
        }
    }

    int Indice(int num) {
        double Res = Math.log10(num) / Math.log10(2);
        return ((int) Math.round(Res));

    }

    int verificarParidad(String[] coso) {
        int errores = 0;
        int par = 0;
        String[] coso2 = new String[coso.length];
        for (int i = 0; i < coso.length; i++) {
            coso2[i] = coso[i];
            for (int j = 0; j < coso[i].length() - 1; j++) {
                if (coso[i].substring(j, j + 1).equals("1")) {
                    par++;
                }
            }
            if (par % 2 != Integer.parseInt(coso2[i].substring(8, 9))) {
                errores++;
            }
            par = 0;
        }
        return errores;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fr_deteccion = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelDec1 = new javax.swing.JLabel();
        jLabelDec2 = new javax.swing.JLabel();
        entradaTextField = new javax.swing.JTextField();
        browseButoon = new javax.swing.JButton();
        salidaTextField = new javax.swing.JTextField();
        jButtonDec2 = new javax.swing.JButton();
        jButtonDec1 = new javax.swing.JButton();
        Atras_Dec = new javax.swing.JButton();
        Back = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fr_correccion = new javax.swing.JFrame();
        bt_corr = new javax.swing.JButton();
        generarham = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bt_corregir = new javax.swing.JButton();
        bt_atras = new javax.swing.JButton();
        Co_atras = new javax.swing.JLabel();
        Bg_Co = new javax.swing.JLabel();
        FileChooser1 = new javax.swing.JFileChooser();
        bt_correccion = new javax.swing.JButton();
        bt_deteccion = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        fr_deteccion.setMaximumSize(new java.awt.Dimension(420, 215));
        fr_deteccion.setMinimumSize(new java.awt.Dimension(420, 215));
        fr_deteccion.setPreferredSize(new java.awt.Dimension(420, 215));
        fr_deteccion.setResizable(false);
        fr_deteccion.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Archivo de entrada :");
        fr_deteccion.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Archivo de salida :");
        fr_deteccion.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabelDec1.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabelDec1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDec1.setText("Enviar paridad :");
        fr_deteccion.getContentPane().add(jLabelDec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabelDec2.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabelDec2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDec2.setText("Recepción :");
        fr_deteccion.getContentPane().add(jLabelDec2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        entradaTextField.setBackground(new java.awt.Color(0, 152, 166));
        entradaTextField.setForeground(new java.awt.Color(255, 255, 255));
        entradaTextField.setText("NULL");
        entradaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaTextFieldActionPerformed(evt);
            }
        });
        fr_deteccion.getContentPane().add(entradaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 120, -1));

        browseButoon.setBackground(new java.awt.Color(0, 204, 204));
        browseButoon.setForeground(new java.awt.Color(255, 255, 255));
        browseButoon.setText("Examinar");
        browseButoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButoonActionPerformed(evt);
            }
        });
        fr_deteccion.getContentPane().add(browseButoon, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        salidaTextField.setBackground(new java.awt.Color(0, 152, 166));
        salidaTextField.setForeground(new java.awt.Color(255, 255, 255));
        salidaTextField.setText("NULL");
        salidaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salidaTextFieldActionPerformed(evt);
            }
        });
        fr_deteccion.getContentPane().add(salidaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 120, -1));

        jButtonDec2.setBackground(new java.awt.Color(79, 194, 248));
        jButtonDec2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDec2.setText("Aceptar");
        jButtonDec2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDec2ActionPerformed(evt);
            }
        });
        fr_deteccion.getContentPane().add(jButtonDec2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        jButtonDec1.setBackground(new java.awt.Color(79, 194, 248));
        jButtonDec1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDec1.setText("Aceptar");
        jButtonDec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDec1ActionPerformed(evt);
            }
        });
        fr_deteccion.getContentPane().add(jButtonDec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        Atras_Dec.setBorderPainted(false);
        Atras_Dec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Atras_DecActionPerformed(evt);
            }
        });
        fr_deteccion.getContentPane().add(Atras_Dec, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Back.png"))); // NOI18N
        fr_deteccion.getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Background_C.png"))); // NOI18N
        fr_deteccion.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 220));

        fr_correccion.setMaximumSize(new java.awt.Dimension(455, 204));
        fr_correccion.setMinimumSize(new java.awt.Dimension(455, 204));
        fr_correccion.setPreferredSize(new java.awt.Dimension(455, 204));
        fr_correccion.setResizable(false);
        fr_correccion.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_corr.setBackground(new java.awt.Color(0, 102, 102));
        bt_corr.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        bt_corr.setForeground(new java.awt.Color(255, 255, 255));
        bt_corr.setText("Examinar, corregir y generar .txt");
        bt_corr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_corrActionPerformed(evt);
            }
        });
        fr_correccion.getContentPane().add(bt_corr, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 240, -1));

        generarham.setBackground(new java.awt.Color(51, 51, 51));
        generarham.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        generarham.setForeground(new java.awt.Color(255, 255, 255));
        generarham.setText("Examinar y generar .ham");
        generarham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarhamActionPerformed(evt);
            }
        });
        fr_correccion.getContentPane().add(generarham, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 240, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Archivo de entrada .txt");
        fr_correccion.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Archivo de entrada .ham");
        fr_correccion.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        bt_corregir.setBackground(new java.awt.Color(51, 51, 51));
        bt_corregir.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        bt_corregir.setForeground(new java.awt.Color(255, 255, 255));
        bt_corregir.setText("Corregir");
        bt_corregir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_corregirActionPerformed(evt);
            }
        });
        fr_correccion.getContentPane().add(bt_corregir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 110, -1));

        bt_atras.setBackground(new java.awt.Color(51, 51, 51));
        bt_atras.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        bt_atras.setForeground(new java.awt.Color(255, 255, 255));
        bt_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_atrasActionPerformed(evt);
            }
        });
        fr_correccion.getContentPane().add(bt_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        Co_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Back.png"))); // NOI18N
        fr_correccion.getContentPane().add(Co_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Bg_Co.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Background_CO.png"))); // NOI18N
        fr_correccion.getContentPane().add(Bg_Co, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_correccion.setEnabled(false);
        bt_correccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_correccionMouseClicked(evt);
            }
        });
        bt_correccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_correccionActionPerformed(evt);
            }
        });
        getContentPane().add(bt_correccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 130, 120));

        bt_deteccion.setBorderPainted(false);
        bt_deteccion.setEnabled(false);
        bt_deteccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_deteccionMouseClicked(evt);
            }
        });
        bt_deteccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deteccionActionPerformed(evt);
            }
        });
        getContentPane().add(bt_deteccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 130, 120));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Background_P.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_deteccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deteccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_deteccionActionPerformed

    private void bt_deteccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_deteccionMouseClicked
        this.setVisible(false);
        fr_deteccion.setVisible(true);
    }//GEN-LAST:event_bt_deteccionMouseClicked

    private void bt_correccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_correccionMouseClicked
        this.setVisible(false);
        fr_correccion.setVisible(true);
    }//GEN-LAST:event_bt_correccionMouseClicked

    private void entradaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entradaTextFieldActionPerformed

    private void salidaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salidaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salidaTextFieldActionPerformed

    private void jButtonDec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDec1ActionPerformed
        
        try {
            Scanner leer = new Scanner(archivo);
            while (leer.hasNext()) {
                linea = leer.nextLine();
            }
        } catch (Exception e) {
        }
        linea = asciiToHex(linea);
        int i = 0;
        String[] texto = new String[linea.length() / 2];
        String[] texto2 = new String[linea.length() / 2];
        String[] texto3 = new String[linea.length() / 2];
        while (i < linea.length()) {
            texto[i / 2] = linea.substring(i, i + 2);
            i = i + 2;
        }
        texto2 = hexToBin(texto);
        texto3 = agregarParidad(texto2);
        crearArchivo(archivo.getName(), texto3, 1);
        JOptionPane.showMessageDialog(null, "Todo codificado correctamente.");
    }//GEN-LAST:event_jButtonDec1ActionPerformed

    private void browseButoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButoonActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".txt, .btp", "txt", "btp");
        FileChooserl.setFileFilter(filtro);

        int opcion = FileChooser1.showOpenDialog(this);

        if (opcion == JFileChooser.APPROVE_OPTION) {
            archivo = FileChooser1.getSelectedFile();
            entradaTextField.setText(archivo.getAbsolutePath());
            jLabelDec1.setVisible(true);
            jLabelDec2.setVisible(true);
            jButtonDec1.setVisible(true);
            jButtonDec2.setVisible(true);
        }
    }//GEN-LAST:event_browseButoonActionPerformed

    private void jButtonDec2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDec2ActionPerformed
        File salida = new File(archivo.getPath().substring(0, archivo.getPath().length() - 4) + ".btp");
        String[] texto = new String[(int) salida.length() / (9 + 2)];
        int i = 0;
        try {
            Scanner leer = new Scanner(salida);
            while (leer.hasNext()) {
                texto[i] = leer.next();
                i++;
            }
        } catch (Exception e) {
        }
        int error = verificarParidad(texto);
        texto = binToHex(texto);
        String[] hexa = new String[1];
        hexa[0] = "";
        for (int j = 0; j < texto.length; j++) {
            hexa[0] = hexa[0] + texto[j];
        }
        hexa[0] = hexToASCII(hexa[0]);
        salidaTextField.setText(archivo.getPath().substring(0, archivo.getPath().length() - archivo.getName().length()) + "salida.txt");
        crearArchivo("salida.txt", hexa, 0);
        if (error == 0) {
            JOptionPane.showMessageDialog(null, "No se detectaron errores.");
        } else if (error == 1) {
            JOptionPane.showMessageDialog(null, "Se detectó " + error + " error.");
        } else {
            JOptionPane.showMessageDialog(null, "Se detectaron " + error + " errores.");
        }
    }//GEN-LAST:event_jButtonDec2ActionPerformed

    private void Atras_DecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Atras_DecActionPerformed
        fr_deteccion.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_Atras_DecActionPerformed

    private void generarhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarhamActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".txt","txt");
        ArrayList<String> PalDat = new ArrayList<String>();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filtro);
        String linea="";
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        FileReader fr = null;
        BufferedReader br = null;
        if (result == JFileChooser.APPROVE_OPTION){
            try{
            archivo = fileChooser.getSelectedFile();
            fr = new FileReader(archivo);
            br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"ISO-8859-1"));
            //f.getAbsolutePath();Ruta
            String s;
         while((s=br.readLine())!=null){
           linea=s;
             System.out.println(s);
         }
         }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error en la seleccion de archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        
        System.out.println("Texto completo: "+linea);
        String linmod="";
        int longitud;
        if(linea.length()%2!=0)
            longitud=linea.length()-1;
        else
            longitud=linea.length();
        for (int j = 0; j < longitud; j=j+2) {            
            linmod=linea.substring(j,j+2);            
            System.out.println("conjunto de dos caracteres: "+linmod);
            linmod = asciiToHex(linmod);
            int i = 0;
            String[] texto = new String[linmod.length() / 2];
            String[] texto2 = new String[linmod.length() / 2];
            while (i < linmod.length()) {
                texto[i / 2] = linmod.substring(i, i + 2);
                i = i + 2;
        }
             texto2 = hexToBin(texto);
             String str="";
             for (int k = 0; k < texto2.length; k++) {
                str=str+texto2[k];
            }
             System.out.println("Binario: "+str);
             PalDat.add(str);
        }
        if (linea.length()%2!=0) {
            linmod=linea.substring(linea.length()-1);
            System.out.println("conjunto de dos caracteres: "+linmod);
            linmod = asciiToHex(linmod);
            int i = 0;
            String[] texto = new String[linmod.length() / 2];
            String[] texto2 = new String[linmod.length() / 2];
            while (i < linmod.length()) {
                texto[i / 2] = linmod.substring(i, i + 2);
                i = i + 2;
        }
             texto2 = hexToBin(texto);
             String str="";
             for (int k = 0; k < texto2.length; k++) {
                str=str+texto2[k];
            }             
             PalDat.add("00000000"+str);
             System.out.println("Binario: "+str);
            
        }
        System.out.println("");
        for (int j = 0; j < PalDat.size(); j++) {
           System.out.println(PalDat.get(j)); 
        }
        


        //Inicializar
        String [] PalCod= new String[PalDat.size()];
        for (int j = 0; j < PalCod.length; j++) {
           PalCod[j]="";
        }
        
        int indice=0;
        int indicetotal=0;
        for (int j = 0; j < PalDat.size(); j++) {
            while(indicetotal<21){
            if(indicetotal==5 || indicetotal==13 || indicetotal==17 || indicetotal==19 || indicetotal==20){
            PalCod[j]=PalCod[j]+"P";
            }
            else{
            PalCod[j]=PalCod[j]+PalDat.get(j).substring(indice, indice+1);
            indice++;
            }
            indicetotal++;
            }
            indice=0;
            indicetotal=0;
        }
        for (int j = 0; j < PalCod.length; j++) {
            
               PalCod[j]=XOR(PalCod[j],1);
               PalCod[j]=XOR(PalCod[j],2);
               PalCod[j]=XOR(PalCod[j],4);
               PalCod[j]=XOR(PalCod[j],8);
               PalCod[j]=XOR(PalCod[j],16);
            
            }
        System.out.println("");
        System.out.println("Pal Codigos");
        System.out.println("");
        for (int j = 0; j < PalCod.length; j++) {
            System.out.println(PalCod[j]);
        }
        crearArchivo(archivo.getName(),PalCod, 2);
        
        JOptionPane.showMessageDialog(null, "Se ha creado el archivo .ham exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_generarhamActionPerformed

    private void bt_corregirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_corregirActionPerformed
        try {
            Scanner leer = new Scanner(archivo);
            while (leer.hasNext()) {
                linea = leer.nextLine();
            }
        } catch (Exception e) {
        }
        linea = asciiToHex(linea);
        System.out.println("El texto: "+linea);
        int i = 0;
        String[] texto = new String[linea.length() / 2];
        String[] texto2 = new String[linea.length() / 2];
        while (i < linea.length()) {
            texto[i / 2] = linea.substring(i, i + 2);
            i = i + 2;
        }
        texto2 = hexToBin(texto);

        
        
    }//GEN-LAST:event_bt_corregirActionPerformed

    private void bt_corrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_corrActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".ham","ham");
        ArrayList<String> PalCod = new ArrayList<String>();
       // ArrayList<String> PalDat = new ArrayList<String>();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filtro);
        String linea="";
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        FileReader fr = null;
        BufferedReader br = null;
        if (result == JFileChooser.APPROVE_OPTION){
            try{
            archivo = fileChooser.getSelectedFile();
            fr = new FileReader(archivo);
            br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"ISO-8859-1"));
            //f.getAbsolutePath();Ruta
            String s;
         while((s=br.readLine())!=null){
            PalCod.add(s);
         }
         }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error en la seleccion de archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        //Comprobar y corregir
        for (int i = 0; i < PalCod.size(); i++) {
            PalCod.set(i, ExtraerParidades(PalCod.get(i)));
            
        }
        JOptionPane.showMessageDialog(null, "La correccion se ha completado satisfactoriamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        for (int i = 0; i < PalCod.size(); i++) {
            System.out.println(PalCod.get(i));
        }
        int cont=0;
        int datos=0;
        int indice=0;
        String[] PalDat= new String[PalCod.size()*2];
        String str="";
        for (int i = 0; i < PalCod.size(); i++) {
            while(datos<16){
                if (cont!=20 && cont!=5 && cont!=13 && cont!=17 && cont!=19) {
                    str+=PalCod.get(i).substring(cont,cont+1);
                    datos++;
                }
                if (datos==8) {
                    PalDat[indice]=str;
                    str=""; 
                    indice++;
                    }
                cont++;            
            }
            PalDat[indice]=str;
            indice++;
            str="";
            cont=0;datos=0;
        }
        System.out.println("PalDatos: ");
        for (int i = 0; i < PalDat.length; i++) {
            System.out.println(PalDat[i]);
        }
        String [] VectorBinario=new String [PalDat.length];
        for (int i = 0; i < PalDat.length; i++) {
            VectorBinario[i]=PalDat[i];
        }
        String [] VectorHex;
        System.out.println("Hex");
        VectorHex=binToHex(VectorBinario);
        for (int i = 0; i < VectorHex.length; i++) {
            System.out.println(VectorHex[i]);
        }
        str="";
        for (int i = 0; i < VectorHex.length; i++) {
            str+=hexToASCII(VectorHex[i]);
        }
        System.out.println("La frase final es:  "+str);
        JOptionPane.showMessageDialog(null, str, "Exito", JOptionPane.PLAIN_MESSAGE);
        String[] strvec=new String[1];
        strvec[0]=str;
        crearArchivo(archivo.getName(),strvec,3);
        
        JOptionPane.showMessageDialog(null, "Se ha creado el archivo .txt exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_bt_corrActionPerformed

    private void bt_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_atrasActionPerformed
        fr_correccion.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_bt_atrasActionPerformed

    private void bt_correccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_correccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_correccionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                

}
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras_Dec;
    private javax.swing.JLabel Back;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Bg_Co;
    private javax.swing.JLabel Co_atras;
    private javax.swing.JFileChooser FileChooser1;
    private javax.swing.JButton browseButoon;
    private javax.swing.JButton bt_atras;
    private javax.swing.JButton bt_corr;
    private javax.swing.JButton bt_correccion;
    private javax.swing.JButton bt_corregir;
    private javax.swing.JButton bt_deteccion;
    private javax.swing.JTextField entradaTextField;
    private javax.swing.JFrame fr_correccion;
    private javax.swing.JFrame fr_deteccion;
    private javax.swing.JButton generarham;
    private javax.swing.JButton jButtonDec1;
    private javax.swing.JButton jButtonDec2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelDec1;
    private javax.swing.JLabel jLabelDec2;
    private javax.swing.JTextField salidaTextField;
    // End of variables declaration//GEN-END:variables
}
