import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HW4World here.
 * 
 * @author Group27
 * @version 4/13/18
 */
public class MouseTrap extends World
{
    private int maxBread = 7;
    private int actCounter, secondCounter;
    private GreenfootImage bg, explain;
    private int actCounterCheese;
    Counter counter = new Counter();
    Lives lives = new Lives();
    
    public void act () {
        spawnPlatform();
        spawnCheese();
    }
    /**
     * Constructor for objects of class MouseGame.
     * 
     */
    public MouseTrap ()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 500, 1, false);
            
            
            GreenfootImage bg = new GreenfootImage("Level 1.png");
            bg.scale(900, 500);
            setBackground(bg);
            
        addObject(new Mouse(), 150, 300);
        addObject(new Platform(),178, 370);
        addObject(new Platform(), 332, 318);
        addObject(new Platform(), 476, 268);
        addObject(new Platform(), 616, 218);
        addObject(new Platform(), 900, 400);
        addObject(counter, 80, 42);
        addObject(lives, 80, 20);
        getCounter();
        getLives();
    }
    private void spawnPlatform() {
       secondCounter = (secondCounter + 1) % 100;
       if (secondCounter == 0) {
           addObject(new Platform(), 900, Greenfoot.getRandomNumber(350) + 75);
       }
    }
    public void spawnBread() {
        actCounter = (actCounter + 1) % 120;
        if (actCounter == 0) {
            addObject(new Bread(), 900, Greenfoot.getRandomNumber(275) + 40);
        }
    }
    public void spawnCheese() {
        actCounterCheese = (actCounterCheese + 1) % 480;
        if (actCounterCheese == 0) { //first cheese spawn
            addObject(new Cheese(), 800, 510);
        }
        else if (actCounterCheese == 100) { //second cheese spawn
            addObject(new Cheese(), 100, 510);
        }
        else if (actCounterCheese == 200) {
            addObject(new Cheese(), 900, 350);
        }
        else if (actCounterCheese == 300) {
            addObject(new Cheese(), 450, 0);
        }
        else if (actCounterCheese == 400) {
            addObject(new Cheese(), 435, 500);
        }
    }
    public Counter getCounter() {
        return counter;
    }
    public Lives getLives() {
        return lives;
    }
}