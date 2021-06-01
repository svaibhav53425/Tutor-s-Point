/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorsPoint;

import java.sql.ResultSet;
import javafx.scene.control.TableView ;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author lenovo
 */
public class T_window extends Application {
     TableView table=new TableView();
    @Override
    public void start(Stage primaryStage) {
        TableColumn first=new TableColumn("Name");first.setMinWidth(100);
         TableColumn second=new TableColumn("Email");second.setMinWidth(100);
          TableColumn third=new TableColumn("Phone");third.setMinWidth(100);
           TableColumn fourth=new TableColumn("Subject");fourth.setMinWidth(100);
            TableColumn fifth=new TableColumn("Location");fifth.setMinWidth(100);
            
        ObservableList<Tutor> data=FXCollections.observableArrayList();
      try {
          Conn c=new Conn();
        String str="select * from tutor";
        ResultSet rs=c.s.executeQuery(str);
        while(rs.next())
        {
            Tutor ob=new Tutor();
            ob.setName(rs.getString("name"));
            ob.setEmail(rs.getString("email"));
            ob.setPhone(rs.getString("phone"));
            ob.setSubject(rs.getString("subject"));
            ob.setLocation(rs.getString("location"));
            String k=rs.getString("password");
            data.add(ob);
        }
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
        first.setCellValueFactory(
                new PropertyValueFactory<Tutor, String>("name"));
        second.setCellValueFactory(
                new PropertyValueFactory<Tutor, String>("email"));
        third.setCellValueFactory(
                new PropertyValueFactory<Tutor, String>("phone"));
        fourth.setCellValueFactory(
                new PropertyValueFactory<Tutor, String>("subject"));
        fifth.setCellValueFactory(
                new PropertyValueFactory<Tutor, String>("location"));
        
             table.setItems(data);
            table.getColumns().addAll(first,second,third,fourth,fifth);
        Scene scene = new Scene(table, 500, 250);
        
        primaryStage.setTitle("Tutor's Details");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
