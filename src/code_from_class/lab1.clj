(ns code-from-class.lab1)

(def error-vector-length 10)

(defn make-individual
  "Creates a random error vector and returns a map of the individual with
   that error vector."
  [program]
  (let [error-vector (vec (repeatedly error-vector-length #(rand-int 10)))]
    {:program program
     :error-vector error-vector
     :total-error (apply + error-vector)}))

(defn make-population
  "Creates a population of random 'individuals'."
  [num-individuals]
  (map make-individual
       (range num-individuals)))



(comment

  ;;; Below here is an example use-case. Your results will obviously differ,
  ;;; since you will have a different random population.

  (def ex-pop (make-population 20))
  ;; => #'code-from-class.lab1/ex-pop

  ex-pop
  ;; => ({:program 0, :error-vector [1 5 4 1 0 6 2 4 3 3], :total-error 29}
  ;;     {:program 1, :error-vector [9 3 5 1 0 7 8 8 3 0], :total-error 44}
  ;;     {:program 2, :error-vector [2 3 5 8 0 1 8 7 1 7], :total-error 42}
  ;;     {:program 3, :error-vector [2 7 4 3 4 5 1 3 5 5], :total-error 39}
  ;;     {:program 4, :error-vector [2 4 8 8 7 5 2 0 5 6], :total-error 47}
  ;;     {:program 5, :error-vector [9 9 2 9 3 5 5 1 5 6], :total-error 54}
  ;;     {:program 6, :error-vector [9 9 9 1 6 9 0 8 4 2], :total-error 57}
  ;;     {:program 7, :error-vector [9 0 7 8 8 4 9 8 0 3], :total-error 56}
  ;;     {:program 8, :error-vector [5 5 4 1 6 8 4 2 9 0], :total-error 44}
  ;;     {:program 9, :error-vector [9 9 6 2 9 2 0 5 4 4], :total-error 50}
  ;;     {:program 10, :error-vector [5 7 2 6 4 6 7 8 5 0], :total-error 50}
  ;;     {:program 11, :error-vector [8 8 7 3 1 0 1 8 0 1], :total-error 37}
  ;;     {:program 12, :error-vector [2 6 4 9 3 2 6 0 7 7], :total-error 46}
  ;;     {:program 13, :error-vector [1 9 6 7 2 4 6 7 3 0], :total-error 45}
  ;;     {:program 14, :error-vector [9 4 2 1 3 9 4 2 3 0], :total-error 37}
  ;;     {:program 15, :error-vector [1 8 7 7 0 9 1 5 4 8], :total-error 50}
  ;;     {:program 16, :error-vector [5 1 8 8 1 4 8 9 3 6], :total-error 53}
  ;;     {:program 17, :error-vector [4 5 8 7 9 1 5 1 9 5], :total-error 54}
  ;;     {:program 18, :error-vector [7 0 2 0 6 0 6 0 1 7], :total-error 29}
  ;;     {:program 19, :error-vector [8 1 1 3 7 5 4 2 2 6], :total-error 39})


  ;(lowest-error-per-case ex-pop)
  ;; => (1 0 1 0 0 0 0 0 0 0)


  ;(lowest-error-groups ex-pop)
  ;; => (({:program 0, :error-vector [1 5 4 1 0 6 2 4 3 3], :total-error 29}
  ;;      {:program 13, :error-vector [1 9 6 7 2 4 6 7 3 0], :total-error 45}
  ;;      {:program 15, :error-vector [1 8 7 7 0 9 1 5 4 8], :total-error 50})
  ;;     ({:program 7, :error-vector [9 0 7 8 8 4 9 8 0 3], :total-error 56}
  ;;      {:program 18, :error-vector [7 0 2 0 6 0 6 0 1 7], :total-error 29})
  ;;     ({:program 19, :error-vector [8 1 1 3 7 5 4 2 2 6], :total-error 39})
  ;;     ({:program 18, :error-vector [7 0 2 0 6 0 6 0 1 7], :total-error 29})
  ;;     ({:program 0, :error-vector [1 5 4 1 0 6 2 4 3 3], :total-error 29}
  ;;      {:program 1, :error-vector [9 3 5 1 0 7 8 8 3 0], :total-error 44}
  ;;      {:program 2, :error-vector [2 3 5 8 0 1 8 7 1 7], :total-error 42}
  ;;      {:program 15, :error-vector [1 8 7 7 0 9 1 5 4 8], :total-error 50})
  ;;     ({:program 11, :error-vector [8 8 7 3 1 0 1 8 0 1], :total-error 37}
  ;;      {:program 18, :error-vector [7 0 2 0 6 0 6 0 1 7], :total-error 29})
  ;;     ({:program 6, :error-vector [9 9 9 1 6 9 0 8 4 2], :total-error 57}
  ;;      {:program 9, :error-vector [9 9 6 2 9 2 0 5 4 4], :total-error 50})
  ;;     ({:program 4, :error-vector [2 4 8 8 7 5 2 0 5 6], :total-error 47}
  ;;      {:program 12, :error-vector [2 6 4 9 3 2 6 0 7 7], :total-error 46}
  ;;      {:program 18, :error-vector [7 0 2 0 6 0 6 0 1 7], :total-error 29})
  ;;     ({:program 7, :error-vector [9 0 7 8 8 4 9 8 0 3], :total-error 56}
  ;;      {:program 11, :error-vector [8 8 7 3 1 0 1 8 0 1], :total-error 37})
  ;;     ({:program 1, :error-vector [9 3 5 1 0 7 8 8 3 0], :total-error 44}
  ;;      {:program 8, :error-vector [5 5 4 1 6 8 4 2 9 0], :total-error 44}
  ;;      {:program 10, :error-vector [5 7 2 6 4 6 7 8 5 0], :total-error 50}
  ;;      {:program 13, :error-vector [1 9 6 7 2 4 6 7 3 0], :total-error 45}
  ;;      {:program 14, :error-vector [9 4 2 1 3 9 4 2 3 0], :total-error 37}))



  )