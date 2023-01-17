package org.firstinspires.ftc.teamcode.commands.subsystem.claw;

import com.asiankoala.koawalib.command.commands.InstantCmd;

import org.firstinspires.ftc.teamcode.subsystems.Claw;

public class ClawCmd extends InstantCmd {
    public ClawCmd(Claw claw, double position) {
        super(() -> {
            claw.setClaw(position);
            return null;
            }, claw);
    }
}

/**
 * TODO: Intake stuff
 **/
//class IntakeOnCmd extends InstantCmd { public IntakeOnCmd(Intake intake) { super(() -> { intake.setIntake(Constants.intaking); return null; }); }}
//class IntakeOffCmd extends InstantCmd { public IntakeOffCmd(Intake intake) { super(() -> { intake.setIntake(-Constants.intaking); return null; }); }}

