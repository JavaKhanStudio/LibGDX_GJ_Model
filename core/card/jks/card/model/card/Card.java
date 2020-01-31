package jks.card.model.card;

import java.util.List;

public class Card 
{
	int cost ; 
	String imagePath ; 
	
	List<Effect> self ;
	List<Effect> targeted ;
	List<Effect> random ;
}
