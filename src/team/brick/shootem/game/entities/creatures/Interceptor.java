package team.brick.shootem.game.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import team.brick.shootem.game.Handler;

public class Interceptor extends Enemy{

	public Interceptor(Handler handler, float x, float y) {
		
		super(handler, x, y);
		
		
	}
	
	
	@Override
	public void render(Graphics g) {
		posX = (int)(x - handler.getGameCamera().getxOffset());
		posY = (int) (y - handler.getGameCamera().getyOffset());
		g.setColor(Color.black);
		g.drawRect(posX, posY, width, height);
		
	}

	@Override
	public void die() {
		// An Interceptor death adds 100 to the player score
		handler.getWorld().getEntityManager().getPlayer().addScore(100);
		
	}

}
