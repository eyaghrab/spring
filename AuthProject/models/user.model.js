const  mongoose=require('mongoose');

const userSchema=new mongoose.Schema({

    email:{

        type:String,
        required:true,
        max:255,
        min:6
    },
    password:{

        type:String ,
        required:true,
        max:1500,
        min:6
    }
});
module.exports=mongoose.model('Login',userSchema);