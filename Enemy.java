import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.URL;
import javax.sound.sampled.*;
import java.io.*;

public class Enemy extends JFrame
{

    public int a, b, hit;
    public Enemy(int coorx, int coory, int h) //haven't implemented individual hit values yet
    {
        a = coorx;
        b = coory;
        hit = h;
    }
    
//     public void moveEnemy(Graphics g)
//         {
//             while(true)
//             {
//             a-=5;
//             
//             repaint();
//             
//         }
//         }
    
    public void drawEnemy(Graphics g, int c)
    {
        if(c == 1)
        {
         g.setColor(Color.YELLOW); //enemy1
            g.fillRect(a,(b-20),5,25);
            g.fillRect((a-10),b,25,5);
            g.fillRect((a-5),b+5,15,5);
            g.fillRect(a-5,b+20,15,5);
            g.fillRect(a-10,b-10,5,5);
            g.fillRect(a+10,b-10,5,5);
            
            g.setColor(Color.RED); // enemy1
            g.fillRect(a-5,b-10,5,10);
            g.fillRect(a+5,b-10,5,10);
            g.fillRect(a-10,b-5,5,5);
            g.fillRect(a+10,b-5,5,5);
            g.fillRect(a-5,b+10,15,10);
            g.fillRect(a-5,b+25,15,5);
            g.fillRect(a-2,b+30,9,5);
            
            g.setColor(new Color(30,144,255)); //enemy1
            g.fillRect(a-15,b+5,10,10);
            g.fillRect(a+10,b+5,10,10);
            g.fillRect(a-18,b+10,8,25);
            g.fillRect(a+15,b+10,8,25);
            g.fillRect(a-15,b-5,5,5);
            g.fillRect(a+15,b-5,5,5);
            g.fillRect(a+20,b-15,3,10);
            g.fillRect(a-18,b-15,3,10);
        }
    
        
        if(c == 2)
        {
           g.setColor(Color.PINK);
           g.fillRect(a-10,b,25,10);
           g.fillRect(a-10,b-10,10,10);
           g.fillRect(a+5,b-10,10,10);
           g.fillRect(a-10,b-25,10,10);
           g.fillRect(a+5,b-25,10,10);
           g.fillRect(a-5,b+10,5,10);
           
           g.setColor(new Color(153,51,153));
           g.fillRect(a-10,b-15,25,5);
           g.fillRect(a,b-25,5,25);
           g.fillRect(a-5,b-35,5,10);
           g.fillRect(a+5,b-35,5,10);
            
        }
    }
}

