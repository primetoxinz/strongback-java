/*
 * Strongback
 * Copyright 2015, Strongback and individual contributors by the @authors tag.
 * See the COPYRIGHT.txt in the distribution for a full listing of individual
 * contributors.
 *
 * Licensed under the MIT License; you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://opensource.org/licenses/MIT
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.strongback.components.ui;

import java.util.function.BiConsumer;
import java.util.function.IntToDoubleFunction;

import org.strongback.components.Switch;
import org.strongback.function.IntToBooleanFunction;
import org.strongback.function.IntToIntFunction;

/**
 * A type of input device similar to an Xbox controller.
 */
public interface Gamepad extends InputDevice {
    ContinuousRange getLeftX();

    ContinuousRange getLeftY();

    ContinuousRange getRightX();

    ContinuousRange getRightY();

    ContinuousRange getLeftTrigger();

    ContinuousRange getRightTrigger();

    Switch getLeftBumper();

    Switch getRightBumper();

    Switch getA();

    Switch getB();

    Switch getX();

    Switch getY();

    Switch getStart();

    Switch getSelect();

    Switch getLeftStick();

    Switch getRightStick();

    void setRumble(double left, double right);

    static Gamepad create(IntToDoubleFunction axisToValue, IntToBooleanFunction buttonNumberToSwitch,
                          IntToIntFunction dPad, ContinuousRange leftX, ContinuousRange leftY, ContinuousRange rightX, ContinuousRange rightY,
                          ContinuousRange leftTrigger, ContinuousRange rightTrigger, Switch leftBumper, Switch rightBumper, Switch buttonA,
                          Switch buttonB, Switch buttonX, Switch buttonY, Switch startButton, Switch selectButton, Switch leftStick,
                          Switch rightStick, BiConsumer<Double, Double> rumbler) {
        return new Gamepad() {
            @Override
            public ContinuousRange getAxis(int axis) {
                return () -> axisToValue.applyAsDouble(axis);
            }

            @Override
            public Switch getButton(int button) {
                return () -> buttonNumberToSwitch.applyAsBoolean(button);
            }

            @Override
            public DirectionalAxis getDPad(int pad) {
                return () -> dPad.applyAsInt(pad);
            }

            @Override
            public ContinuousRange getLeftX() {
                return leftX;
            }

            @Override
            public ContinuousRange getLeftY() {
                return leftY;
            }

            @Override
            public ContinuousRange getRightX() {
                return rightX;
            }

            @Override
            public ContinuousRange getRightY() {
                return rightY;
            }

            @Override
            public ContinuousRange getLeftTrigger() {
                return leftTrigger;
            }

            @Override
            public ContinuousRange getRightTrigger() {
                return rightTrigger;
            }

            @Override
            public Switch getLeftBumper() {
                return leftBumper;
            }

            @Override
            public Switch getRightBumper() {
                return rightBumper;
            }

            @Override
            public Switch getA() {
                return buttonA;
            }

            @Override
            public Switch getB() {
                return buttonB;
            }

            @Override
            public Switch getX() {
                return buttonX;
            }

            @Override
            public Switch getY() {
                return buttonY;
            }

            @Override
            public Switch getStart() {
                return startButton;
            }

            @Override
            public Switch getSelect() {
                return selectButton;
            }

            @Override
            public Switch getLeftStick() {
                return leftStick;
            }

            @Override
            public Switch getRightStick() {
                return rightStick;
            }

            @Override
            public void setRumble(double left, double right) {
                rumbler.accept(left, right);
            }


        };
    }

}