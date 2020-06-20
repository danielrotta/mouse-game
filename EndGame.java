import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CopyOfEndGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGame extends World
{

    /**
     * Constructor for objects of class CopyOfEndGame.
     * 
     */
    public void act() {
        spawnCheese();
        checkEnter();
    }
    public EndGame()
    {    
        super(900, 500, 1, false);
        GreenfootImage bg = new GreenfootImage("GameOver.png");
            bg.scale(900, 500);
            setBackground(bg);
        addObject(new DeadMouse(), 450, 250);
        setPaintOrder(DeadMouse.class, Cheese.class);
    }
    private void spawnCheese() {
        if (Greenfoot.getRandomNumber(100) < 1) {
            addObject(new Cheese(), Greenfoot.getRandomNumber(901), 0);
        }
    }
    private void checkEnter() {
        if (Greenfoot.isKeyDown("Enter")) {
            Greenfoot.setWorld(new MouseTrap());
        }
    }
}
