package islands.model.player.student;

import islands.model.GameModel;
import islands.model.Move;
import islands.model.TileColor;
import islands.model.player.MinimaxPlayer;

/**
 * A player that uses caching to improve on the minimax algorithm.
 *
 * @see TranspositionTable
 */
public class CachingMinimaxPlayer extends MinimaxPlayer {
    /**
     * Constructs a caching minimax player.
     */
    public CachingMinimaxPlayer() {
    }

    @Override
    public String getName() {
        return "Caching Minimax";
    }

    @Override
    public Move getMyMove(GameModel model, int depth, TileColor tileColor) {
        return super.getMyMove(model, depth, tileColor); // TODO: Replace.
    }
}
