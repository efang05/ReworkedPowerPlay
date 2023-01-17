package org.firstinspires.ftc.teamcode.commands.sequence.teleop;

import com.asiankoala.koawalib.command.commands.WaitUntilCmd;
import com.asiankoala.koawalib.command.group.ParallelGroup;
import com.asiankoala.koawalib.command.group.SequentialGroup;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.commands.subsystem.arm.*;
import org.firstinspires.ftc.teamcode.commands.subsystem.claw.*;
import org.firstinspires.ftc.teamcode.commands.subsystem.horizontal.HorizontalCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.horizontal.HorizontalIdleCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.*;
import org.firstinspires.ftc.teamcode.commands.subsystem.turret.*;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class IdleSeq extends ParallelGroup {
    public IdleSeq(Almond almond) {
        super(
                new TurretFrontCmd(almond.turret),
                new ArmLiftCmd(almond.intake),
                new LiftCmd(almond.lift, Constants.idle),
                new HorizontalIdleCmd(almond.lift),
                new ClawCloseCmd(almond.intake)
        );
    }
}
