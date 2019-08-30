//Bubble tea ordering system.
//Global variables, so the various functions below
//can cooperate together.
var toppingArray; //Array of toppings to keep track of toppings
var toppingSelect; //The topping element
var toppingList; //The output for the topping list
var teaSelect; //the tea selection dropdown box
var costOutput; //The element where we will display the cost.
var milkSelect;



//The setup function, sets all the initial values of the
//global variables. It is called when the onload event
//occurs, because we specified the onload attribute in
//HTML.
function setup() {
    "use strict";
    toppingArray = []; //reset toppings

    toppingSelect = document.getElementById("toppingSelect");
    toppingList = document.getElementById("toppingList");
    teaSelect = document.getElementById("teaSelect");
    costOutput = document.getElementById("output");
    milkSelect = document.getElementById("milk");

    document.getElementById("add").onclick = addTopping;
    document.getElementById("remove").onclick = removeTopping;
    document.getElementById("calculate").onclick = calc;
}
setup();

//updateToppings: Helper function
//used to loop through the topping array to generate a string
//that lists all the toppings.
//It then sets the string to the innerHTML of the toppingList
//element, so the user can see it.
function updateToppings() {
    "use strict";
    var toppingString = "<ul>";
    var i;
    for (i = 0; i < toppingArray.length; i = i + 1) {
        toppingString = toppingString + "<li>" + toppingArray[i] + "</li>";
    }

    toppingString = toppingString + "</ul>";
    toppingList.innerHTML = toppingString;
}

//addTopping: Event Listener
//responds to the add Topping button.
//Checks if the topping is in the list
//add to the list if the topping is not in the
//list and then update the webpage use updateToppings
function addTopping() {
    "use strict";
    var toppingValue = toppingSelect.value;

    if (toppingArray.indexOf(toppingValue) === -1) {
        toppingArray.push(toppingValue);
    }
    updateToppings();
}
//removeTopping: Event Listener
//If the list is not empty, removes the last item from thelist
//them updates the page using the updateToppings helper
function removeTopping(event) {
    "use strict";
    if (toppingArray.length !== 0) {
        toppingArray.pop();

    }
    updateToppings();
}

//calc: calculates the price of the order
//1. retrieves the teaType from the page and find the based cost
//2. loop through the toppingArray to add any additional cost
//3. Add the cost of milk.
//*Note: We can do the cost calculation in any order.
//4. update the webpage with the total cost.
var drinkArray;

function calc() {
    "use strict";
    var teaType = teaSelect.value;
    var cost = 0;
    var milk = milkSelect.value;

    var i = 0;

    //1. find base cost
    if (teaType === "black") {
        cost = 2.50;
    } else if (teaType === "red") {
        cost = 3.50;
    } else if (teaType === "green") {
        cost = 3.00;
    }

    //2. loop through toppings
    for (i = 0; i < toppingArray.length; i = i + 1) {
        if (toppingArray[i] === "Grass Jelly") {
            cost = cost + 0.5;
        } else if (toppingArray[i] === "Cocunut") {
            cost = cost + 0.75;
        } else if (toppingArray[i] === "Pearls") {
            cost = cost + 0.5;
        } else if (toppingArray[i] === "Mango Stars") {
            cost = cost + 1.00;
        }
    }
    //4. add the cost of milk
    if (milk === "yes") {
        cost = cost + 1.00;
    }
    //4. display cost
    drinkArray = [];

    drinkArray.push = function () {

        Cost: cost;
        Toppings: toppingArray;
        Type: teaType;

    }
    

    output.innerHTML = "Total Cost $" + cost;

    

}

function reset()
{
    document.getElementById("return").reset();

}
function addDrink()
{

}