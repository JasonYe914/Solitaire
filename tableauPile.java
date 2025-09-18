import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tableauPile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tableauPile extends pile
{
    /**
     * Act - do whatever the tableauPile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public tableauPile(int x, int y){
        super(x,y); 
    }
    
    public boolean canAcceptCard(card Card){
        card top = getTopCard(); 
        if(top == null){
            return Card.getRank() == 13; 
        }
        return Card.suitColor(Card.getSuit()) != top.suitColor(top.getSuit()) && Card.getRank() == top.getRank() - 1; 
    }
    
    //Override
    public void updateLayout() {
        int spacing = 30;

        for (int i = 0; i < cards.size(); i++) {
            card card = cards.get(i);
            card.setLocation(x, y + i * spacing); // vertical offset
        }

        // Bring top card to front
            }

}
