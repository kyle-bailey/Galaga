import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Ship
{
    public int x,y;
    
    public Ship(int a, int b)
    {
        x = a;
        y = b;
    }
    
    public void drawShip(Graphics g)
    {
        g.setColor(Color.RED); //main ship
            g.fillRect(x,y,5,5);
            g.fillRect(x,(y-5),5,5);
            g.fillRect((x-5),y,5,5);
            g.fillRect((x+5),y,5,5);
            g.fillRect((x-5),y+5,5,5);
            g.fillRect((x+5),y+5,5,5);
            g.fillRect(x-10,y+15,5,15);
            g.fillRect(x+10,y+15,5,15);
            g.fillRect(x+15,y+20,5,10);
            g.fillRect(x-15,y+20,5,10);
            g.fillRect(x-20,y-15,5,40);
            g.fillRect(x+20,y-15,5,40);
            g.fillRect(x-35,y-5,5,10);
            g.fillRect(x+35,y-5,5,10);
            
            g.setColor(Color.WHITE); //main ship
            g.fillRect(x,y+5,5,30);
            g.fillRect(x-5,y+10,5,15);
            g.fillRect(x+5,y+10,5,15);
            g.fillRect(x,y-45,5,40);
            g.fillRect(x-5,y-30,5,30);
            g.fillRect(x+5,y-30,5,30);
            g.fillRect(x-10,y-5,5,20);
            g.fillRect(x+10,y-5,5,20);
            g.fillRect(x-15,y,5,20);
            g.fillRect(x+15,y,5,20);
            g.fillRect(x-20,y-5,5,10);
            g.fillRect(x+20,y-5,5,10);
            g.fillRect(x-20,y+10,5,15);
            g.fillRect(x+20,y+10,5,15);
            g.fillRect(x-25,y+10,5,10);
            g.fillRect(x+25,y+10,5,10);
            g.fillRect(x-30,y+15,5,15);
            g.fillRect(x+30,y+15,5,15);
            g.fillRect(x-35,y+5,5,30);
            g.fillRect(x+35,y+5,5,30);
            
            g.setColor(new Color(30,144,255)); //main ship
            g.fillRect(x-15,y,5,5);
            g.fillRect(x+15,y,5,5);
            g.fillRect(x-20,y+5,5,5);
            g.fillRect(x+20,y+5,5,5);
        }
    
        public void shipCapturedColor(Graphics g)
        {
            g.setColor(Color.WHITE);
            g.fillRect(x,y,5,5);
            g.fillRect(x,(y-5),5,5);
            g.fillRect((x-5),y,5,5);
            g.fillRect((x+5),y,5,5);
            g.fillRect((x-5),y+5,5,5);
            g.fillRect((x+5),y+5,5,5);
            g.fillRect(x-10,y+15,5,15);
            g.fillRect(x+10,y+15,5,15);
            g.fillRect(x+15,y+20,5,10);
            g.fillRect(x-15,y+20,5,10);
            g.fillRect(x-20,y-15,5,40);
            g.fillRect(x+20,y-15,5,40);
            g.fillRect(x-35,y-5,5,10);
            g.fillRect(x+35,y-5,5,10);
            
            g.setColor(Color.RED);
            g.fillRect(x,y+5,5,30);
            g.fillRect(x-5,y+10,5,15);
            g.fillRect(x+5,y+10,5,15);
            g.fillRect(x,y-45,5,40);
            g.fillRect(x-5,y-30,5,30);
            g.fillRect(x+5,y-30,5,30);
            g.fillRect(x-10,y-5,5,20);
            g.fillRect(x+10,y-5,5,20);
            g.fillRect(x-15,y,5,20);
            g.fillRect(x+15,y,5,20);
            g.fillRect(x-20,y-5,5,10);
            g.fillRect(x+20,y-5,5,10);
            g.fillRect(x-20,y+10,5,15);
            g.fillRect(x+20,y+10,5,15);
            g.fillRect(x-25,y+10,5,10);
            g.fillRect(x+25,y+10,5,10);
            g.fillRect(x-30,y+15,5,15);
            g.fillRect(x+30,y+15,5,15);
            g.fillRect(x-35,y+5,5,30);
            g.fillRect(x+35,y+5,5,30);
            
            g.setColor(new Color(30,144,255));
            g.fillRect(x-15,y,5,5);
            g.fillRect(x+15,y,5,5);
            g.fillRect(x-20,y+5,5,5);
            g.fillRect(x+20,y+5,5,5);
        }
        
        public void shipCaptured(Graphics g, int ynew)
        {
            while(y > ynew) //not working
            {
                y-=5;
            }
            shipCapturedColor(g);
        }
    }