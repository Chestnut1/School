public class Telecomando {
    private static final int CHANNEL_MAX =999;
    private static final int VOLUME_MAX =100;
    private int channel;
    private boolean on;
    private int volume;
    private boolean tvPower;

    public Telecomando() {
        channel = 1;
        on = false;
        volume = 10;
    }

    public int getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isOn() {
        return on;
    }

    public void setChannel(int channel) {

        if(on && channel<=CHANNEL_MAX){
            this.channel = channel;
        }else{
            this.channel = this.channel;
        }
    }

    public void setVolume(int volume) {
        if(on && volume<=VOLUME_MAX){
            this.volume = volume;
        }else{
            this.volume = this.volume;
        }
    }

    public void setOn() {
        on = !on;
    }

    public void incChannel(){
        this.channel = (this.channel<CHANNEL_MAX-1) ? this.channel++ : this.channel;
    }

    public void IncVolume(){
        this.volume = (this.volume<VOLUME_MAX-1) ? this.volume++ : this.volume;
    }

    @Override
    public String toString() {
        if(on){
            return "TV-->on " + "channel: " + channel + "volume: " + volume;
        }else{
            return "tv is of";
        }
    }
}
