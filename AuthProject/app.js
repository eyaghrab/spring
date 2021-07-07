const express=require('express');
const app=express();
var createError = require('http-errors');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var auteurRouter = require('./routes/auteur.route');
const mongoose =require('mongoose');
const authRoute=require('./routes/auth');
const dbConfig = require('./config/database.config.js');
const dotenv=require('dotenv');
const bodyParser=require('body-parser')
const cors = require('cors')
const { json } = require('body-parser')
require('./db')



var postMessageRoutes=require('./controlles/PostMessageControlles')
app.use(bodyParser.json())
app.use(cors({origin:'http://localhost:3000'}))





app.use('/postMessages',postMessageRoutes)
dotenv.config();
app.use(express.json());

app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
    next();
   });
  
   
//connect to the database
app.use('/api/user',authRoute);
mongoose.Promise = global.Promise;
mongoose.connect(dbConfig.url,{
    useNewUrlParser: true,
    useUnifiedTopology: true
  }).then(() => {
    console.log("Successfully connected db " );    
}).catch(err => {
    console.log('failure to be coonected ' );
    process.exit();
})
//connect to auteur
app.use('/auteurs', auteurRouter);

app.use('/', function(req,res) {
  res.render('index.ejs');
});

app.use(function(req, res, next) {
  next(createError(404));
});

app.use(function(err, req, res, next) {
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};


});


app.listen(4000,()=>console.log('server up on 4000'))