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

public class Lift extends KSubsystem {
    private final KMotor lift1 = new MotorFactory("lift1")
            .getBrake()
            .getReverse()
            .build();

    private final KMotor lift2 = new MotorFactory("lift2")
            .getBrake()
            .getReverse()
            .createEncoder(
                    new EncoderFactory(1.0)
                            .getReverse()
                            .zero()
            )
            .withMotionProfileControl(
                    new PIDGains(
                            0.022,
                            0.0,
                            0.0003
                    ),
                    new FFGains(0.0, 0.0, 0.0, 0.16, 0.0),
                    new MotionConstraints(1600, 800, 0),
                    10.0
            )
            .build();

    public void setTarget(double target) {
        lift2.setPositionTarget(target);
    }

    public double getCurrentHeight() { return lift2.getPos(); }

    @Override
    public void periodic() {
        lift1.setPower(lift2.getPower());
    }
}
