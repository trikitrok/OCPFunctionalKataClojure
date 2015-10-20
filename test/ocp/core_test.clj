(ns ocp.core-test
  (:use midje.sweet)
  (:use [ocp.core]))

(facts
  "about saying numbers"
  (fact
    "most numbers are just said"
    (say 1) => "1"
    (say 2) => "2"))
