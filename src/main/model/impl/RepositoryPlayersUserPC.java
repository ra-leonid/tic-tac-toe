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

package main.model.impl;

import main.interfaces.Player;
import main.interfaces.RepositoryPlayers;
import main.model.ResultMove;

/**
 * @author L. Rastorguev
 **/
public class RepositoryPlayersUserPC implements RepositoryPlayers {

    Player[] players = new Player[2];

    public RepositoryPlayersUserPC() {
        players[0] = new PlayerUser("YOU", 'x');
        players[1] = new PlayerPC("COMPUTER", 'o');
    }

    @Override
    public Player[] getPlayers() {
        return players;
    }

    @Override
    public void informPlayers(final String message) {
        for (final Player player : players) {
            player.inform(message);
        }
    }

    @Override
    public void informPlayersGameOver(final Player winPlayer, final ResultMove resultMove) {

        String message;

        if (resultMove.isDraw()) {
            message = "Sorry, DRAW!";
        } else {
            message = winPlayer.getName() + " WIN!";
        }

        for (final Player player : players) {
            player.inform(message);
        }
    }
}
