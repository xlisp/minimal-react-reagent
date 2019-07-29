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
