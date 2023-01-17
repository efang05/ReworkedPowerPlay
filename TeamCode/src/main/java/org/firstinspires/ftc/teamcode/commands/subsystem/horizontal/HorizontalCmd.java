package org.firstinspires.ftc.teamcode.commands.subsystem.horizontal;

import com.asiankoala.koawalib.command.commands.InstantCmd;

import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class HorizontalCmd extends InstantCmd {
    public HorizontalCmd(Lift lift, double position) {
        super(() -> {
            lift.setHorizontalTarget(position);
            return null;
        });
    }
}
