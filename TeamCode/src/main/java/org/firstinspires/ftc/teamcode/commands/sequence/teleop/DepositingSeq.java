package org.firstinspires.ftc.teamcode.commands.sequence.teleop;

import com.asiankoala.koawalib.command.group.ParallelGroup;
import com.asiankoala.koawalib.command.group.SequentialGroup;
import com.asiankoala.koawalib.gamepad.KButton;
import com.asiankoala.koawalib.gamepad.KGamepad;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.commands.subsystem.arm.ArmDropCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.claw.ClawFullyOpenCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.horizontal.HorizontalBackCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftCmd;

public class DepositingSeq extends SequentialGroup {
    public DepositingSeq(Almond almond, KGamepad driver1, KGamepad driver2) {
        super(
                new ClawFullyOpenCmd(almond.claw),
                new IdleSeq(almond).waitUntil(driver1.getRightBumper()),
                new ReadyIntakeSeq(almond, driver1, driver2)
        );
    }
}
