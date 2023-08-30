(ns code-from-class.class3)




(comment

  (+ 2 3)
  ;; => 5

  (* 1 2 3 4 5)
  ;; => 120

  (* 4)
  ;; => 4

  (/ 6 27)
  ;; => 2/9 ;; gives a ratio

  (float (/ 6 27))
  ;; => 0.22222222

  (+ 3 7.23)
  ;; => 10.23

  (+ 1 2 (* 9 3) 8 (/ 34 11))
  ;; => 452/11

  (type 2999)
  ;; => java.lang.Long

  (type 3.12)
  ;; => java.lang.Double

  (type 5/27)
  ;; => clojure.lang.Ratio

  ;; big int:

  (* 314134313 78391487317843897)
  ;; => Execution error (ArithmeticException) at java.lang.Math/multiplyExact (Math.java:1032).
  ;;    long overflow

  (*' 314134313 78391487317843897)
  ;; => 24625456013639105225337761N

  (type (*' 314134313 78391487317843897))
  ;; => clojure.lang.BigInt

  (type (*' 43 5))
  ;; => java.lang.Long

  (< 4 9)
  ;; => true

  (= 3 9)
  ;; => false

  (< 2 4 6 8 10)
  ;; => true

  (< '(2 3454 4 5)) ;;; bad, don't do this
  ;; => true

  ;; booleans
  true
  ;; => true

  false
  ;; => false

  nil
  ;; => nil

  ;; nil represents no value. 
  ;; The only two "falsy" values in Clojure are false and nil
  ;; Any other value is "true" if used in a conditional

  ;; keywords - always evaluate to themselves
  :kiwis
  ;; => :kiwis

  :avocados
  ;; => :avocados

  ;; Keywords are used in places where you want an identifier
  ;; but don't need to treat it as text

  ;; Strings - always use double quotes:
  "Hi there"
  ;; => "Hi there"

  "This string
is on multiple
lines"
  ;; => "This string\nis on multiple\nlines"

  ;; str converts other data types to strings and concatenates them
  (str 234)
  ;; => "234"

  (str :hi 834 2/3)
  ;; => ":hi8342/3"

  (str "hello" "world")
  ;; => "helloworld"

  (println "cat")
  ;; => nil

  ;; println returns nil after printing its arguments

  (println "why" "do" "I" "have" (+ 5 6) "cats?")
  ;; => nil









  )