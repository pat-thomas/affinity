(ns app.core
  (:require [reagent.core :as r]))

(enable-console-print!)

(def app-state (r/atom {}))

(defn main
  []
  (println "yo"))

(main)
