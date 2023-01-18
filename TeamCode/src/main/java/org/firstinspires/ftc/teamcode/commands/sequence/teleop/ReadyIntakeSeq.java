package org.firstinspires.ftc.teamcode.commands.sequence.teleop;

import com.asiankoala.koawalib.command.commands.InstantCmd;
import com.asiankoala.koawalib.command.commands.WaitCmd;
import com.asiankoala.koawalib.command.commands.WaitUntilCmd;
import com.asiankoala.koawalib.command.group.SequentialGroup;
import com.asiankoala.koawalib.gamepad.KGamepad;
import com.asiankoala.koawalib.hardware.sensor.KDistanceSensor;
import com.asiankoala.koawalib.logger.Logger;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.commands.subsystem.arm.ArmDropCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.claw.ClawFullyOpenCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.horizontal.HorizontalBackCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftCmd;

public class ReadyIntakeSeq extends SequentialGroup {
    public ReadyIntakeSeq(Almond almond, KGamepad driver1, KGamepad driver2, KDistanceSensor DS) {
        super(
                new InstantCmd(() -> {Logger.logInfo("scheduled intaking sequence"); return null; }),
                new InstantCmd(() -> {almond.isIntaking = true; almond.isReady = false; almond.state = Almond.State.INTAKING; return null; }),
                new ArmDropCmd(almond.arm),
                new LiftCmd(almond.lift, Constants.intaking),
                new HorizontalBackCmd(almond.horizontal),
                new ClawFullyOpenCmd(almond.claw),
                new WaitUntilCmd(() -> DS.getLastRead() < 50 ),
                new InstantCmd(() -> {driver1.rumble(1000); return null;})
                );
    }
}
