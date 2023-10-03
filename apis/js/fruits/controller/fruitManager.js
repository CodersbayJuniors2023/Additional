import {fruits} from "../model/fruit.js";

export function getFruits() {
    return fruits;
}

export function getFruitByName(name) {
    return fruits.find((fruit) => {
        return fruit.name === name;
    });
}