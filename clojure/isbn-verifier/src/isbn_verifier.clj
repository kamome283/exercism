(ns isbn-verifier)

(defn- to-num [ch]
  (let [n (Character/digit ch 10)]
    (cond
      (nat-int? n) n
      (= ch \-) nil
      :else (throw (IllegalArgumentException.)))))

(defn- to-num-x [ch]
  (if (= ch \X)
    10
    (to-num ch)))

(defn- digits [isbn]
  (try
    (let [bl (->> isbn butlast (keep to-num) vec)
          l (-> isbn last to-num-x)]
      (conj bl l))
    (catch IllegalArgumentException _ nil)))

(defn- isbn?* [num-digits isbn]
  (if-let [ds (digits isbn)]
    (and (= (count ds) num-digits)
         (->> ds
              (map * (range num-digits 0 -1))
              (apply +)
              (#(mod % 11))
              (= 0)))
    false))

(defn isbn? [isbn]
  (isbn?* 10 isbn))