package org.firstinspires.ftc.teamcode.commands.subsystem.arm;

import com.asiankoala.koawalib.command.commands.InstantCmd;

import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class ArmCmd extends InstantCmd {
    public ArmCmd(Intake intake, double position) {
        super(() -> {
            intake.setArm(position);
            return null;
        });
    }
}
