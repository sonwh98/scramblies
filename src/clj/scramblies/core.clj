(ns scramblies.core
  (:require [clojure.string :as str]
            [clojure.set :as set]))


(defn normalize [a-str]
  (-> a-str
      str/lower-case
      )
  )

(defn scramble [str1 str2]
  (let [set1 (-> str1 normalize set)
        set2 (-> str1 normalize set)]
    (for [c set2]
      (set/subset? #{c} set1))))

