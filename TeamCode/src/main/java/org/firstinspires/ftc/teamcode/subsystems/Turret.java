package org.firstinspires.ftc.teamcode.subsystems;

import com.asiankoala.koawalib.control.controller.PIDGains;
import com.asiankoala.koawalib.control.motor.FFGains;
import com.asiankoala.koawalib.control.profile.MotionConstraints;
import com.asiankoala.koawalib.hardware.motor.EncoderFactory;
import com.asiankoala.koawalib.hardware.motor.KMotor;
import com.asiankoala.koawalib.hardware.motor.MotorFactory;
import com.asiankoala.koawalib.subsystem.KSubsystem;

import org.firstinspires.ftc.teamcode.opmodes.PIDConfig;

public class Turret extends KSubsystem {

    /**
     * TODO: Ticks per unit redo PID lol funny!!!!!
     */

    private final KMotor tmotor = new MotorFactory("tmotor")
            .getBrake()
            .createEncoder(
                    new EncoderFactory( 1.0)
                            .zero()
            )
            .withMotionProfileControl(
                    new PIDGains(
                            PIDConfig.kP,
                            PIDConfig.kI,
                            PIDConfig.kD
                            ),
                    new FFGains(),
                    new MotionConstraints(30, 10, 0),
                    10.0
            )
            .build();

    public void setTarget(double position) {
        tmotor.setPositionTarget(position);
    }

    public double getTargetPosition() { return tmotor.getSetpoint().getX(); }

    public double getCurrentRotation() { return tmotor.getPos(); }

}
