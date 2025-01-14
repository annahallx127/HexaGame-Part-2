package islands.model.player.student;

import islands.model.*;
import islands.model.player.MinimaxPlayer;

/**
 * A player applying alpha-beta pruning to the minimax algorithm.
 */
public class AlphaBetaPlayer extends MinimaxPlayer {
    private final TranspositionTable table = new TranspositionTable();

    /**
     * Constructs sa simulated player using alpha-beta pruning.
     */
    public AlphaBetaPlayer() {
    }

    @Override
    public String getName() {
        return "Alpha-Beta";
    }

    /**
     * Chooses the next move, searching to the specified depth.
     *
     * @param model     the model
     * @param depth     the depth to search
     * @param tileColor the tile color of the current player
     * @return the move
     */
    public RowColPair chooseNextMove(GameModel model, int depth, TileColor tileColor) {
        // The initial value of alpha is -Double.MAX_VALUE because
        // Double.MIN_VALUE is the smallest *positive* double value.
        Move move = getMyMove(model, depth, -Double.MAX_VALUE, Double.MAX_VALUE, tileColor);
        return move.getPosition();
    }

    @Override
    public Move getMyMove(GameModel model, int depth, TileColor tileColor) {
        return getMyMove(model, depth, -Double.MAX_VALUE, Double.MAX_VALUE, tileColor);
    }

    @Override
    public double getOpponentValue(GameModel model, int depth, TileColor
            tileColor) {
        return getOpponentValue(model, depth, -Double.MAX_VALUE, Double.MAX_VALUE, tileColor);
    }

    private Move getMyMove(GameModel model, int depth, double alpha, double beta, TileColor tileColor) {
        if (depth < 0) {
            throw new IllegalArgumentException();
        }
        if (depth == 0 || model.isGameOver()) {
            return new Move(getValue(model, tileColor));
        }
        double maxValue = -Double.MAX_VALUE;
        Move bestMove = null;
        for (RowColPair position : getLegalPositions(model)) {
            GameModel newModel = model.deepCopy();
            newModel.makePlay(position.row(), position.column(), tileColor);
            double childValue = getOpponentValue(newModel, depth - 1, alpha, beta, tileColor.getOpposite());

            maxValue = Math.max(maxValue, childValue);
            alpha = Math.max(alpha, maxValue);

            if (maxValue >= beta) {
                return new Move(position.row(), position.column(), childValue);
            }

            if (bestMove == null || childValue > bestMove.value()) {
                bestMove = new Move(position.row(), position.column(), childValue);
            }
        }
        return bestMove;
    }

    private double getOpponentValue(GameModel model, int depth, double alpha, double beta, TileColor tileColor) {
        if (depth < 0) {
            throw new IllegalArgumentException();
        }
        if (depth == 0 || model.isGameOver()) {
            return getValue(model, tileColor.getOpposite());
        }
        double minValue = Double.MAX_VALUE;
        for (RowColPair position : getLegalPositions(model)) {
            GameModel childModel = model.deepCopy();
            childModel.makePlay(position.row(), position.column(), tileColor);
            Move childMove = getMyMove(childModel, depth - 1, alpha, beta, tileColor.getOpposite());
            if (childMove.value() < minValue) {
                minValue = childMove.value();
            }

            minValue = Math.min(minValue, childMove.value());
            alpha = Math.min(alpha, minValue);

            if (beta <= alpha) {
                break;
            }
        }
        return minValue;
    }
}
