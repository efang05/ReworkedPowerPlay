package org.firstinspires.ftc.teamcode.commands.subsystem.turret;

import com.asiankoala.koawalib.command.commands.InstantCmd;
import com.asiankoala.koawalib.gamepad.KGamepad;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Turret;

public class TurretPresetCmd extends InstantCmd {
    public TurretPresetCmd(Turret turret, KGamepad driver) {
        super(() -> {
            driver.getY().onPress(
                    new InstantCmd(() -> {
                        turret.setTarget(Constants.front);
                        return null;
                    })
            );

            driver.getX().onPress(
                    new InstantCmd(() -> {
                        turret.setTarget(Constants.left);
                        return null;
                    })
            );

            driver.getB().onPress(
                    new InstantCmd(() -> {
                        turret.setTarget(Constants.right);
                        return null;
                    })
            );

            driver.getA().onPress(
                    new InstantCmd(() -> {
                        turret.setTarget(Constants.back);
                        return null;
                    })
            );

            return null;
        });
    }
}
