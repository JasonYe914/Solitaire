import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private stockPile StockPile; 
    private wastePile WastePile; 
    private tableauPile[] TableauPile = new tableauPile[7]; 
    private foundationPile[] FoundationPile = new foundationPile[4]; 
    private GreenfootImage background; 
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        
        super(800, 525, 1); 
        //gives the predefined positions of the categories
        setPaintOrder(card.class, wastePile.class, tableauPile.class); 
        
        background = new GreenfootImage("bg.2.png"); 
        background.scale(800, 600); 
        setBackground(background); 
        
        WastePile = new wastePile(300, 100); 
        addObject(WastePile, 300, 100); 
        
        StockPile = new stockPile(200, 100, WastePile); 
        addObject(StockPile, 100, 100); 
        
        
        for(int i = 0; i < 4; i++){
            FoundationPile[i] = new foundationPile(425 + i*80, 100); 
            addObject(FoundationPile[i], 425 + i*80, 100); 
        }
        
        for(int j = 0; j < 7; j++){
            TableauPile[j] = new tableauPile(125 + j*90,  275);
            addObject(TableauPile[j], 125 + j * 90, 275); 
        }
       
        dealCards(); 
    }
    
    public void dealCards(){
        //this creates the deck that holds all the cards
        List<card> deck = new ArrayList<>(); 
        for(String suit : new String[] {"hearts", "diamonds", "clubs", "spades"}){
            for(int rank = 1; rank <= 13; rank++){
                card Card = new card(suit, rank); 
                deck.add(Card); 
            }
        }
        
        Collections.shuffle(deck); 
        
        //creates the tableau foundation and the location of where the cards should be placed 
        for(int i = 0; i < TableauPile.length; i++){
            for(int j = 0; j <= i; j++){
                card Card = deck.remove(deck.size() - 1); 
                TableauPile[i].addCard(Card); 
                if(j == i){
                    Card.turnFaceUp(); 
                }
            }
        }
        
        
        for(card Card : deck){
            StockPile.addCard(Card); 
        }
        
    }
}
