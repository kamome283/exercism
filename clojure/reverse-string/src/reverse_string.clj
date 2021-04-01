(ns reverse-string)

(defn reverse-string [s] ;; <- arglist goes here
  (->> s (into '()) (apply str)))
