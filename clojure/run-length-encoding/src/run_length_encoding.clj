(ns run-length-encoding)

(defn- encode-step [[fst & rst :as part]]
  (cond->> fst
           (not-empty rst) (str (count part))))

(defn run-length-encode [text]
  (->> text
       (partition-by identity)
       (map encode-step)
       (apply str)))

(defn- decode-step [[_ count-s ch]]
  (cond->> ch
           (not-empty count-s) (repeat (Integer/parseInt count-s))))

(defn run-length-decode [text]
  (->> text
       (re-seq #"(\d*)(\D)")
       (mapcat decode-step)
       (apply str)))