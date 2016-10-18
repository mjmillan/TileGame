package team.brick.shootem.game.states;

import java.awt.Graphics;

import team.brick.shootem.game.Handler;
import team.brick.shootem.game.gfx.Assets;
import team.brick.shootem.game.ui.ClickListener;
import team.brick.shootem.game.ui.UIImageButton;
import team.brick.shootem.game.ui.UILabel;
import team.brick.shootem.game.ui.UIManager;

public class GameOverState extends State
{
	private UIManager uiManager;
	
	public GameOverState(Handler handler)
	{
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		UILabel lblGameOver = new UILabel(150, 150, 1, 1, "GAME OVER", null);
		UILabel lblScore = new UILabel(150, 200, 10, 20, "SCORE: " + String.valueOf(handler.getPlayerScore()), null);
		UILabel lblHighScore = new UILabel(150, 250, 10, 20, "HIGH SCORE: (high score here)", null);
		UIImageButton btnRestart = new UIImageButton(150, 350, 200, 100, Assets.btn_start, new ClickListener()
				{
					public void onClick()
					{
						handler.getMouseManager().setUIManager(null);
						State.setState(handler.getGame().menuState);
					}
				});
		
		uiManager.addObject(lblScore);
		uiManager.addObject(lblHighScore);
		uiManager.addObject(btnRestart);
		
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}
}