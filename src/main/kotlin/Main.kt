package machine
var water = 400
var milk = 540
var coffeeBeans = 120
var cups = 9
var totalMoney = 550
var exit = 0


class coffeeMachine(var option : String) {
    var userOption =
        when (option) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> information()
            else -> exit = 1
        }
}



fun main(){

    do {
        println("\nWrite action (buy, fill, take, remaining, exit): ")
        var optionMachineCoffee = coffeeMachine(readln())
    } while (exit == 0)

}

fun information(){
    val information = arrayOf("\nThe coffee machine has:", "${water} ml of water", "${milk} ml of milk",
        "${coffeeBeans} g of coffee beans", "${cups} disposable cups", "\$${totalMoney} of money")
    for (i in information){
        println(i)
    }
}

fun buy() {
    println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    val coffeeType = readln()
    if (coffeeType == "back") {
        return
    }else {
        when(coffeeType.toInt()) {
            1 -> if (water >= 250 && coffeeBeans >= 16 && cups >= 1) {
                water -= 250
                coffeeBeans -= 16
                totalMoney += 4
                cups--;
                println("I have enough resources, making you a coffee!")
            } else {
                faults()
            }
            2 -> {
                if(water >= 350 && milk >= 75 && coffeeBeans >= 20 && cups >= 1) {
                    water -= 350
                    milk -= 75
                    coffeeBeans -= 20
                    cups--
                    totalMoney += 7
                    println("I have enough resources, making you a coffee!")
                } else {
                    faults()
                }
            }
            else -> {
                if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && cups >= 1) {
                    water -= 200
                    milk -= 100
                    coffeeBeans -= 12
                    cups--
                    totalMoney += 6
                    println("I have enough resources, making you a coffee!")
                } else {
                    faults()
                }
            }
        }
    }
}

fun fill() {
    println("\nWrite how many ml of water you want to add:")
    water += readln().toInt()
    println("Write how many ml of milk you want to add:")
    milk += readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    coffeeBeans += readln().toInt()
    println("Write how many disposable cups you want to add:")
    cups += readln().toInt()
}

fun take() {
    println("\nI gave you \$${totalMoney}")
    totalMoney = 0
}
fun faults () {
    if (water <= 350 ) println("Sorry, not enough water!") else if (milk< 75 )
        println("Sorry, not enough milk!") else if (cups == 0) println("Sorry, not enough cups!")
    else if (coffeeBeans < 20 ) println("Sorry, not enough cofee beans!")
}