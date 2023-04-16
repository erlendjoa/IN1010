// Get the elements from the HTML document
const result = document.getElementById('result');
const numbers = document.querySelectorAll('.number');
const operators = document.querySelectorAll('.operator');
const clearButton = document.getElementById('clear');
const equalsButton = document.getElementById('equals');

// Store the current calculation in these variables
let currentNumber = '';
let operator = '';
let previousNumber = '';

// Update the display when a number button is clicked
numbers.forEach(function(number) {
  number.addEventListener('click', function() {
    currentNumber += number.value;
    result.value = currentNumber;
  });
});

// Save the previous number and operator when an operator button is clicked
operators.forEach(function(operatorButton) {
  operatorButton.addEventListener('click', function() {
    if (currentNumber !== '') {
      previousNumber = currentNumber;
      operator = operatorButton.value;
      currentNumber = '';
    }
  });
});

// Perform the calculation when the equals button is clicked
equalsButton.addEventListener('click', function() {
  if (previousNumber !== '' && currentNumber !== '') {
    const calculation = eval(previousNumber + operator + currentNumber);
    result.value = calculation;
    previousNumber = calculation;
    currentNumber = '';
    operator = '';
  }
});

// Clear the calculator when the clear button is clicked
clearButton.addEventListener('click', function() {
  result.value = '';
  currentNumber = '';
  operator = '';
  previousNumber = '';
});
