package org.firstinspires.ftc.teamcode.subsystems;

import com.asiankoala.koawalib.control.controller.PIDGains;
import com.asiankoala.koawalib.control.motor.FFGains;
import com.asiankoala.koawalib.control.profile.MotionConstraints;
import com.asiankoala.koawalib.hardware.motor.EncoderFactory;
import com.asiankoala.koawalib.hardware.motor.KMotor;
import com.asiankoala.koawalib.hardware.motor.MotorFactory;
import com.asiankoala.koawalib.hardware.servo.KServo;
import com.asiankoala.koawalib.subsystem.KSubsystem;

import org.firstinspires.ftc.teamcode.Constants;

public class Horizontal extends KSubsystem {

    private final KServo horizontal1 = new KServo("horizontal1")
            .startAt(Constants.horizontalback);

    private final KServo horizontal2 = new KServo("horizontal2")
            .reverse()
            .startAt(Constants.horizontalback);


    public void setHorizontalTarget(double target) {
        horizontal1.setPosition(target);
        horizontal2.setPosition(target);
    }
}
