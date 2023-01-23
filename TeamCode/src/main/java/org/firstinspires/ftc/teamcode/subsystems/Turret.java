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

    private final KMotor tmotor = new MotorFactory("turret")
            .getBrake()
            .createEncoder(
                    new EncoderFactory( 3.666666666666667)
                            .zero()
            )
            .withMotionProfileControl(
                    new PIDGains(
                            0.2,
                            0,
                            0.0015
                            ),
                    new FFGains(),
                    new MotionConstraints(PIDConfig.vel, PIDConfig.accel, PIDConfig.deccel),
                    2.5)
            .build();

    public void setTarget(double position) {
        tmotor.setPositionTarget(position);
    }

    public double getTargetPosition() { return tmotor.getTargetState().getX(); }

    public double getCurrentRotation() { return tmotor.getPos(); }

    public double getTargetVel() { return tmotor.getTargetState().getV(); }

    public double getCurrentVelocity() { return tmotor.getVel(); }

}
