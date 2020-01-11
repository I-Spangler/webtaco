(ns taco.taco-table
    (:require [reagent.core :as r]))

(defn a [] "hey")
(js/console.log (a))



(defn my-component []
  [:p "My first React component"])


(defonce todos (r/atom []))
(defonce current-todo (r/atom ""))


(defn hello-there []
  [:div 
   [:input {:value @current-todo 
            :onChange #(reset! current-todo (-> % .-target .-value))}]
   [:button {:onClick #(do 
                         (swap! todos conj @current-todo)
                         (reset! current-todo ""))} ">"]
   (for [i @todos]
     [:div 
      {:key (str i)}
      [:button {:onClick #(swap! todos (fn [todos] (remove #{i} todos)))} "x"]
      [:code (str i)]])])

(defn ^:export main []
  (r/render 
    [hello-there]
    (.getElementById js/document "app")))

(main)

