package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="OdometryIsScary", group="TeleOp")
public class odometryisscary extends OpMode {
    // Declare variables
    DcMotor lbMotor, rbMotor, lfMotor, rfMotor;
    float speedreducer = 0.5F;

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
    private void initDrive{
        //reverse motors
        lbMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    private void driveRobot{
        //main run method
        //begin standard drive
        double drive = -gamepad1.left_stick_y * speedreducer;
        double strafe = gamepad1.left_stick_x * speedreducer;
        double rotate = gamepad1.right_stick_x * speedreducer;

        //VIOLENT Mode
        if(gamepad1.left_bumper){
            speedreducer = 1F; //remove limiter
        }
        else{
            speedreducer = 0.5F; //relimit
        }

        double lfPower = drive + strafe + rotate;
        double rfPower = drive - strafe - rotate;
        double lbPower = drive - strafe + rotate;
        double rbPower = drive + strafe - rotate;\
        //end standard drive
    }
    private  void stopDriveMotors{
        //stop motors

    }
}
