import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.URL;
import javax.sound.sampled.*;
import java.io.*;

public class Galaga extends JFrame implements KeyListener, Runnable
{
    private Image dbImage;
    private Graphics dbg;
    static Scanner read = new Scanner(System.in);
    static Random randy = new Random();
    static int x = 395; // x and y are coordinates for middle peice in main space ship
    static int y = 665;
    static int a = 100; //coordinates of the one enemy
    static int b = 75;
    static int arrow = 0; //direction of movement of main ship
    static int coorx=0, coory=0, coorx1=0, coory1=0, coorx2=0, coory2=0,coorx3=0,coory3=0, coorx4=0, coory4=0, coorx5=0, coory5=0, coorx6=0, coory6=0, coorx7=0, coory7=0; //coordinates of bullets
    static int coorx8=0, coory8=0, coorx9=0, coory9=0, coorx10=0, coory10=0, coorx11=0, coory11=0; //coordinates of bullets
    static int shoot = 0; //variable that allows me to determine when spacebar has been pressed and then shoot
    static int lives = 2;
    int x1;
    static int y1 = 720; //coordinate for the lives
    static int move = 0; //makes the enemy move constantly
    static int hit = 0; //variable to determine if a bullet has hit the enemy
    static int explosion = 0; //when a bullet has hit this sparks the explosion
    static int disapear = 0; //allows me to make one bullet go away without reseting the shoot variable
    private javax.swing.Timer timer;
    static int mute = 0, mutecount=0; //mute variables
    static int pause = 0, pausecount = 0; //pause variables
    static int score = 0;
    static int rfire1 = 0; //variable to determine if the enemy fires
    int fx,fy; //coordinates of enemy fire
    static int shipHit = 0; //used to determine hits on the spaceship
    int dontLoseAllLives = 0; //so all the lives aren't cleared when the ship is hit
    static int n = 0; //controls the redrawing of bullets
    static int captured = 0; //switches the color of the ship when it is captured. 
    static int bombard=0;
    static int exploTimer = 0; //limits the time on ship explosion
    static int title = 0; //draws title screen over gameplay


    public Galaga()
    {
        super("Galaga");
        
        Container mainWindow = getContentPane();
        
        ColorPanel cp = new ColorPanel(Color.BLACK);
        
        mainWindow.add(cp);
        
        addKeyListener(this);
        
        setSize(850,775);
        setVisible(true);
        
    }
    
    public void keyReleased(KeyEvent e)
    {
    }
    
    public void keyTyped(KeyEvent e)
    {
    }
    
    public void keyPressed(KeyEvent e)
    {
        int c = e.getKeyCode();
        
        if(c == 77) //mutes and unmutes sound
        {
            if(mutecount == 0 || (mutecount%2 == 0))
            {
                mute = 1;
                mutecount += 1;
            }
            else
            {
                mute = 0;
                mutecount += 1;
            }
        }
        
        if(c == 80) //pauses and unpauses the game
        {
            pause = 1;
        }
        
        while(pause == 1)
        {
            c = e.getKeyCode();
            if(c == 79)
            {
                pause = 0;
                break;
            }
        }
            
        
        
        if(c == 37)
        {
            arrow = 2;
        }
        
        if(c == 39)
        {
            arrow = 3;
        }
        
        if(c == 40)
        {
            arrow = 4;
        }
        
        if(c == 32)
        {
            if(mute == 0)
            {
            playLaser();
           }
            shoot += 1;
            if((shoot > 12) && (shoot-1)%12 == 0)//resets the shoot variable so I can redraw old bullets
            {
                n+=12;
            }
            if(shoot == n+1)
            {
            coorx =x;
            coory = y-15;
           }
           if(shoot == n+2)
           {
               coorx1 = x;
               coory1 = y-15;
            }
           if(shoot == n+3)
           {
               coorx2 = x;
               coory2 = y-15;
            }
            if(shoot == n+4)
           {
               coorx3 = x;
               coory3 = y-15;
            }
            if(shoot == n+5)
           {
               coorx4 = x;
               coory4 = y-15;
            }
            if(shoot == n+6)
           {
               coorx5 = x;
               coory5 = y-15;
            }
            if(shoot == n+7)
           {
               coorx6 = x;
               coory6 = y-15;
            }
            if(shoot == n+8)
           {
               coorx7 = x;
               coory7 = y-15;
            }
            if(shoot == n+9)
           {
               coorx8 = x;
               coory8 = y-15;
            }
            if(shoot == n+10)
           {
               coorx9 = x;
               coory9 = y-15;
            }
            if(shoot == n+11)
           {
               coorx10 = x;
               coory10 = y-15;
            }
            if(shoot == n+12)
           {
               coorx11 = x;
               coory11 = y-15;
            }
            
        }
        
    }
    
    
    public class ColorPanel extends JPanel
    {
        public ColorPanel(Color backColor)
        {
            setBackground(backColor);
        }

        public void paintComponent(Graphics g)
        {
            g.setColor(Color.BLACK);
            g.fillRect(0,0,1650,1650);
            
            
            for(int x = 0; x < 65; x++) //background pixels
            {
                int a = randy.nextInt(251) + 1;
                int b = randy.nextInt(251) + 1;
                int c = randy.nextInt(251) + 1;
                int xc = randy.nextInt(846);
                int yc = randy.nextInt(651)+50;
                g.setColor(new Color(a,b,c));
                g.fillRect(xc,yc,3,3);
            }
        
           Ship s1 = new Ship(x,y);    
           if(captured == 0)
           {
                s1.drawShip(g);
           }
           if(captured == 1)
           {
                s1.shipCapturedColor(g);
           }
           Enemy e1 = new Enemy(a,b,1);
           Enemy e2 = new Enemy(a+300,b,0);
            
         if(hit == 0)
         {
            int rfire = randy.nextInt(250); //return fire!!
        if(rfire == 0)
        {
            rfire1 = 1;
            fx = a;
            fy = b;
            }
        if(rfire1 == 1)
        {
            g.setColor(Color.WHITE);
            g.fillRect(fx,fy+40,5,15);
            g.setColor(Color.RED);
            g.fillRect(fx,fy+55,5,10);
            g.fillRect(fx-3,fy+50,3,10);
            g.fillRect(fx+5,fy+50,3,10);
        }
       }
        
        level1 l1 = new level1();
            if(hit == 0)
            {
               e1.drawEnemy(g,1);
               //e2.drawEnemy(g,1);
           }
         

           if(shoot >= 1)
           {
               paintBullet(g, coorx, coory);
            }
            if(shoot >= 2)
            {
                paintBullet(g, coorx1, coory1);
            }
            if(shoot >= 3)
            {
                paintBullet(g,coorx2,coory2);
            }   
            if(shoot >= 4)
            {
                paintBullet(g,coorx3,coory3);
            }
            if(shoot >= 5)
            {
                paintBullet(g,coorx4,coory4);
            }
            if(shoot >= 6)
            {
                paintBullet(g,coorx5,coory5);
            }
            if(shoot >= 7)
            {
                paintBullet(g,coorx6,coory6);
            }
            if(shoot >= 8)
            {
                paintBullet(g,coorx7,coory7);
            }
            if(shoot >= 9)
            {
                paintBullet(g,coorx8,coory8);
            }
            if(shoot >= 10)
            {
                paintBullet(g,coorx9,coory9);
            }
            if(shoot >= 11)
            {
                paintBullet(g,coorx10,coory10);
            }
            if(shoot >= 12)
            {
                paintBullet(g,coorx11,coory11);
            }

//             int randdd = randy.nextInt(10);
//             int draw = 0;
//             if(randdd == 1)
//             {
//                 draw = 1;
//             }
//             if(draw == 1)
//             tractorBeam(g,a,b);
            
            if(rfire1 == 1) //moves enemy bullets
            {
                fy+=5;
            }

            if(explosion==1) // explosion
            {
                paintExplosion(g,a,b);
            }
            
            if(shipHit == 1 && exploTimer < 10)
            {
                paintExplosion(g,x-20,y-20);
                exploTimer += 1;
            }
            
            if(exploTimer >= 10)
            {
                shipHit = 0;
                exploTimer = 0;
            }
            
            
            for(int r = 0; r<lives; r++) //lives
            {
                x1=(r*40)+ 20;
                g.setColor(Color.RED);
                g.fillRect(x1,y1,2,2);
                g.fillRect(x1,(y1-2),2,2);
                g.fillRect((x1-2),y1,2,2);
                g.fillRect((x1+2),y1,2,2);
                g.fillRect((x1-2),y1+2,2,2);
                g.fillRect((x1+2),y1+2,2,2);
                g.fillRect(x1-4,y1+6,2,6);
                g.fillRect(x1+4,y1+6,2,6);
                g.fillRect(x1+6,y1+8,2,4);
                g.fillRect(x1-6,y1+8,2,4);
                g.fillRect(x1-8,y1-6,2,16);
                g.fillRect(x1+8,y1-6,2,16);
                g.fillRect(x1-14,y1-2,2,4);
                g.fillRect(x1+14,y1-2,2,4);
            
                g.setColor(Color.WHITE);
                g.fillRect(x1,y1+2,2,12);
                g.fillRect(x1-2,y1+4,2,6);
                g.fillRect(x1+2,y1+4,2,6);
                g.fillRect(x1,y1-18,2,16);
                g.fillRect(x1-2,y1-12,2,12);
                g.fillRect(x1+2,y1-12,2,12);
                g.fillRect(x1-4,y1-2,2,8);
                g.fillRect(x1+4,y1-2,2,8);
                g.fillRect(x1-6,y1,2,8);
                g.fillRect(x1+6,y1,2,8);
                g.fillRect(x1-8,y1-2,2,4);
                g.fillRect(x1+8,y1-2,2,4);
                g.fillRect(x1-8,y1+4,2,6);
                g.fillRect(x1+8,y1+4,2,6);
                g.fillRect(x1-10,y1+4,2,4);
                g.fillRect(x1+10,y1+4,2,4);
                g.fillRect(x1-12,y1+6,2,6);
                g.fillRect(x1+12,y1+6,2,6);
                g.fillRect(x1-14,y1+2,2,12);
                g.fillRect(x1+14,y1+2,2,12);
            
                g.setColor(new Color(30,144,255));
                g.fillRect(x1-6,y1,2,2);
                g.fillRect(x1+6,y1,2,2);
                g.fillRect(x1-8,y1+2,2,2);
                g.fillRect(x1+8,y1+2,2,2);
            }
            
            if(title == 1)
            {
                g.setColor(Color.BLACK);
                g.fillRect(0,0,1650,1650);
            }
            
        }
        
        public void paintBullet(Graphics g,  int coorbx, int coorby)
        {

                    g.setColor(Color.WHITE);
                    g.fillRect(coorbx,coorby-15,5,15);
                    g.setColor(Color.RED);
                    g.fillRect(coorbx,coorby-25,5,10);
                    g.fillRect(coorbx-3,coorby-20,3,10);
                    g.fillRect(coorbx+5,coorby-20,3,10);

        }
        
        public void paintExplosion(Graphics g, int a, int b)
        {
            for(int r = 0; r < 50; r++)
                {
                    int xx = randy.nextInt(55)+a;
                    int yy = randy.nextInt(55)+b;
                    int r1 = randy.nextInt(4);
                    if(r1 == 0)
                    {
                    g.setColor(Color.RED);
                    g.fillRect(xx,yy,5,5);
                   }
                   if(r1 == 1)
                   {
                      g.setColor(Color.WHITE);
                    g.fillRect(xx,yy,5,5);
                   }
                   if(r1 == 2)
                   {
                      g.setColor(Color.YELLOW);
                    g.fillRect(xx,yy,5,5);
                   }
                   if(r1 == 3)
                   {
                      g.setColor(Color.ORANGE);
                    g.fillRect(xx,yy,5,5);
                   }
                }
                explosion = 0;
            }
            
            public void tractorBeam(Graphics g, int a, int b)
            {
                int slow = 0;
                for(int pace = 0; pace < 10000; pace++)
                {
                    if(pace == 0)
                    {
                        g.setColor(Color.BLUE);
                        g.fillRect(a-12,b+40,24,5);
                    }
                    
                    if(pace == 1000)
                    {
                        g.fillRect(a-12,b+50,24,5);
                    }
                }
            }
            
            
            
            }
    
    public void run ()
    {
        
        while( true )
        {
            Dimension frameSize = getSize();
        
        if(arrow == 2)
        {
            if(x<=35)
            x+=5;
            x-=5;
        }
        
        if(arrow == 3)
        {
            if(x>=795)
            x-=5;
            x+=5;
        }
        
        if(arrow ==4)
        {
            if(y>=665)
            {
                y-=5;
            }
            y+=5;
        }
        
          if(shoot >= 1) //bullet 1
       {
           coory-=5;
           checkHit(coorx,coory);
       }
       if(shoot >= 2) //bullet 2
       {
           coory1-=5;
           checkHit(coorx1,coory1);
       }
       if(shoot >= 3) //bullet 3
       {
           coory2-=5;
           checkHit(coorx2,coory2);
       }
       if(shoot >= 4) //bullet 4
       {
           coory3-=5;
           checkHit(coorx3,coory3);
       }
       if(shoot >= 5) //bullet 5
       {
           coory4-=5;
           checkHit(coorx4,coory4);
       }
       if(shoot >= 6) //bullet 6
       {
           coory5-=5;
           checkHit(coorx5,coory5);
       }
       if(shoot >= 7) //bullet 7
       {
           coory6-=5;
           checkHit(coorx6,coory6);
       }
       if(shoot >= 8) //bullet 8
       {
           coory7-=5;
           checkHit(coorx7,coory7);
       }
       if(shoot >= 9)
       {
           coory8-=5;
           checkHit(coorx8,coory8);
       }
       if(shoot >= 10)
       {
           coory9-=5;
           checkHit(coorx9,coory9);
       }
       if(shoot >= 11)
       {
           coory10-=5;
           checkHit(coorx10,coory10);
       }
       if(shoot >= 12)
       {
           coory11-=5;
           checkHit(coorx11,coory11);
       }

        
        
        
        if(arrow == 5) 
        {
            y+=0;
            x+=0;
        }
        
        if(move == 0) //boundaries for enemy
        {
            a+=5;
            if(a+25>=850)
            {
            a-=5;
            move = 1;
            }
        }
        
        if(move == 1) //boundaries for enemy
        {
            a-=5;
            if(a-25<=0)
            {
            a+=5;
            move = 0;
            }
        }
        
        int rand = randy.nextInt(4000);
        if(rand == 666 && hit ==0)
        {
            bombard=1;
        }
        
        if(bombard==1)
        {
            if(a<x)
            {
                a+=1;
                b+=1;
            }
            if(a >= x)
            {
                a-=1;
                b+=1;
            }
        }
        
        if(hit == 1)
        bombard = 0;
                
        
        if((fx>x-30 && fx < x+30) && (fy<y+30 && fy > y-30)) //registers hit on main ship
        {
            shipHit = 1;
            dontLoseAllLives+=1;
            if(dontLoseAllLives == 1)
            lives -=1;
        }
        

            repaint();
            
            
            try
            {
                Thread.sleep(15);
            }catch (InterruptedException e) { }
            
            explosion = 0;
        }
        }
        

        
    
    public static void main (String [] args)
    {
        Thread bounceThread = new Thread ( new Galaga ());
        bounceThread.start();
    }
    
    
    public void update (Graphics g)
    {
        if (dbImage == null)
        {
            dbImage = createImage (this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics ();
        }
        dbg.setColor (getBackground ());
        dbg.fillRect (0, 0, this.getSize().width, this.getSize().height);
        dbg.setColor (getForeground());
        paint(dbg);
        g.drawImage (dbImage, 0, 0, this);
    }


    public static void checkHit(int coorx, int coory)
       {
           if((coorx>(a-30) && coorx<(a+30)) && (coory < b+25 && coory > b-25)) //registers a hit on an enemy
       {
           hit = 1;
           explosion = 1;
           move = 2;
       }
    }
    
    
      public static void playLaser()
      {
          try { 
                URL url = new URL("http://www.chiptape.com/chiptape/sounds/medium/atariAsteroids%20default.wav");       
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (LineUnavailableException e1) {
                e1.printStackTrace();
            }
        }
        
        public static void playLevelSound()
        {
            try { 
                URL url = new URL("http://soundfxcenter.com/video-games/galaga/21fcaa_Galaga_Theme_Song.mp3");       
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (LineUnavailableException e1) {
                e1.printStackTrace();
            }
        }
    }