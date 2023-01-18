package org.firstinspires.ftc.teamcode.commands.sequence.teleop;

import com.asiankoala.koawalib.command.commands.InstantCmd;
import com.asiankoala.koawalib.command.commands.WaitCmd;
import com.asiankoala.koawalib.command.group.SequentialGroup;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.commands.subsystem.arm.ArmCenterCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.arm.ArmDropCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.arm.ArmLiftCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.claw.ClawCloseCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.claw.ClawFullyOpenCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.horizontal.HorizontalBackCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.horizontal.HorizontalIdleCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftCmd;

public class ReadyDepositSeq extends SequentialGroup {
    public ReadyDepositSeq(Almond almond) {
        super(
                new ClawCloseCmd(almond.claw),
                new InstantCmd(() -> {almond.state = Almond.State.GRABBED; return null; }),
                new WaitCmd(0.5),
                new IdleSeq(almond),
                new InstantCmd(() -> {almond.state = Almond.State.READY; return null; })
        );
    }
}
