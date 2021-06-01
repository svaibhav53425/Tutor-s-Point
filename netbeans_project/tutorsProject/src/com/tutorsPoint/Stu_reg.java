/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorsPoint;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author lenovo
 */
public class Stu_reg extends Application {
    Text student;
    Label l1,l2,l3,l4,l5,l6;
    TextField t1,t2,t3,t4,t5,t6;
    Button b1;
    
    @Override
    public void start(Stage primaryStage) {
        student=new Text("STUDENT'S DETAILS");
        student.setFont(Font.font(30));
        l1=new Label("Name :");l1.setPrefWidth(100);
        l2=new Label("Email :");l2.setPrefWidth(100);
        l3=new Label("Phone :");l3.setPrefWidth(100);
        l4=new Label("Class :");l4.setPrefWidth(100);
        l5=new Label("Location :");l5.setPrefWidth(100);
        l6=new Label("Password :");l6.setPrefWidth(100);
        t1=new TextField();t1.setPrefWidth(200);
         t2=new TextField();t2.setPrefWidth(200);
          t3=new TextField();t3.setPrefWidth(200);
           t4=new TextField();t4.setPrefWidth(200);
            t5=new TextField();t5.setPrefWidth(200);
             t6=new TextField();t6.setPrefWidth(200);
           HBox h1=new HBox(l1,t1);
            HBox h2=new HBox(l2,t2);
             HBox h3=new HBox(l3,t3);
              HBox h4=new HBox(l4,t4);
               HBox h5=new HBox(l5,t5);
                HBox h6=new HBox(l6,t6);
        b1=new Button("Submit");b1.setPrefWidth(140);
        VBox v=new VBox(student,h1,h2,h3,h4,h5,h6);
        v.setSpacing(30);
        v.setPadding(new Insets(15,40,20,40));
        BorderPane bp=new BorderPane();
        bp.setTop(v);
        bp.setCenter(b1);
       b1.setOnAction(e->{
           String s1="'"+t1.getText()+"'";
            String s2="'"+t2.getText()+"'";
             String s3="'"+t3.getText()+"'";
              int s4=Integer.parseInt(t4.getText());
               String s5="'"+t5.getText()+"'";
                String s6="'"+t6.getText()+"'";
                
          try { Conn c=new Conn();
           String ss="insert into student(name,email,phone,class,location,password) values("+s1+","+s2+","+s3+","+s4+","+s5+","+s6+");";
         //  System.out.println(ss);
           c.s.executeUpdate(ss);
          }
          catch(SQLException se){
              System.out.println(se);
          }
           primaryStage.close();
       });
        Scene scene = new Scene(bp, 400, 550);
        
        primaryStage.setTitle("Student-Registration");
        primaryStage.setScene(scene);
       primaryStage.show();
    }

   
    
}
