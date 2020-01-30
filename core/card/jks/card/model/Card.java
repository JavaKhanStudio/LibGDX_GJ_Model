package jks.card.model;

import java.util.List;

public class Card 
{
	int cost ; 
	String imagePath ; 
	
	List<Effect> self ;
	List<Effect> targeted ;
	List<Effect> random ;
}
