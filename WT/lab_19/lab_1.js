const fs = require('fs');
const path = require('path');
const express = require('express');
const { readFile } = require('fs');

const app = express();

const port = 3055;


app.get('/TEST', (req, res) => {
  res.send('Hello World!');
});

app.get('/about', (req, res) => {
    res.send('hello its about ');
  });
  app.get('/calc', (req, res) => {
    res.send('hello its about ');
    readFile
  });


  app.get('"D:/Zala/lab 5/lab_5_4_ngtew.html"', (req, res) => {
    fs.readFile(path.join(__dirname, 'files', 'example.txt'), 'utf8', (err, data) => {
        if (err) {
            return res.status(500).send('Error reading file');
        }
        res.send(data);
    });
});

  


app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});
