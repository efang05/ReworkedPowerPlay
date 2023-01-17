package org.firstinspires.ftc.teamcode.commands.subsystem.claw;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class ClawOpenCmd extends ClawCmd {
    public ClawOpenCmd(Intake intake) {
        super(intake, Constants.openedClaw);
    }
}
