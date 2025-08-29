package Interfaces;

public class Main {
    public static void main(String[] args) {
        // Car car = new Car();
        // car.accelerate();
        // car.start();
        // car.stop();
        // car.brake();

        // Media carMedia = new Car();
        // carMedia.stop();

        NiceCar car = new NiceCar();
        car.start();
        car.startMusic();
        car.upgradeEngine();
        car.start();
    }
}
