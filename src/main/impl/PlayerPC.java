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

package main.impl;

import main.BasePlayer;
import main.PlayersMove;

import java.util.Random;

/**
 * @author L. Rastorguev
 **/
public class PlayerPC extends BasePlayer {

    public PlayerPC(final String name, final char mark) {
        super(name, mark);
    }

    @Override
    public PlayersMove getMove(int range) {

        int move = new Random().nextInt(range) + 1;

        return new PlayersMove(move, mark);
    }
}
