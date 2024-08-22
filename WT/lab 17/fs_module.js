const fs= require('fs')
fs.exists('D:/Zala/lab 7/lab_7_1.html',(exists)=>{
    if(exists){
        console.log('file exists');
        }
        else{
            console.log('file does not exist');
            }
});


fs.stat('D:/Zala/lab 7/lab_7_1.html',(data,err)=>{
    if(err){
        console.log('error');
        }
        else{
            console.log(data);

}})