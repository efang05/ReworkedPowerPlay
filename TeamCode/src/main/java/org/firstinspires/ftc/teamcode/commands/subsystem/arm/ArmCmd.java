package org.firstinspires.ftc.teamcode.commands.subsystem.arm;

import com.asiankoala.koawalib.command.commands.InstantCmd;

import org.firstinspires.ftc.teamcode.subsystems.Arm;

public class ArmCmd extends InstantCmd {
    public ArmCmd(Arm arm, double position) {
        super(() -> {
            arm.setArm(position);
            return null;
        }, arm);
    }
}
