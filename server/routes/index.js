var express = require("express");
var router = express.Router();
var database = require("../services/adminfunction.js");
var User = require("../model/user");
var bcrypt = require("bcrypt-nodejs");
var jwt = require("../utils/jwt");
var auth = require("../middleware/authentication");
var distRouter = require("../routes/dist");

router.get("/", function(req, res, next) {
  res.json("Medtrace");
});

router.post("/register", async (req, res, next) => {
  let message = await database.addUser(req.body);
  console.log(message);
  res.json({ success: message });
});

router.post("/login", async (req, res, next) => {
  const user = await User.findOne({ email: req.body.email });
  if (!user) {
    return res.json({ success: false });
  }
  if (!bcrypt.compareSync(req.body.password, user.password)) {
    return res.json({ success: false });
  }
  const token = jwt.generate(user._id);
  res.setHeader("token", token);
  console.log(token);
  res.json({ success: true });
});

router.all("/dist*", auth.isApiUser);
router.use("/dist", distRouter);

module.exports = router;
