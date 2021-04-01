(ns phone-number)

(defn number-vec [num-string]
  (let [regex #"1?\(?([2-9]\d{2})\)?[ -\.]?([2-9]\d{2})[ -\.]?(\d{4})"]
    (some->> num-string (re-matches regex) (drop 1))))

(defn number [num-string] ;; <- arglist goes here
  (or (some->> num-string number-vec (apply str))
      "0000000000"))

(defn area-code [num-string] ;; <- arglist goes here
  (some-> num-string number-vec first))

(defn pretty-print [num-string] ;; <- arglist goes here
  (some->> num-string number-vec (apply format "(%s) %s-%s")))
