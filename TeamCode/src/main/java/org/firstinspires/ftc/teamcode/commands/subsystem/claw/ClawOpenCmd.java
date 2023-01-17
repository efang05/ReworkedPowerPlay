package org.firstinspires.ftc.teamcode.commands.subsystem.claw;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Claw;

public class ClawOpenCmd extends ClawCmd {
    public ClawOpenCmd(Claw claw) {
        super(claw, Constants.openedClaw);
    }
}
