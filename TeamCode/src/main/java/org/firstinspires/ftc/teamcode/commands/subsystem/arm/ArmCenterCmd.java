package org.firstinspires.ftc.teamcode.commands.subsystem;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class ArmCenterCmd extends ArmCmd {
    public ArmCenterCmd(Intake intake) {
        super(intake, Constants.centeredArm);
    }
}
