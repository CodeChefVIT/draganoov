const ml = require("ml-regression");
const csv = require("csvtojson");
const SLR = ml.SLR; // Simple Linear Regression
const path = require("path");
let csvData = [], // parsed Data
  X = [], // Input
  y = []; // Output

let regressionModel;

const readline = require("readline"); // For user prompt to allow predictions

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// csv()
//   .fromFile("./dataset/student_scores.csv")
//   .on("json", jsonObj => {
//     csvData.push(jsonObj);
//     console.log(jsonObj);
//   })
//   .on("done", () => {
//     dressData(); // To get data points from JSON Objects
//     performRegression();
//   });
let csvFilePath = path.join(__dirname, "student_scores.csv");
csv()
  .fromFile(csvFilePath)
  .then(jsonObj => {
    jsonObj.forEach(content => {
      // console.log(content.Hours);
      X.push(content.Hours);
      y.push(content.Scores);
    });
    console.log(X, y);
  });

function performRegression() {
  console.log(X);
  regressionModel = new SLR(X, y); // Train the model on training data
  console.log(regressionModel.toString(3));
  predictOutput();
}

function dressData() {
  /**
   * One row of the data object looks like:
   * {
   *   TV: "10",
   *   Radio: "100",
   *   Newspaper: "20",
   *   "Sales": "1000"
   * }
   *
   * Hence, while adding the data points,
   * we need to parse the String value as a Float.
   */
  csvData.forEach(row => {
    X.push(f(row.Radio));
    y.push(f(row.Sales));
  });
}

function f(s) {
  return parseFloat(s);
}

function predictOutput() {
  rl.question(
    "Enter input X for prediction (Press CTRL+C to exit) : ",
    answer => {
      console.log(
        `At X = ${answer}, y =  ${regressionModel.predict(parseFloat(answer))}`
      );
      predictOutput();
    }
  );
}
