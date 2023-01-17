package org.firstinspires.ftc.teamcode.commands.subsystem.horizontal;

import com.asiankoala.koawalib.command.commands.InstantCmd;

import org.firstinspires.ftc.teamcode.subsystems.Horizontal;

public class HorizontalCmd extends InstantCmd {
    public HorizontalCmd(Horizontal horizontal, double position) {
        super(() -> {
            horizontal.setHorizontalTarget(position);
            return null;
        }, horizontal);
    }
}
