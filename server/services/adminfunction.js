const User = require("../model/user");
require("dotenv").config();

module.exports.addUser = async userDetails => {
  try {
    let message = "ok";
    console.log("A");
    let user = await User.findOne({ email: userDetails.email });
    console.log("B");
    if (user) {
      message = "User already registered";
      return message;
    }
    console.log(user);
    let newUser = new User(userDetails);
    if (userDetails.password === process.env.ADMIN_PASS) {
      console.log("password matched");
      newUser.role = "factory";
    }
    newUser.password = newUser.generateHash(userDetails.password);
    await newUser.save();
    return message;
  } catch (error) {
    throw error;
  }
};
