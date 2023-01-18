package org.firstinspires.ftc.teamcode.commands.subsystem.turret;

import com.asiankoala.koawalib.command.commands.InstantCmd;
import com.asiankoala.koawalib.gamepad.KGamepad;

import org.firstinspires.ftc.teamcode.subsystems.Turret;

public class TurretManualCmd extends InstantCmd {
    public TurretManualCmd(Turret turret, KGamepad driver) {
        super(() -> {
            if(Math.abs(driver.getRightStick().getXAxis()) > 0.5) {
                turret.setTarget(Math.signum(driver.getRightStick().getXAxis()) * 10.0 + turret.getCurrentRotation());
            }
            return null;
        });
    }
}
