(ns armstrong-numbers)

(defn- digits [num]
  (->> num
       (iterate #(quot % 10))
       (take-while pos?)
       (map #(mod % 10))))

(defn- pow [base exp]
  (->> base (repeat exp) (apply *)))

(defn armstrong? [num]
  (let [ds (digits num)]
    (->> ds
         (map #(pow % (count ds)))
         (apply +)
         (= num))))