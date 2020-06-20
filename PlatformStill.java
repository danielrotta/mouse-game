import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class stops objects from falling though it.
 * It spawns in randomly from the right and despawns on the left.
 * 
 * @author Daniel Rotta
 * @version 3/13/18
 */
public class PlatformStill extends Actor
{
    private GreenfootImage platformImage;
    public PlatformStill() {
    platformImage = new GreenfootImage("platform.png");
        platformImage.scale(100, 25);
        setImage(platformImage);
    }
    public void act() 
    {
       // these platforms don't do anything.
       // move();
       // despawn();
    }
    private void move() {
        setLocation(getX() - 1, getY());
    }
    private void despawn() {
        if (getX() < (0 - getImage().getWidth())) {
            getWorld().removeObject(this);
        }
    }
}
