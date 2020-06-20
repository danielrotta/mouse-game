import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2Lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Level2Lives extends Actor
{
    private int lives = 3;
    /**
     * Act - do whatever the Level2Lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public Level2Lives() {
        updateImage2();
    }
    public void lives() {
        lives--;
        updateImage2();
    }
    public void updateImage2() {
        setImage(new GreenfootImage("Lives: " + lives, 25,
            Color.BLUE, new Color(0,0,0,0)));
    }
}
