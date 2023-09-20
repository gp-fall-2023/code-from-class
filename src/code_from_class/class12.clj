(ns code-from-class.class12
  (:require [code-from-class.class4 :as c4]))
;; This allows us to use code from this namespace


(defn square-plus-5
  "Squares x and adds 5 to it."
  [x]
  (+ (c4/square x)
     5))





;; require allows us to use code from another namespace

(comment
  
  (c4/square 5)
  ;; => 25
  
  (square-plus-5 4)
  ;; => 21

  
  ;; eval examples:
  (eval 5)
  ;; => 5

  (eval +)
  ;; => #function[clojure.core/+]

  (eval x)
  ;; => Syntax error compiling at (src/code_from_class/class12.clj:12:3).
  ;;    Unable to resolve symbol: x in this context

  (let [x 45]
    (eval x))
  ;; => 45

  (+ 3 2)
  ;; => 5

  '(+ 3 2)
  ;; => (+ 3 2)

  (eval '(+ 3 2))
  ;; => 5

  
  

  
  )