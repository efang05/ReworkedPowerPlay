package org.firstinspires.ftc.teamcode.commands.subsystem.drive;

import com.asiankoala.koawalib.command.commands.Cmd;
import com.asiankoala.koawalib.gamepad.KGamepad;
import com.asiankoala.koawalib.math.Pose;
import com.asiankoala.koawalib.subsystem.drive.KMecanumDrive;

import org.firstinspires.ftc.teamcode.subsystems.Horizontal;

public class DriveCmd extends Cmd {
    private KMecanumDrive drive;
    private KGamepad driver;

    public DriveCmd(KMecanumDrive drive, KGamepad driver) {
        this.drive = drive;
        this.driver = driver;
    }

    @Override
    public void execute() {
        double xScalar, yScalar, rScalar;
        if (driver.getLeftBumper().isPressed()) {
            xScalar = 0.5; yScalar = 0.5; rScalar = 0.5;
        } else {
            xScalar = 1.0; yScalar = 1.0; rScalar = 1.0;
        }

        Pose drivePowers = new Pose(
                driver.getLeftStick().getXAxis() * xScalar,
                driver.getLeftStick().getYAxis() * yScalar,
                driver.getRightStick().getXAxis() * rScalar
        );

        drive.setPowers(drivePowers);
    }
}
