package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;

@Config
public class Constants {
    /**
     * Slide Presets
     **/
    public static double up = 1150;
    public static double mid = 700;
    public static double low = 350;
    public static double ground = 0;
    public static double idle = 200;
    public static double intaking = 10;
     /**
      * Value to drop slides by to score
      **/
    public static double droppedvalue = 150;

    /**
    * Turret Presets
    **/
    public static double front = 0;
    public static double back = 660;
    public static double right = 330;
    public static double left = -330;

    /**
     * Horizontal Extension Presets
     **/
    public static double horizontalback = 0.54;
    public static double horizontalidle = 0.5;
    public static double horizontalmiddle = 0.61;
    public static double horizontalextended = 1;

    /**
     * Horizontal Pos Indicator
     **/
    public static String horizontalpos = "back";

    /**
     * TODO: Auto Cycle
     **/
    public static boolean running = false;

    /**
     * Arm Presets
     **/
    public static double highposarm = 0.6;
    public static double liftedArm = 1;
    public static double droppedArm = 0.1;
    public static double centeredArm = 0.52;

    /**
     * Claw Presets
     **/
    public static double openedClaw = 0.49;
    public static double closedClaw = 0.242;
    public static double fullyOpen = 0.6;
}
