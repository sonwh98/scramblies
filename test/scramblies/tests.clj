(ns scramblies.tests
  (:require [clojure.test :refer :all]
            [scramblies.core :as s]))

(deftest normalize
  (testing "lower case letters only"
    (is (= "a" (s/normalize "A"))))

  (testing "no punctuations"
    (is (clojure.string/blank? (s/normalize "[?.,#!$%^&*;:{}=-_`~()]"))))

  (testing "no digits"
    (is (clojure.string/blank? (s/normalize "1234567890")))
    (s/normalize "1234567890 a b c") "a b c"
    (is (= (s/normalize "1234567890 a b c") "a b c"))))

(deftest scramble
  (testing "given cases"
    (is (s/scramble? "cedewaraaossoqqyt" "codewars"))
    (is (s/scramble? "rekqodlw" "world"))
    (is (false? (s/scramble? "katas" "steak"))))

  (testing "duplicate letters"
    (is (s/scramble? "hello" "hello"))
    (is (false? (s/scramble? "helo" "hello")))))

(comment
  (clojure.test/run-tests 'scramblies.tests)
  )
