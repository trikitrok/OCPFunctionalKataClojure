(ns ocp.core-test
  (:use midje.sweet)
  (:use [ocp.core]))

(facts
  "about saying numbers"
  (fact
    "most numbers are just said"
    (say 1) => "1"
    (say 2) => "2")

  (fact
    "but the multiples of 3 are said as Fizz"
    (say 3) => "Fizz"
    (say 6) => "Fizz")

  (fact
    "but the multiples of 5 are said as Buzz"
    (say 5) => "Buzz"
    (say 10) => "Buzz")

  (fact
    "but the multiples of 3 and 5 are said as FizzBuzz"
    (say 15) => "FizzBuzz"
    (say 30) => "FizzBuzz")

  (fact
    "but the multiples of 7 are said as Bang"
    (say 7) => "Bang"
    (say 14) => "Bang")

  (fact
    "but the multiples of 3 and 7 are said as FizzBang"
    (say 21) => "FizzBang"
    (say 42) => "FizzBang"))
