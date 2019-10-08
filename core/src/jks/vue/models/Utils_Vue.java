package jks.vue.models;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Utils_Vue 
{

	
	public static Array<Vector2> extracCellPosition(TiledMapTileLayer layer)
	{
		int getWidth = layer.getWidth();
		int getHeight = layer.getHeight();

		Cell cell;
		Array<Vector2> cells = new Array<Vector2>();

		for (int x = 0; x < getWidth; x++)
		{
			for (int y = 0; y < getHeight; y++)
			{
				cell = layer.getCell(x, y);
				if (cell != null) 
					cells.add(new Vector2(x, y));
				
			}
		}
		
		return cells ; 
	}
	
}
