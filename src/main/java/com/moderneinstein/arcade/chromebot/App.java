package com.moderneinstein.arcade.chromebot ;  

import java.awt.image.BufferedImage ;
import java.awt.Color ;
import java.awt.event.KeyEvent  ;
import java.awt.event.InputEvent ;
import java.awt.AWTException ;
import java.awt.Robot  ;
///import java.lang.InterruptedStateException  ;
import java.io.File ;
import java.lang.System ;
import java.io.InputStream   ;
import java.io.InputStreamReader   ;
import  java.io.BufferedReader ;
import java.io.IOException  ;
import  javax.imageio.ImageIO  ;
import javax.swing.*  ;
import java.util.HashMap  ;
import java. util.LinkedList  ;
import  java.util.Arrays ;
import java.io.Serializable ;
import  java.util.HashMap ;
import java.util.function.* ;
import java.io.FileInputStream  ;
import java.io.FileOutputStream ;
import java.io.PrintStream   ;
import java.util.Properties ;
import java.io.OutputStream ; 

/**  
 * Hello world! 
 */ 
public final class App {
       public ChromeBotMain main  = null ;
    public ChromeBotAnalyser lyser = null ;
     public static PrintStream outer = System.out ;
    public BufferedReader reader1 ;
    public OutputStream stream1 ;
    public static String ErrorLog = new String("ErrorLog.txt") ;
    private App()  throws Exception{ 
         this.main  =  new ChromeBotMain()  ;
        this.lyser  = new ChromeBotAnalyser() ;
         Properties props = System.getProperties() ;
        File file1 = new File("ErrorLog.txt") ;
        file1.createNewFile() ; 
         stream1 = new FileOutputStream(file1,true) ;
        System.setErr(new PrintStream(stream1)) ;
        System.gc();
    }
    public int getInput(){
        InputStream ist = System.in  ;
        InputStreamReader isr = new InputStreamReader(ist) ;
         reader1 = new BufferedReader(isr) ;
        String str1= null ; 
        int digit1 = 0  ;
        try{
            str1 = reader1.readLine() ;
             switch(str1){
                  case("D") :
                     digit1 = 0  ;
                    break  ;
                case("W"):
                    digit1 = 2 ;
                     break ;
                case("S"):
                     digit1 = 1  ;
                    break ;
                default:
                    digit1 = 2 ;
                    break ;
                }
        }catch(IOException exp1){
            exp1.printStackTrace() ;
        }
        return digit1 ;
    }
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws Exception{
      outer.println("ChromeBot Started");
      outer.println("W to start S to pause D to quit ;")  ;
        App app1 = new App() ;
        Thread thread1 = app1.main ;
        Thread thread2 = app1.lyser ;
        Thread thread3 = Thread.currentThread()  ;
        int value1 = 2 ;
        while(value1!=0){
            value1 = app1.getInput() ;
            if(value1 == 1){
                thread1.suspend() ;
                thread2.suspend() ;
            }
            if(value1==2){
                if(!thread2.isAlive()){
                    thread2.start() ;  }
                if(!thread1.isAlive()){
                thread1.start() ;}
            }
        }
       // thread1.start() ; 
       // thread2.start() ; 
        System.out.println("ChromeBot stopped") ;
        System.exit(1) ;
    }
}
