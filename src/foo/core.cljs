(ns foo.core
  (:require [reagent.core :as reagent]))

(defn my-component []
  [:h1 "这个是Cljs的组件~"])

;;; IMPORTANT
;; :export metadata is necessary.
(def ^:export MyComponent
  (reagent/reactify-component my-component))

(defn my-component-2 [props]
  [:p ;;{:style "red"}: The `style` prop expects a mapping from style properties to values, not a string. For example, style={{marginRight: spacing + 'em'}} when using JSX.
   (str "cljs-component: " (:name props))])

(def ^:export MyComponent2
  (reagent/reactify-component my-component-2))

(def react-props-atom (reagent/atom {}))

(def ^:export RowComponent
  (reagent/reactify-component
   (fn [props]
     ;; (prn props) ;;打印出来了: {:data nil, :index 18, :isScrolling nil, :style #js {:position "absolute", :left 0, :top 630, :height 35, :width "100%"}}
     ;;(reset! react-props-atom props)
     ;;[:p "========"] ;; 先不存任何数据,看是否能显示出来p标签
     #_[:textarea (-> props
                      (assoc :ref (:inputRef props))
                      (dissoc :inputRef))]
     [:div {:class (if (= (mod (:index props) 2) 0)
                     "ListItemOdd"
                     "ListItemEven")
            :style (:style props)}
      (str "cljs row component: " (:index props))]
     )))
