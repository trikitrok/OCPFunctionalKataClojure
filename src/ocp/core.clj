(ns ocp.core)

(defn- say-buzz [{:keys [acc n] :as so-far}]
  (if (zero? (mod n 5))
    (assoc so-far :acc (str acc "Buzz"))
    so-far))

(defn- say-fizz [{:keys [acc n] :as so-far}]
  (if (zero? (mod n 3))
    (assoc so-far :acc (str acc "Fizz"))
    so-far))

(defn- just-say [{:keys [acc n]}]
  (if (clojure.string/blank? acc)
    (str n)
    acc))

(def ^:private say-number
  (comp just-say say-buzz say-fizz))

(defn say [n]
  (say-number {:acc "" :n n}))
