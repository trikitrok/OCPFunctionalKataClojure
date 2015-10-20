# OCP functional kata.

It's a variation of [Matteo Vaccari](http://matteo.vaccari.name/blog/)'s [Open-Closed kata](http://matteo.vaccari.name/blog/archives/293).

In this case you have to follow a slightly different set of rules:

1. Write a failing test.

2. Write a HOF that builds a function that makes the test pass.

3. Write next failing test.

4. Can you make it pass by just changing that HOF so that it creates a new function
<brt>hat makes all tests pass
(you can also create some new helper functions)?

    - Yes: Great! Go back to step 3.

    - No: Refactor until you can!


## How to run the tests
The project uses [Midje](https://github.com/marick/Midje/).

`lein midje` will run all tests.

`lein midje namespace.*` will run only tests beginning with "namespace.".

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.
