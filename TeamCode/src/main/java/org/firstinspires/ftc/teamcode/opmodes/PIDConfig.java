package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.dashboard.config.Config;

@Config
public class PIDConfig {
    public static double kP = 0.2, kI = 0, kD = 0.00125, kG = 0.2;
    public static double vel = 1500, accel = 1500, deccel = 1200;
}
