(ns foo.core
  (:require [reagent.core :as reagent]))

(defn my-component []
  [:h1 "My Component"])

;;; IMPORTANT
;; :export metadata is necessary.
(def ^:export MyComponent
  (reagent/reactify-component my-component))
