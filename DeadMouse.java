import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DeadMouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DeadMouse extends Actor
{
    private GreenfootImage mouseImage;
    
    public DeadMouse() {
        mouseImage = new GreenfootImage("Mouse.png");
            mouseImage.scale(75, 85);
            setImage(mouseImage);
    }
    public void act() 
    {
        turn(5);
    }
}
