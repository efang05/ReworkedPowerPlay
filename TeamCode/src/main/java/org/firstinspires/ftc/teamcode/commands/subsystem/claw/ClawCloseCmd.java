package org.firstinspires.ftc.teamcode.commands.subsystem.claw;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class ClawCloseCmd extends ClawCmd {
    public ClawCloseCmd(Intake intake) {
        super(intake, Constants.closedClaw);
    }
}
