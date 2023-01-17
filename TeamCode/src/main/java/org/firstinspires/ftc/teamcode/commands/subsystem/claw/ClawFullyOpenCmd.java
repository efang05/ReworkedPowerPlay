package org.firstinspires.ftc.teamcode.commands.subsystem.claw;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class ClawFullyOpenCmd extends ClawCmd {
    public ClawFullyOpenCmd(Intake intake) {
        super(intake, Constants.fullyOpen);
    }
}
