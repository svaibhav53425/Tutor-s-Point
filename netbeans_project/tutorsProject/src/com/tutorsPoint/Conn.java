/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorsPoint;

import java.sql.*;

public class Conn {
  Connection c;
  Statement s;
  public Conn() {
      try{
          Class.forName("com.mysql.jdbc.Driver");
          c=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
          s=c.createStatement();
          s.execute("use project1");
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
  }
}
