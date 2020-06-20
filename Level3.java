import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    private int maxBread = 7;
    private int actCounter, secondCounter;
    private GreenfootImage bg;
    private int actCounterCheese;
    Counter counter = new Counter();
    Lives lives = new Lives();
    
    public void act() {
        spawnPlatform();
        spawnBread();
        spawnCheese();
    }
    public Level3()
    {    
       super(900, 500, 1, false);
        GreenfootImage bg = new GreenfootImage("Level 3.png");
            bg.scale(900, 500);
            setBackground(bg);
            addObject(new MouseLevel3(), 150, 300);
        addObject(new PlatformLevel3(),178, 370);
        addObject(new PlatformLevel3(), 332, 318);
        addObject(new PlatformLevel3(), 476, 268);
        addObject(new PlatformLevel3(), 616, 218);
        addObject(new PlatformLevel3(), 900, 400);
        
         addObject(new PlatformStill(), 450, 250);
        
        addObject(counter, 80, 42);
        addObject(lives, 80, 20);
        getCounter();
        getLives(); 
    }
    private void spawnPlatform() {
       secondCounter = (secondCounter + 1) % 100;
       if (secondCounter == 0) {
           addObject(new PlatformLevel3(), 0, Greenfoot.getRandomNumber(350) + 75);
       }
    }
    public void spawnBread() {
        actCounter = (actCounter + 1) % 120;
        if (actCounter == 0 && getObjects(Bread.class).size() < maxBread) {
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
    }
    public Counter getCounter() {
        return counter;
    }
    public Lives getLives() {
        return lives;
    }
}
