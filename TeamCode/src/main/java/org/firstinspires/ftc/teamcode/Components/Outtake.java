package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Outtake {

    private LinearOpMode parent;
    private Telemetry telemetry;

    public DcMotorEx Outtake;

    public void initialize(){

        stop();
        Outtake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

    }

    public Outtake(HardwareMap hardwareMap) {

        Outtake = hardwareMap.get(DcMotorEx.class, "Outtake");

    }

    public void shoot(){

        Outtake.setPower(1);

    }

    public void stop(){

        Outtake.setPower(0);

    }

}