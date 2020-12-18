
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

public class Details extends javax.swing.JFrame {

    public Details() {
        initComponents();
        //Manage Employee page table
        JTableHeader tableHeader = jTable1.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI",Font.BOLD,15));
        tableHeader.setOpaque(false);
        tableHeader.setForeground(new Color(0,0,0));
        tableHeader.setBackground(new Color(7,43,108));
        //Manage Department page table
        tableHeader = dept_emp_details.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI",Font.BOLD,15));
        tableHeader.setOpaque(false);
        tableHeader.setForeground(new Color(0,0,0));
        tableHeader.setBackground(new Color(7,43,108));
        try{
            conn c1 = new conn();
            //For displaying department
            String q = "select dept_name from department1";
            
            ResultSet rs = c1.s.executeQuery(q); 
            while(rs.next()){
                String dname=rs.getString("dept_name");
                jComboBox1.addItem(dname);
                m_dept_id.addItem(dname);
            }
            //For View Details Page
            q = "select eid,ename from employee1";
            
            rs = c1.s.executeQuery(q); 
            while(rs.next()){
                String v_id=String.valueOf(rs.getInt("eid"));
                String v_name=rs.getString("ename");
                v_e_id.addItem(v_id+" --> "+v_name);
                p_e_id.addItem(v_id+" --> "+v_name);
            }
            //For showing employee details
            q = "select eid,ename,department,designation,salary,email,phone_no from employee1";
            rs = c1.s.executeQuery(q); 
                while(rs.next()){
                    String id=String.valueOf(rs.getInt("eid"));
                    String name=rs.getString("ename");
                    String department=rs.getString("department");
                    String designation=rs.getString("designation");
                    String salary=String.valueOf(rs.getDouble("salary"));
                    String email=rs.getString("email");
                    String phone_no=String.valueOf(rs.getLong("phone_no"));
                    String tbData[]={id,name,department,designation,salary,email,phone_no};
                    DefaultTableModel tblModel=(DefaultTableModel)jTable1.getModel();
                    tblModel.addRow(tbData);
                }
            //For showing employee details in manage department
            q = "select eid,ename from employee1";
            rs = c1.s.executeQuery(q); 
                while(rs.next()){
                    String id=String.valueOf(rs.getInt("eid"));
                    String name=rs.getString("ename");
                    String tbData[]={id,name};
                    DefaultTableModel tblModel=(DefaultTableModel)dept_emp_details.getModel();
                    tblModel.addRow(tbData);
                }
            //For showing attendance detail in manage leave
            q = "select * from attendance";
            rs = c1.s.executeQuery(q); 
                while(rs.next()){
                    String id=String.valueOf(rs.getInt("eid"));
                    String name=rs.getString("ename");
                    String reason=rs.getString("reason");
                    String sd=rs.getString("start_date");
                    String ed=rs.getString("end_date");
                    String status=rs.getString("status");
                    String tbData[]={id,name,sd,ed,reason,status};
                    DefaultTableModel tblModel=(DefaultTableModel) emp_leaverequest.getModel();
                    tblModel.addRow(tbData);
                }
            //For showing employee details in manage department
            q = "select eid,ename from attendance";
            rs = c1.s.executeQuery(q); 
                while(rs.next()){
                    String id=String.valueOf(rs.getInt("eid"));
                    String name=rs.getString("ename");
                    emp_leave_id.addItem(id+" --> "+name);
                }
            
            }
        
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenu2 = new javax.swing.JMenu();
        username = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        n_add = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        n_delete = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        n_update = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        n_printreceipt = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        n_manageleave = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jadd = new javax.swing.JPanel();
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
        e_designation = new javax.swing.JTextField();
        l_password = new javax.swing.JLabel();
        e_skill = new javax.swing.JTextField();
        l_work_details = new javax.swing.JLabel();
        l_designation = new javax.swing.JLabel();
        l_department = new javax.swing.JLabel();
        e_password = new javax.swing.JTextField();
        l_doj = new javax.swing.JLabel();
        e_doj = new com.toedter.calendar.JDateChooser();
        l_salary = new javax.swing.JLabel();
        e_salary = new javax.swing.JTextField();
        l_highest_qual = new javax.swing.JLabel();
        e_experience = new javax.swing.JSpinner();
        add_btn = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jmanageemployee = new javax.swing.JPanel();
        l_delete_emp_det = new javax.swing.JLabel();
        d_l_id = new javax.swing.JLabel();
        v_e_id = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        UPDATE = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        print_emp_table = new javax.swing.JButton();
        jmanagedepartment = new javax.swing.JPanel();
        l_update_emp_details = new javax.swing.JLabel();
        u_l_id = new javax.swing.JLabel();
        m_dept_id = new javax.swing.JComboBox<>();
        u_l_id1 = new javax.swing.JLabel();
        new_dept = new javax.swing.JTextField();
        add_department = new javax.swing.JButton();
        d_name = new javax.swing.JLabel();
        print_table = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        dept_emp_details = new javax.swing.JTable();
        jprintreceipt = new javax.swing.JPanel();
        p_e_id = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        payslip_area = new javax.swing.JTextArea();
        print_receipt = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pay_date = new com.toedter.calendar.JDateChooser();
        generate_receipt = new javax.swing.JButton();
        japplyleave = new javax.swing.JPanel();
        l_delete_emp_det1 = new javax.swing.JLabel();
        emp_leave_id = new javax.swing.JComboBox<>();
        u_l_id2 = new javax.swing.JLabel();
        reject = new javax.swing.JButton();
        accept = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        emp_leaverequest = new javax.swing.JTable();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        username.setBackground(new java.awt.Color(25, 26, 46));

        name.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Welcome ");

        javax.swing.GroupLayout usernameLayout = new javax.swing.GroupLayout(username);
        username.setLayout(usernameLayout);
        usernameLayout.setHorizontalGroup(
            usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameLayout.createSequentialGroup()
                .addGap(534, 534, 534)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(613, Short.MAX_VALUE))
        );
        usernameLayout.setVerticalGroup(
            usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usernameLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        getContentPane().add(username, java.awt.BorderLayout.PAGE_START);
        username.getAccessibleContext().setAccessibleParent(username);

        jPanel1.setBackground(new java.awt.Color(25, 26, 46));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 470));

        n_add.setBackground(new java.awt.Color(25, 26, 46));
        n_add.setPreferredSize(new java.awt.Dimension(170, 51));
        n_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseentered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseexited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add Employee");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclicked(evt);
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
                mouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseentered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseexited(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(25, 26, 46));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Manage Employee");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclicked(evt);
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
                mouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseentered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseexited(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Manage Department");

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
                mouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseentered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseexited(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Print Receipt");

        javax.swing.GroupLayout n_printreceiptLayout = new javax.swing.GroupLayout(n_printreceipt);
        n_printreceipt.setLayout(n_printreceiptLayout);
        n_printreceiptLayout.setHorizontalGroup(
            n_printreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(n_printreceiptLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        n_printreceiptLayout.setVerticalGroup(
            n_printreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, n_printreceiptLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        n_manageleave.setBackground(new java.awt.Color(25, 26, 46));
        n_manageleave.setForeground(new java.awt.Color(255, 255, 255));
        n_manageleave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseentered(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Manage Leave");

        javax.swing.GroupLayout n_manageleaveLayout = new javax.swing.GroupLayout(n_manageleave);
        n_manageleave.setLayout(n_manageleaveLayout);
        n_manageleaveLayout.setHorizontalGroup(
            n_manageleaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(n_manageleaveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        n_manageleaveLayout.setVerticalGroup(
            n_manageleaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(n_manageleaveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(n_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addComponent(n_update, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addComponent(n_add, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(n_printreceipt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(n_manageleave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(n_manageleave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 399, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel5.setLayout(new java.awt.CardLayout());

        jadd.setBackground(new java.awt.Color(255, 255, 255));
        jadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclicked(evt);
            }
        });

        l_emp_details.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        l_emp_details.setForeground(new java.awt.Color(25, 26, 46));
        l_emp_details.setText("                                                       EMPLOYEE DETAILS");

        l_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_name.setText("NAME");

        e_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_idActionPerformed(evt);
            }
        });

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
        buttonGroup1.add(e_male);
        e_male.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        e_male.setSelected(true);
        e_male.setText("Male");
        e_male.setName("male"); // NOI18N
        e_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_maleActionPerformed(evt);
            }
        });

        e_female.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(e_female);
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

        e_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_nameActionPerformed(evt);
            }
        });

        e_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_emailActionPerformed(evt);
            }
        });

        l_experience.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_experience.setText("YEAR OF EXPERIENCE");

        e_highest_qual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_highest_qualActionPerformed(evt);
            }
        });

        l_skill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_skill.setText("SKILLS");

        e_designation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_designationActionPerformed(evt);
            }
        });

        l_password.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_password.setText("PASSWORD");

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

        e_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_passwordActionPerformed(evt);
            }
        });

        l_doj.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_doj.setText("DATE OF JOINING");

        e_doj.setBackground(new java.awt.Color(255, 255, 255));

        l_salary.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_salary.setText("SALARY");

        e_salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_salaryActionPerformed(evt);
            }
        });

        l_highest_qual.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_highest_qual.setText("HIGHEST QUALIFICATION");

        e_experience.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        add_btn.setBackground(new java.awt.Color(25, 26, 46));
        add_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add_btn.setForeground(new java.awt.Color(255, 255, 255));
        add_btn.setText("ADD");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jaddLayout = new javax.swing.GroupLayout(jadd);
        jadd.setLayout(jaddLayout);
        jaddLayout.setHorizontalGroup(
            jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l_emp_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jaddLayout.createSequentialGroup()
                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jaddLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jaddLayout.createSequentialGroup()
                                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_gender)
                                    .addComponent(l_department)
                                    .addComponent(l_doj)
                                    .addComponent(l_salary))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jaddLayout.createSequentialGroup()
                                        .addComponent(e_male)
                                        .addGap(30, 30, 30)
                                        .addComponent(e_female))
                                    .addComponent(e_doj, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(e_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jaddLayout.createSequentialGroup()
                                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_dob)
                                    .addComponent(l_password)
                                    .addComponent(l_designation)
                                    .addComponent(l_name)
                                    .addComponent(l_id))
                                .addGap(35, 35, 35)
                                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(e_id, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(e_designation, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(e_password, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(e_name, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(e_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(70, 70, 70)
                        .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jaddLayout.createSequentialGroup()
                                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_phone)
                                    .addComponent(l_email))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(e_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(e_phone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jaddLayout.createSequentialGroup()
                                .addComponent(l_highest_qual)
                                .addGap(18, 18, 18)
                                .addComponent(e_highest_qual, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jaddLayout.createSequentialGroup()
                                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_skill)
                                    .addComponent(l_experience))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(e_experience, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(e_skill, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jaddLayout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(l_work_details, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jaddLayout.createSequentialGroup()
                        .addGap(477, 477, 477)
                        .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jaddLayout.setVerticalGroup(
            jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jaddLayout.createSequentialGroup()
                .addComponent(l_emp_details, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jaddLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(e_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_id, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_email, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jaddLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(e_email, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(e_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(l_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e_name, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jaddLayout.createSequentialGroup()
                        .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jaddLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(l_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jaddLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(e_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e_male)
                            .addComponent(e_female))
                        .addGap(18, 18, 18)
                        .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_password, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e_password, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jaddLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_highest_qual, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e_highest_qual, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(e_skill, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_skill, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_experience, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e_experience, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addComponent(l_work_details)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_designation, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e_designation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_department, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jaddLayout.createSequentialGroup()
                        .addComponent(l_doj, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(l_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jaddLayout.createSequentialGroup()
                        .addComponent(e_doj, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(e_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel5.add(jadd, "card2");

        jmanageemployee.setBackground(new java.awt.Color(255, 255, 255));
        jmanageemployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseentered(evt);
            }
        });

        l_delete_emp_det.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        l_delete_emp_det.setForeground(new java.awt.Color(25, 26, 46));
        l_delete_emp_det.setText("MANAGE EMPLOYEE DETAILS");

        d_l_id.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        d_l_id.setText("ID");

        v_e_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL" }));
        v_e_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                v_e_idItemStateChanged(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(25, 26, 46));
        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMP NO", "EMP NAME", "DEPARTMENT", "DESIGNATION", "SALARY", "EMAIL", "PHONE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setDragEnabled(true);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setOpaque(false);
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setHeaderValue("SALARY");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("EMAIL");
            jTable1.getColumnModel().getColumn(6).setHeaderValue("PHONE");
        }

        UPDATE.setBackground(new java.awt.Color(100, 136, 72));
        UPDATE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        UPDATE.setForeground(new java.awt.Color(255, 255, 255));
        UPDATE.setText(" UPDATE");
        UPDATE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onUpdate(evt);
            }
        });
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(178, 12, 56));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("DELETE");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onDelete(evt);
            }
        });

        print_emp_table.setBackground(new java.awt.Color(25, 26, 46));
        print_emp_table.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_emp_table.setForeground(new java.awt.Color(255, 255, 255));
        print_emp_table.setText("PRINT");
        print_emp_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                print_emp_tableMouseClicked(evt);
            }
        });
        print_emp_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_emp_tableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jmanageemployeeLayout = new javax.swing.GroupLayout(jmanageemployee);
        jmanageemployee.setLayout(jmanageemployeeLayout);
        jmanageemployeeLayout.setHorizontalGroup(
            jmanageemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jmanageemployeeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(l_delete_emp_det, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(403, 403, 403))
            .addGroup(jmanageemployeeLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(d_l_id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(v_e_id, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(324, 324, 324)
                .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jmanageemployeeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jmanageemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(print_emp_table, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jmanageemployeeLayout.setVerticalGroup(
            jmanageemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jmanageemployeeLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(l_delete_emp_det)
                .addGap(9, 9, 9)
                .addGroup(jmanageemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jmanageemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(v_e_id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(d_l_id))
                    .addComponent(UPDATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addComponent(print_emp_table, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jPanel5.add(jmanageemployee, "card3");

        jmanagedepartment.setBackground(new java.awt.Color(255, 255, 255));

        l_update_emp_details.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        l_update_emp_details.setForeground(new java.awt.Color(25, 26, 46));
        l_update_emp_details.setText("                                                           MANAGE DEPARTMENTS");

        u_l_id.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        u_l_id.setText("DEPARTMENT");

        m_dept_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL" }));
        m_dept_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                m_dept_idItemStateChanged(evt);
            }
        });

        u_l_id1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        u_l_id1.setText("NEW DEPARTMENT");

        new_dept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_deptActionPerformed(evt);
            }
        });

        add_department.setBackground(new java.awt.Color(32, 94, 13));
        add_department.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add_department.setForeground(new java.awt.Color(222, 245, 216));
        add_department.setText("+ ADD");
        add_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_departmentActionPerformed(evt);
            }
        });

        d_name.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        d_name.setForeground(new java.awt.Color(18, 83, 116));

        print_table.setBackground(new java.awt.Color(25, 26, 46));
        print_table.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_table.setForeground(new java.awt.Color(255, 255, 255));
        print_table.setText("PRINT");
        print_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_tableActionPerformed(evt);
            }
        });

        dept_emp_details.setBackground(new java.awt.Color(25, 26, 46));
        dept_emp_details.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        dept_emp_details.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dept_emp_details.setForeground(new java.awt.Color(255, 255, 255));
        dept_emp_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMP NO", "EMP NAME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dept_emp_details.setDragEnabled(true);
        dept_emp_details.setGridColor(new java.awt.Color(255, 255, 255));
        dept_emp_details.setOpaque(false);
        dept_emp_details.setRowHeight(30);
        jScrollPane4.setViewportView(dept_emp_details);
        dept_emp_details.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jmanagedepartmentLayout = new javax.swing.GroupLayout(jmanagedepartment);
        jmanagedepartment.setLayout(jmanagedepartmentLayout);
        jmanagedepartmentLayout.setHorizontalGroup(
            jmanagedepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jmanagedepartmentLayout.createSequentialGroup()
                .addGroup(jmanagedepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jmanagedepartmentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(l_update_emp_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jmanagedepartmentLayout.createSequentialGroup()
                        .addGroup(jmanagedepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jmanagedepartmentLayout.createSequentialGroup()
                                .addGap(369, 369, 369)
                                .addComponent(u_l_id))
                            .addGroup(jmanagedepartmentLayout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(u_l_id1)))
                        .addGap(57, 57, 57)
                        .addGroup(jmanagedepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jmanagedepartmentLayout.createSequentialGroup()
                                .addComponent(new_dept, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(add_department, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(m_dept_id, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jmanagedepartmentLayout.createSequentialGroup()
                .addContainerGap(212, Short.MAX_VALUE)
                .addGroup(jmanagedepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jmanagedepartmentLayout.createSequentialGroup()
                        .addComponent(d_name, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(print_table, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(129, 129, 129))
        );
        jmanagedepartmentLayout.setVerticalGroup(
            jmanagedepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jmanagedepartmentLayout.createSequentialGroup()
                .addComponent(l_update_emp_details, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jmanagedepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(u_l_id, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_dept_id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jmanagedepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jmanagedepartmentLayout.createSequentialGroup()
                        .addComponent(u_l_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(d_name))
                    .addGroup(jmanagedepartmentLayout.createSequentialGroup()
                        .addGroup(jmanagedepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(new_dept, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add_department, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(print_table, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel5.add(jmanagedepartment, "card4");

        jprintreceipt.setBackground(new java.awt.Color(255, 255, 255));

        p_e_id.setForeground(new java.awt.Color(186, 122, 139));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 26, 46));
        jLabel1.setText("Print Salary Receipt");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Select Employee ID");

        payslip_area.setColumns(20);
        payslip_area.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        payslip_area.setRows(5);
        payslip_area.setText("\n");
        jScrollPane3.setViewportView(payslip_area);

        print_receipt.setBackground(new java.awt.Color(25, 26, 46));
        print_receipt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_receipt.setForeground(new java.awt.Color(255, 255, 255));
        print_receipt.setText("Print");
        print_receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_receiptActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Date");

        generate_receipt.setBackground(new java.awt.Color(161, 22, 71));
        generate_receipt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        generate_receipt.setForeground(new java.awt.Color(255, 255, 255));
        generate_receipt.setText("Generate Receipt");
        generate_receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_receiptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jprintreceiptLayout = new javax.swing.GroupLayout(jprintreceipt);
        jprintreceipt.setLayout(jprintreceiptLayout);
        jprintreceiptLayout.setHorizontalGroup(
            jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jprintreceiptLayout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(538, Short.MAX_VALUE))
            .addGroup(jprintreceiptLayout.createSequentialGroup()
                .addGroup(jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jprintreceiptLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(generate_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jprintreceiptLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(12, 12, 12)
                        .addGroup(jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(p_e_id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pay_date, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jprintreceiptLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(print_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(318, 318, 318))
        );
        jprintreceiptLayout.setVerticalGroup(
            jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jprintreceiptLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jprintreceiptLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_e_id, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jprintreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pay_date, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(generate_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jprintreceiptLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jPanel5.add(jprintreceipt, "card5");

        japplyleave.setBackground(new java.awt.Color(255, 255, 255));

        l_delete_emp_det1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        l_delete_emp_det1.setForeground(new java.awt.Color(25, 26, 46));
        l_delete_emp_det1.setText("MANAGE EMPLOYEE LEAVE REQUEST");

        emp_leave_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL" }));
        emp_leave_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                emp_leave_idItemStateChanged(evt);
            }
        });
        emp_leave_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_leave_idActionPerformed(evt);
            }
        });

        u_l_id2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        u_l_id2.setText("EMPLOYEE");

        reject.setBackground(new java.awt.Color(188, 17, 72));
        reject.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        reject.setForeground(new java.awt.Color(255, 255, 255));
        reject.setText("REJECT");
        reject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rejectonUpdate(evt);
            }
        });
        reject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectActionPerformed(evt);
            }
        });

        accept.setBackground(new java.awt.Color(100, 136, 72));
        accept.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        accept.setForeground(new java.awt.Color(255, 255, 255));
        accept.setText("ACCEPT");
        accept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acceptonUpdate(evt);
            }
        });
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });

        emp_leaverequest.setBackground(new java.awt.Color(25, 26, 46));
        emp_leaverequest.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        emp_leaverequest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emp_leaverequest.setForeground(new java.awt.Color(255, 255, 255));
        emp_leaverequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMP NO", "EMP NAME", "START_DATE", "END_DATE", "REASON", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        emp_leaverequest.setDragEnabled(true);
        emp_leaverequest.setGridColor(new java.awt.Color(255, 255, 255));
        emp_leaverequest.setOpaque(false);
        emp_leaverequest.setRowHeight(30);
        jScrollPane2.setViewportView(emp_leaverequest);
        emp_leaverequest.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout japplyleaveLayout = new javax.swing.GroupLayout(japplyleave);
        japplyleave.setLayout(japplyleaveLayout);
        japplyleaveLayout.setHorizontalGroup(
            japplyleaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(japplyleaveLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(japplyleaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, japplyleaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, japplyleaveLayout.createSequentialGroup()
                            .addComponent(l_delete_emp_det1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(330, 330, 330))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, japplyleaveLayout.createSequentialGroup()
                            .addComponent(u_l_id2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emp_leave_id, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(415, 415, 415)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, japplyleaveLayout.createSequentialGroup()
                        .addGroup(japplyleaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(japplyleaveLayout.createSequentialGroup()
                                .addComponent(accept, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(reject, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );
        japplyleaveLayout.setVerticalGroup(
            japplyleaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(japplyleaveLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(l_delete_emp_det1)
                .addGap(32, 32, 32)
                .addGroup(japplyleaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emp_leave_id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(u_l_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(japplyleaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reject, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accept, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(japplyleave, "card6");

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseclicked
        // TODO add your handling code here:
        if(evt.getSource()==n_add){
            jadd.setVisible(true);
            jmanageemployee.setVisible(false);
            jmanagedepartment.setVisible(false);
            jprintreceipt.setVisible(false);
            japplyleave.setVisible(false);
        }
        if(evt.getSource()==n_delete){
            jadd.setVisible(false);
            jmanageemployee.setVisible(true);
            jmanagedepartment.setVisible(false);
            jprintreceipt.setVisible(false);
            japplyleave.setVisible(false);
        }
        if(evt.getSource()==n_update){
            jadd.setVisible(false);
            jmanageemployee.setVisible(false);
            jmanagedepartment.setVisible(true);
            jprintreceipt.setVisible(false);
            japplyleave.setVisible(false);
        }
         if(evt.getSource()==n_printreceipt){
            jadd.setVisible(false);
            jmanageemployee.setVisible(false);
            jmanagedepartment.setVisible(false);
            japplyleave.setVisible(false);
            jprintreceipt.setVisible(true);
        }
         if(evt.getSource()==n_manageleave){
            jadd.setVisible(false);
            jmanageemployee.setVisible(false);
            jmanagedepartment.setVisible(false);
            jprintreceipt.setVisible(false);
            japplyleave.setVisible(true);
        }
    }//GEN-LAST:event_mouseclicked

    private void mouseentered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseentered
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
        if(evt.getSource()==n_manageleave){
            n_manageleave.setBackground(new Color(0,0,0));
        }
    }//GEN-LAST:event_mouseentered

    private void mouseexited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseexited
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
        if(evt.getSource()==n_manageleave){
            n_manageleave.setBackground(new Color(25,26,46));
        }
    }//GEN-LAST:event_mouseexited

    private void e_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_idActionPerformed

    private void e_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_phoneActionPerformed

    private void e_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_femaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_femaleActionPerformed

    private void e_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_maleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_maleActionPerformed

    private void e_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_nameActionPerformed

    private void e_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_emailActionPerformed

    private void e_highest_qualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_highest_qualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_highest_qualActionPerformed

    private void e_designationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_designationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_designationActionPerformed

    private void e_skillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_skillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_skillActionPerformed

    private void e_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_passwordActionPerformed

    private void e_salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_salaryActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
       int id=0,year_of_exp;
       String name="",designation="",highest_qual="",skills="",email="",department="",password="";
       long phone=0;
       Double salary=0.0;
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
       else if(e_doj.getDate()==null){
           JOptionPane.showMessageDialog(null, "Please Enter employee Date Of Joining.");
       }
       else if(e_password.getText().length()==0){
           JOptionPane.showMessageDialog(null, "Please Enter employee password.");
       }
       else if(e_designation.getText().length()==0){
           JOptionPane.showMessageDialog(null, "Please Enter employee designation.");
       }
       else if(e_salary.getText().length()==0){
           JOptionPane.showMessageDialog(null, "Please Enter employee salary.");
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
       else if(!isStringValid(e_designation.getText())){
            JOptionPane.showMessageDialog(null, "Employee designation should only contain alphabets.");
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
                name=e_name.getText();
                email=e_email.getText();
                password=e_password.getText();
                Date dob=e_dob.getDate();
                Date doj=e_doj.getDate();
                String dob_s=sdf.format(dob);
                String doj_s=sdf.format(doj);
                salary=Double.parseDouble(e_salary.getText());
                String gender=(e_male.isSelected())?"Male":"Female";
                designation=e_designation.getText();
                department=jComboBox1.getSelectedItem().toString();
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
                    String q = "INSERT INTO `employee1`(`EID`, `ENAME`, `DOB`, `GENDER`, `PASSWORD`,`DESIGNATION`, `DEPARTMENT`, `DOJ`, `SALARY`, `EMAIL`, `PHONE_NO`, `HIGHEST_QUAL`, `SKILLS`, `YOE`) VALUES ('"+id+"','"+name+"','"+dob_s+"','"+gender+"','"+password+"','"+designation+"','"+department+"','"+doj_s+"','"+salary+"','"+email+"','"+phone+"','"+highest_qual+"','"+skills+"','"+year_of_exp+"')";

                    c1.s.executeUpdate(q); 
                    e_id.setText("");
                    e_name.setText("");
                    e_email.setText("");
                    e_phone.setText("");
                    e_dob.setDate(null);
                    e_doj.setDate(null);
                    e_designation.setText("");
                    e_salary.setText("");
                    e_highest_qual.setText("");
                    e_skill.setText("");
                    
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                
                JOptionPane.showMessageDialog(null, id+name+dob+gender);
                JOptionPane.showMessageDialog(null, department);
                
                //Sending Email
//                String toEmail="shettymalathijaya09@gmail.com";
//                String fromEmail="shettymalathijaya09@gmail.com";
//                String fromPassword="malathi09";
//                String Subject="EMS";
//                
//                Properties p=new Properties();
//                p.put("mail.smtp.auth", "true");
//                p.put("mail.smtp.starttls.enable","true");
//                p.put("mail.smtp.host","smtp.gmail.com");
//                p.put("mail.smtp.port","567");
//                
//                Session s=Session.getDefaultInstance(p, new javax.mail.Authenticator(){
//                    protected PasswordAuthentication getPasswordAuthentication(){
//                        return new PasswordAuthentication(fromEmail,fromPassword);
//                    }
//                });
//                try{
//                     MimeMessage message = new MimeMessage(s);  
//                     message.setFrom(new InternetAddress(fromEmail));  
//                     message.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));  
//                        message.setSubject("Ping");  
//                        message.setText("Hello, this is example of sending email  ");  
//                                 // Send message  
//         Transport.send(message);  
//         System.out.println("message sent successfully...."); 
//                }
//                catch(Exception ex){
//                    System.out.println(ex);
//                }
//                try{
//                    Email email_send=new Email("shettymalathijaya09@gmail.com","malathi09");
//                    email_send.setFrom("shettymalathijaya09@gmail.com", "Employee Management System");
//                    email_send.setSubject("This email is for testing.");
//                    email_send.setContent("<h1>This is content</h1>","text/html");
//                    email_send.addRecipient("shettymalathijaya09@gmail.com");
//                    email_send.send();
//                }
//                catch(Exception e){
//                    e.printStackTrace();
//                }
           }
           catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null, "Employee ID must contain only number.");
           }
           
       }      
    }//GEN-LAST:event_add_btnActionPerformed

    private void v_e_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_v_e_idItemStateChanged
        String q="select eid,ename,department,designation,salary,email,phone_no from employee1";
        ResultSet rs;
        DefaultTableModel tblModel=(DefaultTableModel)jTable1.getModel();
        tblModel.setRowCount(0);//For clearing table
        try{
            conn c1 = new conn();
            //For showing employee details
            
            if(evt.getStateChange()==1){
                if(evt.getItem().toString().equals("ALL")){
//                    JOptionPane.showMessageDialog(null, evt.getItem().toString());
                    q = "select eid,ename,department,designation,salary,email,phone_no from employee1";
                }
                else{
                    String val=evt.getItem().toString().split("-->")[0];
                    q = "select eid,ename,department,designation,salary,email,phone_no from employee1 where eid='"+val+"'";
                }
                            rs = c1.s.executeQuery(q); 
                while(rs.next()){
                    String id=String.valueOf(rs.getInt("eid"));
                    String name=rs.getString("ename");
                    String department=rs.getString("department");
                    String designation=rs.getString("designation");
                    String salary=String.valueOf(rs.getDouble("salary"));
                    String email=rs.getString("email");
                    String phone_no=String.valueOf(rs.getLong("phone_no"));
                    String tbData[]={id,name,department,designation,salary,email,phone_no};
                    
                    
                    tblModel.addRow(tbData);
                }
            }

            }
        catch(SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_v_e_idItemStateChanged

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UPDATEActionPerformed

    private void onDelete(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onDelete
        String record=v_e_id.getSelectedItem().toString();
        try{
            conn c1 = new conn();
             if(record.equals("ALL")){
                JOptionPane.showMessageDialog(null, "Please select record you want to delete.");
            }
            else{
                String val=record.split("-->")[0];
                
                int result=JOptionPane.showConfirmDialog(null, "Are you sure want to delete record "+record,"Delete Record",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                if(result==JOptionPane.YES_OPTION){
                    String q = "delete from employee1 where eid='"+val+"'";
                    c1.s.execute(q);
                    JOptionPane.showMessageDialog(null,"Record "+record+" deleted successfully.");
                }
                else{
                    
                }
                
            }
        }
       catch(SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_onDelete

    private void onUpdate(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onUpdate
        String record=v_e_id.getSelectedItem().toString();
        try{
            conn c1 = new conn();
             if(record.equals("ALL")){
                JOptionPane.showMessageDialog(null, "Please select record you want to update.");
            }
            else{
                String val=record.split("-->")[0];
                TableModel tblModel=(DefaultTableModel)jTable1.getModel();
                String name=tblModel.getValueAt(0,1).toString();
                String department=tblModel.getValueAt(0,2).toString();
                String designation=tblModel.getValueAt(0,3).toString();
                Double salary=Double.parseDouble(tblModel.getValueAt(0,4).toString());
                String email=tblModel.getValueAt(0,5).toString();
                Long phone=Long.parseLong(tblModel.getValueAt(0,6).toString());
                
                String q = "update employee1 set ename='"+name+"',department='"+department+"',designation='"+designation+"',salary='"+salary+"',email='"+email+"',phone_no='"+phone+"' where eid='"+val+"'";
                c1.s.executeUpdate(q);
                
                JOptionPane.showMessageDialog(null,name+department+designation+salary+email+phone);
                JOptionPane.showMessageDialog(null,"Record "+record+" updated successfully.");
             }
        }
       catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_onUpdate

    private void add_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_departmentActionPerformed
        String new_deptname="";
        if(new_dept.getText().length()==0){
             JOptionPane.showMessageDialog(null,"Please enter department name.");
        }
        else{
             new_deptname=new_dept.getText();
            //New department insertion
            try{
                conn c1 = new conn();
                String q = "INSERT INTO `department1`(`dept_name`) VALUES ('"+new_deptname+"')";
                JOptionPane.showMessageDialog(null,"New department "+new_deptname+" added successfully");
                new_dept.setText("");
                c1.s.executeUpdate(q); 

            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_add_departmentActionPerformed

    private void m_dept_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_m_dept_idItemStateChanged
        String q="select eid,ename from employee1";
        ResultSet rs;
        DefaultTableModel tblModel=(DefaultTableModel)dept_emp_details.getModel();
        tblModel.setRowCount(0);//For clearing table
        try{
            conn c1 = new conn();
            //For showing employee details
            
            if(evt.getStateChange()==1){
                if(evt.getItem().toString().equals("ALL")){
                    d_name.setText("        Employee details");
                    q = "select eid,ename from employee1";
                }
                else{
                    String val=evt.getItem().toString();
                    d_name.setText("Employee details of department "+val);
                    q = "select eid,ename from employee1 where department='"+val+"'";
                }
                rs = c1.s.executeQuery(q); 
                while(rs.next()){
                    String id=String.valueOf(rs.getInt("eid"));
                    String name=rs.getString("ename");
                    String tbData[]={id,name};
                    tblModel.addRow(tbData);
                }
            }

            }
        catch(SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_m_dept_idItemStateChanged

    private void new_deptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_deptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_new_deptActionPerformed

    private void print_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_tableActionPerformed
        MessageFormat header= new MessageFormat(d_name.getText());
        
        try{
            dept_emp_details.print(JTable.PrintMode.FIT_WIDTH,header,null);
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, null);
        }
    }//GEN-LAST:event_print_tableActionPerformed

    private void print_emp_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_emp_tableActionPerformed
        MessageFormat header= new MessageFormat("All employee details");
        
        try{
            jTable1.print(JTable.PrintMode.FIT_WIDTH,header,null);
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, null);
        }
    }//GEN-LAST:event_print_emp_tableActionPerformed

    private void print_emp_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_print_emp_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_print_emp_tableMouseClicked

    private void generate_receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate_receiptActionPerformed
        String record = p_e_id.getSelectedItem().toString();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        if(pay_date.getDate()==null){
           JOptionPane.showMessageDialog(null, "Please select date.");
       }
        else{
            try{
                    conn c1 = new conn();
                    String salary="",department="";
                    String id=record.split("-->")[0];
                    String name=record.split("-->")[1];
                    Date pay_d = pay_date.getDate();
                    String pay_d_s=sdf.format(pay_d);

                    String q="select salary,department from employee1 where eid='"+id+"'";
                    ResultSet rs=c1.s.executeQuery(q);
                    while(rs.next()){
                        salary=rs.getString("salary");
                        department=rs.getString("department");
                    }

                    payslip_area.setText("");
                    payslip_area.append("****************************************\n" +"		PAY SLIP\n" +"****************************************\n" +"****************************************\n\n   EMPLOYEE ID:\t"+id+"\n"+"   NAME:   "+name+"\n   DATE:  "+pay_d_s+"\n   SALARY:  "+salary+"\n   DEPARTMENT:  "+department);           
            }
           catch(SQLException e){
                e.printStackTrace();
            }   
        }
    }//GEN-LAST:event_generate_receiptActionPerformed

    private void print_receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_receiptActionPerformed
        try{
            payslip_area.print();
        }
        catch(PrinterException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_print_receiptActionPerformed

    private void emp_leave_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_emp_leave_idItemStateChanged
         String q="select * from attendance";
        ResultSet rs;
        DefaultTableModel tblModel=(DefaultTableModel)emp_leaverequest.getModel();
        tblModel.setRowCount(0);//For clearing table
        try{
            conn c1 = new conn();
            //For showing employee details
            if(evt.getStateChange()==1){
                if(evt.getItem().toString().equals("ALL")){
                    q = "select * from attendance";
                }
                else{
                    String val=evt.getItem().toString().split("-->")[0];
                    q = "select * from attendance where eid='"+val+"'";
                }
                rs = c1.s.executeQuery(q); 
                while(rs.next()){
                    String id=String.valueOf(rs.getInt("eid"));
                    String name=rs.getString("ename");
                    String reason=rs.getString("reason");
                    String sd=rs.getString("start_date");
                    String ed=rs.getString("end_date");
                    String status=rs.getString("status");
                    String tbData[]={id,name,sd,ed,reason,status};
                    tblModel.addRow(tbData);
                }
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_emp_leave_idItemStateChanged

    private void rejectonUpdate(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rejectonUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_rejectonUpdate

    private void rejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectActionPerformed
        try{
            conn c1 = new conn();
            //For showing employee details in manage department
            String val=emp_leave_id.getSelectedItem().toString().split("-->")[0];
            String q = "update attendance set status='REJECTED' where eid='"+val+"'";
            c1.s.executeUpdate(q); 
            
            
            }
        
        catch(SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_rejectActionPerformed

    private void acceptonUpdate(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptonUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_acceptonUpdate

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        try{
            conn c1 = new conn();
            //For showing employee details in manage department
            String val=emp_leave_id.getSelectedItem().toString().split("-->")[0];
            String q = "update attendance set status='ACCEPTED' where eid='"+val+"'";
            c1.s.executeUpdate(q); 
            
            
            }
        
        catch(SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_acceptActionPerformed

    private void emp_leave_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_leave_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_leave_idActionPerformed
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
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UPDATE;
    private javax.swing.JButton accept;
    private javax.swing.JButton add_btn;
    private javax.swing.JButton add_department;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel d_l_id;
    private javax.swing.JLabel d_name;
    private javax.swing.JTable dept_emp_details;
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
    private javax.swing.JTextField e_password;
    private javax.swing.JTextField e_phone;
    private javax.swing.JTextField e_salary;
    private javax.swing.JTextField e_skill;
    private javax.swing.JComboBox<String> emp_leave_id;
    private javax.swing.JTable emp_leaverequest;
    private javax.swing.JButton generate_receipt;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jadd;
    private javax.swing.JPanel japplyleave;
    private javax.swing.JPanel jmanagedepartment;
    private javax.swing.JPanel jmanageemployee;
    private javax.swing.JPanel jprintreceipt;
    private javax.swing.JLabel l_delete_emp_det;
    private javax.swing.JLabel l_delete_emp_det1;
    private javax.swing.JLabel l_department;
    private javax.swing.JLabel l_designation;
    private javax.swing.JLabel l_dob;
    private javax.swing.JLabel l_doj;
    private javax.swing.JLabel l_email;
    private javax.swing.JLabel l_emp_details;
    private javax.swing.JLabel l_experience;
    private javax.swing.JLabel l_gender;
    private javax.swing.JLabel l_highest_qual;
    private javax.swing.JLabel l_id;
    private javax.swing.JLabel l_name;
    private javax.swing.JLabel l_password;
    private javax.swing.JLabel l_phone;
    private javax.swing.JLabel l_salary;
    private javax.swing.JLabel l_skill;
    private javax.swing.JLabel l_update_emp_details;
    private javax.swing.JLabel l_work_details;
    private javax.swing.JComboBox<String> m_dept_id;
    private javax.swing.JPanel n_add;
    private javax.swing.JPanel n_delete;
    private javax.swing.JPanel n_manageleave;
    private javax.swing.JPanel n_printreceipt;
    private javax.swing.JPanel n_update;
    public javax.swing.JLabel name;
    private javax.swing.JTextField new_dept;
    private javax.swing.JComboBox<String> p_e_id;
    private com.toedter.calendar.JDateChooser pay_date;
    private javax.swing.JTextArea payslip_area;
    private javax.swing.JButton print_emp_table;
    private javax.swing.JButton print_receipt;
    private javax.swing.JButton print_table;
    private javax.swing.JButton reject;
    private javax.swing.JLabel u_l_id;
    private javax.swing.JLabel u_l_id1;
    private javax.swing.JLabel u_l_id2;
    public javax.swing.JPanel username;
    private javax.swing.JComboBox<String> v_e_id;
    // End of variables declaration//GEN-END:variables
}
