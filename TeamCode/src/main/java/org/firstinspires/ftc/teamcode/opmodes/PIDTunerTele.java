package org.firstinspires.ftc.teamcode.opmodes;

import com.asiankoala.koawalib.command.KOpMode;
import com.asiankoala.koawalib.command.KScheduler;
import com.asiankoala.koawalib.command.commands.InstantCmd;
import com.asiankoala.koawalib.command.commands.LoopCmd;
import com.asiankoala.koawalib.command.commands.WatchdogCmd;
import com.asiankoala.koawalib.gamepad.KGamepad;
import com.asiankoala.koawalib.logger.Logger;
import com.asiankoala.koawalib.logger.LoggerConfig;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.commands.sequence.teleop.ReadyIntakeSeq;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftPresetCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.turret.TurretCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.turret.TurretPresetCmd;
import org.firstinspires.ftc.teamcode.opmodes.PIDConfig;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

@TeleOp
public class PIDTunerTele extends KOpMode {
    private Almond almond;
    private KGamepad driver1;
    private KGamepad driver2;

    public PIDTunerTele() {
        super(true, 8);
    }
    private final double front = 0;
    private final double back = 180;

    @Override
    public void mInit() {
        driver1 = getDriver();
        driver2 = getGunner();
        Logger.setConfig(LoggerConfig.Companion.getDASHBOARD_CONFIG());
        almond = new Almond();
        almond.lift.setTarget(7);
        driver1.getRightBumper().onPress(new InstantCmd(() -> { almond.turret.setTarget(front); return null; }));
        driver1.getLeftBumper().onPress(new InstantCmd(() -> { almond.turret.setTarget(back); return null; }));
    }

    @Override
    public void mLoop() {
        Logger.addTelemetryData("state", "lol");
        //Logger.addTelemetryData("motor2", almond.lift.lift2.getPower());
        Logger.addVar("Current Position", almond.turret.getCurrentRotation());
        Logger.addVar("Target Position", almond.turret.getTargetPosition());
        Logger.addVar("Current Vel", almond.turret.getCurrentVelocity());
        Logger.addVar("Target Vel", almond.turret.getTargetVel());

    }
}
