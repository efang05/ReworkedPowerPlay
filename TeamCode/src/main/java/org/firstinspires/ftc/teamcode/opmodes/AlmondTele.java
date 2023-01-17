package org.firstinspires.ftc.teamcode.opmodes;

import com.asiankoala.koawalib.command.KOpMode;
import com.asiankoala.koawalib.command.KScheduler;
import com.asiankoala.koawalib.command.commands.MecanumCmd;
import com.asiankoala.koawalib.command.commands.WatchdogCmd;
import com.asiankoala.koawalib.gamepad.KGamepad;
import com.asiankoala.koawalib.logger.Logger;
import com.asiankoala.koawalib.logger.LoggerConfig;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.commands.sequence.teleop.DepositingSeq;
import org.firstinspires.ftc.teamcode.commands.sequence.teleop.IdleSeq;
import org.firstinspires.ftc.teamcode.commands.sequence.teleop.MainSeq;
import org.firstinspires.ftc.teamcode.commands.sequence.teleop.ReadyIntakeSeq;

public class AlmondTele extends KOpMode {
    private Almond almond;
    private KGamepad driver1 = getDriver();
    private KGamepad driver2 = getGunner();

    public AlmondTele() {
        super(true, 8);
    }

    @Override
    public void mInit() {
        Logger.setConfig(LoggerConfig.Companion.getDASHBOARD_CONFIG());
        almond = new Almond();
        KScheduler.schedule(new ReadyIntakeSeq(almond, driver1, driver2));
        scheduleCycling();
    }

    private void scheduleDrive() {
        almond.drive.setDefaultCommand(new MecanumCmd(almond.drive, driver1.getLeftStick(), driver1.getRightStick()));
    }

    private void scheduleCycling() {
        KScheduler.schedule(
                new WatchdogCmd(
                        new ReadyIntakeSeq(almond, driver1, driver2),
                        () -> { return (driver1.getLeftBumper().isPressed() && !almond.isIntaking); }
                )
        );
        KScheduler.schedule(
                new WatchdogCmd(
                        new MainSeq(almond, driver1, driver2),
                        () -> { return (driver1.getRightBumper().isPressed() && almond.isIntaking); }
                )
        );
    }
}
