const router=require('express').Router();
const User=require('../models/user.model');
const {registerValidation,loginValidation}=require('../validation');
const bcrypt=require('bcryptjs');
const jwt=require('jsonwebtoken');

router.post('/register',async(req,res)=>{

    const{error}=registerValidation(req.body);
    if(error) return res.status(400).send(error.details[0].message);
    const emailExist=await User.findOne({email:req.body.email});
    if(emailExist) return res.status(400).send('Email already exsits');
    const salt=await bcrypt.genSalt(10);
    const hashPassword=await bcrypt.hash(req.body.password,salt);
    const user =new User({
        email:req.body.email,
        password:hashPassword
    });
    try{

        const savedUser=await user.save();
        res.send({user:user._id});
    }
    catch(err){
        res.status(404).send(err);
    }
});

    router.post('/login',async(req,res)=>{
        console.log('req.body : '+req.body);
        const{error}=loginValidation(req.body);
        if(error) return res.status(400).send(error.details[0].message);

        const user=await User.findOne({email:req.body.email});
        if(!user) return res.status(400).send('Email is not found');

        const validPass=await bcrypt.compare(req.body.password,user.password);
        if(!validPass) 
        return res.status(400).send('invalid password');
        // res.send('Logged in !!');
        const token=jwt.sign({_id:user._id},process.env.TOKEN_SECRET);
        res.header('auth-token',token).send(token);

    });

module.exports=router;