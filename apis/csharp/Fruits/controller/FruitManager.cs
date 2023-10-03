using System.Text.Json;
using Fruits.model;

namespace Fruits.controller;

public static class FruitManager
{
    public static Fruit GetFruitByName(string name)
    {
        var fruit = GetFruits().FirstOrDefault(f => f.Name == name) ?? null;
        if (fruit == null)
        {
            throw new InvalidOperationException("fruit not found");
        }

        return fruit;
    }

    public static Fruit[] GetFruits()
    {
        return new[]
        {
            new Fruit("Apple", "Red"),
            new Fruit("Banana", "Yellow"),
            new Fruit("Orange", "Orange"),
            new Fruit("Grapes", "Purple")
        };
    }
}