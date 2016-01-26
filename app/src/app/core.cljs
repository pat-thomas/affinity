(ns app.core
  (:require [reagent.core :as r]))

(enable-console-print!)

(def app-state (r/atom {}))

(defn app
  []
  [:p "hello"])

(defn main
  []
  (r/render-component [app] (. js/document (getElementById "app-container"))))

(main)
