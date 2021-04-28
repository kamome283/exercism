(ns isbn-verifier)

(defn- to-num [c]
  (if (= c \X)
    10
    (Character/digit c 10)))

(defn isbn? [isbn]
  (let [ds (re-matches #"\d{9}[\dX]" (clojure.string/replace isbn #"-" ""))]
    (and (some? ds)
         (->> ds
              (map to-num)
              (map * (range 10 0 -1))
              (apply +)
              (#(mod % 11))
              zero?))))