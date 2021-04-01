(ns collatz-conjecture)

(defn collatz-one [num]
  (if (even? num)
    (/ num 2)
    (+ (* num 3) 1)))

(defn collatz [num]
  {:pre [(pos? num)]}
  (->> (iterate collatz-one num)
       (take-while #(> % 1))
       count))