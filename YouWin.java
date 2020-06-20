import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouWin extends World
{
    YouWinCounter counter = new YouWinCounter();
    private int actCounterCheese;
    public void act() {
        spawnCheese();
        spawnCheese2();
    }
    public YouWin ()
    {    
        
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 500, 1, false);
        
        GreenfootImage bg = new GreenfootImage("Win Screen.png");
            bg.scale(900, 500);
            setBackground(bg);
        
        // middle and corner platforms
        addObject(new PlatformStill(), 450, 250);
        addObject(new PlatformStill(), 808, 131);
        addObject(new PlatformStill(), 92, 131);
        
        // staircase starting from the left
        addObject(new PlatformStill(), 50, 400);
        addObject(new PlatformStill(), 150, 300);
        addObject(new PlatformStill(), 250, 200);
        addObject(new PlatformStill(), 350, 100);
        
        // staircase starting from the right
        addObject(new PlatformStill(), 850, 400);
        addObject(new PlatformStill(), 750, 300);
        addObject(new PlatformStill(), 650, 200);
        addObject(new PlatformStill(), 550, 100);
        
        //flat ground + mouse
        addObject(new YouWinMouse(), 150, 300); //tutorial mouse contains the enter to start game code
        addObject(new PlatformStill(), 0, 470);
        addObject(new PlatformStill(), 100, 470);
        addObject(new PlatformStill(), 200, 470);
        addObject(new PlatformStill(), 300, 470);
        addObject(new PlatformStill(), 400, 470);
        addObject(new PlatformStill(), 500, 470);
        addObject(new PlatformStill(), 600, 470);
        addObject(new PlatformStill(), 700, 470);
        addObject(new PlatformStill(), 800, 470);
        addObject(new PlatformStill(), 900, 470);
        
        //cheese counter
        addObject(counter, 450, 210);
        getCounter();
    }
    private void spawnCheese() {
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
    private void spawnCheese2() {
         if (Greenfoot.getRandomNumber(100) < 1) {
            addObject(new Cheese(), Greenfoot.getRandomNumber(901), 0);
        }
    }
    public YouWinCounter getCounter() {
        return counter;
    }
}
