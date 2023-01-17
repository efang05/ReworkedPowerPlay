package org.firstinspires.ftc.teamcode.commands.subsystem.claw;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Claw;

public class ClawCloseCmd extends ClawCmd {
    public ClawCloseCmd(Claw claw) {
        super(claw, Constants.closedClaw);
    }
}
