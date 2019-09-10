# Traffic Controller System for a Junction
## Instruction
* When a person is at the junction, he/she looks at the traffic light to decide to go or to stop.
* When a car is at the junction, the driver looks at the traffic light to decide to turn right, go straight ahead or turn left.
* In following design, a person or a car interact with other person/cars is not considered.
* In following design, consider 4 way intersections only.
* In following design, time unit is second.

## Classes
```
enum TrafficLightStatus {
    ON,
    OFF,
    FLASH
}
enum TrafficLightType {
    NORMAL,
    LEFTTURN,
    WALK
}
// TrafficLight, it will display differently upon different time
Class TrafficLight {
    TrafficLightType type;
    TrafficLightStatus status
    int offBegin;
    int offEnd;
    int onBegin;
    int onEnd;
    int flashBegin;
    int flashEnd;

    void TrafficLight(TrafficLightType type, int offBegin, int offEnd, int onBegin, int onEnd, int flashBegin, int flashEnd) {
        this.type = type;
        this.offBegin = offBegin;
        this.offEnd = offEnd;
        this.onBegin = onBegin;
        this.onEnd = onEnd;
        this.flashBegin = flashBegin;
        this.flashEnd = flashEnd;
    }

    /*
    * To get the current status of this traffic light
    * @param time Tell the time
    * @return TrafficLightStatus Current light status
    */
    TrafficLightStatus function getStatus(int time) {
        if (time >= onBegin && time < onEnd) {
            this.status = TrafficLightStatus.ON;
        } else if (time >= flashBegin && time < flashEnd){
            this.status = TrafficLightStatus.FLASH;
        } else {
            this.status = TrafficLightStatus.OFF;
        }
        return this.status;
    }
}
// There will be about four walk lights and two sets of car lights on each road in the real world. Simplify the situation to one sets of lights on each road.
Class Road {
    TrafficLight normalLight;
    TrafficLight leftTurnLight;
    TrafficLight walkLight;

    void Road(TrafficLight normalLight, TrafficLight leftTurnLight, TrafficLight walkLight) {
        this.normalLight = normalLight;
        this.leftTurnLight = leftTurnLight;
        this.walkLight = walkLight;
    }
    /*
    * To check whether can go or not
    * @param time Tell the time
    * @return boolean Can go or not
    */
    boolean function canWalk(int time) = {
        return walkLight && walkLight.getStatus(time) == TrafficLightStatus.ON
    }
    boolean function canCarGo(int time) = {
        return normal && normal.getStatus(time) == TrafficLightStatus.ON
    }
    boolean function canCarTurnLeft(int time) = {
        return leftTurnLight && leftTurnLight.getStatus(time) == TrafficLightStatus.ON
    }
}
// A timer. Once started, it will go on counting.
Class Timer {
    int maxTime;
    int current;

    void Timer(int maxTime) {
        this.current = 0;
        this.maxTime = maxTime;
    }
    /*
    * To start a timer
    * @param maxTime If reach the maxTime, reset it to zero
    * @return void
    */
    void function start() {
        //do some kind of loop, and record the loop
        (.......) {
            this.current ++;
            if (this.current++ >= maxTime) {
                this.current = 0;
            }
        }
    }
    /*
    * To start a timer
    * @param maxTime If reach the maxTime, reset it to zero
    * @return void
    */
    void function stop() {
        // stop the recorded loop
        ....stop
        this.current = 0;
    }
    /*
    * To define the cycle time and run the timer
    * @param cycleTime The lifetime for each cycle
    * @return void
    */
    int function tellNow() {
        return this.current;
    }
}
// A "stone" represents a car or a person.
emun stoneType = {
    CAR,
    PERSON
}
emun stonePurpose = {
    STRAIGHT,
    TURNLEFT
}
Class Stone {
    stoneType type;
    stonePurpose purpose;

    stoneType function getType() {
        return this.type;
    }
    stonePurpose function getPurpose() {
        return this.purpose;
    }

    void Stone(stoneType type, stonePurpose purpose) {
        this.type = type;
        this.purpose = purpose;
    }
    /*
    * Actions
    * @return void
    */
    void function go() {
        //to go
    }
    void function turnLeft() {
        //to turnLeft
    }
    void function stop() {
        //to stop
    }
}
// Core of the system
Class CentralControlSystem {
    Road roads[];
    Timer timer;
    /*
    * To define the cycle time and run the timer
    * @param cycleTime The lifetime for each cycle
    * @return void
    */
    void function Run(cycleTime) {
        this.timer = new Timer(cycleTime);
        timer.start();
    }
    /*
    * To register the roads
    * @param road Add road to the system
    * @return boolean Whether the road is registered successfully
    */
    boolean function RegisterRoads(road) {
        //check whether there is conflict with this new road
        if(check(road)) {
            //check pass
            //record the road
            roads.push(road);
            //register successfully
            return true;
        } else {
            return false;
        };
    }
    /*
    * Whether a stone can go or not
    * @param stone A stone want to go or turn left
    * @param road The specific road
    * @return boolean Go or not go
    */
    boolean canGo(Stone stone, Road road) {
        int now = timer.tellNow();
        boolean ret = false;
        // Wrong way!
        if (road not in roads) {
            return ret;
        }
        if (stone.stoneType == stoneType.CAR) {
            if (stone.stonePurpose)
        } else if (stone.stoneType == stoneType.PERSON) {
            //
            ret = road.canWalk(now);
        }
    }
}
```
## Flow
```
void main(String args[]) {
    CentralControlSystem system = new CentralControlSystem();

    // some magic numbers here, should be defined
    // new three traffic lights
    TrafficLight lightLeft1 = new TrafficLight(TrafficLightType.LEFTTURN, 0, 60, 60, 70, 70, 75);
    TrafficLight lightNormal1 = new TrafficLight(TrafficLightType.NORMAL, 0, 75, 75, 115, 115, 120);
    TrafficLight lightWalk1 = new TrafficLight(TrafficLightType.WALK, 0, 75, 75, 110, 110, 115);
    // new a road. Add lights above to this road
    Road r1 = new Road(lightNormal1, lightLeft1, lightWalk1);

    // new another three traffic lights
    TrafficLight lightLeft2 = new TrafficLight(TrafficLightType.LEFTTURN, 0, 0, 0, 5, 5, 10);
    TrafficLight lightNormal2 = new TrafficLight(TrafficLightType.NORMAL, 0, 10, 10, 55, 55, 60);
    TrafficLight lightWalk2 = new TrafficLight(TrafficLightType.WALK, 0, 10, 10, 50, 50, 55);

    // new a road. Add lights above to this road
    Road r2 = new Road(lightNormal2, lightLeft2, lightWalk2);

    if (!system.RegisterRoads(r1)) {
        //Error!
    }
    if (!system.RegisterRoads(r2)) {
        //Error!
    }
    //No errors
    system.run();

    //A person want to go straight at r1
    Stone s1 = new Stone(stoneType.PERSON, stonePurpose.STRAIGHT);
    if (system.canGo(s1, r1)) {
        stone.go();
    } else {
        stone.stop();
    }
    //A car want to turn left
    Stone s2 = new Stone(stoneType.CAR, stonePurpose.TURNLEFT);
    if (system.canGo(s2)) {
        stone.turnLeft();
    } else {
        stone.stop();
    }
}
```
