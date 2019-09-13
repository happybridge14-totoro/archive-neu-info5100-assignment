# VenderMachine

## Instruction
* The vender machine accepts all six kinds of coins (two dollar coin is not considered)
* The vender machine will return four kind of coins if the user is over-paid
* The input coins and out coins are stored in two separate places
* The vender machine will provide different kind of goods
* The unit of the the codes below is cent

## Classes
```
Class Coin {
    name,
    value
}
Class goods {
    name,
    price
}

Class VenderMachine {
    message = "Available";

    Coin penny = new Coin("penny", 1);
    Coin nickel = new Coin("nickel", 5);
    Coin dime = new Coin("dime", 10);
    Coin quarter = new Coin("quarter", 25);
    Coin halfDollar = new Coin("halfDollar", 50);
    Coin oneDollar = new Coin("oneDollar", 100);
    HashMap<String, int> coinsLeft = new HashMap<String, int>;
    coinsLeft.put("penny", 100);
    coinsLeft.put("nickel", 100);
    coinsLeft.put("dime", 100);
    coinsLeft.put("quarter", 100);
    Goods cola = new Goods("cola", 0.99);
    Goods gatorate = new Goods("gatorate", 1.99);
    Goods dove = new Goods("dove", 0.99);
    Goods perrier = new Goods("perrier", 2.99);
    HashMap<String, int> goodsLeft = new HashMap<String, int>;
    goodsLeft.put("cola", 100);
    goodsLeft.put("gatorate", 100);
    goodsLeft.put("dove", 100);
    goodsLeft.put("perrier", 100);

    Good targetGood,
    int acceptsValue,

    function setAvailable () {
        message = "Available";
        targetGood = "";
        acceptsValue = 0;
    }
    function clickStart() {
        message = "Please choose your good";
    }
    function choose(targetName) {
        targetGood = findGoodbyName(targetName);
        int targetLeft = findQuantitybyName(targetName);
        if (targetLeft <= 0) {
            message = "Sold out. Please choose another good";
            //wait for 5s
            ......
            setAvailable();
        } else {
            message = "pay " + targetGood.value/100 + "." +  targetGood.value%100 + "$ more";
        }
    }
    function insertCoin(Coin coin) {
        acceptsValue+= coin.value;
        int needToPay = targetGood.value - acceptsValue;
        if (needToPay > 0) {
            message = "pay " + needToPay/100 + "." +  needToPay%100 + "$ more";
        } else if (needToPay == 0) {
            //deal accepts
            message = "Wait";
            //deliver good
            int targetLeft = findQuantitybyName(targetName);
            goodsLeft.set(targetGood.name, targetLeft - 1);
            //deal done
            message = "Done. Please take your good";
            //wait for 5s
            ......
            setAvailable();
        } else {
            //customer overpaids the good and will get change
            message = "Wait";
            //deliver good
            int targetLeft = findQuantitybyName(targetName);
            goodsLeft.set(targetGood.name, targetLeft - 1);
            // give change
            message = "Giving change";
            int change = -needToPay;
            //calculate how many coins need to be returned
            int quarterToReturn = change / 25;
            if (quarterToReturn > findRemainsbyCoinName("quarter")) {
                message = "Not enough change. Please contact our staff for help. XXX-XXX-XXXX";
            }
            change = change % 25;

            int dimToReturn = change / 10;
            if (dimToReturn > findRemainsbyCoinName("dim")) {
                message = "Not enough change. Please contact our staff for help. XXX-XXX-XXXX";
            }
            change = change % 10;

            int nickelToReturn = change / 5;
            if (dimToReturn > findRemainsbyCoinName("nickel")) {
                message = "Not enough change. Please contact our staff for help. XXX-XXX-XXXX";
            }
            change = change % 5;

            int centToReturn = change;
            if (centToReturn > findRemainsbyCoinName("cent")) {
                message = "Not enough change. Please contact our staff for help. XXX-XXX-XXXX";
            }
            // Pay the change
            ......
            message = "Done. Please take your good and change";
            //wait for 10s
            ......
            setAvailable();
        }
    }

}
```

## Flow
```
void main(String args[]) {
    VenderMachine machine1 = new VenderMachine();
    machine1.setAvailable();
    //here come a person and click "start" button
    machine1.clickStart();
    //customer choose good
    machine1.choose("dove");
    //customer insert coins
    machine1.insertCoin(new Coin("penny"));
    machine1.insertCoin(new Coin("quarter"));
    machine1.insertCoin(new Coin("quarter"));
    machine1.insertCoin(new Coin("quarter"));
    //At this time, the customer has paid enough money. He will get the food and the change
    machine1.insertCoin(new Coin("quarter"));
    //Deal done
}
```
