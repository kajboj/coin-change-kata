### What is a kata?

A code kata is an exercise in programming which helps a programmer improve their skills through practice and repetition

### Which kata are we solving?

We are going to extend the already solved **Coin change kata** by adding another
component to the system.

The original coin change kata exercise was about producing the minimal amount of change for a given amount
For instance, If the input is: $0.99, the output should be: 3 quarters, 2 dimes, and 4 pennies

This time we're going to extend coin changer system to fulfill the following requirements:
* user can insert coins
* user can ask for a change for given amount
* system returns null when user asks for change for the amount greater than the amount inserted

Example:

ChangeCalculator calculator = new ChangeCalculator()

calculator.insert(Coins.QUARTER);     // inserted 25
calculator.insert(Coins.HALF_DOLLAR); // inserted 75
calculator.insert(Coins.DIME);        // inserted 85

calculator.getChange(79);             // returns NICKEL and CENT

### 3 Rules of TDD to have in mind for solving the exercise

1. You are not allowed to write any production code unless it is to make a failing unit test pass.
2. You are not allowed to write any more of a unit test than is sufficient to fail; and compilation failures are failures.
3. You are not allowed to write any more production code than is sufficient to pass the one failing unit test.

### Setup the project in eclipse (or ride)

Import the project as a Gradle project in eclipse

Set as gradle user home directory the directory in where the project has been cloned

![Configuration](https://github.com/doktor500/coin-change-kata/blob/master/config.png)
