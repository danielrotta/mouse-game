import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cheese here.
 * 
 * @author Daniel Rotta
 * @version (a version number or a date)
 */

public class Cheese extends Actor
{
    private GreenfootImage cheeseImage;
    private int gravity, vSpeed = 30, hSpeed = 5;
    private int moveVariation;
    private boolean terminateMethod = false;
    
    private int sideGravity;
    
    public Cheese() {
        cheeseImage = new GreenfootImage("Cheese3.png");
        cheeseImage.scale(35, 35);
        setImage(cheeseImage);
    }
    public void act() 
    {
        setVariation();
        move();
        despawn();
    }
    
    private void despawn() {
        if (getY() > 520 || getX() < -5 || getY() < -100) {
            getWorld().removeObject(this);
        }
    }
    
    private void move() {
        if (moveVariation == 1) { //first movement variation
            gravity--;
            setLocation(getX() - hSpeed, getY() - gravity - vSpeed);
            turn(7);
        }
        else if (moveVariation == 2) { //second movement variation
            gravity--;
            setLocation(getX() + hSpeed, getY() - gravity - vSpeed);
            turn(-7);
        }
        else if (moveVariation == 3) { //third
            if (getY() >= 250) {
                gravity--;
                setLocation(getX() - 1, getY() + gravity);
                turn(7);
            }
            else if (getY() < 250) {
                gravity++;
                setLocation(getX() - 1, getY() + gravity);
                turn(-7);
            }
        }
        else if (moveVariation == 4) {
            setLocation(getX(), getY() + 1);
            turn (3);
        }
        else if (moveVariation == 5) {
            if (getX() < 450) {
                sideGravity++;
                setLocation(getX() + sideGravity, getY() - 1);
            }
            else if (getX() >= 450) {
                sideGravity--;
                setLocation(getX() + sideGravity, getY() - 1);
            }
        }
        else {
            setLocation(getX(), getY() + 1);
            turn(-3);
        }
    }
    private void setVariation() {
        if (!(terminateMethod)) {
            if (getX() == 800) {
                moveVariation = 1;
            }
            else if (getX() == 100) {
                moveVariation = 2;
            }
            else if (getX() == 900) {
                moveVariation = 3;
            }
            else if (getX() == 450) {
                moveVariation = 4;
            }
            else if (getX() == 435) {
                moveVariation = 5;
            }
        terminateMethod = true;
    }
    }
}
