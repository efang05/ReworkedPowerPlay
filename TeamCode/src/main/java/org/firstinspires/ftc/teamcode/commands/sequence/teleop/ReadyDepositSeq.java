package org.firstinspires.ftc.teamcode.commands.sequence.teleop;

import com.asiankoala.koawalib.command.group.SequentialGroup;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.commands.subsystem.arm.ArmDropCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.claw.ClawFullyOpenCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.horizontal.HorizontalBackCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftCmd;

public class ReadyIntakeSeq extends SequentialGroup {
    public ReadyIntakeSeq(Almond almond) {
        super(
                new ArmDropCmd(almond.intake),
                new LiftCmd(almond.lift, Constants.intaking),
                new HorizontalBackCmd(almond.lift),
                new ClawFullyOpenCmd(almond.intake)
        );
    }
}
