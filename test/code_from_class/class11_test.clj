(ns code-from-class.class11-test
  (:require [clojure.test :refer [deftest is]]
            [code-from-class.class11 :as c11]))

(deftest infinite-foobar-test
  (is (= (nth c11/infinite-foobar 2) "foobarbar"))
  (is (= (nth c11/infinite-foobar 5)
         (str (nth c11/infinite-foobar 4) "bar"))))