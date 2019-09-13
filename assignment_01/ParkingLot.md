# Design a Parking lot

## Instruction
* The parking lot designed has two entrances and two exits
* The parking fee depends on the parking time
* The parking lot has a maximum capability of parking. If no spaces left, the entrances are closed.

## Classes
```
// A car
Car {
    // License number of the car
    lid,
    goAway() {}
    park() {}
    // Pay the parking fee after parking
    pay(fee) {}
}
// The car in the parking lot
ParkingCar {
    lid, startTime
}
// The entrance of the parking lot
Entrance {
    // Display the remaining space for the parking lot
    message
    // Whether the entrance is open or closed
    statue,
    // park a car
    ParkingCar function pass(Car car) {
        return new ParkingCar(car.lid, Time.now());
    }
}
// The exit of the parking lot
Exit {
    message,
    int function exit() {
        return Time.now();
    }
}
ParkingLot {
    int maximumSpace,
    int availableSpace,
    // Store car parking
    ArrayList<ParkingCar> carsParking,
    // Store entrances
    entrances[],
    // Store exists
    exits[],
    // Check and register entrances
    boolean function registerEntrance(Entrance entrance) {
        boolean ret = false;
        if (entrance is not in entrances) {
            entrances.push(entrance);
            ret = true;
        }
        return ret;
    }
    // Check and register exits
    function registerExit(Exit exit) {
        boolean ret = false;
        if (exit is not in exits) {
            entrances.push(entrance);
            ret = true;
        }
        return ret;
    }
    // To tell the entrance the available seats
    function updateSpaces() {
        for (int i = 0; i < entrances.length; i++) {
            entrances[i].message = availableSpace + " seats available";
            entrances[i].statue = availableSpace > 0 ? "closed" : "open";
        }
    }
    function parkACar(Car car, Entrance entrance) {
        ParkingCar record = entrance.pass(car);
        carsParking.add(record);
        availableSpace = maximumSpace - carsParking.length;
        this.updateSpaces();
    }
    int function exit(Car car, Exit exit) {
        ParkingCar record = findRecordByID(carsParking, car.lid);
        int parkingTime = record.startTime - exit.exit();
        return findCostDependOnTime(parkingTime);
    }
    function leaveACar(Car car) {
        ParkingCar record = findRecordByID(carsParking, car.lid);
        carsParking.remove(record);
        availableSpace = maximumSpace - carsParking.length;
        this.updateSpaces();
    }
    function pay() { }
}
//
```
## Flow
```
void main(String args[]) {
    // Here is a parking lot, with maximun capability of 100 cars. And currently there is no car parking
    ParkingLot parkingLot = new ParkingLot(100, 0, 0);
    parkingLot.updateSpaces();
    // Here are two exits();
    Exit exit1 = new Exit();
    parkingLot.registerExit(exit1);
    Exit exit2 = new Exit();
    parkingLot.registerExit(exit2);
    // Here are two entrances();
    Entrance entrance1 = new Entrance();
    parkingLot.registerEntrance(entrance1);
    Entrance entrance2 = new Entrance();
    parkingLot.registerEntrance(entrance2);
    // tell the entrance current available seats
    parkingLot.updateSpaces();

    //Here comes a car at entrance1 with registration plate "A12345B"
    Car car1 = new Car("A12345B");
    if (entrance1.status == "closed") {
        car1.goAway();
    } else {
        // "park" behavior recorded in the system
        parkingLot.parkACar(car1, entrance1);
        // actual park action
        car1.park();
    }
    // Leaving, when the car is about to exit at exit2
    int fee = parkingLot.exit(car1, exit2);
    // physically pay the fee
    car1.pay(fee);
    // Remove records
    parkingLot.leaveACar(car1);
    // physically exit
    car1.exit();
}
```
