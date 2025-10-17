package Chapter1;

import java.util.Random;
import java.sql.Date;
import java.util.*; // import java.util.Date wont work since Date due to naming conflict with sql date

import Chapter1.packageA.A;

/* 
 * compile: javac Chapter1/SimpleClass.java
 * run:     java Chapter1/SimpleClass
 * 
 * single Source File Launcher:
 *  available if no imports to packages not included in the jdk
 *  java Chapter1/SimpleClass.java opt args
 * 
 * compile from another directory: 
 * run from another directory:  java -cp Chapter1 SimpleClass.java
 * 
 */
public class SimpleClass{
    String name; // null default
    String initname="name";
    
    public void setName(String n){
        this.name=n;
    } 

    public static void method(){
        System.out.println("Hello OCP");
    }

    //main can have static or final modifyers 
    public void main(String args[]){
        SimpleClass sc= new SimpleClass();
        sc.method();
        sc.setName("john");
        System.out.println(sc.name);
        Random random = new Random();
        System.out.println(random.nextInt(10));

        Date utilDate= new Date(1);
        java.sql.Date sqlDate= new java.sql.Date(1);

        A a = new A();

        try{
            System.out.println(args[0]);
            System.out.println(args[1]);
        }catch(Exception e){

        }
    }

}


