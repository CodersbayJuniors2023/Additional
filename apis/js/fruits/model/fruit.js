// constructor function
function Fruit(name, color) {
    this.name = name;
    this.color = color;
}

// fruit store
export const fruits = [
    new Fruit("Apple", "Red"),
    new Fruit("Banana", "Yellow"),
    new Fruit("Orange", "Orange"),
    new Fruit("Grapes", "Purple")
];