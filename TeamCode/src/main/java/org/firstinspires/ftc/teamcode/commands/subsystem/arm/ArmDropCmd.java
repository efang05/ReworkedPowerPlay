package org.firstinspires.ftc.teamcode.commands.subsystem.arm;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Arm;

public class ArmDropCmd extends ArmCmd {
    public ArmDropCmd(Arm arm) {
        super(arm, Constants.droppedArm);
    }
}
