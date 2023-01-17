package org.firstinspires.ftc.teamcode.commands.subsystem.arm;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class ArmDropCmd extends ArmCmd {
    public ArmDropCmd(Intake intake) {
        super(intake, Constants.droppedArm);
    }
}
