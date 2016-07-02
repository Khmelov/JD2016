package by.it.sinkevich.jd01_13.TaskC;

/**
 * @author Sinkevich Denis
 */
class AudioPlayer extends Player {

    private IElectronic connectedDevice;
    private boolean internetConnectionState;

    public AudioPlayer() {

    }

    AudioPlayer(String name) {
        super(name);
    }

    @Override
    public boolean connectToOtherDevice(IElectronic device) {
        if (isTurnedOn()) {
            connectedDevice = device;
            System.out.println("AudioPlayer is connected to " + device);
            return true;
        } else {
            System.out.println("AudioPlayer is off! Could not connect!");
        }
        return false;
    }

    @Override
    public void connectToInternet() {
        if (isTurnedOn() && !internetConnectionState) {
            internetConnectionState = true;
            System.out.println("AudioPlayer connected to internet!");
        } else if (!isTurnedOn()) {
            System.out.println("AudioPlayer is off!");
        }
    }

    public IElectronic getConnectedDevice() {
        return connectedDevice;
    }

    public void setConnectedDevice(IElectronic connectedDevice) {
        this.connectedDevice = connectedDevice;
    }

    public boolean isInternetConnectionState() {
        return internetConnectionState;
    }

    public void setInternetConnectionState(boolean internetConnectionState) {
        this.internetConnectionState = internetConnectionState;
    }

    @Override
    public String toString() {
        return "AudioPlayer: " + getName();
    }
}