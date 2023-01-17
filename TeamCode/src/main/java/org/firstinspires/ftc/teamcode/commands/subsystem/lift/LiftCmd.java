package org.firstinspires.ftc.teamcode.commands.subsystem.lift;

import com.asiankoala.koawalib.command.commands.InstantCmd;

import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class LiftCmd extends InstantCmd {
    public LiftCmd(Lift lift, double position) {
        super(() -> {
            lift.setTarget(position);
            return null;
        });
    }
}
