(ns bob)

(defn response-for [s]
  (condp re-matches s
    #"^\s*$" "Fine. Be that way!"                           ;nothing
    #"^[A-Z ]+\?\s*$" "Calm down, I know what I'm doing!"   ;yell-question
    #".*\?\s*$" "Sure."                                     ;question
    #"^[^a-z]*[A-Z]+[^a-z]*$" "Whoa, chill out!"            ;yell
    "Whatever."))