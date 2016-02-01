(ns app.core
  (:require [reagent.core :as r]
            [app.xhr      :as xhr]))

(enable-console-print!)

(def app-state (r/atom {}))

(defn app
  []
  [:p "hello"])

(defn main
  []
  (xhr/make-xhr {:method      "GET"
                 :url         "ping"
                 :data        {}
                 :on-complete (fn [_]
                                (println "got it"))})
  (r/render-component [app] (. js/document (getElementById "app-container"))))

(main)
