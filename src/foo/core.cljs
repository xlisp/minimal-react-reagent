(ns foo.core
  (:require [reagent.core :as reagent]
            ["react-window" :refer [FixedSizeList]]))

(declare RowComponent)

(defn my-component [props & children]
  (prn "my-component---->>>" props "-----" children)
  [:div
   [:> FixedSizeList
    {:class-name "List"
     :height 1000 
     :item-count 1000
     :itemSize 35
     :width 500}
    RowComponent]])

;;; IMPORTANT
;; :export metadata is necessary.
(def ^:export MyComponent
  (reagent/reactify-component my-component))

(defn my-component-2 [props]
  [:p (str "cljs-component: " (:name props))])

(def ^:export MyComponent2
  (reagent/reactify-component my-component-2))

(def react-props-atom (reagent/atom {}))

(def ^:export RowComponent
  (reagent/reactify-component
   (fn [props]
     [:div {:class (if (= (mod (:index props) 2) 0)
                     "ListItemOdd"
                     "ListItemEven")
            :style (:style props)}
      (str "cljs row component: " (:index props))])))
