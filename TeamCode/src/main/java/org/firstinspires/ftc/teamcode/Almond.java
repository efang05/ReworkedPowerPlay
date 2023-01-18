package org.firstinspires.ftc.teamcode;

import com.asiankoala.koawalib.hardware.motor.KMotor;
import com.asiankoala.koawalib.hardware.motor.MotorFactory;
import com.asiankoala.koawalib.hardware.sensor.KDistanceSensor;
import com.asiankoala.koawalib.subsystem.drive.KMecanumDrive;

import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Turret;
import org.firstinspires.ftc.teamcode.subsystems.Lift;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Horizontal;

public class Almond {
    private final KMotor lf = new MotorFactory("leftFront")
            .getReverse()
            .getBrake()
            .build();

    private final KMotor lr = new MotorFactory("leftRear")
            .getReverse()
            .getBrake()
            .build();

    private final KMotor rr = new MotorFactory("rightRear")
            .getBrake()
            .build();

    private final KMotor rf = new MotorFactory("rightFront")
            .getBrake()
            .build();

    public KMecanumDrive drive = new KMecanumDrive(lf, lr, rr, rf);

    public KDistanceSensor DS = new KDistanceSensor("distance");

    public Lift lift = new Lift();
    public Claw claw = new Claw();
    public Turret turret = new Turret();
    public Horizontal horizontal = new Horizontal();
    public Arm arm = new Arm();

    public boolean isIntaking = false;
}
