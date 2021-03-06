import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jumpy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouWinMouse extends Actor
{
    private int lives = 3;
    private int gravity, addGravity, jumpCount, boostCount;
    private boolean boostOn = false;
    private GreenfootImage mouseImage, mouseLeft, mouseCrouch, sonicMouse;
    private final int MAX_BOOST_DISTANCE = 30;
    private int cheeseEaten = 0;
    
    GreenfootSound backgroundMusic = new GreenfootSound("MouseGameTrack.mp3");
    
    GreenfootSound collectSound = new GreenfootSound("CollectSound.wav");
    
    public YouWinMouse()
    {
        mouseImage = new GreenfootImage("Mouse.png");
        mouseImage.scale(75, 85);
        setImage(mouseImage);
        
        mouseLeft = new GreenfootImage("MouseLeft.png");
        mouseLeft.scale(85, 85);
        
        mouseCrouch = new GreenfootImage("Mouse.png");
        mouseCrouch.scale(75, 30);
        
        sonicMouse = new GreenfootImage("Mouse.png");
        sonicMouse.scale(150, 75);
        
    }
    /**
     * Act - do whatever the Jumpy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        eatCheese();
        checkForKey();
        gravity();
        fallOff();
        quit();
    }
     private void checkForKey()
    {
        checkRight();
        checkLeft();
        checkForJump();
        crouch();
        boost();
    }
    private void gravity() {
        gravity--;
        platformInteraction();
        setLocation(getX(), getY() - gravity);
    }
    private void checkForJump()
    {
        if (Greenfoot.isKeyDown("space") && jumpCount < 10) {
           gravity = 11 + addGravity;
           jumpCount++;
           addGravity = 0;
        }
    }
    private void checkRight()
    {
        if ((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
                && boostOn && boostCount < MAX_BOOST_DISTANCE) {
            move(10);
            setImage(mouseImage);
            boostCount++;
        }
        else if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            move(5);
            setImage(mouseImage);
            boostReset();
        }
    }
    private void checkLeft()
    {
        if ((Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
                && boostOn && boostCount < MAX_BOOST_DISTANCE) {
            move(-10);
            setImage(mouseLeft);
            boostCount++;
        }
        else if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            move(-5);
            setImage(mouseLeft);
            boostReset();
        }
    }
    private boolean platformInteraction() {
        if (getOneObjectAtOffset(0, 48, PlatformStill.class) != null  && Greenfoot.isKeyDown("space") == false) {
            gravity = 0;
            jumpCount = 0;
            return true;
        }
        else {
            return false;
        }
    }
    private void crouch() {
        if ((Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
                && platformInteraction()) {
            setImage(mouseCrouch);
            addGravity = 80;
        }
    }
    private void boost() {
        if ((Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
                && platformInteraction()) {
            setImage(sonicMouse);
            boostOn = true;
        }
    }
    private void boostReset() {
        boostOn = false;
        boostCount = 0;
    }
    private void eatCheese() {
        if (getOneIntersectingObject(Cheese.class) != null) {
            getWorld().removeObject(getOneIntersectingObject(Cheese.class));
            collectSound.play();
            ((YouWin)getWorld()).getCounter().addScore();
            cheeseEaten++;
        }
    }
    private void fallOff() {
        if (getY() > 575) {
            setLocation(400,0); // top and center
            gravity = 0; // without this mouse keeps previous speed and zooms back in for respawn
        }
    }
    private void quit() {
        if (Greenfoot.isKeyDown("Enter")) {
            backgroundMusic.stop();
            Greenfoot.stop();
        }
    }
}
