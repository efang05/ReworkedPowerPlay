package org.firstinspires.ftc.teamcode.commands.subsystem.lift;

import com.asiankoala.koawalib.command.commands.InstantCmd;
import com.asiankoala.koawalib.gamepad.KGamepad;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class LiftPresetCmd extends InstantCmd {
    public LiftPresetCmd(Almond almond, Lift lift, KGamepad driver) {
        super(() -> {
            if (almond.isReady) {
                driver.getDpadLeft().onPress(
                        new InstantCmd(() -> {
                            lift.setTarget(Constants.low);
                            return null;
                        })
                );

                driver.getDpadUp().onPress(
                        new InstantCmd(() -> {
                            lift.setTarget(Constants.up);
                            return null;
                        })
                );

                driver.getDpadRight().onPress(
                        new InstantCmd(() -> {
                            lift.setTarget(Constants.mid);
                            return null;
                        })
                );

                driver.getDpadDown().onPress(
                        new InstantCmd(() -> {
                            lift.setTarget(Constants.ground);
                            return null;
                        })
                );
            }
            return null;
        });
    }
}
