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

    private final TranspositionTable transpositionTable;
    /**
     * Constructs a caching minimax player.
     */
    public CachingMinimaxPlayer() {
        this.transpositionTable = new TranspositionTable();
    }

    @Override
    public String getName() {
        return "Caching Minimax";
    }

    @Override
    public Move getMyMove(GameModel model, int depth, TileColor tileColor) {
        String key = model.getBoardString();
// idk why red
        if (transpositionTable.containsKey(key)) {
            return transpositionTable.get(key);
        } else {
            Move move = super.getMyMove(model, depth, tileColor);
            transpositionTable.put(key, move);
            return move;
        }


    }
}
