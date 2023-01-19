/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas_jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.TableModel;
import utilidades.Conexion;

/**
 *
 * @author _pickia
 */
public class Panel {
    
    private JFrame PanelLiga;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtPeso;
	private JTextField txtEdad;
	private JTable table;
        
        public Panel() {
		 initialize();
		// Connect();
		// loadData();
	}
        
       private void initialize() {
		PanelLiga = new JFrame();
		PanelLiga.setTitle("CRUD sobre MYSQL");
		PanelLiga.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		PanelLiga.getContentPane().setLayout(null);
                JLabel lblNewLabel = new JLabel("Panel de gestion");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 259, 60);
                //Hacemos visible el Jframe
                PanelLiga.setVisible(true);
                //le añadimos al panel la etiqueta
		PanelLiga.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(20, 71, 387, 284);
                //De nuevo añadimos el panel al Frame
		PanelLiga.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(21, 46, 46, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(21, 81, 46, 24);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Peso");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(21, 116, 46, 24);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Edad");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(21, 154, 46, 24);
		panel.add(lblNewLabel_1_3);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtID.setBounds(78, 46, 287, 24);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(78, 81, 287, 24);
		panel.add(txtName);
		
		txtPeso = new JTextField();
		txtPeso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPeso.setColumns(10);
		txtPeso.setBounds(78, 120, 287, 24);
		panel.add(txtPeso);
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEdad.setColumns(10);
		txtEdad.setBounds(78, 155, 287, 24);
		panel.add(txtEdad);
		
		JButton btnSave = new JButton("Save");
                 //Boton de guardar
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(78, 195, 89, 23);
		panel.add(btnSave);
		btnSave.addActionListener((ActionEvent e) -> {
                    try {
                        Conexion con = new Conexion();
                        Connection btnSaveConection= con.conectar();
                        //Recuperamos lo que introduce el usuario
                        //String id = txtID.getText();
                        String nombre = txtName.getText();
                        String peso = txtPeso.getText();
                        String edad = txtEdad.getText();
                        
                        if (nombre == null || nombre.isEmpty() || nombre.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Por favor introduzca un nombre");
                            txtName.requestFocus();
                            
                        }
                        if (peso == null || peso.isEmpty() || peso.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Por favor introduzca un peso");
                            txtPeso.requestFocus();
                            
                        }
                        if (edad == null || edad.isEmpty() || edad.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Por favor introduza la edad");
                            txtEdad.requestFocus();
                           
                        }
                        
                        if (txtID.getText().isEmpty()) {
                            String sql = "insert into jugadores (nombre,peso,edad) values (?,?,?)";
                            PreparedStatement pst = btnSaveConection.prepareStatement(sql);
                            pst.setString(1, nombre);//el parametro viene del formulario
                            pst.setString(2, peso);
                            pst.setString(3, edad);
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Datos insertado correctamente");
                            con.cerrarConexion();
                            clear();
                            //loadData();
                        }
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
               
		
		JButton btnUpdate = new JButton("Actualizar");
                //Creamos el botón y le adjutamos un evento
		btnUpdate.addActionListener((ActionEvent e) -> {
                    // Update Details
                    String id = txtID.getText();
                    String name = txtName.getText();
                    String peso = txtPeso.getText();
                    String edad = txtEdad.getText();
                    
                    if (name == null || name.isEmpty() || name.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor introduzca el Nombre");
                        txtName.requestFocus();
                        return;
                    }
                    if (peso == null || peso.isEmpty() || peso.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor introduzca el Peso");
                        txtPeso.requestFocus();
                        return;
                    }
                    if (edad == null || edad.isEmpty() || edad.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor introduzca la Edad ");
                        txtEdad.requestFocus();
                        return;
                    }
                    
                    if (!txtID.getText().isEmpty()) {
                        String sql = "update users set NAME=?,AGE=?,CITY=? where ID=?";
                        //pst = con.prepareStatement(sql);
                        //pst.setString(1, name);
                        //pst.setString(2, peso);
                        //pst.setString(3, edad);
                        //  pst.setString(4, id);
                        // pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Los datos se han introducido correctamente");
                        //clear();
                        //loadData();
                    }
                });
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(177, 195, 89, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener((ActionEvent e) -> {
                    // Delete Details
                    String id = txtID.getText();
                    //true->false false->true
                    if (!txtID.getText().isEmpty()) {
                        
                        int result = JOptionPane.showConfirmDialog(null, "Seguro que quieres estos datos", "Borrar",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        
                        if (result == JOptionPane.YES_OPTION) {
                            String sql = "delete from users where ID=?";
                            //pst = con.prepareStatement(sql);
                            //pst.setString(1, id);
                            //pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Data Deleted Success");
                            //clear();
                            //loadData();
                        }
                    }
                });
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(276, 195, 89, 23);
		panel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 71, 467, 284);
		PanelLiga.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				// ID NOMBRE PESO EDAD
				txtID.setText(model.getValueAt(index, 0).toString());
				txtName.setText(model.getValueAt(index, 1).toString());
				txtPeso.setText(model.getValueAt(index, 2).toString());
				txtEdad.setText(model.getValueAt(index, 3).toString());
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setRowHeight(30);
                //Al scrollPanel le añadimos la tabla
		scrollPane.setViewportView(table);
		PanelLiga.setBounds(100, 100, 910, 522);
		PanelLiga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
       
       public void clear() {
			txtID.setText("");
			txtName.setText("");
			txtPeso.setText("");
			txtEdad.setText("");
			txtName.requestFocus();
		}
    
}
