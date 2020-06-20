import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
/**
 * Write a description of class YouWinCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouWinCounter extends Actor
{
    /**
     * Act - do whatever the YouWinCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int score;
    
    public YouWinCounter() {
        updateImage();
    }
    
    public void act() 
    {
     
    } 
    
    public void updateImage() {
        setImage(new GreenfootImage("Score: " + score, 25,
            Color.YELLOW, new Color(0,0,0,0)));
    }
 
    public void addScore() {
        score++;
        updateImage();
    }
}
