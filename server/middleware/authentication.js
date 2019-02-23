const jwt = require("../utils/jwt");
const User = require("../model/user");

module.exports.isApiUser = (req, res, next) => {
  const userId = jwt.verify(req.headers.token);
  if (userId) {
    req.user = { id: userId };
    return next();
  }
  let err = new Error();
  err.status = 500;
  err.message = "Invalid token supplied with request.";
  return next(err);
};
