package org.firstinspires.ftc.teamcode.commands.sequence.teleop;

import com.asiankoala.koawalib.command.commands.InstantCmd;
import com.asiankoala.koawalib.command.commands.WaitUntilCmd;
import com.asiankoala.koawalib.command.group.RaceGroup;
import com.asiankoala.koawalib.command.group.SequentialGroup;
import com.asiankoala.koawalib.gamepad.KButton;
import com.asiankoala.koawalib.gamepad.KGamepad;
import com.asiankoala.koawalib.hardware.sensor.KDistanceSensor;
import com.asiankoala.koawalib.logger.Logger;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.commands.subsystem.arm.ArmDropCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.claw.ClawFullyOpenCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.horizontal.HorizontalBackCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftCmd;

public class MainSeq extends SequentialGroup {
    public MainSeq(Almond almond, KGamepad driver1, KGamepad driver2, KDistanceSensor DS) {
        super(
                new InstantCmd(() -> {Logger.logInfo("scheduled intake sequence"); return null; }),
                new SequentialGroup(
                        new InstantCmd(() -> {almond.isIntaking = false; return null; }),
                        new ReadyDepositSeq(almond),
                        new WaitUntilCmd(driver1.getRightBumper()),
                        new DepositingSeq(almond, driver1, driver2, DS)
                )
        );
    }
}
