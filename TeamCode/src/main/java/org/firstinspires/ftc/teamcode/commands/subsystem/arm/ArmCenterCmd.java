package org.firstinspires.ftc.teamcode.commands.subsystem.arm;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Arm;

public class ArmCenterCmd extends ArmCmd {
    public ArmCenterCmd(Arm arm) {
        super(arm, Constants.centeredArm);
    }
}
