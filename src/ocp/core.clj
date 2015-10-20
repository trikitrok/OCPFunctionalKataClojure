(ns ocp.core)

(defn- multiple-of? [m n]
  (zero? (mod n m)))

(def ^:private particular-ways-of-saying-numbers
  [{:pred (partial multiple-of? 3) :say-as "Fizz"}
   {:pred (partial multiple-of? 5) :say-as "Buzz"}
   {:pred (partial multiple-of? 7) :say-as "Bang"}
   {:pred #(contains? #{11 13 17} %) :say-as "Klang"}])

(defn- make-particular-way-of-saying
  [{:keys [pred say-as]}]
  (fn [{:keys [res n] :as so-far}]
    (if (pred n)
      (assoc so-far :res (str res say-as))
      so-far)))

(defn- default-way-of-saying [{:keys [res n]}]
  (if (clojure.string/blank? res)
    (str n)
    res))

(defn- make-say-function []
  (->> particular-ways-of-saying-numbers
       reverse
       (map make-particular-way-of-saying)
       (cons default-way-of-saying)
       (apply comp)))

(def ^:private say-number (make-say-function))

(defn say [n]
  (say-number {:res "" :n n}))
