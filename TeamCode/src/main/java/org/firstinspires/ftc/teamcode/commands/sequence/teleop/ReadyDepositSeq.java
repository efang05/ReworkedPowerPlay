package org.firstinspires.ftc.teamcode.commands.sequence.teleop;

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
                new ClawCloseCmd(almond.intake),
                new HorizontalIdleCmd(almond.lift),
                new LiftCmd(almond.lift, Constants.idle),
                new ArmLiftCmd(almond.intake)
        );
    }
}
