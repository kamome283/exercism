(ns run-length-encoding)

(defn- convert [matcher, step]
  (->> (repeatedly #(re-find matcher))
       (take-while some?)
       (map step)
       (apply str)))

(defn- encode-step [[s, ch]]
  (let [cnt (count s)]
    (if (= cnt 1)
      ch
      (str cnt ch))))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (convert (re-matcher #"(.)\1*" plain-text) encode-step))

(defn- decode-step [[_, count-s, ch]]
  (if (empty? count-s)
    ch
    (->> ch (repeat (Integer/parseInt count-s)) (apply str))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (convert (re-matcher #"(\d*)(\D)" cipher-text) decode-step))