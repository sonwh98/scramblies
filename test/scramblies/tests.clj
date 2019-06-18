(ns scramblies.tests
  (:require [clojure.test :refer :all]
            [scramblies.core :as sc]))

(deftest normalize
  (is (= "a" (sc/normalize "A")))
  )

(deftest scramble
  (is (= 1 1)))

