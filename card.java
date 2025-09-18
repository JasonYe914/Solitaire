import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class card extends Actor
{
    /**
     * Act - do whatever the card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int rank; 
    private String suit; 
    private boolean faceUp; 
    private GreenfootImage faceImage; 
    private GreenfootImage backImage; 
    private boolean isDragging = false;
    private int oX, oY; 
    private pile currentPile; 
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mousePressed(this)){
            
            if(faceUp){
                isDragging = true; 
                oX = getX(); 
                oY = getY(); 
            }
            
            bringToFront(); 
            
        }
        
        if(isDragging && Greenfoot.mouseDragged(this)){
            MouseInfo mouse = Greenfoot.getMouseInfo(); 
            if(mouse != null){
                setLocation(mouse.getX(), mouse.getY()); 
            }
        }
        
        if(isDragging && Greenfoot.mouseDragEnded(this)){
            isDragging = false; 
            pile targetPile = (pile) getOneIntersectingObject(pile.class); 
            
            if(targetPile != null && targetPile.canAcceptCard(this)){
                currentPile.removeCard(this); 
                targetPile.addCard(this); 
                currentPile = targetPile; 
            }
            else{
                setLocation(oX, oY); 
                currentPile.updateVisuals(); 
            }
        }
    }
    
    /*
     * Objective: Sets up the game for singular card 
     */
    public card(String suit, int rank){
        this.suit = suit; 
        this.rank = rank; 
        this.faceImage = new GreenfootImage(rank + "_of_" + suit +".png"); 
        faceImage.scale(71, 96); 
        setImage(faceImage);
        this.backImage = new GreenfootImage("redflip.png");
        backImage.scale(71,96); 
        setImage(backImage); 
        this.faceUp = false; 
    
    }
    public void bringToFront() {
        // Make sure card is in a world
        World world = getWorld();
        if (world == null){
            return;
        }

        // Save current position
        int x = getX();
        int y = getY();

        // Remove and re-add to bring to front
        world.removeObject(this);
        world.addObject(this, x, y);
    }

    
    public void setCurrentPile(pile Pile){
        this.currentPile = Pile; 
    }
    
    /*
     * Objective: sets the image faceUp 
     */
    public void turnFaceUp(){
        faceUp = true; 
        setImage(faceImage); 
    }
    /*
     * Objective: sets the image faceDown 
     */
    public void turnFaceDown(){
        faceUp = false; 
        setImage(backImage); 
    }
    /*
     * return if it is faceUp or down 
     */
    public boolean isFaceUp(){
        return faceUp; 
    }
    /*
     * return rank 
     */
    public int getRank(){
        return rank; 
    }
    /*
     * return suit
     */
    public String getSuit(){
        return suit; 
    }
    /*
     * Objective: returns true or false if card can be stacked 
     * Paramter: another card 
     */
    public boolean canStackOn(card other){
        if(faceUp == true){
            if(this.suit != other.suit && suitColor(this.suit) != suitColor(other.suit)){
                if(this.rank == other.rank - 1){
                    return true;
                }
            }
        }
        return false; 
    }
    
    /*
     * Objective: Identify the color of card
     * Parameter: suit of the card
     */
    public String suitColor(String suit){
        if(suit.equals("diamonds") || suit.equals("hearts")){
            return "red"; 
        }
        return "black"; 
    }


}
