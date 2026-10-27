interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
}

class Radio implements Device {
    int volume = 10;
    public void turnOn() { System.out.println("Radio starts playing static/music."); }
    public void turnOff() { System.out.println("Radio goes silent."); }
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Radio volume knob turned to: " + this.volume);
    }
}

class SmartLight implements Device {
    public void turnOn() {
        System.out.println("Smart Light glows bright white.");
    }
    public void turnOff() {
        System.out.println("Smart Light shuts off.");
    }
    public void setVolume(int level) {
        System.out.println("Smart Light brightness set to: " + level + "%");
    }
}

class BasicRemote {
    protected Device device;
    public BasicRemote(Device device) { this.device = device; }
    public void powerOn() { device.turnOn(); }
    public void powerOff() { device.turnOff(); }
}

class AdvancedRemote extends BasicRemote {
    public AdvancedRemote(Device device) { super(device); }
    public void mute() {
        System.out.println("[Remote] Mute button pressed!");
        device.setVolume(0);
    }
}

class PartyRemote extends BasicRemote {
    public PartyRemote(Device device) {
        super(device);
    }

    public void partyMode() {
        System.out.println("[Party Remote] Pumping up the party!");
        device.turnOn();
        device.setVolume(100);
    }
}

public class Main {
    public static void main(String[] args) {
        Device light = new SmartLight();
        AdvancedRemote remote = new AdvancedRemote(light);
        remote.powerOn();
        remote.mute();

        System.out.println("-----------------");

        Device radio = new Radio();
        PartyRemote partyRemote = new PartyRemote(radio);
        partyRemote.partyMode();
    }
}