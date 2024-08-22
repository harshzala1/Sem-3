const child_process = require('child_process');
const path = require('path');

path1 = '"D:/Zala/lab 5/lab-5-11.html"';
child_process.exec(path1,(err,stdout,stdin)=>{
    console.log(stdout);
})