package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Pusher {

    private LinearOpMode parent;
    private Telemetry telemetry;

    public Servo pusher;

    public Pusher(HardwareMap hardwareMap) {

        pusher = hardwareMap.get(Servo.class,"pusher");

    }

    public void initialize() {
    }

    public void push1() {

        pusher.setPosition(0);

    }

    public void push2() {

        pusher.setPosition(0);

    }

    public void push3() {

        pusher.setPosition(0);

    }

    public void pushReturn() {

        pusher.setPosition(0);

    }

    public void pushUp() {

        pusher.setPosition(pusher.getPosition() +0.001);

    }

    public void pushDown() {

        pusher.setPosition(pusher.getPosition() -0.001);

    }
}
