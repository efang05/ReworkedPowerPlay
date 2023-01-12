package org.firstinspires.ftc.teamcode.opmodes;

import com.asiankoala.koawalib.command.KOpMode;
import com.asiankoala.koawalib.logger.Logger;
import com.asiankoala.koawalib.logger.LoggerConfig;

import org.firstinspires.ftc.teamcode.Almond;

public class AlmondTele extends KOpMode {
    private Almond almond;

    public AlmondTele() {
        super(true);
    }

    @Override
    public void mInit() {
        Logger.INSTANCE.setConfig(LoggerConfig.Companion.getDASHBOARD_CONFIG());
        almond = new Almond();
    }
}
