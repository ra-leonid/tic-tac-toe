/*
 * Copyright (c) 2022  L. Rastorguev
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package main;

/**
 * @author L. Rastorguev
 **/
// Класс - описывающий бизнес-логику
public final class Play {

    private final RepositoryPlayers players;

    private final GameBoard gameBoard = new GameBoard();

    public Play(final RepositoryPlayers players) {

        this.players = players;

    }

    public void runPlay() {

        players.informPlayers(gameBoard.getRulesGame());

        int range = gameBoard.getMaxMoves();

        while (true) {

            for (final Player player : players.getPlayers()) {

                while (true) {

                    PlayersMove playersMove = player.getMove(range);

                    if (gameBoard.setMove(playersMove)) {

                        break;

                    }

                    player.inform("The field is taken.");

                }

                players.informPlayers(gameBoard.getStringBoard());

                ResultMove resultMove = gameBoard.getResultMove();

                if (resultMove.gameOver()) {

                    players.informPlayersGameOver(player, resultMove);
                    return;

                }

            }
        }
    }
}
