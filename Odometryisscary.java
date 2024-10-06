package org.firstinspires.ftc.teamcode;
import com.google.common.base.Ticker;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.google.common.base.Stopwatch;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name="OdometryIsScary", group="TeleOp")
public class Odometryisscary extends OpMode {
    // Declare variables
    DcMotor lbMotor, rbMotor, lfMotor, rfMotor;
    double speedreducer = 0.5;
    Stopwatch count1 = Stopwatch.createStarted();

    //cavab was here
    @Override
    public void init() {
        // Initialize motors

        initDrive();
    }

    @Override
    public void loop() {
        // Drive section
        driveRobot();

    }

    @Override
    public void stop() {
        // Stop the robot drive
        stopDriveMotors();
    }
    private void initDrive(){
        //reverse motors

    }
    // I love java!


    private void driveRobot(){

        //main run method
        //begin standard drive
        double drive = -gamepad1.left_stick_y * speedreducer;
        double strafe = gamepad1.left_stick_x * speedreducer;
        double rotate = gamepad1.right_stick_x * speedreducer;

        //VIOLENT Mode
        if(gamepad1.left_bumper){
            speedreducer = 1; //remove limiter
        }
        else{
            speedreducer = 0.5; //relimit
        }

        double lfPower = drive + strafe + rotate;
        double rfPower = drive - strafe - rotate;
        double lbPower = drive - strafe + rotate;
        double rbPower = drive + strafe - rotate;
        //end standard drive
        //that was a lie... maybe ill learn kotlin
        telemetry.addData("Counter1", count1);
    }
    private  void stopDriveMotors(){
        //stop motors

    }
}
