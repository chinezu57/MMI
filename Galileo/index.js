var http = require('http');
var Galileo = require("galileo-io");
var express = require('express');
var app = express();
var server = http.createServer(app);

var board = new Galileo();
var delayTime = 1000;
var targetPin = 9;
var pinToRead = 8;
var pinValue8;
var pin1Mode;

var intervalHandler;
var byte = 0;

var pinMode = {INPUT: 0, OUTPUT: 1};
var digitalPinsModes = [pinMode.INPUT, pinMode.INPUT, pinMode.INPUT, pinMode.INPUT, pinMode.INPUT, pinMode.INPUT, pinMode.OUTPUT, pinMode.OUTPUT, pinMode.OUTPUT, pinMode.OUTPUT, pinMode.OUTPUT, pinMode.OUTPUT];
var digitalPinsValues = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
var analogPinsModes = [pinMode.INPUT, pinMode.INPUT, pinMode.INPUT, pinMode.OUTPUT, pinMode.OUTPUT, pinMode.OUTPUT];

board.on("ready", function () {
    console.log("Ready Function Reached!");
    this.pinMode(2, this.MODES.INPUT);
    this.pinMode(3, this.MODES.INPUT);
    this.pinMode(4, this.MODES.INPUT);
    this.pinMode(5, this.MODES.INPUT);
    this.pinMode(6, this.MODES.INPUT);
    this.pinMode(7, this.MODES.INPUT);
    this.pinMode(8, this.MODES.OUTPUT);
    this.pinMode(9, this.MODES.OUTPUT);
    this.pinMode(10, this.MODES.OUTPUT);
    this.pinMode(11, this.MODES.OUTPUT);
    this.pinMode(12, this.MODES.OUTPUT);
    this.pinMode(13, this.MODES.OUTPUT);
    this.pinMode("A0", this.MODES.INPUT);
    this.pinMode("A1", this.MODES.INPUT);
    this.pinMode("A2", this.MODES.INPUT);
    this.pinMode("A3", this.MODES.OUTPUT);
    this.pinMode("A4", this.MODES.OUTPUT);
    this.pinMode("A5", this.MODES.OUTPUT);
});

app.get('/boss', function (req, res) {
    res.send('hello boss');
});

app.get('/digitalPin/:pinNumber', function (req, res) {
    var pinNumber = req.params.pinNumber;
    if (digitalPinsModes[pinNumber] == pinMode.INPUT) {
        var pinValue = null;
        board.digitalRead(pinNumber, function readHandler(data) {
            pinValue = data;
        });
        setTimeout(function () {
            res.send('Pin ' + pinNumber + ' value is: ' + pinValue);
        }, 100);
    }
    else {
        res.send('Pin ' + pinNumber + ' is not set in input mode');
    }
});

app.get('/digitalPin/:pinNumber/toggle', function (req, res) {
    var pinNumber = req.params.pinNumber;
    var value = req.params.value;
    board.digitalWrite(pinNumber, (digitalPinsValues[pinNumber] ^= 1));
    res.send('Pin value toggled');
});

app.get('/analogPin/:pinNumber', function(req, res){
    var pinNumber = req.params.pinNumber;
    if (analogPinsModes[pinNumber] == pinMode.INPUT) {
        var pinValue = null;
        board.analogRead("A"+pinNumber, function readHandler(data) {
            pinValue = data;
        });
        setTimeout(function () {
            res.send('Pin ' + "A" +pinNumber + ' value is: ' + pinValue);
        }, 100);
    }
    else {
        res.send('Pin ' + "A" + pinNumber + ' is not set in input mode');
    }
});

app.get('/analogPin/:pinNumber/:value', function(req, res){
    var pinNumber = req.params.pinNumber;
    var value = req.params.value;
    board.digitalWrite(pinNumber, value);
    res.send('Pin value changed');
});

server.listen(3000);
console.log('Server running at http://192.168.137.17:3000');
