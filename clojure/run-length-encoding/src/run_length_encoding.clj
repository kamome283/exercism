(ns run-length-encoding)

(defn- encode-step [s]
  (let [ch (first s)
        cnt (count s)]
    (if (= cnt 1)
      ch
      (str cnt ch))))

(defn run-length-encode [text]
  (->> text (partition-by identity) (map encode-step) (apply str)))

(defn- decode-step [[_ count-s ch]]
  (if (empty? count-s)
    ch
    (->> ch (repeat (Integer/parseInt count-s)) (apply str))))

(defn run-length-decode [text]
  (->> text (re-seq #"(\d*)(\D)") (map decode-step) (apply str)))