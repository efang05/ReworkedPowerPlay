package org.firstinspires.ftc.teamcode.opmodes;

import com.asiankoala.koawalib.command.KOpMode;
import com.asiankoala.koawalib.command.KScheduler;
import com.asiankoala.koawalib.gamepad.KGamepad;
import com.asiankoala.koawalib.logger.Logger;
import com.asiankoala.koawalib.logger.LoggerConfig;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.commands.subsystem.lift.LiftCmd;
import org.firstinspires.ftc.teamcode.commands.subsystem.turret.TurretCmd;
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

    @Override
    public void mInit() {
        driver1 = getDriver();
        driver2 = getGunner();
        Logger.setConfig(LoggerConfig.Companion.getDASHBOARD_CONFIG());
        almond = new Almond();
        scheduleTuner();
    }

    @Override
    public void mLoop() {
        Logger.addTelemetryData("state", "lol");
        Logger.addVar("Current Position", almond.lift.getCurrentHeight());
        Logger.addVar("Target Position", almond.lift.getTargetPosition());
    }

    public void scheduleTuner() {
        driver1.getRightBumper().onPress(new LiftCmd(almond.lift, PIDConfig.position));
    }
}
