package helper;

import helper.DBUtils;

import javax.swing.*;
import java.sql.*;

import static javax.swing.JOptionPane.YES_OPTION;

public class Registration {
    private Connection con;

    private int id;

    public Registration() {
        try {
            con = DBUtils.getDbConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    ResultSet get(){
        try {
            String select = "SELECT * FROM customers";
            PreparedStatement statement = con.prepareStatement(select);
            return statement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void getId(int id){
        this.id = id;
    }


    void insert(String firstName, String secondName, String phoneNum, String check) {
        try {
            String insert = "INSERT INTO customers(first_name, second_name, phone,private) VALUES (?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(insert);
            statement.setString(1, firstName);
            statement.setString(2, secondName);
            statement.setString(3, phoneNum);
            statement.setString(4, check);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    int update(String firstName, String secondName, String phoneNum, String check){
        String message = "Are you sure you want to update the details of row number " +this.id +"?";
        int in = JOptionPane.showConfirmDialog(null,message,"Confirm update",0,2);
        if (in ==0) {
            try {
                String update = "UPDATE customers SET id=?,first_name =?,second_name =?,phone =?,private =?  WHERE id =?";

                PreparedStatement statement = con.prepareStatement(update);
                statement.setInt(1, this.id);
                statement.setString(2, firstName);
                statement.setString(3, secondName);
                statement.setString(4, phoneNum);
                statement.setString(5, check);
                statement.setInt(6, this.id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 1;
        }else{
            return 0;
        }
    }
    int delete(){
        String message = "Are you sure you want to delete row number " + this.id;
        int in = JOptionPane.showConfirmDialog(null,message,"Confirm Delete",JOptionPane.YES_NO_OPTION,2);
        if(in == YES_OPTION){
            String delete ="DELETE FROM customers WHERE id =?";
            try{
                PreparedStatement statement = con.prepareStatement(delete);
                statement.setInt(1,this.id);
                statement.execute();
                statement.close();

            }catch (SQLException e){

            }
            return 1;
        }else{
            return 0;
        }

    }

}