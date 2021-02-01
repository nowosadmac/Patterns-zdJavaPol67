package edu.grcy.patterns.behavioral.state;

public class Flight {
    FlightState state;

    public Flight() {
        if(this.state == null) {
            this.state = Onboarding.getInstance();
        }
    }

    public void setStatus(FlightState state) {
        this.state = state;
    }

    public void update() {
        if (state instanceof Onboarding) {
            System.out.println("Prepare to start. Passengers walk in");
        }
        state.updateState(this);
    }
}
