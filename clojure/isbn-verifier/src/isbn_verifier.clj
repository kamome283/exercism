(ns isbn-verifier)

(defn- digits [isbn]
  (let [checker #"^(:?\d+-?)+[\dX]?$"
        extractor #"[\dX]"]
    (if (re-matches checker isbn)
      (->> isbn
           (re-seq extractor)
           (map #(-> % first (Character/digit 10)))))))

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