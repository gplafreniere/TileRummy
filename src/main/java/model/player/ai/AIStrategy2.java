package model.player.ai;

import model.Game;
import model.Hand;

public class AIStrategy2 extends AIStrategy {

	public AIStrategy2(Game game, Hand hand) {
		super(game, hand);
	}

	@Override
	boolean firstHandStrategy() {
		if (game.getTable().size() == 0) {
			logger.debug("NO MELDS ON TABLE. AIStrategy2 WON'T PLAY FIRST HAND");
			return false;
		}
		boolean success = attemptToPlayFirstHand();
		if (success) {
			logger.debug("AIStrategy2 PLAYED ITS FIRST HAND");
		}
		return success;
	}

	@Override
	void regularStrategy() {
		if(attemptToPlayAllTiles()){
			logger.debug("AIStrategy2 PLAYED ALL ITS TILES");
			return;
		}
		if(playConservative()){
			logger.debug("AIStrategy2 PLAYED A HAND");
			return;
		}
		logger.debug("AIStrategy2 DRAWS A TILE");
	}
}