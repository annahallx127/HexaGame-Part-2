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

    // This doesn't override the ordinary getMyMove() method because it adds
    // alpha and beta parameters.
    private Move getMyMove(GameModel model, int depth, double alpha, double beta, TileColor tileColor) {
        return null; // TODO: Implement.
    }

    // This doesn't override the ordinary getMyMove() method because it adds
    // alpha and beta parameters.
    private double getOpponentValue(GameModel model, int depth, double alpha, double beta, TileColor tileColor) {
        return 0.0; // TODO: Implement.
    }
}
