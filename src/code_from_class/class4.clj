(ns code-from-class.class4)

(defn square
  "Squares the input x; this is a docstring"
  [x] ;; this is the list of parameters
  (* x x)) ;; functions return the last (or only) thing they evaluate


(comment

  ; Sequences: lists and vectors
  ; lists - look like code
  ;       - implemented as linked lists

  '(1 2 3)
  ;; => (1 2 3)

  (1 2 3)
  ;; => Execution error (ClassCastException) at code-from-class.class4/eval5969 (REPL:12).
  ;;    class java.lang.Long cannot be cast to class clojure.lang.IFn (java.lang.Long is in module java.base of loader 'bootstrap'; clojure.lang.IFn is in unnamed module of loader 'app')

  ((+ 2 3))
  ;; => Execution error (ClassCastException) at code-from-class.class4/eval5971 (REPL:16).
  ;;    class java.lang.Long cannot be cast to class clojure.lang.IFn (java.lang.Long is in module java.base of loader 'bootstrap'; clojure.lang.IFn is in unnamed module of loader 'app')

  '(+ 2 3)
  ;; => (+ 2 3)

  '(1 (2 3 4) 5 6)
  ;; => (1 (2 3 4) 5 6)

  (quote (1 2 3))
  ;; => (1 2 3)

  (nth '(1 (2 3 4) 5 6) 1)
  ;; => (2 3 4)

  (list 1 (+ 2 3) 4)
  ;; => (1 5 4)

  ;; vectors - faster indexed access, slower in other ways
  ;;         - implemented as dynamic arrays

  [1 2 3]
  ;; => [1 2 3]

  [1 (+ 2 3) 4]
  ;; => [1 5 4]

  (vector 1 2 3)
  ;; => [1 2 3]

  ;; we can mix data types in lists and vectors:
  '(5 :apple "hi" ("a" :list))
  ;; => (5 :apple "hi" ("a" :list))

  ;; sequence functions -- work on lists and vectors

  (first '(:a :b :c :d))
  ;; => :a

  (rest '(:a :b :c :d))
  ;; => (:b :c :d)

  (count '(:a :b :c :d))
  ;; => 4

  (nth '(:a :b :c :d) 3)
  ;; => :d

  ;; conjoin
  (conj '(:a :b :c :d) 3)  ;; list -- adds to the beginning
  ;; => (3 :a :b :c :d)

  (conj [:a :b :c :d] 3)
  ;; => [:a :b :c :d 3]

  (concat '(1 2 3) '(4 5 6))
  ;; => (1 2 3 4 5 6)

  (concat [1 2 3] [4 5 6])
  ;; => (1 2 3 4 5 6)

  (vec (concat [1 2 3] [4 5 6]))
  ;; => [1 2 3 4 5 6]


  ;; let: allows you to assign values to symbols within
  ;; a lexical context
  ;; we never change the value of a variable
  ;; let is your friend
  (let [nums '(7 2 3 1 2)
        the-first (first nums)]
    (* the-first the-first))
  ;; => 49

  ;; note: no pure functions actually change values bound
  ;; to symbols

  (let [nums '(7 2 3 1 2)]
    (println nums)
    (println (conj nums 100)) ;; returns a new list with 100
    (println nums)
    (rest nums)) ;; returned, since let returns last form
  ;; => (2 3 1 2)


  ;; defn - define function
  (defn square
    "Squares the input x; this is a docstring"
    [x] ;; this is the list of parameters
    (* x x)) ;; functions return the last (or only) thing they evaluate

  (square 5)
  ;; => 25

  (square 3.6)
  ;; => 12.96

  (square 5/3)
  ;; => 25/9

  (square "hi")
  ;; => Execution error (ClassCastException) at code-from-class.class4/square (REPL:106).
  ;;    class java.lang.String cannot be cast to class java.lang.Number (java.lang.String and java.lang.Number are in module java.base of loader 'bootstrap')

  (defn sphere-volume
    "Calculates the volume of a sphere. Prints r-cubed."
    [radius]
    (let [r-cubed (* radius radius radius)
          volume (* 4/3 Math/PI r-cubed)]
      (println "The r-cubed is" r-cubed)
      volume))
  ;; => #'code-from-class.class4/sphere-volume

  (sphere-volume 4)
  ;; => 268.08257310632894

  ;; if -- if the first argument is true, it returns the second argument
  ;;       else returns the third
  (if (< 1 4)
    (str 1 " is smaller")
    (str 4 " is smaller"))
  ;; => "1 is smaller"

  (when true
    (println "yay"))
  ;; => nil

  (when false
    (println "boo"))
  ;; => nil

  (when true
    (println "hi")
    (+ 3 (* 2 3)))
  ;; => 9

  (defn how-big
    "Tells how big a number is"
    [num]
    (cond ;; takes pairs of conditions and what to do if condition is true
      (< num 0) "That's negative!"
      (< num 10) "Single digit"
      (< num 100) "Double digit"
      :else "That's a big number!"))

  (how-big 323432)
  ;; => "That's a big number!"

  (how-big 6)
  ;; => "Single digit"

  ;; def creates a global binding to a symbol
  ;; you should ONLY use it to create global constants
  ;; you should NEVER use it to change the binding of a symbol that already has one
  ;; you should NEVER use it within any other code
  (def more-nums '(1 2 3 4 5))
  ;; => #'code-from-class.class4/more-nums

  more-nums
  ;; => (1 2 3 4 5)

  (rest more-nums)
  ;; => (2 3 4 5)

  more-nums
  ;; => (1 2 3 4 5)


  ;; it turns out, defn is just short for def with an anon fns:
  (def cube
    (fn [x]
      (* x x x)))
  ;; => #'code-from-class.class4/cube

  (cube 5)
  ;; => 125

  ;; fn defines an anonymous function that doesn't have a binding
  )