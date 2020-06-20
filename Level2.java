import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    private int maxBread = 2;
    private int actCounter, secondCounter;
    private GreenfootImage bg;
    private int actCounterCheese;
    
    Level2Counter counter2 = new Level2Counter();
    Level2Lives lives2 = new Level2Lives();
    
    public void act () {
        spawnPlatform();
        spawnBread();
        spawnCheese();
    }
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 500, 1, false);
        
        GreenfootImage bg = new GreenfootImage("Level 2.png");
            bg.scale(900, 500);
            setBackground(bg);
        addObject(new MouseLevel2(), 150, 300);
        addObject(new Platform(),178, 370);
        addObject(new Platform(), 332, 318);
        addObject(new Platform(), 476, 268);
        addObject(new Platform(), 616, 218);
        addObject(new Platform(), 900, 400);
        addObject(counter2, 80, 42);
        addObject(lives2, 80, 20);
       
        getCounter2();
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
        else if (actCounterCheese == 300) {
            addObject(new Cheese(), 450, 0);
        }
        else if (actCounterCheese == 400) {
            addObject(new Cheese(), 435, 500);
        }
    }
  
    public Level2Counter getCounter2() {
        return counter2;
    }
    public Level2Lives getLives() {
        return lives2;
    }
}