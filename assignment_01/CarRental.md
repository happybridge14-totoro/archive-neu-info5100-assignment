# Design a Car Rental System

## Instruction
* The car rental system is designed as a virtual "MV(C)" model system
* This system has a simple entrance which supports both stuff and customer to login
* Stuff can set the car rental status.
* Customer can rent a car or cancel rental.

## Class
```
Class Customer {
    cid, username, encryptedPwd, name, age, phone, email, billingInfo, drivingLicense
}
Class Staff {
    sid, username, encryptedPwd, name, age, phone, email, etc..
}
Class Cars {
    lid, carType, isAvailable
}
Class Order {
    orderId,
    Car car,
    Customer customer,
    startTime,
    expectReturnTime,
    returnTime,
    estimatedCost,
    cost,
    status
}

//The only interface which a person can interact
Class View {
    View logOut() {
        return System.logOut();
    }
}
Class LoginView extends View {
    errorMsg,
    Customer register(username, encryptedPwd, name, age, phone, email) {
        return System.register(...args[]);
    }
    View login(userName, password) {
        return System.login(userName, password);
    }
    View logOut() {
        return System.logOut();
    }
}
Class CustomerView extends View {
    String[] viewInfo() {
        return [name,age,gender,nickname,etc..];
    }
    boolean editInfo(String newInfo[]) {
        return System.updateInfo([name, age, gender, nickname, etc..]);
    }
    String[] viewBillingInfo() {
        return [cardNumber, expireDate, etc..];
    }
    boolean editBillingInfo(cardNumber, expireDate, cvvCode) {
        return System.updateBillingInfo([cardNumber, expireDate, cvvCode, etc..]);
    }
    String[] viewOrderHistory() {
        return [order1, order2, order3, etc..];
    }
    List<Car> searchCars(carType) {
        return system.searchCars(carType);
    }
    Order rentACar(Car car, Customer customer, int startTime, int expectReturnTime) {
        Order order = new Order();
        order.id = System.getOrderID();
        order.car = car;
        order.customer = customer;
        order.status = "waiting for payment";
        order.startTime = startTime;
        order.expectReturnTime = expectReturnTime;
        System.submitOrder(order);
        return order;
    }
    boolean payOrder(Order order) {
        return System.payOrder(order, paymentInfo);
    }
    Order viewCurrentRental() {
        return System.getOrder(customer, "pending");
    }
    boolean cancelRental(Order order) {
        return System.cancelOrder(order);
    }
}
Class StaffView extends View {
    String viewOrders(String searchParam[]) {
        return System.searchOrder(name, phone, email);
    }
    String finishOrder(int orderID) {
        return System.finishOrder(orderID);
    }
    boolean cancelOrder(Order order) {
        return System.cancelOrder(order);
    }
    String viewCustomerInfo(String infoParam[]) {
        return System.searchCustomer(name, phone, email);
    }
    Car addNewCar(lid, type) {
        return System.addNewCar(lid, type);
    }
}
Class System {
    List<Car> cars,
    Order[] orders,
    Staff[] staffs,
    Customer[] customers,
    CustomerView customerView,
    LoginView loginView,
    StaffView staffView,

    Order searchOrder(cid, carType ... ) {
        for (Order i: orders) {
            if (cid != null && i.customer.cid != cid)  {
                continue;
            }
            if (carType != null && i.car.carType != carType)  {
                continue;
            }
            ...
            return i;
        }
    }
    Order searchCustomer(name, phone, email) {
        for (Order i: orders) {
            if (i.name == name && i.phone == phone && i.email == email) {
                return i;
            }
        }
    }
    Boolean cancelOrder(Order order) {
        order.status = "Canceled";
        // In real world, maybe more should be considered
        // If the customer has paid the rent fee in advance before cancelable deadline, payment should be refunded
        return true;
    }
    boolean addNewCar(lid, type) {
        Car newCar = new Car(lid, type, true);
        cars.push(newCar);
        return newCar;
    }
    boolean payOrder(order, paymentInfo) {
        if (isValid(order) || isValid(paymentInfo)) {
            return false;
        }
        if (pay(paymentInfo, order.cost)) {
            order.status = "paid";
            return true;
        };
        return false;
    }
    View login(username, pwd) {
        String encryptedPwd = encrypt(pwd);
        for (Staff i: staffs) {
            if (username == i.username && encryptedPwd == i.encryptedPwd) {
                return staffView;
            }
        }
        for (Customer i: customers) {
            if (username == i.username && encryptedPwd == i.encryptedPwd) {
                return customerView;
            }
        }
        loginView.errorMsg = "username or password error";
        return loginView;
    }
    View register(username, pwd, name, age, phone, email) {
        if (check(username)) {
            String encryptedPwd = encrypt(pwd);
            Customer newCustomer = new Customer(username, encryptedPwd, name, age, phone, email);
            customers.push(newCustomer);
            return customerView;
        } else {
            return loginView;
        }
    }
    Cars[] searchCars(carType) {
        List<Car> cars = new List<Car>;
        for (Car i: cars) {
            if (i.isAvailable && car.carType == carType) {
                cars.add(i);
            }
        }
        return cars;
    }
    boolean submitOrder(order) {
        if (!checkParam(order.orderid)) {
            return false;
        }
        if (!checkParam(order.car.lid)) {
            return false;
        }
        if (!checkParam(order.car.isAvailable)) {
            return false;
        }
        if (!checkParam(order.customer.cid)) {
            return false;
        }
        if (!checkParam(order.startTime)) {
            return false;
        }
        if (!checkParam(order.expectReturnTime)) {
            return false;
        }
        ...
        order.car.status = "occupied";
        return true;
    }
    boolean finishOrder(orderID) {
        Order targetOrder = null;
        for (Order i: orders) {
            if (i.orderID == orderID) {
                targetOrder = i;
            }
        }
        if (i) {
            i.status = "Done";
            return true
        }
        return false;
    }
    LoginView logOut() {
        return loginView;
    }
    ...
}


```

## Flow
```
void main(String args[]) {
    System system = new System();
    //Stuff
    StaffView stuffView = system.loginView.login("stuff_henry", "123");
    //There is a new car here
    Car newCar = new Car("washington AAA-1111", "suv");
    stuffView.addNewCar(newCar);
    stuffView.logOut();

    //New Customer
    CustomerView newCustomerView = system.loginView.register("henry", "123", 99, etc...);
    List<Car> cars= newCustomer.searchCars("suv");
    // If the customer find a idea car
    Car car = cars.get(0);
    Order newOrder = newCustomerView.rentACar(car, newCustomer, "01/10/2019", "01/11/2019");
    newCustomerView.editBillingInfo("11111111", "31/12/2020", "111");
    if (newCustomerView.payOrder(newOrder)) {
        //Success!
    };
    newCustomerView.logOut()

    //Return a car
    //Staff check the car and everything is OK.
    int orderId = 111;
    StaffView stuffView = system.loginView.login("stuff_henry", "123");
    if (stuffView.finishOrder(orderId)) {
        //Deal done!
    }
}
```
