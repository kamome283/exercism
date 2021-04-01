(ns beer-song
  (:require [clojure.string :as str]))

(defn bottles [num]
  (case num
    0 "no more bottles"
    1 "1 bottle"
    (str num " bottles")))

(defn verse
  "Returns the nth verse of the song."
  [num]
  (let [first-line (-> (str (bottles num) " of beer on the wall, " (bottles num) " of beer.")
                       str/capitalize)
        second-line (case num
                      0 "Go to the store and buy some more, 99 bottles of beer on the wall."
                      1 "Take it down and pass it around, no more bottles of beer on the wall."
                      (str "Take one down and pass it around, " (bottles (- num 1)) " of beer on the wall."))]
    (str first-line "\n" second-line "\n")))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (sing start 0))
  ([start end] (->> (range start (dec end) -1) (map verse) (str/join "\n"))))
