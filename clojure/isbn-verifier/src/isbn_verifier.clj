(ns isbn-verifier)

(defn isbn? [isbn]
  (or (some->> (clojure.string/replace isbn #"-" "")
               (re-matches #"\d{9}[\dX]")
               (map #(if (= % \X)
                       10
                       (Character/digit % 10)))
               (map * (range 10 0 -1))
               (apply +)
               (#(mod % 11))
               zero?)
      false))