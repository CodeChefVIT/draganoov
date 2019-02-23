var express = require("express");
var router = express.Router();

/* GET users listing. */
router.get("/test", function(req, res, next) {
  res.json("Dist route");
});

module.exports = router;
