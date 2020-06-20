import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class stops objects from falling though it.
 * It spawns in randomly from the right and despawns on the left.
 * 
 * @author Daniel Rotta
 * @version 3/13/18
 */
public class PlatformLevel3 extends Actor
{
    private GreenfootImage platformImage;
    public PlatformLevel3() {
        platformImage = new GreenfootImage("platform.png");
        platformImage.scale(100, 25);
        setImage(platformImage);
    }
    public void act() 
    {
       move();
       despawn();
    }
    private void move() {
        setLocation(getX() + 1, getY());
    }
    private void despawn() {
        if (getX() > (900 + getImage().getWidth())) {
            getWorld().removeObject(this);
        }
    }
}
