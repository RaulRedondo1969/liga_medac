/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz_usuario;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author usuario
 */
public class InterfazAltas {
    
        private JFrame ligaMedacAltas;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtPeso;
	private JTextField txtEdad;
	//private JTable table;
    
        public InterfazAltas(){
            inicializarPanelAltas();
        }
        private void inicializarPanelAltas(){
            
            ligaMedacAltas = new JFrame("Altas Jugadores");
            ligaMedacAltas.setTitle("Jugadores");
            ligaMedacAltas.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
            ligaMedacAltas.getContentPane().setLayout(null);
            ligaMedacAltas.setVisible(true);
        }
    
    
}
