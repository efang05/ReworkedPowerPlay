package org.firstinspires.ftc.teamcode.opmodes;

import com.asiankoala.koawalib.command.KOpMode;
import com.asiankoala.koawalib.command.KScheduler;
import com.asiankoala.koawalib.gamepad.KGamepad;
import com.asiankoala.koawalib.logger.Logger;
import com.asiankoala.koawalib.logger.LoggerConfig;

import org.firstinspires.ftc.teamcode.Almond;
import org.firstinspires.ftc.teamcode.commands.subsystem.turret.TurretCmd;
import org.firstinspires.ftc.teamcode.opmodes.PIDConfig;

public class PIDTunerTele extends KOpMode {
    private Almond almond;
    private KGamepad driver1 = getDriver();
    private KGamepad driver2 = getGunner();

    public PIDTunerTele() {
        super(true, 8);
    }

    @Override
    public void mInit() {
        Logger.setConfig(LoggerConfig.Companion.getDASHBOARD_CONFIG());
        almond = new Almond();
        scheduleTuner();
    }

    @Override
    public void mLoop() {
        Logger.addTelemetryData("state", "lol");
        Logger.addVar("Current Position", almond.turret.getCurrentRotation());
        Logger.addVar("Target Position", almond.turret.getTargetPosition());
    }

    public void scheduleTuner() {
        driver1.getRightBumper().onPress(new TurretCmd(almond.turret, PIDConfig.position));
    }
}
