package org.firstinspires.ftc.teamcode.commands.subsystem.lift;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.State;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class LiftCmds {
    public static LiftCmd getLiftCmd(State state, Lift lift) {
        switch(state) {
            case UP: return new LiftCmd(lift, Constants.up);
            case MID: return new LiftCmd(lift, Constants.mid);
            case LOW: return new LiftCmd(lift, Constants.low);
            case GROUND: return new LiftCmd(lift, Constants.ground);
        }
        return null;
    }
}