package org.firstinspires.ftc.teamcode.commands.subsystem;

import com.asiankoala.koawalib.command.commands.InstantCmd;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

class ClawCmd extends InstantCmd { public ClawCmd(Intake intake, double position) { super(() -> { intake.setClaw(position); return null; }); }}
class ClawOpenCmd extends ClawCmd { public ClawOpenCmd(Intake intake) { super(intake, Constants.openedClaw); } }
class ClawCloseCmd extends ClawCmd { public ClawCloseCmd(Intake intake) { super(intake, Constants.closedClaw); } }

class ArmCmd extends InstantCmd { public ArmCmd(Intake intake, double position) { super(() -> { intake.setArm(position); return null; }); }}
class ArmLiftCmd extends ArmCmd { public ArmLiftCmd(Intake intake) { super(intake, Constants.liftedArm); }}
class ArmCenterCmd extends ArmCmd { public ArmCenterCmd(Intake intake) { super(intake, Constants.centeredArm); }}
class ArmDropCmd extends ArmCmd { public ArmDropCmd(Intake intake) { super(intake, Constants.droppedArm); }}

class IntakeOnCmd extends InstantCmd { public IntakeOnCmd(Intake intake) { super(() -> { intake.setIntake(Constants.intaking); return null; }); }}
class IntakeOffCmd extends InstantCmd { public IntakeOffCmd(Intake intake) { super(() -> { intake.setIntake(-Constants.intaking); return null; }); }}

