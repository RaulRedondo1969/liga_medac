/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplosTablas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author usuario
 */
public class TableExample {
      JFrame f;   
      
    TableExample(){    //Siempre inicializamos en el constructor de la clase. 
    f=new JFrame();    
    //DataModel
    String data[][]={ {"101","Amit","670000"},    
                          {"102","Jai","780000"},    
                          {"101","Sachin","700000"}};    
    String column[]={"ID","NAME","SALARY"};         
    JTable jt=new JTable(data,column);    // Hay que pasarle las filas y col del DataModel
    jt.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(jt);    // Interesante lo del ScrollPanel
    f.add(sp);          
    f.setSize(300,400);    
    f.setVisible(true);    
}     
public static void main(String[] args) {    
    new TableExample();    
}    
}
