package islands.model.player.student;

import islands.model.GameModel;
import islands.model.TileColor;
import islands.model.player.MinimaxPlayer;

/**
 * A player that chooses the highest-scoring move based on the assumption
 * that the opponent chooses moves randomly.
 */
public class RandomMaxPlayer extends MinimaxPlayer {
    /**
     * Constructs a player that chooses the highest-scoring move based on the assumption that the
     * opponent chooses moves randomly.
     */
    public RandomMaxPlayer() {
    }

    @Override
    public String getName() {
        return "RandomMax";
    }

    // Because this only does the opponent move, it does not need to provide a move, just a value.
    @Override
    public double getOpponentValue(GameModel model, int depth, TileColor tileColor) {
        // TODO: Handle the base cases.

        // TODO: Compute and return the average of the child node values.
        return 0.0;
    }
}
