package org.firstinspires.ftc.teamcode.commands.sequence.teleop;

import com.asiankoala.koawalib.command.group.SequentialGroup;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.commands.subsystem.arm.*;
import org.firstinspires.ftc.teamcode.commands.subsystem.claw.*;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.*;
import org.firstinspires.ftc.teamcode.commands.subsystem.turret.*;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class IdleSeq extends SequentialGroup {
    public IdleSeq(Almond almond) {
        super(
                new TurretFrontCmd(almond.turret),
                new ArmDropCmd(almond.intake),
                new LiftCmd(almond.lift, Constants.intaking)
        );
    }
}
