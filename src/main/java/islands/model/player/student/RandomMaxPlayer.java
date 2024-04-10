package islands.model.player.student;

import islands.model.GameModel;
import islands.model.Move;
import islands.model.RowColPair;
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
        if (depth < 0) {
            throw new IllegalArgumentException();
        }

        if (depth == 0 || model.isGameOver()) {
            return getValue(model, tileColor.getOpposite());
        }

        double childSum = 0;
        for (RowColPair position : getLegalPositions(model)) {
            GameModel childModel = model.deepCopy();
            childModel.makePlay(position.row(), position.column(), tileColor);
            Move childMove = getMyMove(childModel, depth - 1, tileColor.getOpposite());

            double minValue = childMove.value();
            childSum += minValue;

        }
        return childSum / getLegalPositions(model).size();
    }
}

