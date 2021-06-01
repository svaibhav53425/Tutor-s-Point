/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorsPoint;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
/**
 *
 * @author lenovo
 */
public class page1 extends Application {
      Label l1,l2;
      Button b1,b2,b3,b4;
      Text wel;
    @Override
    public void start(Stage primaryStage) {
        wel= new Text();
        wel.setText("WELCOME TO TUTORSPOINT");
       
        wel.setFont(Font.font(30));
        HBox h=new HBox(wel);h.setPadding(new Insets(30));
        l1=new Label("Students");l1.setPrefWidth(100);
        l2=new Label("Tutors");l2.setPrefWidth(100);
        b1=new Button("Login");
        b1.setPrefWidth(100);
         b2=new Button("Registration");b2.setPrefWidth(100);
         b3=new Button("Login");b3.setPrefWidth(100);
          b4=new Button("Registration");b4.setPrefWidth(100);
        HBox h1=new HBox(l1,b1,b2);
        h1.setAlignment(Pos.CENTER);
        h1.setFillHeight(true);
        h1.setSpacing(20);
        h1.setPadding(new Insets(10));
        HBox h2=new HBox(l2,b3,b4);h2.setAlignment(Pos.CENTER);
        h2.setFillHeight(true);h2.setPadding(new Insets(10));
         h2.setSpacing(20);
        VBox v1=new VBox(h,h1,h2);
        v1.setPadding(new Insets(5,15,10,15));
      //  v1.setAlignment(Pos.CENTER);
        BorderPane bp=new BorderPane();
        bp.setPadding(new Insets(5));
        bp.setCenter(v1);
        b2.setOnAction(e->{
            Stu_reg ob=new Stu_reg();
            Stage stage2=new Stage();
            ob.start(stage2);
        });
        b4.setOnAction(e->{
            Tut_reg ob=new Tut_reg();
            Stage stage3=new Stage();
            ob.start(stage3);
        });
         b1.setOnAction(e->{
            S_login ob=new S_login();
            Stage stage3=new Stage();
            ob.start(stage3);
        });
          b3.setOnAction(e->{
            T_login ob=new T_login();
            Stage stage4=new Stage();
            ob.start(stage4);
        });
        Scene scene = new Scene(bp, 500, 280);
      
        primaryStage.setTitle("TutorsPoint-Main");
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
