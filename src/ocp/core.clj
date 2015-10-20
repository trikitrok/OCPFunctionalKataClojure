(ns ocp.core)

(defn- say-fizz [fn n]
  (when (zero? (mod n 3))
    "Fizz"))

(defn- just-say [fn n]
  (if-let [res (fn n)]
    res
    (str n)))

(def ^:private say-number
  (partial just-say
           (partial say-fizz
                    (fn [n] nil))))

(defn say [n]
  (say-number n))
