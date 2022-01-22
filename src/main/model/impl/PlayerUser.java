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

import main.model.BasePlayer;
import main.model.PlayersMove;

import java.util.Scanner;

/**
 * @author L. Rastorguev
 **/

public class PlayerUser extends BasePlayer {

    public PlayerUser(final String name, final char mark) {
        super(name, mark);
    }

    @Override
    public PlayersMove getMove(int range) {

        System.out.println("Enter your move from 1 to " + range + ":");

        int move;

        while (true) {

            move = new Scanner(System.in).nextInt();

            if (move > 0 && move <= range) {
                break;
            }

            System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        }

        return new PlayersMove(move, mark);
    }

    @Override
    public void inform(final String message) {
        System.out.println(message);
    }
}
