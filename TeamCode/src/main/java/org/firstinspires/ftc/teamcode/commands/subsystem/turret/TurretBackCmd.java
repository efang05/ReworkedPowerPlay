package org.firstinspires.ftc.teamcode.commands.subsystem;

import com.asiankoala.koawalib.command.commands.InstantCmd;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Turret;

public class TurretBackCmd extends TurretCmd { TurretBackCmd(Turret turret) { super(turret, Constants.back); } }
