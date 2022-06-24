package helper;
import helper.Registration;

import javax.swing.*;//importing all the necessary packages
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Gui {


    static JFrame frame;// declaring attributes for each method for gui components
    static JMenuBar menubar;
    static JMenu menu1, menu2, menu3;
    static JMenuItem item1, item2, item3, item4, item5, item6;


    static JScrollPane scroll;
    static JLabel label1, label2, label3;
    static JTextField text1, text2, text3;
    static JPanel pan1, pan2, pan3, pan4, pan5;
    static JCheckBox check;
    static JRadioButton radiobtn1, radiobtn2;
    static JButton but1, but2, but3, but4;
    static Registration res = new Registration();

    static JTable table = new JTable();
    static Object[] column = {"id","Forename", "Surname", "Phone", "Private"};//column heading of the table
    static Object[][] row = {};
    static DefaultTableModel chgmod = new DefaultTableModel(row, column);//declaring the rows for the table





    public static void main(String[] args) {


        frame = new JFrame("Phone Book");
        frame.setSize(955, 515);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(true);


        /****JPanel 1****/ //This panel consists menu bar and the table
        //creating table
        pan1 = new JPanel();


        table.setModel(chgmod);
        scroll = new JScrollPane(table);
        refreshTable();

        pan1.add(scroll);//adding a scroll bar for the table
        pan1.setBorder(new TitledBorder("Name:"));
        pan1.setLayout(new FlowLayout());

        //setting a menu bar
        menubar = new JMenuBar();
        menu1 = new JMenu("File");
        item1 = new JMenuItem("Exit");
        menubar.add(menu1);
        menu1.add(item1);
        menu1.setMnemonic(KeyEvent.VK_C);
        menu1.setToolTipText("ALT + C");//hovers when you put your mouse pointer on the specific menu
        item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));//shortcut key to quit the program i.e. CTRL + C
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }

        });
        menu2 = new JMenu("Edit");
        item2 = new JMenuItem("Clear");
        menu2.setMnemonic(KeyEvent.VK_F);
        menu2.setToolTipText("ALT + F");
        menubar.add(menu2);
        menu2.add(item2);
        item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));//CTRL + X
        item3 = new JMenuItem("Update");
        menubar.add(menu2);
        menu2.add(item3);
        menu2.addSeparator();
        item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK));//CTRL + U


        item4 = new JMenuItem("Add");
        menubar.add(menu2);
        menu2.add(item4);
        item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));//CTRL + A

        item5 = new JMenuItem("Remove");
        menubar.add(menu2);
        menu2.add(item5);
        item5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));//CTRL + R


        menu3 = new JMenu("Help");
        item6 = new JMenuItem("About");
        menubar.add(menu3);
        menu3.add(item6);
        menu3.setMnemonic(KeyEvent.VK_H);
        menu3.setToolTipText("ALT + H");
        item6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_DOWN_MASK));//CTRL + J
        item6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Coming soon", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        /*****JPanel 2****/ //This panel consists of the registration fields
        pan2 = new JPanel();

        label1 = new JLabel("First Name:");
        pan2.add(label1);
        text1 = new JTextField(20);
        pan2.add(text1);

        label2 = new JLabel("Second Name:");
        pan2.add(label2);
        text2 = new JTextField(20);
        pan2.add(text2);

        label3 = new JLabel("Phone:");
        pan2.add(label3);
        text3 = new JTextField(20);
        pan2.add(text3);

        check = new JCheckBox("Private");
        pan2.add(check);


        pan2.setBorder(new TitledBorder("Info:"));
        pan2.setLayout(new GridLayout(4, 1));

        /*****JPanel 3*****/ //This panel consists of the JRadio Button part
        pan3 = new JPanel();
        ButtonGroup btn1 = new ButtonGroup();

        radiobtn1 = new JRadioButton("Forename, Surname");
        btn1.add(radiobtn1);
        pan3.add(radiobtn1);


        radiobtn2 = new JRadioButton("Surname, Forename");
        btn1.add(radiobtn2);
        pan3.add(radiobtn2);

        radiobtn1.setSelected(true);
        radiobtn1.setEnabled(false);
        radiobtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                table.moveColumn(0, 1);
                radiobtn2.setEnabled(false);
                radiobtn1.setEnabled(true);
            }
        });
        radiobtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                table.moveColumn(0, 1);
                radiobtn2.setEnabled(true);
                radiobtn1.setEnabled(false);
            }
        });

        pan3.setBorder(new TitledBorder("File as:"));
        pan3.setLayout(new GridLayout(2, 1));

        /***JPanel 4*****/ //This panel consists of all the functional Jbuttons
        pan4 = new JPanel();


        //this is for the clear button
        but1 = new JButton("Clear");
        pan4.add(but1);
        but1.setToolTipText("It clears the field");
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text1.setText("");
                text2.setText("");
                text3.setText("");
                check.setSelected(false);
            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                but1.doClick();
            }
        });


        //this is for the update button
        but2 = new JButton("Update");
        pan4.add(but2);
        but2.setToolTipText("Updates the table");
        but2.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "You must select the row first");
                }else{
                    String firstName = text1.getText().trim();//trim removes any unnecessary spaces in the fields
                    String secondName = text2.getText().trim();
                    String phoneNum = text3.getText().trim();
                    String priv="";
                    if (check.isSelected()){
                        priv="Private";
                    }
                    //use of nested if
                    if (!(firstName.isEmpty() || secondName.isEmpty() || phoneNum.isEmpty())) {//condition that checks if the fields are empty or not
                        int update = res.update(firstName,secondName,phoneNum,priv);
                        if(update ==1 ) {
                            refreshTable();
                            but1.doClick();
                        }
                    }else{
                        JOptionPane.showMessageDialog(frame,"Please fill out all the fields","Empty Text",0);
                    }
                }
            }
        });
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                but2.doClick();
            }
        });

        but3 = new JButton("Add");
        pan4.add(but3);
        but3.setToolTipText("Adds the entered values in the table");
        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String firstName = text1.getText().trim();//trim removes any unnecessary spaces in the fields
                String secondName = text2.getText().trim();
                String phoneNum = text3.getText().trim();
                String priv="";
                int id= (table.getSelectedRow());
                if (check.isSelected()){
                    priv="Private";
                }
                //use of nested if
                if (!(firstName.isEmpty() || secondName.isEmpty() || phoneNum.isEmpty())) {//condition that checks if the fields are empty or not
                    res.insert(firstName,secondName,phoneNum,priv);
                    refreshTable();
                    but1.doClick();
                }else{
                    JOptionPane.showMessageDialog(frame,"Please fill out all the fields","Empty Text",0);
                }

            }
        });
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                but3.doClick();
            }
        });

        but4 = new JButton("Remove");
        pan4.add(but4);
        but4.setToolTipText("Removes the selected row of the table.");
        but4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int deleteSure = res.delete();
                if(deleteSure == 1) {
                    refreshTable();
                    but1.doClick();
                }
            }
        });
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                but4.doClick();
            }
        });



        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                text1.setText(chgmod.getValueAt(selectedRow, 1).toString());
                text2.setText(chgmod.getValueAt(selectedRow, 2).toString());
                text3.setText(chgmod.getValueAt(selectedRow, 3).toString());
                String priv = chgmod.getValueAt(selectedRow,4).toString();
                if(priv.equals("Private")){
                    check.setSelected(true);
                }
                res.getId(Integer.parseInt(chgmod.getValueAt(selectedRow,0).toString()));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        pan4.setLayout(new GridLayout(2, 2));

        /*****JPanel 5*****/ //This panel decides the placement of the Jbutton,JRadio button and Jlabel
        pan5 = new JPanel();
        pan5.add(pan2);
        pan5.add(pan3);
        pan5.add(pan4);

        pan5.setLayout(new GridLayout(3, 1));
        frame.add(pan5);// adds panel2,panel3,and panel4

        //Giving direction to the different panels
        frame.add(menubar, BorderLayout.NORTH);
        frame.add(pan5, BorderLayout.EAST);
        frame.add(pan1, BorderLayout.WEST);

        frame.setJMenuBar(menubar);//menu bar gets stick on the top of the frame
        frame.setVisible(true);//sets the visibility of frame to the user

    }


    public static void refreshTable(){
        ResultSet resultset = res.get();
        try {
            chgmod.setRowCount(0);
            while (resultset.next()){
                chgmod.addRow(new Object[]{
                        resultset.getInt("id"),
                        resultset.getString("first_name"),
                        resultset.getString("second_name"),
                        resultset.getString("phone"),
                        resultset.getString("private"),
                });
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }



}