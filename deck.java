import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

/**
 * Write a description of class deck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class deck extends Actor
{
    /**
     * Act - do whatever the deck wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private List<card> cards;
    
    public void act()
    {
        // Add your action code here.
    }
    
    public deck(){
        String suit[] = {"clubs", "diamonds", "hearts", "spades"}; 
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < 14; j++){
                card temp = new card(suit[i], j); 
                cards.add(temp); 
            }
        }
        shuffle(); 
        
    }
    
    public void shuffle(){
        Collections.shuffle(cards); 
    }
    
    public card deal(){
        if(!isEmpty()){
            return cards.remove(0); 
        }
        return null; 
    }
    
    public List<card> dealThree(){
        List<card> hand = new ArrayList<>(); 
        for(int i = 0; i < 3 && !isEmpty(); i++){
            hand.add(deal()); 
        }
        return hand; 
    }
    
    public boolean isEmpty(){
        return cards.isEmpty(); 
    }
}
