package org.firstinspires.ftc.teamcode.commands.subsystem.arm;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Arm;

public class ArmLiftCmd extends ArmCmd {
    public ArmLiftCmd(Arm arm) {
        super(arm, Constants.liftedArm);
    }
}
