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
// Класс - модель (класс данных)
public final class ResultMove {
    public static int WIN = 1;
    public static int DRAW = 0;
    public static int GAME_CONTINUES = -1;

    private final int result;

    public ResultMove(int result) {
        this.result = result;
    }

    public boolean gameOver() {
        return result != GAME_CONTINUES;
    }

    public boolean isDraw() {
        return result == DRAW;
    }
}
