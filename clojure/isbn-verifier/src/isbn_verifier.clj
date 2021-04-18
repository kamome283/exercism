(ns isbn-verifier)

(defn- digits [isbn]
  (let [normalized (->> isbn
                        (remove #(= \- %))
                        (apply str))
        extractor #"\d{9}[\dX]"
        to-num (fn [c] (if (= c \X)
                         10
                         (Character/digit c 10)))]
    (some->> (re-matches extractor normalized)
             (map to-num))))

(defn isbn? [isbn]
  (if-let [ds (digits isbn)]
    (and (= (count ds) 10)
         (->> ds
              (map * (range 10 0 -1))
              (apply +)
              (#(mod % 11))
              zero?))
    false))