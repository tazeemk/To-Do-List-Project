var express = require("express");
var mongoClient =require("mongodb").MongoClient;
var cors=require("cors");
var app = express();
app.use(cors());

app.use(express.urlencoded({extended: true}));
app.use(express.json());

var conString="mongodb://127.0.0.1:27017";
app.get("/user",(req,res)=>{
    mongoClient.connect(conString).then(clientObj=>{
        var database =clientObj.db("React-Proj")
        database.collection("tbluser").find({}).toArray().then(document=>{
            res.send(document);
            res.end();
        })
    })
})
app.post("/register-user",(req,res)=>{
    var user ={
        userId:req.body.userId,
        userName:req.body.userName,
        Password:req.body.Password,
        Email:req.body.Email,
        Mobile:req.body.Mobile
    }
    mongoClient.connect(conString).then(clientObj=>{
     var database =clientObj.db("React-Proj");
     database.collection("tbluser").insertOne(user).then(()=>{
        console.log("user Registered")
        res.end();
     })
    })
})

app.put("/edit-api/:userid",(req,res)=>{
    mongoClient.connect(conString).then(clientObj=>{
        var database =clientObj.db("React-Proj");
        database.collection("tbluser").updateOne({userId:req.params.userid},{$set:{UserId:req.params.userid,
            UserName:req.body.userName,Password:req.body.Password,Email:req.body.Email,Mobile:req.body.Mobile
        }}).then(()=>{
            console.log("Updated user");
            res.end();
        })
    });
})
app.delete("/delete-user/:userid",(req,res)=>{
    mongoClient.connect(conString).then(clientObj=>{
        var database =clientObj.db("React-Proj");
        database.collection("tbluser").deleteOne({userId:req.params.userid}).then(()=>{
            console.log("user deleted");
            res.end();
        })
    });
})
// Route for Appointments 

app.get("/appointments/:userId", (req, res)=>{

    mongoClient.connect(conString).then(clientObj=>{
         var database = clientObj.db("React-Proj");
         database.collection("tblappointments").find({UserId:req.params.userId}).toArray().then(documents=>{
              res.send(documents);
              console.log(documents)
              res.end();
         });
    });
});

app.get("/get-appointment/:id", (req, res)=>{

    mongoClient.connect(conString).then(clientObj=>{
         var database = clientObj.db("React-Proj");
         database.collection("tblappointments").find({Appointment_Id:parseInt(req.params.id)}).toArray().then(documents=>{
              res.send(documents);
              res.end();
         });
    });
});

app.post("/add-appointment",(req, res)=>{

    var appointment = {
        Appointment_Id: parseInt(req.body.Appointment_Id),
        Title: req.body.Title,
        Description: req.body.Description, 
        Date: new Date(req.body.Date),
        UserId: req.body.userId
    }

    mongoClient.connect(conString).then(clientObj=>{

        var database = clientObj.db("React-Proj");

        database.collection("tblappointments").insertOne(appointment).then(()=>{
             console.log('Appointment added');
             res.end();
        });
    });
});

app.put("/edit-appointment/:id", (req, res)=>{

    mongoClient.connect(conString).then(clientObj=>{

          var database = clientObj.db("React-Proj");

          database.collection("tblappointments").updateOne({Appointment_Id:parseInt(req.params.id)},{$set:{Appointment_Id:parseInt(req.body.Appointment_Id), Title: req.body.Title, Description: req.body.Description, Date:new Date(req.body.Date), UserId:req.body.userId}}).then(()=>{
              console.log('Appointment Details Updated..');
              res.end();
          });
    });
});

app.delete("/delete-appointment/:id", (req, res)=>{

    mongoClient.connect(conString).then(clientObj=>{

              var database = clientObj.db("React-Proj");

              database.collection("tblappointments").deleteOne({Appointment_Id:parseInt(req.params.id)}).then(()=>{

                   console.log('User Deleted..');
                   res.end();
              });
    });
});


app.listen(3200)
console.log(`server started : http://127.0.0.1:3200`)