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
//import org.junit4.runners.JUnit4;
//import org.junit4.assert.AssertEquals ;
//import org.junit4.Test ;
import java.io.Serializable ;
public class Node{
public static class Position{
public int xPos ; 
public int yPos ; 
public int scale ;
public Position(int xPos1,int yPos1, int scale1 ){
this.xPos = xPos1 ; 
this.yPos = yPos1 ;
this.scale =  scale1 ;
}
public Position(int xPos1,int yPos1){
this.xPos = xPos1 ; 
this.yPos = yPos1 ;
this.scale = 1 ;
}
public void setPos(int xPos1, int yPos1  ){
this.xPos = xPos1 ;
this.yPos = yPos1 ; 
}
public void setPosX(int xPos1 ){
this.xPos = xPos1 ;
}
public void setPosY(int yPos1){
this.yPos = yPos1 ; 
}
public int getPosX(){
int x1 = this.xPos ;
return x1 ;
}
public int getPosY(){
int y1 = this.yPos ;
return y1 ;
}
}
int thresh ;
int height ; 
int width;
Position position ;
Rectangle rect ; 
public int Thresh ;
public Node(){
this(0,0,1)  ;
return ; 
}
public Node(int x1, int y1,int scale){
this.position =  new Position(x1,y1,scale) ;
this.height  = 0 ;
this.width = 0 ; 
this.rect = new Rectangle(x1,y1,0,0);

}
public Node(int x1, int y1,int height1, int width1,int scale ){
this.position = new Position(x1,y1,scale) ;
this.height = height1 ; 
this.width = width1 ; 
this.rect = new Rectangle(x1,y1,height,width);
}
public Position getPosition(){
Position pos = this.position ;
return pos  ; 
}
public int getWidth(){
int width1 = this.width; 
return width1 ;
}
public int getHeight(){
int height1 = this.height; 
return height1 ;
}
public void setPostion(Position pos1){
Position pos2 = pos1 ;
this.position = pos2 ;
}
public void setHeight(int height1){
int pos2 =  height1 ;
this.height = pos2 ;
}
public void setWidth(int width1){
int pos2 =  width1 ;
this.width = pos2 ;
}
}
