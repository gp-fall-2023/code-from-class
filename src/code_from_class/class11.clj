(ns code-from-class.class11)

(def infinite-foobar
  (iterate (fn [s]
             (str s "bar"))
           "foo"))

(comment

  (take 5 infinite-foobar)
  ;; => ("foo" "foobar" "foobarbar" "foobarbarbar" "foobarbarbarbar")

  ;; find the first foobarbaretc. with more than 40 characters
  (first (filter #(< 40 (count %))
                 infinite-foobar))
  ;; => "foobarbarbarbarbarbarbarbarbarbarbarbarbar"

  ;; lazy-seq: a more general construction of lazy/infinite sequences
  (defn even-numbers
    ([] (even-numbers 0))
    ([n]
     (lazy-seq (cons n
                     (even-numbers (+' n 2))))))


  (take 10 (even-numbers))
  ;; => (0 2 4 6 8 10 12 14 16 18)

  (nth (even-numbers) 1000000)
  ;; => 2000000

  (nth (even-numbers) 1000000000)
  ;; => 2000000000

  (take 10 (filter even? (range)))
  ;; => (0 2 4 6 8 10 12 14 16 18)

  (take 10 (map even? (range)))
  ;; => (true false true false true false true false true false)

  (take 10 (map #(* 2 %) (range)))
  ;; => (0 2 4 6 8 10 12 14 16 18)

  ;; Triangle numbers
  ; t(n) = t(n-1) + n

  (defn triangle-numbers
    "Returns an infinite sequence of triangle numbers"
    ([] (triangle-numbers 1 0))
    ([n tn-1]
     (let [next-number (+ tn-1 n)]
       (lazy-seq (cons next-number
                       (triangle-numbers (inc n)
                                         next-number))))))

  (take 10 (triangle-numbers))
  ;; => (1 3 6 10 15 21 28 36 45 55)

  (reductions + (range 5))
  ;; => (0 1 3 6 10)

  (take 10 (reductions + (range)))
  ;; => (0 1 3 6 10 15 21 28 36 45)

  ;; read-string - returns the data structure represented by the string
  (read-string "(+ 2 3)")
  ;; => (+ 2 3)

  (type (read-string "(+ 2 3)"))
  ;; => clojure.lang.PersistentList

  (read-string "[1 2 3]")
  ;; => [1 2 3]

  (read-string "(defn function-name
                  \"this is a docstring\"
                  [x]
                  (+ x 5))")
  ;; => (defn function-name "this is a docstring" [x] (+ x 5))


  (read-string "5")
  ;; => 5

  (read-string "'(2 3 4)")
  ;; => '(2 3 4)

  (read-string "(quote (2 3 4))")
  ;; => '(2 3 4)

  ;; a reader macro expanding anon fns
  (read-string "#(+ % %)")
  ;; => (fn* [p1__6121#] (+ p1__6121# p1__6121#))

  (read-string "(+ 1 2) ; this is a comment")
  ;; => (+ 1 2)

  (read-string "variable")
  ;; => variable

  (read-string "\"this is a string\"")
  ;; => "this is a string"
  )