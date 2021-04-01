(ns clock)

(defn clock->string [[hours, minutes]] ;; <- arglist goes here
  (format "%02d:%02d" hours minutes))

(defn clock [hours minutes] ;; <- arglist goes here
  (let [normalized-total (-> (+ (* hours 60) minutes)
                             (mod (* 60 24)))
        hours (quot normalized-total 60)
        minutes (mod normalized-total 60)]
    [hours, minutes]))

(defn add-time [[hours, minutes], time]
  (clock hours (+ minutes time)))