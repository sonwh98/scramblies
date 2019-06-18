(ns scramblies.core
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(defn normalize [a-str]
  (-> a-str
      str/lower-case
      ))

(defn subset? [c a-set]
  (set/subset? #{c} (set a-set)))

(defn scramble? [str1 str2]
  (let [set-a (-> str1 normalize set)
        set-b (-> str2 normalize set)
        subset-a (set/select (fn [c]
                               (subset? c set-b))
                             set-a)]
    (= subset-a set-b)))

(comment
  (scramble? "cedewaraaossoqqyt" "codewars")
  (scramble? "rekqodlw" "world")

  (scramble? "katas" "steak")
  
  )
