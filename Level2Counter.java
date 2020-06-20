import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
/**
 * Write a description of class Level2Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2Counter extends Actor
{
    /**
     * Act - do whatever the Level2Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int score;
    
    public Level2Counter() {
        updateImage();
    }
    
    public void act() 
    {
     
    } 
    
    public void updateImage() {
        setImage(new GreenfootImage("Score: " + score, 25,
            Color.BLUE, new Color(0,0,0,0)));
    }
 
    public void addScore() {
       
        score++;
        updateImage();
    }
}
