(ns code-from-class.class18)


;; eval
;; takes a data structure and evaluates it
;; literals evaluate to themselves
;; lists evaluate to function calls
;; symbols evaluate to their latest binding

(def xyz 'this-is-a-symbol)

xyz
;; => this-is-a-symbol

(eval 'xyz)
;; => this-is-a-symbol

(eval xyz)
;; => Syntax error compiling at (src/code_from_class/class18.clj:18:1).
;;    Unable to resolve symbol: this-is-a-symbol in this context

(def this-is-a-symbol 52)

(eval xyz)
;; => 52

(type xyz)
;; => clojure.lang.Symbol

;; Imagine you were implementing integer_+

(def some-push-state {:integer '(5 3 100)
                      :string '()
                      :exec '()})

;; not the way you'll implement most Push instructions
(defn integer_+
  [push-state]
  (let [top-item (first (:integer push-state))
        second-item (second (:integer push-state))
        result (+ top-item second-item)
        new-int-stack (conj (drop 2 (:integer push-state))
                            result)]
    (assoc push-state :integer new-int-stack)))

;; test this out:
(integer_+ some-push-state)
;; => {:integer (8 100), :string (), :exec ()}

;; so far so good!

(def program '(integer_+))

program
;; => (integer_+)

;; part of your interpreter?
(let [the-first-instruction (first program)]
  (the-first-instruction some-push-state))
;; => nil

;; why do we get nil?
;; the-first-instruction is getting bound to the SYMBOL integer_+
;; when we run the-first-instruction as a function, this is equivalent
;; to: ('integer_+ {...})

('integer_+ some-push-state)
;; => nil

(integer_+ some-push-state)
;; => {:integer (8 100), :string (), :exec ()}

;; before a function is called, every element of the list is evaluated,
;; including the function itself!
;; 
(eval '+)
;; => #function[clojure.core/+]

+
;; => #function[clojure.core/+]

(+ 2 3)
;; => 5


;; is equivalent to:
(get some-push-state 'integer_+)
;; => nil

(let [the-first-instruction (first program)]
  ((eval the-first-instruction) some-push-state))
;; => {:integer (8 100), :string (), :exec ()}


(eval 'integer_+)
;; => #function[code-from-class.class18/integer-+]
