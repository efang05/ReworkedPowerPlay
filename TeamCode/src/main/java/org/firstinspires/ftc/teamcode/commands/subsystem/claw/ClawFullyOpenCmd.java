package org.firstinspires.ftc.teamcode.commands.subsystem.claw;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Claw;

public class ClawFullyOpenCmd extends ClawCmd {
    public ClawFullyOpenCmd(Claw claw) {
        super(claw, Constants.fullyOpen);
    }
}
