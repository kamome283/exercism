(ns complex-numbers)

(defn real [[a _]] a)

(defn imaginary [[_ b]] b)

(defn abs [[a b]]
  (Math/sqrt (+ (Math/pow a 2) (Math/pow b 2))))

(defn conjugate [[a b]]
  [a (- b)])

(defn add [[a b] [c d]]
  [(+ a c) (+ b d)])

(defn sub [[a b] [c d]]
  [(- a c) (- b d)])

(defn mul [[a b] [c d]]
  [(- (* a c) (* b d)), (+ (* b c) (* a d))])

(defn div [[a b] [c d]]
  (let [dnm (+ (Math/pow c 2) (Math/pow d 2))]
    [(/ (+ (* a c) (* b d)) dnm), (/ (- (* b c) (* a d)) dnm)]))
