/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorsPoint;

import java.sql.ResultSet;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author lenovo
 */
public class T_login extends Application {
    
     Label l1,l2,l3;
    TextField t1,t2;
    @Override
    public void start(Stage primaryStage) {
        l1=new Label("E-mail :");l1.setPrefWidth(100);
        l2=new Label("Password: ");l2.setPrefWidth(100);
        t1=new TextField();t1.setPrefWidth(200);
        t2=new TextField();t2.setPrefWidth(200);
        l3=new Label("");
        Button b=new Button("Login");b.setPrefWidth(140);
       b.setOnAction(e->{
           String s1="'"+t1.getText()+"'";
            String s2="'"+t2.getText()+"'";
          try {
            Conn ob=new Conn();
           ResultSet rs= ob.s.executeQuery("select email,password from tutor where email="+s1+"and password="+s2+";");
         if(rs.next()==true)
         {   S_window op=new S_window();
            Stage sk=new Stage();
            op.start(sk);primaryStage.close();
         }
         else
         {l3.setText("incorrect email or password");l3.setPrefWidth(300);}
          }
          catch (Exception se)
          {
              System.out.println(se);
          }
           
       });
        HBox h1=new HBox(l1,t1);
        HBox h2=new HBox(l2,t2);
        HBox h3=new HBox(l3);
        VBox v=new VBox(h1,h2,h3);
        v.setSpacing(13);
        v.setPadding(new Insets(25,15,10,15));
       
        BorderPane bp=new BorderPane();
        bp.setTop(v);
        bp.setCenter(b);
        Scene scene = new Scene(bp, 300, 170);
        primaryStage.setTitle("Tutor-Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

 
  
}
