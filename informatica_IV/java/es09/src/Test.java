public class Test {
    public static void main(String[] args) {
        Telecomando  device = new Telecomando();
        System.out.println(device.toString());
        device.setOn(true);
        System.out.println(device.toString());
        device.setChannel(57);
        System.out.println(device.toString());
        device.setChannel(9999);
        System.out.println(device.toString());
        device.incChannel();
        System.out.println(device.toString());
        device.setVolume(101);
        System.out.println(device.toString());
        device.IncVolume();
        System.out.println(device.toString());
    }
}
