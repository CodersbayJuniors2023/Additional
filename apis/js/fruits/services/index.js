import express from 'express';
import { getFruitByName, getFruits } from "../controller/fruitManager.js";

const app = express();
const port = 3000;

app.get('/', (req, res) => res.send('JS service is up and running!'));

app.get('/fruits', (req, res) => {
    res.setHeader('Content-Type', 'application/json');
    res.status(200).send(getFruits());
});

app.get('/fruit', (req, res) => {
    const name = req.query.name;
    const response = getFruitByName(name);

    if (response == null) {
        res.sendStatus(404);
    } else {
        res.setHeader('Content-Type', 'application/json');
        res.status(200).send(response);
    }
});

app.listen(port, () => {
    console.log(`Fruit service listening on port ${port}`);
});
