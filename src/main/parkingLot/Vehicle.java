public abstract class Vehicle {
    public abstract VehicleSize getSize();
}
class Car extends Vehicle {
    @Override
    public VehicleSize getSize() {
        return VehicleSize.COMPACT;
    }
}
class Truck extends Vehicle {
    @Override
    public VehicleSize getSize() {
        return VehicleSize.LARGE;
    }
}

