(ns ocp.core)

(defn- multiple-of? [m n]
  (zero? (mod n m)))

(defn- make-say-something [pred what]
  (fn [{:keys [acc n] :as so-far}]
    (if (pred n)
      (assoc so-far :acc (str acc what))
      so-far)))

(def say-buzz
  (make-say-something
    (partial multiple-of? 5) "Buzz"))

(def say-fizz
  (make-say-something
    (partial multiple-of? 3) "Fizz"))

(defn- just-say [{:keys [acc n]}]
  (if (clojure.string/blank? acc)
    (str n)
    acc))

(def ^:private say-number
  (comp just-say say-buzz say-fizz))

(defn say [n]
  (say-number {:acc "" :n n}))
