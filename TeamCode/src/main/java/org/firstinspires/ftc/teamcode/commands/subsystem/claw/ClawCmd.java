package org.firstinspires.ftc.teamcode.commands.subsystem;

import com.asiankoala.koawalib.command.commands.InstantCmd;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class ClawCmd extends InstantCmd {
    public ClawCmd(Intake intake, double position) { super(() -> { intake.setClaw(position); return null; }); }
}

/**
 * TODO: Intake stuff
 **/
//class IntakeOnCmd extends InstantCmd { public IntakeOnCmd(Intake intake) { super(() -> { intake.setIntake(Constants.intaking); return null; }); }}
//class IntakeOffCmd extends InstantCmd { public IntakeOffCmd(Intake intake) { super(() -> { intake.setIntake(-Constants.intaking); return null; }); }}

