(ns series
  (:require [clojure.string :as str]))

(defn slices [string length] ;; <- arglist goes here
  (case length
    0 [""]
    (->> string
         (partition length 1)
         (map str/join))))
