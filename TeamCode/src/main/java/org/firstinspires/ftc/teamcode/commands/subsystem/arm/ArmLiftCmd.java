package org.firstinspires.ftc.teamcode.commands.subsystem;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class ArmLiftCmd extends ArmCmd {
    public ArmLiftCmd(Intake intake) {
        super(intake, Constants.liftedArm);
    }
}
