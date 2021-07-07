const express=require('express');
const router=express.Router();
const Auteur=require('../models/auteur.model');


router.post('/', async (req,res)=> {
    try{
    var auteur=new Auteur(req.body);
    await auteur.save();

    res.redirect('/auteurs');
   }catch(e){
    res.status(500).send(e);
}
});

router.get('/',async (req,res)=> {
var result=await Auteur.find();
res.render('auteurs/listAuteurs.ejs',{auteur:result});
});

router.get('/ajout',function (req,res) {
res.render('auteurs/ajoutAuteur.ejs');
});
module.exports=router;