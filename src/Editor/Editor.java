package Editor;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.*;

public class Editor extends JFrame implements ActionListener {

    JTextArea Hoja;
    JTable tabla, linea1, linea2, linea3, linea4, linea5, fondo, regla, regla2;
    JToolBar barra;
    JButton btn1, btn2, btn3, N, K, S, A, peg, cor, cop;
    JLabel Portapapeles, Fuente, reglaText1, reglaText2;
    //Choice fuente, tamaño;
    JComboBox fuente, tamaño;
    JMenuBar menu;
    JMenu archivo;
    JMenuItem abrir, guardar, salir;

    Color color;

    public static void main(String[] args) {
        Editor objeto = new Editor();
        objeto.setVisible(true);
    }

    public Editor() {
        super();
        configurarVentana();
        inicializarComponentes();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    private void configurarVentana() {
        setTitle("Editor de Texto");
        setLayout(null);
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setSize(1280, 720);
        Container contenedor = getContentPane();
        contenedor.setBackground(new Color(201, 211, 227));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void inicializarComponentes() {

        menu = new JMenuBar();
        setJMenuBar(menu);
        archivo = new JMenu("Archivo");
        menu.add(archivo);
        abrir = new JMenuItem("Abrir");
        guardar = new JMenuItem("Guardar");
        salir = new JMenuItem("Salir");
        archivo.add(abrir);
        archivo.add(guardar);
        archivo.add(salir);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    String nombre = "";
                    JFileChooser file = new JFileChooser();
                    file.showSaveDialog(null);
                    File guarda = file.getSelectedFile();
                    if (guarda != null) {
                        FileWriter save = new FileWriter(guarda+".txt");
                        save.write(Hoja.getText());
                        save.close();
                        JOptionPane.showMessageDialog(null, "El archivo se a guardado Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        abrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String aux = "";
                String texto = "";
                try {
                    JFileChooser file = new JFileChooser();
                    file.showOpenDialog(null);
                    File abre = file.getSelectedFile();
                    if (abre != null) {
                        FileReader archivos = new FileReader(abre);
                        BufferedReader lee = new BufferedReader(archivos);
                        while ((aux = lee.readLine()) != null) {
                            texto += aux + "\n";
                        }
                        lee.close();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex + ""
                            + "\nNo se ha encontrado el archivo",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
                Hoja.setText(texto);
            }
        });

        N = new JButton("N");

        K = new JButton("K");
        S = new JButton("S");
        A = new JButton();
        A.setIcon(new ImageIcon(getClass().getResource("/Media/Color.png")));

        peg = new JButton();
        peg.setIcon(new ImageIcon(getClass().getResource("/Media/Pegar.png")));

        cor = new JButton();
        cor.setIcon(new ImageIcon(getClass().getResource("/Media/Cortar.png")));

        cop = new JButton();
        cop.setIcon(new ImageIcon(getClass().getResource("/Media/Copiar.png")));

        String[] fuentes = {"Arial", "ComicSansMS", "Impact"};
        String[] tamaños = {"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"};

        fuente = new JComboBox(fuentes);
        tamaño = new JComboBox(tamaños);

        //fuente = new Choice();
        //tamaño = new Choice();
        reglaText1 = new JLabel();
        reglaText2 = new JLabel();
        Portapapeles = new JLabel();
        Fuente = new JLabel();

        Hoja = new JTextArea();
        tabla = new JTable();
        linea1 = new JTable();
        linea2 = new JTable();
        linea3 = new JTable();
        linea4 = new JTable();
        linea5 = new JTable();
        regla = new JTable();
        regla2 = new JTable();

        fondo = new JTable();
        Hoja.setBounds(225, 150, 830, 900);

        regla = new JTable();

        tabla.setBounds(0, 0, 1920, 100);
        tabla.setBackground(new Color(230, 240, 250));

        linea1.setBounds(180, 10, 2, 80);
        linea2.setBounds(440, 10, 2, 80);
        //linea3.setBounds(530, 10, 2, 80);
        //linea4.setBounds(710, 10, 2, 80);
        //linea5.setBounds(820, 10, 2, 80);

        linea1.setBackground(new Color(226, 227, 228));
        linea2.setBackground(new Color(226, 227, 228));

        Portapapeles.setText("Portapapeles");
        Portapapeles.setBackground(new Color(115, 131, 153));
        Portapapeles.setBounds(30, 75, 100, 20);

        Fuente.setText("Fuente");
        Fuente.setBackground(new Color(115, 131, 153));
        Fuente.setBounds(240, 75, 100, 20);

        fondo.setBounds(0, 1000, 1920, 50);
        fondo.setBackground(new Color(240, 240, 240));

        regla.setBackground(new Color(229, 233, 239));
        regla.setBounds(225, 127, 830, 15);

        regla2.setBackground(new Color(255, 255, 255));
        regla2.setBounds(345, 127, 590, 15);

        reglaText2.setText("3   -   |   2   -   |   1   -   |");
        reglaText2.setBackground(new Color(30, 57, 117));
        reglaText2.setBounds(225, 127, 830, 15);

        reglaText1.setText("-   |   1   -   |   2   -   |   3   -   |   4   -   |   5   -   |   6   -   |   7   -   |   8   -   |   9   -   |   10   -   |   11   -   |   12   -   |   13   -   |   14   -   |   15   -   |   16");
        reglaText1.setBackground(new Color(30, 57, 117));
        reglaText1.setBounds(345, 127, 830, 15);

        N.setBackground(new Color(218, 228, 241));
        N.setBounds(190, 50, 50, 20);
        N.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                Font negrita = new Font(Hoja.getFont().getFontName(), Font.BOLD, Hoja.getFont().getSize());
                Hoja.setFont(negrita);
            }

        });

        K.setBackground(new Color(218, 228, 241));
        K.setBounds(240, 50, 50, 20);
        K.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                Font cursiva = new Font(Hoja.getFont().getFontName(), Font.ITALIC, Hoja.getFont().getSize());
                Hoja.setFont(cursiva);
            }

        });

        S.setBackground(new Color(218, 228, 241));
        S.setBounds(290, 50, 50, 20);
        S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                Font subrayado = new Font(Hoja.getFont().getFontName(), TextAttribute.UNDERLINE_ON, Hoja.getFont().getSize());
                Hoja.setFont(subrayado);
            }

        });

        A.setBackground(new Color(218, 228, 241));
        A.setBounds(350, 20, 80, 40);
        A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JColorChooser Selectorcolor = new JColorChooser();
                color = Selectorcolor.showDialog(null, "Seleccione un Color", Color.BLUE);
                Hoja.setForeground(color);
            }
        });

        peg.setBounds(30, 20, 40, 50);
        peg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Hoja.paste();
            }
        });
        cor.setBounds(90, 20, 30, 30);
        cor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Hoja.cut();
            }
        });
        cop.setBounds(120, 20, 30, 30);
        cop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Hoja.copy();
            }
        });

        tamaño.setBounds(300, 20, 40, 20);
        tamaño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Font Origen;
                switch (tamaño.getSelectedIndex()) {
                    case 0:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 8);
                        Hoja.setFont(Origen);
                        break;
                    case 1:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 9);
                        Hoja.setFont(Origen);
                        break;
                    case 2:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 10);
                        Hoja.setFont(Origen);
                        break;
                    case 3:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 11);
                        Hoja.setFont(Origen);
                        break;
                    case 4:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 12);
                        Hoja.setFont(Origen);
                        break;
                    case 5:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 14);
                        Hoja.setFont(Origen);
                        break;
                    case 6:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 16);
                        Hoja.setFont(Origen);
                        break;
                    case 7:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 18);
                        Hoja.setFont(Origen);
                        break;
                    case 8:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 20);
                        Hoja.setFont(Origen);
                        break;
                    case 9:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 22);
                        Hoja.setFont(Origen);
                        break;
                    case 10:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 24);
                        Hoja.setFont(Origen);
                        break;
                    case 11:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 26);
                        Hoja.setFont(Origen);
                        break;
                    case 12:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 28);
                        Hoja.setFont(Origen);
                        break;
                    case 13:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 36);
                        Hoja.setFont(Origen);
                        break;
                    case 14:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 48);
                        Hoja.setFont(Origen);
                        break;
                    case 15:
                        Origen = new Font(Hoja.getFont().getFontName(), Hoja.getFont().getStyle(), 72);
                        Hoja.setFont(Origen);
                        break;

                }
            }
        });

        fuente.setBounds(190, 20, 110, 20);
        fuente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Font origenfuente;
                switch (fuente.getSelectedIndex()) {
                    case 0:
                        origenfuente = new Font("Arial", Hoja.getFont().getStyle(), Hoja.getFont().getSize());
                        Hoja.setFont(origenfuente);
                        break;
                    case 1:
                        origenfuente = new Font("Comic Sans MS", Hoja.getFont().getStyle(), Hoja.getFont().getSize());
                        Hoja.setFont(origenfuente);
                        break;
                    case 2:
                        origenfuente = new Font("Impact", Hoja.getFont().getStyle(), Hoja.getFont().getSize());
                        Hoja.setFont(origenfuente);
                        break;

                }
            }
        });

        /*
         fuente.add("Arial");
         fuente.add("Calibri");
         fuente.add("Impact");
         fuente.add("Showcard Gothic");
         fuente.add("Trajan Pro");
         fuente.add("Wide Latin");
        
        
         tamaño.add("10");
         tamaño.add("11");
         tamaño.add("12");
         tamaño.add("15");

         fuente.setBounds(190, 20, 110, 20);
         tamaño.setBounds(300, 20, 40, 20);

         add(fuente);
         add(tamaño);
         mb.add(m);
         */
        add(fuente);
        add(tamaño);
        add(peg);
        add(cor);
        add(cop);
        add(Hoja);

        add(N);
        add(K);
        add(S);
        add(A);

        add(reglaText1);
        add(reglaText2);
        add(Portapapeles);
        add(Fuente);

        add(regla2);
        add(regla);
        add(fondo);
        add(linea1);
        add(linea2);
        add(linea3);
        add(linea4);
        add(linea5);
        add(tabla);
    }

}
