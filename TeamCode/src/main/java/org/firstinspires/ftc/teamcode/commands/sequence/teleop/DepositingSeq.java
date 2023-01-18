package org.firstinspires.ftc.teamcode.commands.sequence.teleop;

import com.asiankoala.koawalib.command.commands.InstantCmd;
import com.asiankoala.koawalib.command.commands.WaitCmd;
import com.asiankoala.koawalib.command.group.ParallelGroup;
import com.asiankoala.koawalib.command.group.SequentialGroup;
import com.asiankoala.koawalib.gamepad.KButton;
import com.asiankoala.koawalib.gamepad.KGamepad;
import com.asiankoala.koawalib.hardware.sensor.KDistanceSensor;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.commands.subsystem.arm.ArmDropCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.claw.ClawFullyOpenCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.horizontal.HorizontalBackCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftCmd;

public class DepositingSeq extends SequentialGroup {
    public DepositingSeq(Almond almond, KGamepad driver1, KGamepad driver2, KDistanceSensor DS) {
        super(
                new InstantCmd(() -> {almond.isReady = false; almond.state = Almond.State.DEPOSITING; return null; }),
                new ClawFullyOpenCmd(almond.claw),
                new WaitCmd(0.5),
                new InstantCmd(() -> {almond.state = Almond.State.IDLE; return null; }),
                new IdleSeq(almond).waitUntil(driver1.getRightBumper()),
                new ReadyIntakeSeq(almond, driver1, driver2, DS)
        );
    }
}
