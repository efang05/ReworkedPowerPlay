package org.firstinspires.ftc.teamcode.commands.subsystem.arm;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class ArmLiftCmd extends ArmCmd {
    public ArmLiftCmd(Intake intake) {
        super(intake, Constants.liftedArm);
    }
}
