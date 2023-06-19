package com.moderneinstein.arcade.chromebot;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.geom.*;
import java.awt.Rectangle;
import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.util.function.Function ;

import com.moderneinstein.arcade.chromebot.App ;

public class ChromeBot extends Thread implements Runnable{
    Node node ;
    public int thresh;
    public int thresh_;
    public Robot robot;
//    public Rectangle rect;
    public boolean isDino;
    public boolean isTranslated = false;
    public static int KEYSPACE = KeyEvent.VK_SPACE ;
    public static int KEYDOWN = KeyEvent.VK_DOWN ;
    public static int KEYUP = KeyEvent.VK_UP ;
    public static int MOUSECLICKLEFT = InputEvent.BUTTON1_DOWN_MASK ;
    public static int MOUSECLICKRIGHT = InputEvent.BUTTON2_DOWN_MASK ;
    //Unparametized Constructor
    public ChromeBot(){
        this(0,0,0,0);
        App.outer.println("ChromeBot created");
    }

    public ChromeBot(int x1,int y1,int width1,int height1){
        try{
            robot=new Robot();

        } catch (AWTException exp){
            exp.printStackTrace();
        }
        Node node1 = new Node(x1,y1,height1,width1,1) ;
      //  rect=node1.rectangle ;
	this.node = node1 ;
    }
    public ChromeBot(Node node1){
	try{
	robot = new Robot() ;
		}
		catch(AWTException exp){
		exp.printStackTrace() ;
		}
	this.node = node1;
//	this.rect  = new Rectangle(node1.rectangle)  ;
		}
    public boolean jump() throws ChromeBotException{
        int sum=0;
       // robot.keyPress(ChromeBot.KEYDOWN);
       // robot.mouseWheel(-6);
        BufferedImage image=robot.createScreenCapture(node.rect);
        int width2 = image.getWidth();
        int height2 = image.getHeight();
        for(int i=0;i<width2;i+=1){
            for(int j=0;j<height2;j+=1){
                Color c=new Color(image.getRGB(i,j));
                sum+=c.getRed();
                sum+=c.getBlue();
                sum+=c.getGreen();
                }
            }
        //System.out.println(this.toString() + sum);
        if(sum<=thresh&&isDino==true ){
            /*
        robot.delay(100);
        robot.keyRelease(ChromeBot.KEYDOWN);
        robot.keyPress(ChromeBot.KEYSPACE);
        robot.delay(200);
        robot.keyRelease(ChromeBot.KEYSPACE);
        robot.keyPress(ChromeBot.KEYDOWN);  */
      //  App.outer.println(22) ;
        }//"Sum of the pixel color components is exceedingly beyond the threshold"
        if( sum>=2000000){throw new ChromeBotException("Sum of the pixel color components is exceedingly beyond the threshold");
        }
        if(isDino==false){
            if(sum>=thresh){
                return true;
            }else{
            return false;
            }
        }
        else{
            return false;
        }
    }
    public int  scale() throws ChromeBotException{
        int sum= 0;
        //robot.keyPress(ChromeBot.KEYDOWN);
       // robot.mouseWheel(-6);
        BufferedImage image=robot.createScreenCapture(node.rect);
        int width=image.getWidth();
         int height=image.getHeight();
        for(int i=0;i<width;i+=1){
            for(int j=0;j<height;j+=1){
                Color c=new Color(image.getRGB(i,j));
                sum+=c.getRed();
                sum+=c.getBlue();
                sum+=c.getGreen();
            }
        }
        //System.out.println(this.toString() + sum);
        if(sum>=thresh_){
            /* 
            robot.delay(80);
            robot.keyRelease(ChromeBot.KEYDOWN);
            robot.keyPress(ChromeBot.KEYSPACE);
            robot.delay(200);
            robot.keyRelease(ChromeBot.KEYSPACE);
            robot.keyPress(ChromeBot.KEYDOWN);
            */
           // App.outer.println(33) ;
        }
        if( sum>=2000000) {throw new ChromeBotException("Sum of the pixel color components is exceedingly beyond the threshold");
        }
        return sum;
    }
    public int restart(boolean state) throws ChromeBotException{
        int sum2=0;
        BufferedImage image=robot.createScreenCapture(node.rect);
        int width2 =  image.getWidth();
        int height2 = image.getHeight();
        for(int i=0;i<width2;i+=1){
            for(int j=0;j<height2;j+=1){
                 Color c=new Color(image.getRGB(i,j));
                sum2+=c.getRed();
                sum2+=c.getBlue();
                sum2+=c.getGreen();
                }
        }
         if((state==true&&sum2<=thresh)||(state==false&&sum2>=thresh_)){
            /* 
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.mouseMove(node.position.xPos,node.position.yPos );
            robot.mousePress(ChromeBot.MOUSECLICKLEFT);
            robot.delay(200);
            robot.mouseRelease(ChromeBot.MOUSECLICKLEFT);
            robot.mouseMove(node.position.xPos+80,node.position.yPos+80);
            */ 
        }
        if(sum2>=2000000){throw new ChromeBotException("Sum of the pixel color components is exceedingly beyond the threshold");
                }
        return sum2;
    }//Button postion initialisation method();
    public void init(){
        /*
        robot.mouseMove(node.position.xPos+node.width/2,node.position.yPos+node.height/2);
        robot.mousePress(ChromeBot.MOUSECLICKLEFT);
	robot.delay(50)  ;
        robot.mouseRelease(ChromeBot.MOUSECLICKLEFT);
        robot.keyPress(ChromeBot.KEYSPACE);
        robot.delay(50);
        robot.keyRelease(ChromeBot.KEYSPACE);
        robot.mouseMove(node.position.xPos+80,node.position.yPos+80);
	robot.mousePress(ChromeBot.MOUSECLICKLEFT);
	robot.delay(50) ;
        robot.mouseRelease(ChromeBot.MOUSECLICKLEFT);
        */
    }
    //public test method(non-static);
    public int test() throws AWTException{
        int sum=0;
        BufferedImage image=robot.createScreenCapture(node.rect);
        int width =  image.getWidth();
        int height = image.getHeight();
        for(int i=0;i<width;i+=1){
            for(int j=0;j<height;j+=1){
                Color c=new Color(image.getRGB(i,j));
                sum+=c.getRed();
                sum+=c.getBlue();
                sum+=c.getGreen();
                }
        }
        //System.out.println(this.toString() + sum2);
        if(sum>=2000000){throw new ChromeBotException("Sum of the pixel color components is exceedingly beyond the threshold");
                }
       // App.outer.println(sum);
        return sum;
    }
    //ChromeBot position translation method(non-static);
    public void translate(int a,int b){
        if(this.isTranslated==false){
        node.position.xPos=node.position.xPos+a;
        node.position.yPos=node.position.yPos+b;
        this.isTranslated = true;
        }
    }
}
