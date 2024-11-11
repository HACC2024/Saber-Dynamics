package com.example.saberdynamicshacc2024_hkmenergyusagedisplay;


// appliance class ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class appliance {
    // initialize  money and energy variables
    public double moneyPerSec = 0;
    public double energyPerSec = 0;

    public double money = 0;
    public double energy = 0;

    // constructer
    public void Appliance() {
    }


    // method to add money/energy when appliance enabled
    public void applianceOn(double m, double e) {
        moneyPerSec += m;
        energyPerSec += e;

        // TODO update visuals
        // this.showEnableVisual
        // this.hideDisableVisual


    }

    // method to subtract money/energy when appliance disabled
    public void applianceOff(double money, double energy) {
        moneyPerSec -= money;
        energyPerSec -= energy;

        // TODO update visuals
        // this.showDisableVisual
        // this.hideEnableVisual

    }


    // end of appliance class
}


