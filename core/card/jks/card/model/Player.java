package jks.card.model;

import java.util.List;

import jks.card.model.card.Card;

public class Player 
{

	String name ;
	Unit refUnit ; 
	List<Card> wholeDeck ;
	
	List<Card> hand ;
	List<Card> discard ;
	List<Card> library ;
	List<Card> exile ;
	
}
