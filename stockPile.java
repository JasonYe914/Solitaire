import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Collections;

/**
 * Write a description of class stockPile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class stockPile extends pile
{
    /**
     * Act - do whatever the stockPile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private wastePile WastePile; 
    private int drawCount = 1; 
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if(!cards.isEmpty()){
                dealToWaste(); 
            }
            else{
                resetFromWaste(); 
            }
        }
    }
    
    public stockPile( int x, int y, wastePile WastePile){
        super(x,y); 
        this.WastePile = WastePile;  
        
        this.baseImage = new GreenfootImage("square.png"); 
        baseImage.scale(40,40); 
        setImage(baseImage); 
        
    }
    
    public void updateVisuals(){
        for(card Card : cards){
            Card.setLocation(x,y); 
        }
        
    }
    
    
    public void dealToWaste(){
        int count = Math.min(drawCount, cards.size()); 
        
        for(int i = 0; i < count; i++){
            card Card = cards.remove(cards.size()-1); 
            Card.turnFaceUp(); 
            WastePile.addCard(Card); 
            WastePile.updateVisuals(); 
        }
    }
    
    public void resetFromWaste(){
        List<card> toReturn = WastePile.clearPile();
        Collections.reverse(toReturn); 
        for(card Card : toReturn){
            Card.turnFaceDown(); 
            addCard(Card); 
        }
    }
    
}
