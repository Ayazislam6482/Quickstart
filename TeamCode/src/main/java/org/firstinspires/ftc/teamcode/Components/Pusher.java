package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Pusher {

    public Servo pusher;

    // Position constants - adjust these for your robot
    private final double PUSH_UP_POS = 1.0;     // Fully up position (right bumper)
    private final double PUSH_DOWN_POS = -2.0;   // Fully down position (left bumper)

    // Current position state
    private double currentPosition;

    // Button state tracking for edge detection
    private boolean lastR1State = false;
    private boolean lastL1State = false;

    // Track which position we're in
    private enum PusherState {
        UP,
        DOWN
    }

    private PusherState currentState = PusherState.DOWN;

    public Pusher(HardwareMap hardwareMap) {
        pusher = hardwareMap.get(Servo.class, "pusher");
    }

    public void initialize() {
        // Start at middle position (can be a default state or middle of range)
        currentPosition = -2.0;  // Midpoint value (change if desired)
        currentState = PusherState.DOWN;
        pusher.setPosition(currentPosition);
    }

    /**
     * Update method to be called in OpMode loop
     * R1 (right_bumper) moves the pusher all the way up
     * L1 (left_bumper) moves the pusher all the way down
     */
    public void update(Gamepad gamepad) {
        boolean r1Pressed = gamepad.right_bumper;
        boolean l1Pressed = gamepad.left_bumper;

        // R1 rising edge detection - move to UP position
        if (r1Pressed && !lastR1State) {
            pushUp(); // Move to UP position
        }

        // L1 rising edge detection - move to DOWN position
        if (l1Pressed && !lastL1State) {
            pushDown(); // Move to DOWN position
        }

        // Update button states for next loop
        lastR1State = r1Pressed;
        lastL1State = l1Pressed;
    }

    // Move to fully up position (right bumper)
    public void pushUp() {
        currentPosition = PUSH_UP_POS;
        currentState = PusherState.UP;
        pusher.setPosition(currentPosition);
    }

    // Move to fully down position (left bumper)
    public void pushDown() {
        currentPosition = PUSH_DOWN_POS;
        currentState = PusherState.DOWN;
        pusher.setPosition(currentPosition);
    }

    // Get current position for telemetry
    public double getCurrentPosition() {
        return currentPosition;
    }

    // Get current state as string for telemetry
    public String getStateString() {
        switch (currentState) {
            case UP:
                return "UP (R1)";
            case DOWN:
                return "DOWN (L1)";
            default:
                return "UNKNOWN";
        }
    }

    // Get the servo object directly if needed
    public Servo getServo() {
        return pusher;
    }
}
