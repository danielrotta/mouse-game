import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bread here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bread extends Actor
{
    private GreenfootImage newBread;
    private int life;
    public Bread()
    {
        newBread = new GreenfootImage("bread.png");
        setImage(newBread);
    }
    /**
     * Act - do whatever the Bread wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        advanceLeft();
        despawn();
    }
    
    public void despawn() {
        if (getX() < 0) {
            getWorld().removeObject(this);
        }
    }
    
    public void advanceLeft()
    {
        setLocation(getX() - 2, getY());
    }
}

