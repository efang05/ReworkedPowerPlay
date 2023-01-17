package org.firstinspires.ftc.teamcode.commands.subsystem.arm;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class ArmCenterCmd extends ArmCmd {
    public ArmCenterCmd(Intake intake) {
        super(intake, Constants.centeredArm);
    }
}
