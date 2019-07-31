(ns foo.core
  (:require [reagent.core :as reagent]
            ["react-window" :refer [FixedSizeList]]
            ["react-virtualized-auto-sizer" :refer [AutoSizer]]))

(declare RowComponent)

(defn my-component [props & children]
  [:div
   [:> FixedSizeList
    {:class-name "List"
     :height (:height props)
     :item-count 1000
     :itemSize 35
     :width (:width props)}
    RowComponent]])

;;; IMPORTANT
;; :export metadata is necessary.
(def ^:export MyComponent
  (reagent/reactify-component my-component))
 
(defn my-component-2 [props]
  (prn "-----------" props)
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

(defn autosize-component [props & children]
  [:div
   [:> AutoSizer
    (clj->js (fn [props] (prn "======" props)))
   ;;[:> MyComponent2]
   ;;MyComponent2
   ;;(reagent/as-element [:div [:div "aaa"] [:div "bbb"]])
   ;;"aaaaaaa" ;;Element type is invalid: expected a string (for built-in components) or a class/function (for composite components) but got: undefined. You likely forgot to export your component from the file it's defined in, or you might have mixed up default and named imports.
   
   #_(fn [props]
     (prn "------" props)
     []
     #_[:div
      [:div "aaaa"]
      [:div "bbb"]]
     )
   ]]
  )

(def ^:export AutoSizerComponent
  (reagent/reactify-component autosize-component))
