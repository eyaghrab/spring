const mongoose = require('mongoose')

var PostMessage = mongoose.model('PostMessage',
{
    title : {type:String},
    description : {type:String},
    avis:{type:s=String}

},'postMessages')

module.exports = { PostMessage}