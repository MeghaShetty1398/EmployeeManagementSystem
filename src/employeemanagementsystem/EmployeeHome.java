/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagementsystem;
import com.email.durgesh.Email;
import java.awt.Color;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.regex.Pattern;
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*; 
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
/**
 *
 * @author Owner
 */
public class EmployeeHome extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeHome
     */
    public EmployeeHome() {
        initComponents();
        JTableHeader tableHeader = jTable1.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI",Font.BOLD,15));
        tableHeader.setOpaque(false);
        tableHeader.setForeground(new Color(0,0,0));
        tableHeader.setBackground(new Color(7,43,108));
    }
    public void defaultValue(){
        e_designation.setEditable(false);
        e_id.setEditable(false);
        e_salary.setEditable(false);
        e_doj.setEnabled(false);
        e_department.setEditable(false);
        
        try{
            conn c1 = new conn();
            //For showing employee details
            JOptionPane.showMessageDialog(null, name.getText());
            String q = "select * from employee1 where ename='"+name.getText()+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
                while(rs.next()){
                    String id=String.valueOf(rs.getInt("eid"));
                    String name=rs.getString("ename");
                    String department=rs.getString("department");
                    String designation=rs.getString("designation");
                    String salary=String.valueOf(rs.getDouble("salary"));
                    String email=rs.getString("email");
                    String phone_no=String.valueOf(rs.getLong("phone_no"));
                    String highest_qual=rs.getString("highest_qual");
                    String skills=rs.getString("skills");
                    String dob=rs.getString("dob");
                    String doj=rs.getString("doj");
                    String gender=rs.getString("gender");
                    int yoe=rs.getInt("yoe");
                    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                    
                    e_id.setText(id);
                    e_name.setText(name);
                    e_designation.setText(designation);
                    e_department.setText(department);
                    e_salary.setText(salary);
                    e_email.setText(email);
                    e_phone.setText(phone_no);
                    e_highest_qual.setText(highest_qual);
                    e_skill.setText(skills);
                    try{
                        e_dob.setDate(sdf.parse(dob));
                        e_doj.setDate(sdf.parse(doj));
                    }
                    catch(Exception e){
                        
                    }
                    e_experience.setValue(yoe);
                    if(gender.equalsIgnoreCase("Female")){
                        e_female.setSelected(true);
                    }
                    else{
                        e_male.setSelected(true);
                    }
                    //To set value in label in my profile page
                    l_id2.setText(id);
                    l_name2.setText(name);
                    l_dob2.setText(dob);
                    l_email2.setText(email);
                    l_highest_qual2.setText(highest_qual);
                    l_skill2.setText(skills);
                    l_phone2.setText(phone_no);
                    l_gender2.setText(gender);
                    l_designation2.setText(designation);
                    l_doj2.setText(doj);
                    l_salary2.setText(salary);
                    l_department2.setText(department);
                    l_experience2.setText(String.valueOf(yoe));
                }
                //For attendance
                q = "select * from attendance where ename='"+name.getText()+"'";
                rs = c1.s.executeQuery(q); 
                while(rs.next()){
                    String sd=rs.getString("start_date");
                    String ed=rs.getString("end_date");
                    String reason=rs.getString("reason");
                    String status=rs.getString("status");
                    JOptionPane.showMessageDialog(null, reason);
                    String tbData[]={sd,ed,reason,status};
                    DefaultTableModel tblModel=(DefaultTableModel)jTable1.getModel();
                    tblModel.addRow(tbData);
                }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        n_add = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        n_delete = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        n_update = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        n_printreceipt = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        j_update_det = new javax.swing.JPanel();
        l_emp_details = new javax.swing.JLabel();
        l_name = new javax.swing.JLabel();
        e_id = new javax.swing.JTextField();
        e_phone = new javax.swing.JTextField();
        l_id = new javax.swing.JLabel();
        l_dob = new javax.swing.JLabel();
        e_dob = new com.toedter.calendar.JDateChooser();
        l_gender = new javax.swing.JLabel();
        e_male = new javax.swing.JRadioButton();
        e_female = new javax.swing.JRadioButton();
        l_email = new javax.swing.JLabel();
        l_phone = new javax.swing.JLabel();
        e_name = new javax.swing.JTextField();
        e_email = new javax.swing.JTextField();
        l_experience = new javax.swing.JLabel();
        e_highest_qual = new javax.swing.JTextField();
        l_skill = new javax.swing.JLabel();
        e_department = new javax.swing.JTextField();
        e_skill = new javax.swing.JTextField();
        l_work_details = new javax.swing.JLabel();
        l_designation = new javax.swing.JLabel();
        l_department = new javax.swing.JLabel();
        l_doj = new javax.swing.JLabel();
        e_doj = new com.toedter.calendar.JDateChooser();
        l_salary = new javax.swing.JLabel();
        e_salary = new javax.swing.JTextField();
        l_highest_qual = new javax.swing.JLabel();
        e_experience = new javax.swing.JSpinner();
        update_my_details = new javax.swing.JButton();
        e_designation = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jmyprofile = new javax.swing.JPanel();
        j_update_det1 = new javax.swing.JPanel();
        l_emp_details1 = new javax.swing.JLabel();
        l_name1 = new javax.swing.JLabel();
        l_id1 = new javax.swing.JLabel();
        l_dob1 = new javax.swing.JLabel();
        l_gender1 = new javax.swing.JLabel();
        l_email1 = new javax.swing.JLabel();
        l_phone1 = new javax.swing.JLabel();
        l_experience1 = new javax.swing.JLabel();
        l_skill1 = new javax.swing.JLabel();
        l_designation1 = new javax.swing.JLabel();
        l_department1 = new javax.swing.JLabel();
        l_doj1 = new javax.swing.JLabel();
        l_salary1 = new javax.swing.JLabel();
        l_highest_qual1 = new javax.swing.JLabel();
        l_id2 = new javax.swing.JLabel();
        l_name2 = new javax.swing.JLabel();
        l_dob2 = new javax.swing.JLabel();
        l_email2 = new javax.swing.JLabel();
        l_highest_qual2 = new javax.swing.JLabel();
        l_skill2 = new javax.swing.JLabel();
        l_phone2 = new javax.swing.JLabel();
        l_gender2 = new javax.swing.JLabel();
        l_designation2 = new javax.swing.JLabel();
        l_doj2 = new javax.swing.JLabel();
        l_salary2 = new javax.swing.JLabel();
        l_department2 = new javax.swing.JLabel();
        l_experience2 = new javax.swing.JLabel();
        jupdatepassword = new javax.swing.JPanel();
        l_update_emp_details = new javax.swing.JLabel();
        u_l_id1 = new javax.swing.JLabel();
        old_password = new javax.swing.JTextField();
        d_name = new javax.swing.JLabel();
        u_l_id2 = new javax.swing.JLabel();
        new_password = new javax.swing.JTextField();
        u_l_id3 = new javax.swing.JLabel();
        confirm_new_password = new javax.swing.JTextField();
        change_password = new javax.swing.JButton();
        jprintreceipt = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        start_date = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        end_date = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reason = new javax.swing.JTextArea();
        apply_leave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        username.setBackground(new java.awt.Color(25, 26, 46));

        name.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        name.setForeground(new java.awt.Color(83, 207, 44));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(235, 49, 131));
        jLabel6.setText("WELCOME");

        javax.swing.GroupLayout usernameLayout = new javax.swing.GroupLayout(username);
        username.setLayout(usernameLayout);
        usernameLayout.setHorizontalGroup(
            usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameLayout.createSequentialGroup()
                .addGap(434, 434, 434)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );
        usernameLayout.setVerticalGroup(
            usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usernameLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        getContentPane().add(username, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(25, 26, 46));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 470));

        n_add.setBackground(new java.awt.Color(25, 26, 46));
        n_add.setPreferredSize(new java.awt.Dimension(170, 51));
        n_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n_addmouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                n_addmouseentered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                n_addmouseexited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Update Profile");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2mouseclicked(evt);
            }
        });

        javax.swing.GroupLayout n_addLayout = new javax.swing.GroupLayout(n_add);
        n_add.setLayout(n_addLayout);
        n_addLayout.setHorizontalGroup(
            n_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(n_addLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        n_addLayout.setVerticalGroup(
            n_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, n_addLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        n_delete.setBackground(new java.awt.Color(25, 26, 46));
        n_delete.setPreferredSize(new java.awt.Dimension(170, 48));
        n_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n_deletemouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                n_deletemouseentered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                n_deletemouseexited(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(25, 26, 46));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("My Profile");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3mouseclicked(evt);
            }
        });

        javax.swing.GroupLayout n_deleteLayout = new javax.swing.GroupLayout(n_delete);
        n_delete.setLayout(n_deleteLayout);
        n_deleteLayout.setHorizontalGroup(
            n_deleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(n_deleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        n_deleteLayout.setVerticalGroup(
            n_deleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, n_deleteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        n_update.setBackground(new java.awt.Color(25, 26, 46));
        n_update.setPreferredSize(new java.awt.Dimension(170, 48));
        n_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n_updatemouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                n_updatemouseentered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                n_updatemouseexited(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Change Password");

        javax.swing.GroupLayout n_updateLayout = new javax.swing.GroupLayout(n_update);
        n_update.setLayout(n_updateLayout);
        n_updateLayout.setHorizontalGroup(
            n_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(n_updateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        n_updateLayout.setVerticalGroup(
            n_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, n_updateLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        n_printreceipt.setBackground(new java.awt.Color(25, 26, 46));
        n_printreceipt.setPreferredSize(new java.awt.Dimension(170, 48));
        n_printreceipt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n_printreceiptmouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                n_printreceiptmouseentered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                n_printreceiptmouseexited(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Apply Leave");

        javax.swing.GroupLayout n_printreceiptLayout = new javax.swing.GroupLayout(n_printreceipt);
        n_printreceipt.setLayout(n_printreceiptLayout);
        n_printreceiptLayout.setHorizontalGroup(
            n_printreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(n_printreceiptLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        n_printreceiptLayout.setVerticalGroup(
            n_printreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, n_printreceiptLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(n_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
            .addComponent(n_update, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
            .addComponent(n_add, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(n_printreceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(n_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(n_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(n_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(n_printreceipt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 449, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new java.awt.CardLayout());

        j_update_det.setBackground(new java.awt.Color(255, 255, 255));
        j_update_det.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_update_detmouseclicked(evt);
            }
        });

        l_emp_details.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        l_emp_details.setForeground(new java.awt.Color(25, 26, 46));
        l_emp_details.setText("                                                       EMPLOYEE DETAILS");

        l_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_name.setText("NAME");

        e_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        e_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_idActionPerformed(evt);
            }
        });

        e_phone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        e_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_phoneActionPerformed(evt);
            }
        });

        l_id.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_id.setText("ID");

        l_dob.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_dob.setText("DATE OF BIRTH");

        e_dob.setBackground(new java.awt.Color(255, 255, 255));

        l_gender.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_gender.setText("GENDER");

        e_male.setBackground(new java.awt.Color(255, 255, 255));
        e_male.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        e_male.setText("Male");
        e_male.setName("male"); // NOI18N
        e_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_maleActionPerformed(evt);
            }
        });

        e_female.setBackground(new java.awt.Color(255, 255, 255));
        e_female.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        e_female.setText("Female");
        e_female.setName("female"); // NOI18N
        e_female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_femaleActionPerformed(evt);
            }
        });

        l_email.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_email.setText("EMAIL");

        l_phone.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_phone.setText("PHONE NO.");

        e_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        e_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_nameActionPerformed(evt);
            }
        });

        e_email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        e_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_emailActionPerformed(evt);
            }
        });

        l_experience.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_experience.setText("YEAR OF EXPERIENCE");

        e_highest_qual.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        e_highest_qual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_highest_qualActionPerformed(evt);
            }
        });

        l_skill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_skill.setText("SKILLS");

        e_department.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        e_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_departmentActionPerformed(evt);
            }
        });

        e_skill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        e_skill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_skillActionPerformed(evt);
            }
        });

        l_work_details.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        l_work_details.setForeground(new java.awt.Color(25, 26, 46));
        l_work_details.setText("WORK DETAILS");

        l_designation.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_designation.setText("DESIGNATION");

        l_department.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_department.setText("DEPARTMENT");

        l_doj.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_doj.setText("DATE OF JOINING");

        e_doj.setBackground(new java.awt.Color(255, 255, 255));

        l_salary.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_salary.setText("SALARY");

        e_salary.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        e_salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_salaryActionPerformed(evt);
            }
        });

        l_highest_qual.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_highest_qual.setText("HIGHEST QUALIFICATION");

        e_experience.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        update_my_details.setBackground(new java.awt.Color(25, 26, 46));
        update_my_details.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        update_my_details.setForeground(new java.awt.Color(255, 255, 255));
        update_my_details.setText("UPDATE");
        update_my_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_my_detailsActionPerformed(evt);
            }
        });

        e_designation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        e_designation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_designationActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 102));
        jLabel7.setText("*");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 102));
        jLabel8.setText("*");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 102));
        jLabel9.setText("*");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 102));
        jLabel10.setText("*");

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 102));
        jLabel11.setText("*-The field is not editable");

        javax.swing.GroupLayout j_update_detLayout = new javax.swing.GroupLayout(j_update_det);
        j_update_det.setLayout(j_update_detLayout);
        j_update_detLayout.setHorizontalGroup(
            j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l_emp_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(j_update_detLayout.createSequentialGroup()
                .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(j_update_detLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(j_update_detLayout.createSequentialGroup()
                                .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(j_update_detLayout.createSequentialGroup()
                                        .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(l_dob)
                                            .addComponent(l_name)
                                            .addComponent(l_id))
                                        .addGap(35, 35, 35)
                                        .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(e_id, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(e_name, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(e_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(j_update_detLayout.createSequentialGroup()
                                        .addComponent(l_gender)
                                        .addGap(100, 100, 100)
                                        .addComponent(e_male)
                                        .addGap(30, 30, 30)
                                        .addComponent(e_female)))
                                .addGap(18, 18, 18)
                                .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(j_update_detLayout.createSequentialGroup()
                                        .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(l_phone)
                                            .addComponent(l_email))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(e_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(e_phone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(j_update_detLayout.createSequentialGroup()
                                        .addComponent(l_highest_qual)
                                        .addGap(18, 18, 18)
                                        .addComponent(e_highest_qual, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, j_update_detLayout.createSequentialGroup()
                                        .addComponent(l_skill)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(e_skill, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(j_update_detLayout.createSequentialGroup()
                                .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(j_update_detLayout.createSequentialGroup()
                                        .addComponent(l_experience)
                                        .addGap(30, 30, 30))
                                    .addGroup(j_update_detLayout.createSequentialGroup()
                                        .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGap(18, 18, 18)
                                        .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(l_salary)
                                            .addComponent(l_doj)
                                            .addComponent(l_designation)
                                            .addComponent(l_department))
                                        .addGap(18, 18, 18)))
                                .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(e_experience, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(e_designation, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(e_doj, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(e_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(e_department, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(j_update_detLayout.createSequentialGroup()
                                        .addGap(155, 155, 155)
                                        .addComponent(l_work_details, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(j_update_detLayout.createSequentialGroup()
                        .addGap(477, 477, 477)
                        .addComponent(update_my_details, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(j_update_detLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        j_update_detLayout.setVerticalGroup(
            j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j_update_detLayout.createSequentialGroup()
                .addComponent(l_emp_details, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(j_update_detLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(e_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_id, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_email, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(j_update_detLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(e_email, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(e_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(l_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e_name, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(j_update_detLayout.createSequentialGroup()
                        .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(j_update_detLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(l_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, j_update_detLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(e_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e_male)
                            .addComponent(e_female))
                        .addGap(18, 18, 18)
                        .addComponent(e_experience, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(j_update_detLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_highest_qual, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e_highest_qual, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(e_skill, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_skill, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(j_update_detLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(l_experience, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(j_update_detLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(l_work_details)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(14, 14, 14)
                .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_designation, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_designation, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(8, 8, 8)
                .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(l_doj, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(e_doj, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(j_update_detLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_department, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_department, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(update_my_details, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(j_update_det, "card2");

        jmyprofile.setBackground(new java.awt.Color(255, 255, 255));
        jmyprofile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmyprofilemouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmyprofilemouseentered(evt);
            }
        });

        j_update_det1.setBackground(new java.awt.Color(255, 255, 255));
        j_update_det1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_update_det1mouseclicked(evt);
            }
        });

        l_emp_details1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        l_emp_details1.setForeground(new java.awt.Color(25, 26, 46));
        l_emp_details1.setText("                                            MY DETAILS");

        l_name1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_name1.setText("NAME: ");

        l_id1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_id1.setText("ID: ");

        l_dob1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_dob1.setText("DATE OF BIRTH: ");

        l_gender1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_gender1.setText("GENDER: ");

        l_email1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_email1.setText("EMAIL: ");

        l_phone1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_phone1.setText("PHONE NO.: ");

        l_experience1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_experience1.setText("YEAR OF EXPERIENCE: ");

        l_skill1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_skill1.setText("SKILLS: ");

        l_designation1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_designation1.setText("DESIGNATION: ");

        l_department1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_department1.setText("DEPARTMENT: ");

        l_doj1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_doj1.setText("DATE OF JOINING: ");

        l_salary1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_salary1.setText("SALARY: ");

        l_highest_qual1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_highest_qual1.setText("HIGHEST QUALIFICATION: ");

        l_id2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_id2.setForeground(new java.awt.Color(79, 115, 213));
        l_id2.setText("ID");

        l_name2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_name2.setForeground(new java.awt.Color(79, 115, 213));

        l_dob2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_dob2.setForeground(new java.awt.Color(79, 115, 213));

        l_email2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_email2.setForeground(new java.awt.Color(79, 115, 213));

        l_highest_qual2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_highest_qual2.setForeground(new java.awt.Color(79, 115, 213));

        l_skill2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_skill2.setForeground(new java.awt.Color(79, 115, 213));

        l_phone2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_phone2.setForeground(new java.awt.Color(79, 115, 213));

        l_gender2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_gender2.setForeground(new java.awt.Color(79, 115, 213));

        l_designation2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_designation2.setForeground(new java.awt.Color(79, 115, 213));

        l_doj2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_doj2.setForeground(new java.awt.Color(79, 115, 213));

        l_salary2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_salary2.setForeground(new java.awt.Color(79, 115, 213));

        l_department2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_department2.setForeground(new java.awt.Color(79, 115, 213));

        l_experience2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_experience2.setForeground(new java.awt.Color(79, 115, 213));

        javax.swing.GroupLayout j_update_det1Layout = new javax.swing.GroupLayout(j_update_det1);
        j_update_det1.setLayout(j_update_det1Layout);
        j_update_det1Layout.setHorizontalGroup(
            j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l_emp_details1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(j_update_det1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_id1)
                    .addComponent(l_dob1)
                    .addComponent(l_name1)
                    .addComponent(l_email1)
                    .addComponent(l_highest_qual1)
                    .addComponent(l_skill1)
                    .addComponent(l_phone1)
                    .addComponent(l_gender1)
                    .addComponent(l_designation1)
                    .addComponent(l_doj1)
                    .addComponent(l_salary1)
                    .addComponent(l_department1)
                    .addComponent(l_experience1))
                .addGap(75, 75, 75)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(l_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_name2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_dob2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_email2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_highest_qual2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_skill2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_phone2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_gender2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_salary2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_department2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_designation2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_doj2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(l_experience2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        j_update_det1Layout.setVerticalGroup(
            j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j_update_det1Layout.createSequentialGroup()
                .addComponent(l_emp_details1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_dob2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_dob1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_email1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_email2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_highest_qual1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_highest_qual2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_skill1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_skill2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_phone1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_phone2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_gender1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_gender2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_designation2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_designation1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_doj2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_doj1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_salary1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_salary2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_department1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_department2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(j_update_det1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_experience1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_experience2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout jmyprofileLayout = new javax.swing.GroupLayout(jmyprofile);
        jmyprofile.setLayout(jmyprofileLayout);
        jmyprofileLayout.setHorizontalGroup(
            jmyprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1173, Short.MAX_VALUE)
            .addGroup(jmyprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jmyprofileLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(j_update_det1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jmyprofileLayout.setVerticalGroup(
            jmyprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
            .addGroup(jmyprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jmyprofileLayout.createSequentialGroup()
                    .addContainerGap(16, Short.MAX_VALUE)
                    .addComponent(j_update_det1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );

        jPanel2.add(jmyprofile, "card3");

        jupdatepassword.setBackground(new java.awt.Color(255, 255, 255));

        l_update_emp_details.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        l_update_emp_details.setForeground(new java.awt.Color(25, 26, 46));
        l_update_emp_details.setText("                                                    UPDATE  MY PASSWORD");

        u_l_id1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        u_l_id1.setText("Old Password");

        old_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                old_passwordActionPerformed(evt);
            }
        });

        d_name.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        d_name.setForeground(new java.awt.Color(18, 83, 116));

        u_l_id2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        u_l_id2.setText("New Password");

        new_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_passwordActionPerformed(evt);
            }
        });

        u_l_id3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        u_l_id3.setText("Confirm New Password");

        confirm_new_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_new_passwordActionPerformed(evt);
            }
        });

        change_password.setBackground(new java.awt.Color(25, 26, 46));
        change_password.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        change_password.setForeground(new java.awt.Color(255, 255, 255));
        change_password.setText("CHANGE MY PASSWORD");
        change_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jupdatepasswordLayout = new javax.swing.GroupLayout(jupdatepassword);
        jupdatepassword.setLayout(jupdatepasswordLayout);
        jupdatepasswordLayout.setHorizontalGroup(
            jupdatepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jupdatepasswordLayout.createSequentialGroup()
                .addGroup(jupdatepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jupdatepasswordLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(l_update_emp_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jupdatepasswordLayout.createSequentialGroup()
                        .addGroup(jupdatepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jupdatepasswordLayout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addGroup(jupdatepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(u_l_id1)
                                    .addComponent(u_l_id2)))
                            .addGroup(jupdatepasswordLayout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addComponent(u_l_id3)))
                        .addGap(112, 112, 112)
                        .addGroup(jupdatepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(new_password, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(old_password, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirm_new_password, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jupdatepasswordLayout.createSequentialGroup()
                .addContainerGap(287, Short.MAX_VALUE)
                .addComponent(d_name, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
            .addGroup(jupdatepasswordLayout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addComponent(change_password, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jupdatepasswordLayout.setVerticalGroup(
            jupdatepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jupdatepasswordLayout.createSequentialGroup()
                .addComponent(l_update_emp_details, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jupdatepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(old_password, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(u_l_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jupdatepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(u_l_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(new_password, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jupdatepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirm_new_password, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(u_l_id3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(change_password, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196)
                .addComponent(d_name)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jPanel2.add(jupdatepassword, "card4");

        jprintreceipt.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 26, 46));
        jLabel1.setText("APPLY FOR LEAVE");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Start Date");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Reason");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("End Date");

        reason.setColumns(20);
        reason.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        reason.setRows(5);
        jScrollPane1.setViewportView(reason);

        apply_leave.setBackground(new java.awt.Color(25, 26, 46));
        apply_leave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        apply_leave.setForeground(new java.awt.Color(255, 255, 255));
        apply_leave.setText("APPLY LEAVE");
        apply_leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apply_leaveActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "START DATE", "END DATE", "REASON", "STATUS"
            }
        ));
        jTable1.setRowHeight(25);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jprintreceiptLayout = new javax.swing.GroupLayout(jprintreceipt);
        jprintreceipt.setLayout(jprintreceiptLayout);
        jprintreceiptLayout.setHorizontalGroup(
            jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jprintreceiptLayout.createSequentialGroup()
                .addGroup(jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jprintreceiptLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jprintreceiptLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98)
                        .addGroup(jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(start_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(end_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jprintreceiptLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(apply_leave, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(162, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jprintreceiptLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jprintreceiptLayout.setVerticalGroup(
            jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jprintreceiptLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(start_date, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jprintreceiptLayout.createSequentialGroup()
                        .addComponent(end_date, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jprintreceiptLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(apply_leave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jPanel2.add(jprintreceipt, "card5");

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2mouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2mouseclicked
        // TODO add your handling code here:
        if(evt.getSource()==n_add){
            j_update_det.setVisible(true);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_delete){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(true);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_update){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(true);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_printreceipt){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(true);
        }
    }//GEN-LAST:event_jLabel2mouseclicked

    private void n_addmouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n_addmouseclicked
        // TODO add your handling code here:
        if(evt.getSource()==n_add){
            j_update_det.setVisible(true);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_delete){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(true);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_update){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(true);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_printreceipt){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(true);
        }
    }//GEN-LAST:event_n_addmouseclicked

    private void n_addmouseentered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n_addmouseentered
        if(evt.getSource()==n_add){
            n_add.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_delete){
            n_delete.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_update){
            n_update.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_printreceipt){
            n_printreceipt.setBackground(new Color(0,0,0));
        }
    }//GEN-LAST:event_n_addmouseentered

    private void n_addmouseexited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n_addmouseexited
        if(evt.getSource()==n_add){
            n_add.setBackground(new Color(25,26,46));
        }
        if(evt.getSource()==n_delete){
            n_delete.setBackground(new Color(25,26,46));
        }
        if(evt.getSource()==n_update){
            n_update.setBackground(new Color(25,26,46));
        }
        if(evt.getSource()==n_printreceipt){
            n_printreceipt.setBackground(new Color(25,26,46));
        }
    }//GEN-LAST:event_n_addmouseexited

    private void jLabel3mouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3mouseclicked
        // TODO add your handling code here:
        if(evt.getSource()==n_add){
            j_update_det.setVisible(true);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_delete){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(true);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_update){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(true);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_printreceipt){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(true);
        }
    }//GEN-LAST:event_jLabel3mouseclicked

    private void n_deletemouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n_deletemouseclicked
        // TODO add your handling code here:
        if(evt.getSource()==n_add){
            j_update_det.setVisible(true);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_delete){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(true);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_update){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(true);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_printreceipt){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(true);
        }
    }//GEN-LAST:event_n_deletemouseclicked

    private void n_deletemouseentered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n_deletemouseentered
        if(evt.getSource()==n_add){
            n_add.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_delete){
            n_delete.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_update){
            n_update.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_printreceipt){
            n_printreceipt.setBackground(new Color(0,0,0));
        }
    }//GEN-LAST:event_n_deletemouseentered

    private void n_deletemouseexited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n_deletemouseexited
        if(evt.getSource()==n_add){
            n_add.setBackground(new Color(25,26,46));
        }
        if(evt.getSource()==n_delete){
            n_delete.setBackground(new Color(25,26,46));
        }
        if(evt.getSource()==n_update){
            n_update.setBackground(new Color(25,26,46));
        }
        if(evt.getSource()==n_printreceipt){
            n_printreceipt.setBackground(new Color(25,26,46));
        }
    }//GEN-LAST:event_n_deletemouseexited

    private void n_updatemouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n_updatemouseclicked
        // TODO add your handling code here:
        if(evt.getSource()==n_add){
            j_update_det.setVisible(true);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_delete){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(true);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_update){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(true);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_printreceipt){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(true);
        }
    }//GEN-LAST:event_n_updatemouseclicked

    private void n_updatemouseentered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n_updatemouseentered
        if(evt.getSource()==n_add){
            n_add.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_delete){
            n_delete.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_update){
            n_update.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_printreceipt){
            n_printreceipt.setBackground(new Color(0,0,0));
        }
    }//GEN-LAST:event_n_updatemouseentered

    private void n_updatemouseexited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n_updatemouseexited
        if(evt.getSource()==n_add){
            n_add.setBackground(new Color(25,26,46));
        }
        if(evt.getSource()==n_delete){
            n_delete.setBackground(new Color(25,26,46));
        }
        if(evt.getSource()==n_update){
            n_update.setBackground(new Color(25,26,46));
        }
        if(evt.getSource()==n_printreceipt){
            n_printreceipt.setBackground(new Color(25,26,46));
        }
    }//GEN-LAST:event_n_updatemouseexited

    private void n_printreceiptmouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n_printreceiptmouseclicked
        // TODO add your handling code here:
        if(evt.getSource()==n_add){
            j_update_det.setVisible(true);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_delete){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(true);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_update){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(true);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_printreceipt){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(true);
        }
    }//GEN-LAST:event_n_printreceiptmouseclicked

    private void n_printreceiptmouseentered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n_printreceiptmouseentered
        if(evt.getSource()==n_add){
            n_add.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_delete){
            n_delete.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_update){
            n_update.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_printreceipt){
            n_printreceipt.setBackground(new Color(0,0,0));
        }
    }//GEN-LAST:event_n_printreceiptmouseentered

    private void n_printreceiptmouseexited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n_printreceiptmouseexited
        if(evt.getSource()==n_add){
            n_add.setBackground(new Color(25,26,46));
        }
        if(evt.getSource()==n_delete){
            n_delete.setBackground(new Color(25,26,46));
        }
        if(evt.getSource()==n_update){
            n_update.setBackground(new Color(25,26,46));
        }
        if(evt.getSource()==n_printreceipt){
            n_printreceipt.setBackground(new Color(25,26,46));
        }
    }//GEN-LAST:event_n_printreceiptmouseexited

    private void e_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_idActionPerformed

    private void e_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_phoneActionPerformed

    private void e_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_maleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_maleActionPerformed

    private void e_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_femaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_femaleActionPerformed

    private void e_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_nameActionPerformed

    private void e_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_emailActionPerformed

    private void e_highest_qualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_highest_qualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_highest_qualActionPerformed

    private void e_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_departmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_departmentActionPerformed

    private void e_skillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_skillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_skillActionPerformed

    private void e_salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_salaryActionPerformed

    private void update_my_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_my_detailsActionPerformed
        int id=0,year_of_exp;
        String ename="",highest_qual="",skills="",email="";
        long phone=0;
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        if(e_id.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Please Enter employee ID.");
        }
        else if(e_name.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Please Enter employee name.");
        }
        else if(e_dob.getDate()==null){
            JOptionPane.showMessageDialog(null, "Please Enter employee Date Of Birth.");
        }
        else if(e_email.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Please Enter employee email.");
        }
        else if(e_phone.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Please Enter employee phone number.");
        }
        else if(e_highest_qual.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Please Enter employee highest qualification.");
        }
        else if(e_skill.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Please Enter employee skills.");
        }
        else if(!isStringValid(e_name.getText())){
            JOptionPane.showMessageDialog(null, "Employee name should only contain alphabets.");
        }
        else if (!isEmailValid(e_email.getText())){
            JOptionPane.showMessageDialog(null, "Employee email is not valid.");
        }
        else if (e_phone.getText().length()!=10){
            JOptionPane.showMessageDialog(null, "Employee phone number should contain 10 digits.");
        }
        else if(!isStringValid(e_highest_qual.getText())){
            JOptionPane.showMessageDialog(null, "Employee highest qualification should only contain alphabets.");
        }
        else{
            try{
                id=Integer.parseInt(e_id.getText());
                ename=e_name.getText();
                email=e_email.getText();
                Date dob=e_dob.getDate();
                String dob_s=sdf.format(dob);             
                String gender=(e_male.isSelected())?"Male":"Female";              
                highest_qual=e_highest_qual.getText();
                skills=e_skill.getText();
                try{
                    phone=Long.parseLong(e_phone.getText());
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Employee Phone Number must contain only digits.");
                }
                year_of_exp=(Integer)e_experience.getValue();

                //SQL Insertion
                try{
                    conn c1 = new conn();
                    String q="UPDATE employee1 set eid='"+id+"',ename='"+ename+"',email='"+email+"',gender='"+gender+"',phone_no='"+phone+"',dob='"+dob_s+"',yoe='"+year_of_exp+"',skills='"+skills+"',highest_qual='"+highest_qual+"' where ename='"+name.getText()+"'";
                    c1.s.executeUpdate(q);

                }
                catch(SQLException e){
                    e.printStackTrace();
                }

               
                          
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Employee ID must contain only number.");
        }

        }
    }//GEN-LAST:event_update_my_detailsActionPerformed

    private void j_update_detmouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_update_detmouseclicked
        // TODO add your handling code here:
        if(evt.getSource()==n_add){
            j_update_det.setVisible(true);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_delete){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(true);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_update){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(true);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_printreceipt){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(true);
        }
    }//GEN-LAST:event_j_update_detmouseclicked

    private void jmyprofilemouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmyprofilemouseclicked
        // TODO add your handling code here:
        if(evt.getSource()==n_add){
            j_update_det.setVisible(true);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_delete){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(true);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_update){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(true);
            jprintreceipt.setVisible(false);
        }
        if(evt.getSource()==n_printreceipt){
            j_update_det.setVisible(false);
            jmyprofile.setVisible(false);
            jupdatepassword.setVisible(false);
            jprintreceipt.setVisible(true);
        }
    }//GEN-LAST:event_jmyprofilemouseclicked

    private void jmyprofilemouseentered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmyprofilemouseentered
        if(evt.getSource()==n_add){
            n_add.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_delete){
            n_delete.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_update){
            n_update.setBackground(new Color(0,0,0));
        }
        if(evt.getSource()==n_printreceipt){
            n_printreceipt.setBackground(new Color(0,0,0));
        }
    }//GEN-LAST:event_jmyprofilemouseentered

    private void old_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_old_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_old_passwordActionPerformed
    public static boolean isEmailValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
    public static boolean isStringValid(String str) 
    { 
        String strRegex = "^[ A-Za-z]+$"; 
                              
        Pattern pat = Pattern.compile(strRegex); 
        if (str == null) 
            return false; 
        return pat.matcher(str).matches(); 
    } 
    private void new_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_new_passwordActionPerformed

    private void confirm_new_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_new_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirm_new_passwordActionPerformed

    private void change_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_passwordActionPerformed
        String old_pswd="",new_pswd="",confirm_new_pswd="";
        old_pswd=old_password.getText().toString();
        new_pswd=new_password.getText().toString();
        confirm_new_pswd=confirm_new_password.getText().toString();
       if(old_password.getText().length()==0){
           JOptionPane.showMessageDialog(null, "Please Enter old password.");
       }
       else if(new_password.getText().length()==0){
           JOptionPane.showMessageDialog(null, "Please Enter new password.");
       }
       else if(confirm_new_password.getText().length()==0){
           JOptionPane.showMessageDialog(null, "Please Enter confirm new password.");
       }
       else if(!isPasswordValid(new_password.getText())){
            JOptionPane.showMessageDialog(null, "Entered password is not valid.");
       }
       else if(!new_pswd.equals(confirm_new_pswd)){
            JOptionPane.showMessageDialog(null, "New Pssword and Confirm new password does not match.");
       }
       else{
            try{
                String o_pswd;
                conn c1 = new conn();
    
                String q="select password from employee1 where ename='"+name.getText()+"'";
                ResultSet rs=c1.s.executeQuery(q);
                if(rs.next()){
                    o_pswd=rs.getString("password");
                    if(o_pswd==old_password.getText()){
                        JOptionPane.showMessageDialog(null, "Old Password does not match.");
                    }
                    else{
                        q="update employee1 set password='"+new_pswd+"' where ename='"+name.getText()+"'";
                        c1.s.executeUpdate(q);  
                        old_password.setText("");
                        new_password.setText("");
                        confirm_new_password.setText("");
                        JOptionPane.showMessageDialog(null, "Password updated successfully");
                    }
                }                            
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            
       }
    }//GEN-LAST:event_change_passwordActionPerformed

    private void e_designationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_designationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_designationActionPerformed

    private void j_update_det1mouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_update_det1mouseclicked
        // TODO add your handling code here:
    }//GEN-LAST:event_j_update_det1mouseclicked

    private void apply_leaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apply_leaveActionPerformed
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
       if(reason.getText().length()==0){
           JOptionPane.showMessageDialog(null, "Please Enter .");
       }
       else if(start_date.getDate()==null){
           JOptionPane.showMessageDialog(null, "Please Enter Start Date.");
       }
       else if(end_date.getDate()==null){
           JOptionPane.showMessageDialog(null, "Please Enter End Date.");
       }
       else{
                Date sd=start_date.getDate();
                Date ed=end_date.getDate();
                String sd_s=sdf.format(sd);
                String ed_s=sdf.format(ed);
                String s_reason=reason.getText();           
                //SQL Insertion
                try{
                    conn c1 = new conn();
                    String q = "INSERT INTO `attendance`(`EID`, `ENAME`, `START_DATE`, `END_DATE`, `REASON`,`STATUS`) VALUES ('"+employee_login.logged_in_eid+"','"+name.getText()+"','"+sd_s+"','"+ed_s+"','"+s_reason+"','PENDING')";

                    c1.s.executeUpdate(q); 
                    start_date.setDate(null);
                    end_date.setDate(null);
                    reason.setText("");
                    
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
           
       }      
    }//GEN-LAST:event_apply_leaveActionPerformed
    public static boolean isPasswordValid(String str) 
    { 
        String strRegex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"; 
                              
        Pattern pat = Pattern.compile(strRegex); 
        if (str == null) 
            return false; 
        return pat.matcher(str).matches(); 
    } 
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
            java.util.logging.Logger.getLogger(EmployeeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton apply_leave;
    private javax.swing.JButton change_password;
    private javax.swing.JTextField confirm_new_password;
    private javax.swing.JLabel d_name;
    private javax.swing.JTextField e_department;
    private javax.swing.JTextField e_designation;
    private com.toedter.calendar.JDateChooser e_dob;
    private com.toedter.calendar.JDateChooser e_doj;
    private javax.swing.JTextField e_email;
    private javax.swing.JSpinner e_experience;
    private javax.swing.JRadioButton e_female;
    private javax.swing.JTextField e_highest_qual;
    private javax.swing.JTextField e_id;
    private javax.swing.JRadioButton e_male;
    private javax.swing.JTextField e_name;
    private javax.swing.JTextField e_phone;
    private javax.swing.JTextField e_salary;
    private javax.swing.JTextField e_skill;
    private com.toedter.calendar.JDateChooser end_date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel j_update_det;
    private javax.swing.JPanel j_update_det1;
    private javax.swing.JPanel jmyprofile;
    private javax.swing.JPanel jprintreceipt;
    private javax.swing.JPanel jupdatepassword;
    private javax.swing.JLabel l_department;
    private javax.swing.JLabel l_department1;
    private javax.swing.JLabel l_department2;
    private javax.swing.JLabel l_designation;
    private javax.swing.JLabel l_designation1;
    private javax.swing.JLabel l_designation2;
    private javax.swing.JLabel l_dob;
    private javax.swing.JLabel l_dob1;
    private javax.swing.JLabel l_dob2;
    private javax.swing.JLabel l_doj;
    private javax.swing.JLabel l_doj1;
    private javax.swing.JLabel l_doj2;
    private javax.swing.JLabel l_email;
    private javax.swing.JLabel l_email1;
    private javax.swing.JLabel l_email2;
    private javax.swing.JLabel l_emp_details;
    private javax.swing.JLabel l_emp_details1;
    private javax.swing.JLabel l_experience;
    private javax.swing.JLabel l_experience1;
    private javax.swing.JLabel l_experience2;
    private javax.swing.JLabel l_gender;
    private javax.swing.JLabel l_gender1;
    private javax.swing.JLabel l_gender2;
    private javax.swing.JLabel l_highest_qual;
    private javax.swing.JLabel l_highest_qual1;
    private javax.swing.JLabel l_highest_qual2;
    private javax.swing.JLabel l_id;
    private javax.swing.JLabel l_id1;
    private javax.swing.JLabel l_id2;
    private javax.swing.JLabel l_name;
    private javax.swing.JLabel l_name1;
    private javax.swing.JLabel l_name2;
    private javax.swing.JLabel l_phone;
    private javax.swing.JLabel l_phone1;
    private javax.swing.JLabel l_phone2;
    private javax.swing.JLabel l_salary;
    private javax.swing.JLabel l_salary1;
    private javax.swing.JLabel l_salary2;
    private javax.swing.JLabel l_skill;
    private javax.swing.JLabel l_skill1;
    private javax.swing.JLabel l_skill2;
    private javax.swing.JLabel l_update_emp_details;
    private javax.swing.JLabel l_work_details;
    private javax.swing.JPanel n_add;
    private javax.swing.JPanel n_delete;
    private javax.swing.JPanel n_printreceipt;
    private javax.swing.JPanel n_update;
    public javax.swing.JLabel name;
    private javax.swing.JTextField new_password;
    private javax.swing.JTextField old_password;
    private javax.swing.JTextArea reason;
    private com.toedter.calendar.JDateChooser start_date;
    private javax.swing.JLabel u_l_id1;
    private javax.swing.JLabel u_l_id2;
    private javax.swing.JLabel u_l_id3;
    private javax.swing.JButton update_my_details;
    public javax.swing.JPanel username;
    // End of variables declaration//GEN-END:variables
}
