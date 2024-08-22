// snake game

const express = require('express');
const http = require('http');
const socketIO = require('socket.io');

const app = express();

const server = http.createServer(app);

const io = socketIO(server);

app.use(express.static('public'));

const port = process.env.PORT || 3000;

let snake = [{ x: 100, y: 100 }];

let food = { x: 300, y: 300 };

let direction = 'right';

let intervalId;

io.on('connection', (socket) => {
    console.log('User connected');
    socket.emit('snake', snake);
    socket.emit('food', food);
    socket.on('movement', (data) => {
        direction = data;
    });
    socket.on('disconnect', () => {
        console.log('User disconnected');
    });
    generateFood();
    intervalId = setInterval(moveSnake, 100);
    snakeEatsFood();
    checkCollision();
    setTimeout(() => {
        clearInterval(intervalId);
        console.log('Game over');
        io.emit('gameOver');
    }, 5000);
    function moveSnake() {
        const head = snake[0];
        let newHead;
        switch (direction) {
            case 'up':
                newHead = { x: head.x, y: head.y - 20 };
                break;
            case 'down':
                newHead = { x: head.x, y: head.y + 20 };
                break;
            case 'left':
                newHead = { x: head.x - 20, y: head.y };
                break;
            case 'right':
                newHead = { x: head.x + 20, y: head.y };
                break;
        }
        if (
            newHead.x < 0 ||
            newHead.x > 600 ||
            newHead.y < 0 ||
            newHead.y > 600 ||
            snake.some((part) => part.x === newHead.x && part.y ===
                newHead.y)
        ) {
            clearInterval(intervalId);
            console.log('Game over');
            io.emit('gameOver');
        } else {
            snake.unshift(newHead);
            const last = snake.pop();
            if (last.x === food.x && last.y === food.y) {
                generateFood();
            } else {
                io.emit('clearTail', last);
            }
            io.emit('snake', snake);
        }
        snakeEatsFood();
        checkCollision();
        function snakeEatsFood() {
            if (snake[0].x === food.x && snake[0].y === food.y) {
                generateFood();
            }
        }
        function generateFood() {
            food = {
                x: Math.floor(Math.random() * 30) * 20,
                y: Math.floor(Math.random() * 30) * 20
            };
            io.emit('food', food);
        }
        function checkCollision() {
            const head = snake[0];
            for (let i = 1; i < snake.length; i++) {
                if (head.x === snake[i].x && head.y === snake[i].y) {
                    clearInterval(intervalId);
                    console.log('Game over');
                    io.emit('gameOver');
                }
            }
        }
        function moveSnake() {
            const head = snake[0];
            let newHead;
            switch (direction) {
                case 'up':
                    newHead = { x: head.x, y: head.y - 20 };
                    break;
                case 'down':
                    newHead = { x: head.x, y: head.y + 20 };
                    break;
                case 'left':
                    newHead = { x: head.x - 20, y: head.y };
                    break;
                case 'right':
                    newHead = { x: head.x + 20, y: head.y };
                    break;
            }
            if (
                newHead.x < 0 ||
                newHead.x > 600 ||
                newHead.y < 0 ||
                newHead.y > 600 ||
                snake.some((part) => part.x === newHead.x && part.y ===
                    newHead.y)
            ) {
                clearInterval(intervalId);
                console.log('Game over');
                io.emit('gameOver');
            } else {
                snake.unshift(newHead);
                const last = snake.pop();
                if (last.x === food.x && last.y === food.y) {
                    generateFood();
                } else {
                    io.emit('clearTail', last);
                }
                io.emit('snake', snake);
            }
            snakeEatsFood();
            checkCollision();
            function snakeEatsFood() {
                if (snake[0].x === food.x && snake[0].y === food.y) {
                    generateFood();
                }
            }
            function generateFood() {
                food = {
                    x: Math.floor(Math.random() * 30) * 20,
                    y: Math.floor(Math.random() * 30) * 20
                };
                io.emit('food', food);
            }
            function checkCollision() {
                const head = snake[0];
                for (let i = 1; i < snake.length; i++) {
                    if (head.x === snake[i].x && head.y === snake[i].y) {
                        clearInterval(intervalId);
                        console.log('Game over');
                        io.emit('gameOver');
                    }
                }
            }
            function moveSnake() {
                const head = snake[0];
                let newHead;
                switch (direction) {
                    case 'up':
                        newHead = { x: head.x, y: head.y - 20 };
                        break;
                    case 'down':
                        newHead = { x: head.x, y: head.y + 20 };
                        break;
                    case 'left':
                        newHead = { x: head.x - 20, y: head.y };
                        break;
                    case 'right':
                        newHead = { x: head.x + 20, y: head.y };
                        break;
                }
                if (
                    newHead.x < 0 ||
                    newHead.x > 600 ||
                    newHead.y < 0 ||
                    newHead.y > 600 ||
                    snake.some((part) => part.x === newHead.x && part.y ===
                        newHead.y)
                ) {
                    clearInterval(intervalId);
                    console.log('Game over');
                    io.emit('gameOver');
                } else {
                    snake.unshift(newHead);
                    const last = snake.pop();
                    if (last.x === food.x && last.y === food.y) {
                        generateFood();
                    } else {
                        io.emit('clearTail', last);
                    }
                    io.emit('snake', snake);
                }
                snakeEatsFood();
            }
            checkCollision();
            function snakeEatsFood() {
                if (snake[0].x === food.x && snake[0].y === food.y) {
                    generateFood();
                }
            }
            function generateFood() {
                food = {
                    x: Math.floor(Math.random() * 30) * 20,
                    y: Math.floor(Math.random() * 30) * 20
                };
                io.emit('food', food);
            }
            function checkCollision() {
                const head = snake[0];
                for (let i = 1; i < snake.length; i++) {
                    if (head.x === snake[i].x && head.y === snake[i].y) {
                        clearInterval(intervalId);
                        console.log('Game over');
                        io.emit('gameOver');
                    }
                }
            }
            function moveSnake() {
                const head = snake[0];
                let newHead;
                switch (direction) {
                    case 'up':
                        newHead = { x: head.x, y: head.y - 20 };
                        break;
                    case 'down':
                        newHead = { x: head.x, y: head.y + 20 };
                        break;
                    case 'left':
                        newHead = { x: head.x - 20, y: head.y };
                        break;
                    case 'right':
                        newHead = { x: head.x + 20, y: head.y };
                        break;
                }
                if (
                    newHead.x < 0 ||
                    newHead.x > 600 ||
                    newHead.y < 0 ||
                    newHead.y > 600 ||
                    snake.some((part) => part.x === newHead.x && part.y ===
                        newHead.y)
                ) {
                    clearInterval(intervalId);
                    console.log('Game over');
                    io.emit('gameOver');
                } else {
                    snake.unshift(newHead);
                    const last = snake.pop();
                    if (last.x === food.x && last.y === food.y) {
                        generateFood();
                    } else {
                        io.emit('clearTail', last);
                    }
                    io.emit('snake', snake);
                }
                snakeEatsFood();
            }
        }
    }
}

