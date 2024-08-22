const express = require('express');
const path = require('path');
const fs = require('fs');
const app = express();
const port = 3000;


app.use(express.static(path.join(__dirname, 'public')));

app.get('/about', (req, res) => {
    fs.readFile(path.join(__dirname, 'public', 'about.txt'), 'utf8', (err, data) => {
        if (err) {
            return res.status(500).send('Error reading about.txt');
        }
        res.send(`<h1>About Us</h1><pre>${data}</pre>`);
    });
});
app.get('/TEST', (req, res) => {
    res.send('Hello World!');
  });
app.get('/contact', (req, res) => {
   fs.readFile('./hello.txt')
   res.end(DATA,toString());
});

app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
