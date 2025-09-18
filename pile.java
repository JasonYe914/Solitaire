import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class pile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pile extends Actor
{
    /**
     * Act - do whatever the pile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected List<card> cards; 
    protected int x,y; 
    protected GreenfootImage baseImage; 
    public void act()
    {
        // Add your action code here.
    }
    
    public pile(int x, int y){
        this.x = x; 
        this.y = y; 
        cards = new ArrayList<>(); 
        
    }
    
    public void addCard(card Card){
        cards.add(Card); 
        if (getWorld() != null && Card.getWorld() == null) {
            getWorld().addObject(Card, x, y); // x, y should be pile's position
        }
        Card.bringToFront(); 
        Card.setCurrentPile(this); 
        updateVisuals(); 
    }
    
    public void removeCard(card Card){
        cards.remove(Card); 
        updateVisuals(); 
        card top = getTopCard(); 
        if(top != null && top.isFaceUp() == false){
            top.turnFaceUp(); 
        }
    }
    
    public card getTopCard(){
        if(cards.isEmpty()){
            return null; 
        }
        return cards.get(cards.size()-1); 
    }
    
    public boolean canAcceptCard(card Card){
        return false; 
    }
    
    public void updateVisuals(){
        int offsetY = 0; 
        for(card Card : cards){//iterate through list of cards (deck) 
            Card.setLocation(x, y + offsetY); //creates the fanning effect
            offsetY += 20; 
        }
    }
    
    public int size(){
        return cards.size(); 
    }
    
    public List<card> getCards(){
        return cards; 
    }
}
