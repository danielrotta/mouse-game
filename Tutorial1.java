import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial1 extends World
{
    private GreenfootImage toJump, toBoost, toCrouch, toCollect, toStart, explain;
    public Tutorial1()
    {    
        super(900, 500, 1, false);
        
        GreenfootImage explain = new GreenfootImage("Explain3.png");
        explain.scale(900, 500);
        setBackground(explain);
        
        
        addObject(new TutorialMouse(), 150, 300);
        
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
    }
}
