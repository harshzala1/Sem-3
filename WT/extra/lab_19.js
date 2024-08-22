//perform curd opration in express js also use middle name where it's needed
const express = require('express')
const app = express();
const bodyparsher = require('body-parser');

app.use(bodyparsher.urlencoded());
const students = [
    {
        id: 1,
        name: "John",
        age: 20
    },
    {
        id: 2,
        name: "Doe",
        age: 62

    },
    {
        id: 3,
        name: "fghjk",
        age: 25
    }

]
//get opration 
app.get('/students', (req, res) => {
  res.send(students);
  });
  //get element by id
  app.get('/students/:id', (req, res) => {
    const xstud=students.find((stu)=>{
        if(stu.id==req.params.id)
        {
            return true;
        }
    });
    res.send(students);
});
//post opration
app.post('/students', (req, res) => {
    students.push(req.body);

});

app.delete('/student/name',(req,res)=>{
    students.splice(req.params.index,1);
    res.send(students);
});
app.listen(3030, (req,res) => {
    console.log(`Server is running at http://localhost:3030`);
  });
  