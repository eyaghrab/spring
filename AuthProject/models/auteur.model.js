const mongoose=require('mongoose');
const auteurSchema=mongoose.Schema({
    nomauteur:String,
    email:String,
    numtel:String

});
module.exports=mongoose.model('auteur',auteurSchema);