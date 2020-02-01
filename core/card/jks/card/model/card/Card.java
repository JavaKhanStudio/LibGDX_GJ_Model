package jks.card.model.card;

import java.util.List;

public class Card 
{
	int cost ; 
	String imagePath ; 
	boolean permanent ;
	List<Enum_Tag> tag ; 
	
	List<Effect> play ;
	List<Effect> passive ;
}
