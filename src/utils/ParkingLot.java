package utils;

import java.util.concurrent.locks.ReentrantLock;

public class ParkingLot {
    private ReentrantLock lock;
    private int availableLargeSpots;
    private int availableSmallSpots;

    private Car[] LargeSpots;
    private Car[] SmallSpots;


    public ParkingLot(int availableLargeSpots, int availableSmallSpots) {
        this.lock = new ReentrantLock();
        this.availableLargeSpots = availableLargeSpots;
        this.availableSmallSpots = availableSmallSpots;
        LargeSpots = new Car[availableLargeSpots];
        SmallSpots = new Car[availableSmallSpots];
    }

    public void parkCar(Car car){
        lock.lock();
        try{
            if (car instanceof LargeCar) {
                if (availableLargeSpots > 0) {

                    System.out.println("大车停车成功！");
                    availableLargeSpots--;
                } else if (availableSmallSpots > 0) {
                    System.out.println("大车位已满，请停到小车位！");
                } else {
                    System.out.println("停车位已满，请等待！");
                }
            } else if (car instanceof SmallCar) {
                if (availableSmallSpots > 0) {
                    System.out.println("小车停车成功！");
                    availableSmallSpots--;
                } else if (availableLargeSpots > 0) {
                    System.out.println("小车位已满，请停到大车位！");
                } else {
                    System.out.println("停车位已满，请等待！");
                }
            }
        }finally {
            lock.unlock();
        }
    }

    //测试类
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5, 10);

        // 模拟停车场停车
        Car largeVehicle = new LargeCar("A72JT");
        Car smallVehicle = new SmallCar("B3433");
        parkingLot.parkCar(largeVehicle);
        parkingLot.parkCar(smallVehicle);
        parkingLot.parkCar(largeVehicle);
        parkingLot.parkCar(smallVehicle);
    }
}

class Car{}
class LargeCar extends Car{
    //车牌号
    public String CarID;

    public LargeCar(String carID) {
        CarID = carID;
    }
}
class SmallCar extends Car{
    //车牌号
    public String CarID;

    public SmallCar(String carID) {
        CarID = carID;
    }
}
