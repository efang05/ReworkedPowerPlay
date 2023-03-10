package org.firstinspires.ftc.teamcode.commands.subsystem.lift;

import com.asiankoala.koawalib.command.commands.InstantCmd;
import com.asiankoala.koawalib.gamepad.KGamepad;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class LiftManualCmd extends InstantCmd {
    public LiftManualCmd(Almond almond, Lift lift, KGamepad driver) {
        super(() -> {
            if(Math.abs(driver.getLeftStick().getYAxis()) > 0.5 && almond.isReady) {
                lift.setTarget(Math.signum(driver.getLeftStick().getYAxis()) * 10.0 + lift.getCurrentHeight());
            }
            return null;
        });
    }
}
