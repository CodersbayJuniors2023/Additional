using Fruits.controller;

var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();

app.MapGet("/", () => "Web Service is running");
app.MapGet("/fruits", () => Results.Json(FruitManager.GetFruits()));
app.MapGet("/fruit{name}", (string name) =>
{
    try
    {
        Results.Json(FruitManager.GetFruitByName(name));
    }
    catch (Exception e)
    {
        Results.NotFound("fruit not found");
    }
});

app.Run();