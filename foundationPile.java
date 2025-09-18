import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class foundationPile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class foundationPile extends pile
{
    /**
     * Act - do whatever the foundationPile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean win = false; 
    private GreenfootImage fImage; 
    public void act()
    {
        // Add your action code here.
    
    }
    
    public foundationPile(int x, int y){
        super(x,y); 
        fImage = new GreenfootImage("holder.1.png"); 
        fImage.scale(71,96); 
        setImage(fImage); 
        
    }
    
    public void updateVisuals(){
        for(card Card : cards){
            Card.setLocation(x,y); 
        }
    }
    
    public boolean canAcceptCard(card Card){
        card Top = getTopCard(); 
        
        if(Top == null){
            return Card.getRank() == 1; 
        }
        // not the same as tableau so different rules return Card.canStackOn(Top);
        // ---> Fix this 
        return Card.getRank() == Top.getRank() + 1 && Card.suitColor(Card.getSuit()) == Top.suitColor(Top.getSuit()); 
    }
    
    public void checkWin(){
        card Top = getTopCard();
        
        if(Top.getRank() == 13){
            win = true; 
        }
    }
}
