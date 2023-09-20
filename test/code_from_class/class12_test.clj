(ns code-from-class.class12-test
  (:require [clojure.test :refer [deftest is]]
            [code-from-class.class12 :as c12]))

;; deftest defines a new test. It is usually used to test a single function
;; is asserts that a single statement is true.
;; this is often used with =, but any fn call that returns a boolean
;; is good enough
(deftest square-plus-5-test
  (is (= (c12/square-plus-5 4) 21))
  (is (= (c12/square-plus-5 7) 54))

  ;; this test fails!
  ;;(is (= (c12/square-plus-5 -2) 1))

  (is (thrown? java.lang.ClassCastException
               (c12/square-plus-5 "zebra"))))

(comment
  
  (c12/square-plus-5 "zebra")
  ;; => Execution error (ClassCastException) at code-from-class.class4/square (class4.clj:6).
  ;;    class java.lang.String cannot be cast to class java.lang.Number (java.lang.String and java.lang.Number are in module java.base of loader 'bootstrap')

  (* "zebra" "zebra")
  ;; => Execution error (ClassCastException) at code-from-class.class12-test/eval6282 (REPL:27).
  ;;    class java.lang.String cannot be cast to class java.lang.Number (java.lang.String and java.lang.Number are in module java.base of loader 'bootstrap')

  
  )