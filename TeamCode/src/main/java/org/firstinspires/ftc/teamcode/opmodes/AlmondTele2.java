package org.firstinspires.ftc.teamcode.opmodes;

import com.asiankoala.koawalib.command.KOpMode;
import com.asiankoala.koawalib.command.KScheduler;
import com.asiankoala.koawalib.command.commands.LoopCmd;
import com.asiankoala.koawalib.command.commands.WatchdogCmd;
import com.asiankoala.koawalib.gamepad.KGamepad;
import com.asiankoala.koawalib.logger.Logger;
import com.asiankoala.koawalib.logger.LoggerConfig;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.commands.sequence.teleop.MainSeq;
import org.firstinspires.ftc.teamcode.commands.sequence.teleop.ReadyIntakeSeq;
import org.firstinspires.ftc.teamcode.commands.subsystem.drive.DriveCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftManualCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftPresetCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.turret.TurretManualCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.turret.TurretPresetCmd;

@TeleOp
public class AlmondTele2 extends KOpMode {

    private Almond almond;
    private KGamepad driver1;
    private KGamepad driver2;

    public AlmondTele2() {
        super(true, 8);
    }

    @Override
    public void mInit() {
        driver1 = getDriver();
        driver2 = getGunner();
        Logger.setConfig(LoggerConfig.Companion.getDASHBOARD_CONFIG());
        almond = new Almond();
        //KScheduler.schedule(new ReadyIntakeSeq(almond, driver1, driver2, almond.DS));
        scheduleDrive();

//        scheduleCycling();
//        schedulePresets();
//        scheduleManualControl();
    }

    @Override
    public void mLoop() {
        Logger.addTelemetryData("state", almond.state);
    }

    private void scheduleDrive() {
        almond.drive.setDefaultCommand(new DriveCmd(almond.drive, driver1));
    }

    private void scheduleCycling() {
        KScheduler.schedule(
                new WatchdogCmd(
                        new ReadyIntakeSeq(almond, driver1, driver2, almond.DS),
                        () -> { return (driver1.getLeftBumper().isPressed() && !almond.isIntaking); }
                )
        );
        KScheduler.schedule(
                new WatchdogCmd(
                        new MainSeq(almond, driver1, driver2, almond.DS),
                        () -> { return (driver1.getRightBumper().isPressed() && almond.isIntaking); }
                )
        );
    }

    private void schedulePresets() {
        KScheduler.schedule(
                new LoopCmd(() -> {
                    KScheduler.schedule(
                            new LiftPresetCmd(almond, almond.lift, driver2)
                    );
                    KScheduler.schedule(
                            new TurretPresetCmd(almond,     almond.turret, driver2)
                    );
                    return null;
                })
        );
    }

    private void scheduleManualControl() {
        KScheduler.schedule(
                new LoopCmd(() -> {
                    KScheduler.schedule(
                            new LiftManualCmd(almond, almond.lift, driver2)
                    );
                    KScheduler.schedule(
                            new TurretManualCmd(almond, almond.turret, driver2)
                    );
                    return null;
                })
        );
    }

    private void configureControls() {
        driver1.getLeftStick().setXRateLimiter(5.0);
        driver1.getLeftStick().setYRateLimiter(5.0);
        driver1.getRightStick().setXRateLimiter(5.0);
    }
}
