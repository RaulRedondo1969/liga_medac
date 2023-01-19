/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas_jdbc;

/**
 *
 * @author usuario
 */
/*import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.TableModel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class users {

	private JFrame frmCurdOperationSwing;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtCity;
	private JTable table;

	/**
	 * Launch the application.
     * @param args
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        users window = new users();
                        window.frmCurdOperationSwing.setVisible(true);
                    } catch (Exception e) {
                        
                    }
                });
	}

	/**
	 * Create the application.
         * Constructor
	 */
	/*public users() {
		 initialize();
		// Connect();
		// loadData();
	}*/
	
	
	//Database Connection
	/*Connection con = null;
	PreparedStatement pst;
	ResultSet rs;*/
	
	/*public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/dbjoes?characterEncoding=utf8";
			String username = "root";
			String password = "root";
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException ex) {
		}
	}*/
	
	// Clear All
		/*public void clear() {
			txtID.setText("");
			txtName.setText("");
			txtAge.setText("");
			txtCity.setText("");
			txtName.requestFocus();
		}*/
	
		// Load Table
		/*public void loadData() {
			try {
				pst = con.prepareStatement("Select * from users");
				rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}*/

		
	/**
	 * Initialize the contents of the frame.
	 */
	/*private void initialize() {
		frmCurdOperationSwing = new JFrame();
		frmCurdOperationSwing.setTitle(" Swing MySQL");
		frmCurdOperationSwing.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmCurdOperationSwing.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Panel de Altas");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 259, 60);
		frmCurdOperationSwing.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(20, 71, 387, 284);
		frmCurdOperationSwing.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(21, 46, 46, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(21, 81, 46, 24);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Edad");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(21, 116, 46, 24);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ciudad");
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
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAge.setColumns(10);
		txtAge.setBounds(78, 120, 287, 24);
		panel.add(txtAge);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCity.setColumns(10);
		txtCity.setBounds(78, 155, 287, 24);
		panel.add(txtCity);
		// hasta aqio 
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener((ActionEvent e) -> {
                   // String id = txtID.getText();
                    String name = txtName.getText();
                    String age = txtAge.getText();
                    String city = txtCity.getText();
                    
                    if (name == null || name.isEmpty() || name.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter Name");
                        txtName.requestFocus();
                        return;
                    }
                    if (age == null || age.isEmpty() || age.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter Age");
                        txtAge.requestFocus();
                        return;
                    }
                    if (city == null || city.isEmpty() || city.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Enter City");
                        txtCity.requestFocus();
                    }
                    
                 /*   if (txtID.getText().isEmpty()) {
                        try {
                            String sql = "insert into users (NAME,AGE,CITY) values (?,?,?)";
                            pst = con.prepareStatement(sql);
                            pst.setString(1, name);
                            pst.setString(2, age);
                            pst.setString(3, city);
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Data insert Success");
                            clear();
                            //loadData();
                            
                        } catch (SQLException e1) {
                        }
                    }
                });*/
		/*btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(78, 195, 89, 23);
		panel.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				// Update Details
				String id = txtID.getText();
				String name = txtName.getText();
				String age = txtAge.getText();
				String city = txtCity.getText();

				if (name == null || name.isEmpty() || name.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Name");
					txtName.requestFocus();
					return;
				}
				if (age == null || age.isEmpty() || age.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Age");
					txtAge.requestFocus();
					return;
				}
				if (city == null || city.isEmpty() || city.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter City");
					txtCity.requestFocus();
					return;
				}

				if (!txtID.getText().isEmpty()) {
					try {
						String sql = "update users set NAME=?,AGE=?,CITY=? where ID=?";
						pst = con.prepareStatement(sql);
						pst.setString(1, name);
						pst.setString(2, age);
						pst.setString(3, city);
						pst.setString(4, id);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Data Update Success");
						clear();
						//loadData();

					} catch (SQLException e1) {
					}
				}
			}
		});*/
	/*	btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(177, 195, 89, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				
				// Delete Details
				String id = txtID.getText();
				if (!txtID.getText().isEmpty()) {

					int result = JOptionPane.showConfirmDialog(null, "Sure? You want to Delete?", "Delete",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (result == JOptionPane.YES_OPTION) {
						try {
							String sql = "delete from users where ID=?";
						//	pst = con.prepareStatement(sql);
						//	pst.setString(1, id);
						//	pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Data Deleted Success");
							clear();
							//loadData();

						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}

			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(276, 195, 89, 23);
		panel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 71, 467, 284);
		frmCurdOperationSwing.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				// ID NAME AGE CITY
				txtID.setText(model.getValueAt(index, 0).toString());
				txtName.setText(model.getValueAt(index, 1).toString());
				txtAge.setText(model.getValueAt(index, 2).toString());
				txtCity.setText(model.getValueAt(index, 3).toString());
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		frmCurdOperationSwing.setBounds(100, 100, 910, 522);
		frmCurdOperationSwing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/
//}


