package com.example.saberdynamicshacc2024_hkmenergyusagedisplay;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // initialize global variables
    public static TextView tvMoney;
    public static TextView tvEnergy;
    public static double totalEnergyPerSec;
    public static double totalMoneyPerSec;

    // initialize appliance objects
    public final static appliance ceilingFan = new appliance();
    public final static appliance airConditioner = new appliance();
    public final static appliance washerDryer = new appliance();
    public final static appliance refrigerator = new appliance();
    public final static appliance oven = new appliance();
    public final static appliance tv = new appliance();
    public final static appliance porchLights = new appliance();
    public final static appliance ceilingLights = new appliance();

    // set appliance on/off state to a variable (on == true, off == false)
    boolean ceilingFanState = false;
    boolean airConditionerState = false;
    boolean washerDryerState = false;
    boolean refrigeratorState = false;
    boolean ovenState = false;
    boolean tvState = false;
    boolean porchLightsState = false;
    boolean ceilingLightsState = false;



    int ceilingLightOff;
    int airConditionerOff;
    int washerDryerOff;
    int refrigeratorOff;
    int ovenOff;
    int tvOff;
    int porchLightsOff;
    int ceilingFanOff;

    int ceilingLightOn;
    int airConditionerOn;
    int washerDryerOn;
    int refrigeratorOn;
    int ovenOn;
    int tvOn;
    int porchLightsOn;
    int ceilingFanOn;

    ImageButton ceilingFanButton;
    ImageButton airConditionerButton;
    ImageButton washerDryerButton;
    ImageButton refrigeratorButton;
    ImageButton ovenButton;
    ImageButton tvButton;
    ImageButton porchLightsButton;
    ImageButton ceilingLightButton;

    public static Drawable green;
    public static Drawable yellowGreen;
    public static Drawable yellow;
    public static Drawable orange;
    public static Drawable red;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvButton), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        // set text views
        tvMoney = (TextView)findViewById(R.id.tvMoney);
        tvEnergy = (TextView)findViewById(R.id.tvEnergy);


        // set each button to a variable
        ceilingFanButton = findViewById(R.id.ceilingLightButton);
        airConditionerButton = findViewById(R.id.acButton);
        washerDryerButton = findViewById(R.id.washerDryerButton);
        refrigeratorButton = findViewById(R.id.refrigeratorButton);
        ovenButton = findViewById(R.id.ovenButton);
        tvButton = findViewById(R.id.tvButton);
        porchLightsButton = findViewById(R.id.porchLightButton);
        ceilingLightButton = findViewById(R.id.ceilingFanButton);


        // set each version (off/on) of an image to a variable
        ceilingLightOff = R.drawable.ceiling_light_off;
        airConditionerOff = R.drawable.ac_off;
        washerDryerOff = R.drawable.washdry_off;
        refrigeratorOff = R.drawable.fridge_off;
        ovenOff = R.drawable.oven_off;
        tvOff = R.drawable.tv_off;
        porchLightsOff = R.drawable.porch_light_off;
        ceilingFanOff = R.drawable.fan_off;

        ceilingLightOn = R.drawable.ceiling_light_on;
        airConditionerOn = R.drawable.ac_on;
        washerDryerOn = R.drawable.washer_dryer_on;
        refrigeratorOn = R.drawable.refrigerator_on;
        ovenOn = R.drawable.oven_on;
        tvOn = R.drawable.tv_on;
        porchLightsOn = R.drawable.porch_light_on;
        ceilingFanOn = R.drawable.ceiling_fan_on;


        // set colors to a variable
        green = getDrawable(R.drawable.green);
        yellowGreen = getDrawable(R.drawable.yello_green);
        yellow = getDrawable(R.drawable.yellow);
        orange = getDrawable(R.drawable.orange);
        red = getDrawable(R.drawable.red);


        // ON BUTTON CLICK --> DO SOMETHING
        // TODO change the money and energy values to the actual values
        ceilingFanButton.setOnClickListener( v -> { // when you click the specific appliances button, do the following
            enableDisableProcess(ceilingFanState, ceilingFan, 1, 2, ceilingFanButton, ceilingFanOff, ceilingFanOn); // enable/disable the appliance (adds/subtracts from the _PerSecond values
            ceilingFanState = !ceilingFanState; // changes the on/off state boolean for the appliance

        });
        airConditionerButton.setOnClickListener( v -> {
            enableDisableProcess(airConditionerState, airConditioner, 3, 4, airConditionerButton, airConditionerOff, airConditionerOn);
            airConditionerState = !airConditionerState;
        });
        washerDryerButton.setOnClickListener( v -> {
            enableDisableProcess(washerDryerState, washerDryer, 5, 6, washerDryerButton, washerDryerOff, washerDryerOn);
            washerDryerState = !washerDryerState;
        });
        refrigeratorButton.setOnClickListener( v -> {
            enableDisableProcess(refrigeratorState, refrigerator, 7, 8, refrigeratorButton, refrigeratorOff, refrigeratorOn);
            refrigeratorState = !refrigeratorState;
        });
        ovenButton.setOnClickListener( v -> {
            enableDisableProcess(ovenState, oven, 9, 10, ovenButton, ovenOff, ovenOn);
            ovenState = !ovenState;
        });
        tvButton.setOnClickListener( v -> {
            enableDisableProcess(tvState, tv, 11, 12, tvButton, tvOff, tvOn);
            tvState = !tvState;
        });
        porchLightsButton.setOnClickListener( v -> {
            enableDisableProcess(porchLightsState, porchLights, 13, 14, porchLightsButton, porchLightsOff, porchLightsOn);
            porchLightsState = !porchLightsState;
        });
        ceilingLightButton.setOnClickListener( v -> {
            enableDisableProcess(ceilingLightsState, ceilingLights, 15, 16, ceilingLightButton, ceilingLightOff, ceilingLightOn);
            ceilingLightsState = !ceilingLightsState;
        });







    } // end of main



    // enable/disable appliance
    public static void enableDisableProcess(boolean s, appliance a, double m, double e, ImageButton b, int imageOff, int imageOn) {
        if (!s) {
            a.applianceOn(m, e); // when you turn on an appliance, add to the money and energy values
//            s = true;

            b.setImageResource(imageOn);

        }
        if (s) {
            a.applianceOff(m, e); // when you turn off an appliance, subtract from the money and energy values
//            s = false;
            b.setImageResource(imageOff);
        }



        // adds up the total energy and money per second from each appliances
        totalEnergyPerSec = ceilingFan.energyPerSec + airConditioner.energyPerSec + washerDryer.energyPerSec + refrigerator.energyPerSec +
                oven.energyPerSec + tv.energyPerSec + porchLights.energyPerSec + ceilingLights.energyPerSec;
        totalMoneyPerSec = ceilingFan.moneyPerSec + airConditioner.moneyPerSec + washerDryer.moneyPerSec + refrigerator.moneyPerSec +
                oven.moneyPerSec + tv.moneyPerSec + porchLights.moneyPerSec + ceilingLights.moneyPerSec;


        // prints those values
        tvMoney.setText("Money Per Second " + totalMoneyPerSec);
        tvEnergy.setText("Energy Second " + totalEnergyPerSec);

        colorChange(totalEnergyPerSec);
    }

    public static void colorChange(double e) {
        if (e > 40) {
            red.setVisible(true, false);
            Log.d("ColorChange", "e: " + e + ", red visibility: " + red.isVisible());
        } else if (e > 30) {
            orange.setVisible(true, false);
            Log.d("ColorChange", "e: " + e + ", orange visibility: " + orange.isVisible());
        } else if (e > 20) {
            yellow.setVisible(true, false);
            Log.d("ColorChange", "e: " + e + ", yellow visibility: " + yellow.isVisible());
        }else if (e > 10) {
            yellowGreen.setVisible(true, false);
            Log.d("ColorChange", "e: " + e + ", yellow green visibility: " + yellowGreen.isVisible());
        } else {
            red.setVisible(false, false);
            orange.setVisible(false, false);
            yellowGreen.setVisible(false, false);
        }
    }






}