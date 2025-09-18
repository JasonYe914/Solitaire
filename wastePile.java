import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class wastePile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wastePile extends pile
{
    /**
     * Act - do whatever the wastePile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage wasteImage; 
    public void act()
    {
        // Add your action code here.
    }
    
    public wastePile(int x, int y){
        super(x,y); 
        wasteImage = new GreenfootImage("holder.1.png"); 
        wasteImage.scale(71, 96); 
        setImage(wasteImage); 
    }
    
    public void addCard(card Card){
        super.addCard(Card); 
        Card.turnFaceUp(); 
        updateVisuals(); 
    }
    
    public void updateVisuals(){
        for(card Card : cards){
            Card.setLocation(x, y);
        }
        
    }
    
    public List<card> clearPile(){
        List<card> all = new ArrayList<>(cards); 
        for(card Card : all){
            getWorld().removeObject(Card); 
        }
        cards.clear(); 
        return all; 
    }
    
}
