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
    (say 10) => "Buzz"))
