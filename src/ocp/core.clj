(ns ocp.core)

(defn- multiple-of? [m n]
  (zero? (mod n m)))

(defn- make-particular-way-of-saying [{:keys [pred say-as]}]
  (fn [{:keys [acc n] :as so-far}]
    (if (pred n)
      (assoc so-far :acc (str acc say-as))
      so-far)))

(defn- just-say [{:keys [acc n]}]
  (if (clojure.string/blank? acc)
    (str n)
    acc))

(defn- make-say-function []
  (let [particular-ways-of-saying-numbers
        [{:pred (partial multiple-of? 3) :say-as "Fizz"}
         {:pred (partial multiple-of? 5) :say-as "Buzz"}
         {:pred (partial multiple-of? 7) :say-as "Bang"}
         {:pred #(contains? #{11 13 17} %) :say-as "Klang"}]]
    (->> particular-ways-of-saying-numbers
         reverse
         (map make-particular-way-of-saying)
         (cons just-say)
         (apply comp))))

(def ^:private say-number (make-say-function))

(defn say [n]
  (say-number {:acc "" :n n}))
