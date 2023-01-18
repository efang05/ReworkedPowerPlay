package org.firstinspires.ftc.teamcode.opmodes;

import com.asiankoala.koawalib.command.KOpMode;
import com.asiankoala.koawalib.command.KScheduler;
import com.asiankoala.koawalib.command.commands.InstantCmd;
import com.asiankoala.koawalib.command.commands.LoopCmd;
import com.asiankoala.koawalib.command.commands.MecanumCmd;
import com.asiankoala.koawalib.command.commands.WatchdogCmd;
import com.asiankoala.koawalib.gamepad.KGamepad;
import com.asiankoala.koawalib.logger.Logger;
import com.asiankoala.koawalib.logger.LoggerConfig;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.commands.sequence.teleop.MainSeq;
import org.firstinspires.ftc.teamcode.commands.sequence.teleop.ReadyIntakeSeq;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftManualCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftPresetCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.turret.TurretManualCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.turret.TurretPresetCmd;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

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
        scheduleDrive();
        schedulePresets();
        scheduleManualControl();
    }

    @Override
    public void mLoop() {
        Logger.addTelemetryData("state", "lol");
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

    private void schedulePresets() {
        KScheduler.schedule(
                new LoopCmd(() -> {
                    new LiftPresetCmd(almond.lift, driver2);
                    new TurretPresetCmd(almond.turret, driver2);
                    return null;
                })
        );
    }

    private void scheduleManualControl() {
        KScheduler.schedule(
                new LoopCmd(() -> {
                    new LiftManualCmd(almond.lift, driver2);
                    new TurretManualCmd(almond.turret, driver2);
                    return null;
                })
        );
    }
}
