package org.firstinspires.ftc.teamcode.commands.sequence.teleop;

import com.asiankoala.koawalib.command.commands.InstantCmd;
import com.asiankoala.koawalib.command.commands.WaitUntilCmd;
import com.asiankoala.koawalib.command.group.RaceGroup;
import com.asiankoala.koawalib.command.group.SequentialGroup;
import com.asiankoala.koawalib.gamepad.KButton;
import com.asiankoala.koawalib.gamepad.KGamepad;
import com.asiankoala.koawalib.logger.Logger;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.commands.subsystem.arm.ArmDropCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.claw.ClawFullyOpenCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.horizontal.HorizontalBackCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftCmd;

public class IntakingSeq extends SequentialGroup {
    public IntakingSeq(Almond almond, KGamepad driver1, KGamepad driver2) {
        super(
                new InstantCmd(() -> {Logger.logInfo("scheduled intake sequence"); return null; }),
                new RaceGroup(
                        new SequentialGroup(
                                new ReadyDepositSeq(almond),
                                new WaitUntilCmd(driver1.getRightBumper())
                                ),
                        new SequentialGroup(
                                new WaitUntilCmd(driver1.getLeftBumper()),
                                new ReadyIntakeSeq(almond)
                        )
                )
        );
    }
}
