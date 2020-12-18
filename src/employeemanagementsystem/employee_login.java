
package employeemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class employee_login implements ActionListener {
    JFrame f;
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    public static int logged_in_eid;
    employee_login(){

        f=new JFrame("Employee Login");

        f.setBackground(Color.white);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        l1 = new JLabel("Employee ID");
        l1.setBounds(40,250,100,30);
        f.add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,300,100,30);
        f.add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,250,150,30);
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,300,150,30);
        f.add(t2);
        
        l3 = new JLabel("EMPLOYEE LOGIN");
        l3.setFont(new Font("Verdana", Font.BOLD, 18));
        l3.setBounds(70,25,200,30);
        f.add(l3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("employeemanagementsystem/icons/employee_login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(110,60,150,150);
        f.add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,350,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,350,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(400,500);
        f.setLocation(800,300);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
        try{
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            
            String q = "select * from employee1 where eid='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q);
            String name="";
            if(rs.next()){
//                new details().f.setVisible(true);
                f.setVisible(false);
                EmployeeHome d=new EmployeeHome();
                
                q = "select eid,ename from employee1 where eid='"+u+"'";
            
                rs = c1.s.executeQuery(q); 
                if(rs.next()){
//                new details().f.setVisible(true);
                    name=rs.getString("ename");
                    logged_in_eid=rs.getInt("eid");
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                }
                d.name.setText(name);
                d.defaultValue();
                d.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                f.setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        else{
            int a=JOptionPane.showConfirmDialog(f,"Are you sure?");  
            if(a==JOptionPane.YES_OPTION){  
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                f.setVisible(false);
            } 
        }
    }
    public static void main(String[] arg){
        employee_login l=new employee_login();
    }
}
