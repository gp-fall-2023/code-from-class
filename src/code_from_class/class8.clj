(ns code-from-class.class8)

(def nums (range 4 12))

;; filter - filter out elements of a seq
;; map - applies a fn to each element, create a new seq of the results

(defn all-words-with-more-than-5-characters
  "Takes a sequence of words and keeps those with > 5 characters"
  [words]
  (filter #(< 5 (count %))
          words))

(comment

  (all-words-with-more-than-5-characters
   '("hi" "hello" "ballet" "basketball" "elephant" "green"))
  ;; => ("ballet" "basketball" "elephant")

  nums
  ;; => (4 5 6 7 8 9 10 11)


  (reduce + nums)
  ;; => 60

  ;(+ ... (+ (+ (+ (+ (+ 4 5) 6) 7) 8) 9) ...)

  (apply + nums)
  ;; => 60

  (+ 4 5 6 7 8 9 10 11)
  ;; => 60

  (reduce + 100 nums) ;; 100 is an optional first argument
  ;; => 160

  ;(+ ... (+ (+ (+ (+ (+ (+ 100 4) 5) 6) 7) 8) 9) ...)

  (reduce (fn [x y] (str x ", " y))
          nums)
  ;; => "4, 5, 6, 7, 8, 9, 10, 11"

  ;; NOT THE SAME!
  (apply (fn [x y] (str x ", " y))
         nums)
  ;; => Execution error (ArityException) at code-from-class.class8/eval8149 (REPL:44).
  ;;    Wrong number of args (8) passed to: code-from-class.class8/eval8149/fn--8150

  (interpose ", " nums)
  ;; => (4 ", " 5 ", " 6 ", " 7 ", " 8 ", " 9 ", " 10 ", " 11)

  (str (interpose ", " nums))
  ;; => "clojure.lang.LazySeq@afb2046f"

  (str (apply list (interpose ", " nums)))
  ;; => "(4 \", \" 5 \", \" 6 \", \" 7 \", \" 8 \", \" 9 \", \" 10 \", \" 11)"

  (apply str (interpose ", " nums))
  ;; => "4, 5, 6, 7, 8, 9, 10, 11"

  (reduce conj '() nums)
  ;; => (11 10 9 8 7 6 5 4)

  (reverse nums)
  ;; => (11 10 9 8 7 6 5 4)

  (reduce list nums)
  ;; => (((((((4 5) 6) 7) 8) 9) 10) 11)

  (reduce + (range 100000))
  ;; => 4999950000

  (reduce list (range 100000))
  ;; => Error printing return value (StackOverflowError) at clojure.lang.PersistentHashMap$BitmapIndexedNode/assoc (PersistentHashMap.java:705).
  ;;    null

  (last (reduce list (range 100000)))
  ;; => 99999

  (reduce list (range 30))
  ;; => (((((((((((((((((((((((((((((0 1) 2) 3) 4) 5) 6) 7) 8) 9) 10) 11) 12) 13) 14) 15) 16) 17) 18) 19) 20) 21) 22) 23) 24)
  ;;         25)
  ;;        26)
  ;;       27)
  ;;      28)
  ;;     29)


  ;; recursion!

  (defn my-count
    [lst]
    (if (empty? lst)
      0
      (inc (my-count (rest lst)))))

  (my-count nums)
  ;; => 8

  (my-count (range 30))
  ;; => 30

  (my-count (range 100000))
  ;; => Execution error (StackOverflowError) at code-from-class.class8/my-count (REPL:96).
  ;;    null

  ;; In Clojure, recursive calls consume call stack space.
  ;; Java isn't very good at managing these recursive calls 
  ;; max call stack size is ~1000

  (defn fib
    "The nth Fibonacci number"
    [n]
    (cond
      (= n 0) 1
      (= n 1) 1
      :else (+ (fib (dec n))
               (fib (- n 2)))))
  ;; => #'code-from-class.class8/fib

  (fib 5)
  ;; => 8

  (map fib (range 10))
  ;; => (1 1 2 3 5 8 13 21 34 55)

  ;; runs forever
  (fib 100)


  (defn first-positive-in-list
    "Return the first positive number in a list"
    [numbers]
    (cond
      (empty? numbers) nil
      (< 0 (first numbers)) (first numbers)
      :else (first-positive-in-list (rest numbers))))
  ;; => #'code-from-class.class8/first-positive-in-list

  (first-positive-in-list '(-4 -2 -19 5 -7 8 -9))
  ;; => 5

  (first-positive-in-list (range -100000 5))
  ;; => Execution error (StackOverflowError) at code-from-class.class8/first-positive-in-list (REPL:138).
  ;;    null

  (defn first-positive-in-list-tail
    "Return the first positive number in a list"
    [numbers]
    (cond
      (empty? numbers) nil
      (< 0 (first numbers)) (first numbers)
      :else (recur (rest numbers))))

  (first-positive-in-list-tail '(-4 -2 -19 5 -7 8 -9))
  ;; => 5

  (first-positive-in-list-tail (range -100000 5))
  ;; => 1

  (defn my-count-tail-helper
    "c will count up to the count"
    [lst c]
    (if (empty? lst)
      c
      (recur (rest lst)
             (inc c))))

  (defn my-count-tail
    [lst]
    (my-count-tail-helper lst 0))

  (my-count-tail (range 100000))
  ;; => 100000



  )