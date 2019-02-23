const mongoose = require("mongoose");

const blockChainSchema = mongoose.Schema({
  chain: [
    {
      type: mongoose.Schema.ObjectId,
      ref: "Block"
    }
  ]
});

module.exports = mongoose.model("Blockchain", blockChainSchema);
