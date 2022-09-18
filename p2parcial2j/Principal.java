/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2parcial2j;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author Jairo Fernando
 */
public class Principal {
static Scanner dato = new Scanner (System.in);




public static void PedirNiv(){
System.out.println("Por favor, ingrese el Niv para buscar sus datos  : ");
String niv = dato.next();

        String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","BaseDeDatos1");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "SELECT * FROM tb_comisiones where niv = '"+niv+"' ";
          
            ResultSet resultado = sentencia.executeQuery(sql);
            
            int nivdb =0;
            
            while(resultado.next()){
                
                nivdb = resultado.getInt(1);
                //System.out.println("\nNiv ="+resultado.getString(2));
            }
            
            if(nivdb == 0){
                System.out.println("El niv ingresado no existe");
                PedirNiv();
            }else{
               BuscarNiv(nivdb);
            }
               
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
} ////////fin de PedirNiv//////////////////



//////////////////BuscarNiv//////////////////
public static void BuscarNiv(int niv){
    
        String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","BaseDeDatos1");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "SELECT * FROM tb_comisiones where niv = " +niv;
          
            ResultSet resultado = sentencia.executeQuery(sql);
       
            while(resultado.next()){
                System.out.println("\nNiv   ="+resultado.getInt(1));
                System.out.println("Nombre  = "+resultado.getString(2));
                System.out.println("Comision de Enero   ="+resultado.getInt(3));
                System.out.println("Comision de Febrero ="+resultado.getInt(4));
                System.out.println("Comision de Marzo   ="+resultado.getInt(5));
                System.out.println("Comision de Abril   ="+resultado.getInt(6));
                System.out.println("Comision de Mayo    ="+resultado.getInt(7));
                System.out.println("Comision de Junio ="+resultado.getInt(8));
                System.out.println("\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}////////////fin de BuscarNiv///////////////////



/////////////////CONSULTA DE LOS NIV///////////////////////////////
     public static void ConsultadelosNiv(){
         

        String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","BaseDeDatos1");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "SELECT * FROM tb_comisiones";
          
            ResultSet resultado = sentencia.executeQuery(sql);
       
            while(resultado.next()){
                System.out.println("\nNiv ="+resultado.getInt(1));
                System.out.println("Nombre = "+resultado.getString(2));
                System.out.println("Enero ="+resultado.getInt(3));
                System.out.println("Febrero ="+resultado.getInt(4));
                System.out.println("Marzo ="+resultado.getInt(5));
                System.out.println("Abril ="+resultado.getInt(6));
                System.out.println("Mayo ="+resultado.getInt(7));
                System.out.println("Junio ="+resultado.getInt(8));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}//////////////////fin de consultas de los NIV/////////////////////
     
     
     
     ////////////SUMAS DE TODOS LOS VENDEDORES//////////////
      public static void sumas(){
         

        String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","BaseDeDatos1");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "Select Niv, nombres, (enero+febrero+marzo+abril+mayo+junio) from tb_comisiones;";
             
          
            ResultSet resultado = sentencia.executeQuery(sql);
       
            while(resultado.next()){
                 System.out.println("\nNiv ="+resultado.getInt(1));
                System.out.println("Nombre = "+resultado.getString(2));
                System.out.println("Total ventas ="+resultado.getInt(3));
              
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}//fin de suma
      
      
      
      
      
 

////////////METODO PARA ELIMINAR EL NIV///////////////
public static void ConsultaEliminarNiv(){
    
System.out.println("Por favor, ingrese el Niv a eliminar: ");
String niv = dato.next();

        String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","BaseDeDatos1");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "SELECT * FROM tb_comisiones where niv = '"+niv+"' ";
          
            ResultSet resultado = sentencia.executeQuery(sql);
            
            int nivdb =0;
            
            while(resultado.next()){
                
                nivdb = resultado.getInt(1);
                //System.out.println("\nNiv ="+resultado.getString(2));
            }
            
            if(nivdb == 0){
                System.out.println("El niv ingresado no existe");
                ConsultaNiv();
            }else{
                   int op;

System.out.println("Esta seguro de Eliminar el Niv?");
          System.out.println("1.Si ");
          System.out.println("2.No ");
        
        System.out.println("Introcudir una opcion");
        op=dato.nextInt();
    switch(op){
    
    
        case 1:
           
            EliminarNiv(nivdb);
         break;
      
          case 2:
          
         break;        
         
          default:System.out.println("No es una opcion valida, Introdusca una opcion valida");
    
    }           
            }//fin del else
                          
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
} //fin de eliminarNiv



///////METODO EN DONDE SE REALIZA LA CONSULTA A LA BASE DE DATOS PARA ELIMINAR//////
public static void EliminarNiv(int niv){
   
    
    
     String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","BaseDeDatos1");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "delete from tb_comisiones  where niv = '"+niv+"' ";
             
          
            sentencia.executeUpdate(sql);
                      
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}//fin de Actualizar Nombre


/////////Actualizacion de Niv y Nombre////////////////     
public static void ConsultaNiv(){


System.out.println("Por favor, ingrese el Niv: ");
String niv = dato.next();

        String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","BaseDeDatos1");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "SELECT * FROM tb_comisiones where niv = '"+niv+"' ";
          
            ResultSet resultado = sentencia.executeQuery(sql);
            
            int nivdb =0;
            
            while(resultado.next()){
                
                nivdb = resultado.getInt(1);
                //System.out.println("\nNiv ="+resultado.getString(2));
            }
            
            if(nivdb == 0){
                System.out.println("El niv ingresado no existe");
                ConsultaNiv();
            }else{
                ActualizarNombre(nivdb);
            }
               
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
} ////////fin de actualizarniv//////////////////


//////////////////Actualiza Niv//////////////////
public static void ActualizarNombre(int niv){
    System.out.println("Por favor ingrese el nuevo nombre: ");
    String nuevonombre = dato.next();
    
     String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","BaseDeDatos1");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "update tb_comisiones set nombres = '"+nuevonombre+"' where niv = '"+niv+"' ";
             
          
            sentencia.executeUpdate(sql);
                      
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}//fin de Actualizar Nombre





/////////////MENU//////////////
public static void main(String[] args) {
       int op;
do{ 
          System.out.println("1. Consulta por Niv");
          System.out.println("2. Consulta de los Niv ");
          System.out.println("3. Suma de todo los meses ");
          System.out.println("4. Eliminar ");
          System.out.println("5. Actualizar ");
          
        System.out.println("Introcudir una opcion");
        op=dato.nextInt();
    switch(op){
    
    
         case 1:
           PedirNiv();
            
         break;
        
        case 2:
           ConsultadelosNiv();
            
         break;
      
          case 3:
             sumas();
         break;
         
          case 4:
            ConsultaEliminarNiv();
         break;
         
         case 5:
            ConsultaNiv();
         break;
         
          default:System.out.println("No es una opcion valida, Introdusca una opcion valida");
    
    }
            
    
}while(op!=3);


    }//final de main
    
    
}//final de principal
