var _ = require('lodash');
var numbers = [1, 2, 3, 4];

listOfNumbers = _.concat(numbers, 5, [6,7]);
console.log(listOfNumbers);